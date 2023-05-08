	var root = getContextPath();

	function getContextPath() {

    return sessionStorage.getItem("contextpath");

	}

	
      // index page 로딩 후 전국의 시도 설정.
      let areaUrl = `${root}/travel/sido`;

      // fetch(areaUrl, { method: "GET" }).then(function (response) { return response.json() }).then(function (data) { makeOption(data); });
      fetch(areaUrl, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeOption(data));

      function makeOption(data) {
        let areas = data;
        // console.log(areas);
        let sel = document.getElementById("search-area");
        areas.forEach((area) => {
          let opt = document.createElement("option");
          opt.setAttribute("value", area.sidoCode);
          opt.appendChild(document.createTextNode(area.sidoName));

          sel.appendChild(opt);
        });
      }

      document.getElementById("search-area").addEventListener("change", () => {
        let value = document.getElementById("search-area").value;
        let uri = `${root}/travel/gugun?sido=` + value;
        fetch(uri, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeOption2(data));
      })

      function makeOption2(data) {
        let gus = data;
        console.log(gus);
        let sel = document.getElementById("search-gu-id");
        sel.innerHTML=""
        let opt = document.createElement("option");
        opt.setAttribute("value", "null");
        opt.appendChild(document.createTextNode("군/구"));

        sel.appendChild(opt);
        gus.forEach((area) => {
          let opt = document.createElement("option");
          opt.setAttribute("value", area.gugun_code);
          opt.appendChild(document.createTextNode(area.gugun_name));

          sel.appendChild(opt);
        });
      }

      // 검색 버튼을 누르면..
      // 지역, 유형, 검색어 얻기.
      // 위 데이터를 가지고 공공데이터에 요청.
      // 받은 데이터를 이용하여 화면 구성.
      document.getElementById("btn-search").addEventListener("click", () => {
        let searchUrl = `${root}/travel/spot`;
        let areaCode = document.getElementById("search-area").value;
        let contentTypeId = document.getElementById("search-content-id").value;
        let keyword = document.getElementById("search-keyword").value;
        let sigunguCode = document.getElementById("search-gu-id").value;
        // &listYN=Y&arrange=A&keyword=부산&contentTypeId=12&sigunguCode=2
        if (parseInt(areaCode)) searchUrl += `?sido_code=`+areaCode;
        if (parseInt(contentTypeId)) searchUrl += `&content_type_id=`+ contentTypeId;
        if (parseInt(sigunguCode)) searchUrl += `&gugun_code=`+sigunguCode;
        if (!keyword) {
          alert("검색어 입력 필수!!!");
          return;
        } else searchUrl = searchUrl + `&keyword=`+ encodeURIComponent(keyword);
        fetch(searchUrl)
          .then((response) => response.json())
          .then((data) => makeList(data));
      });

      var positions; // marker 배열.
      var markers;
      var infos = [];
      function makeList(data) {
        positions = [];
        let trips = data;
        if (markers != null) {
          for(let mark of markers) {
            mark.setMap(null);
          }
        }
        markers = [];
        
        if (trips == null) {
          alert("검색 결과가 없습니다. 다시 검색해주세요");
          return;
        }

        trips.forEach((area) => {
          let markerInfo = {
            title: area.title,
            latlng: new kakao.maps.LatLng(area.latitude, area.longitude),
          };
          positions.push(markerInfo);
        });
        displayMarker(trips);
      }

      // 카카오지도
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
          level: 5, // 지도의 확대 레벨
        };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);
      var bounds = new kakao.maps.LatLngBounds();
      function displayMarker(area) {
    	 bounds = new kakao.maps.LatLngBounds();

        // 마커 이미지의 이미지 주소입니다
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

        for (var i = 0; i < positions.length; i++) {
          // 마커 이미지의 이미지 크기 입니다
          var imageSize = new kakao.maps.Size(24, 35);

          // 마커 이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

		  var points = [];

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지
            clickable: true,

           
          });
          bounds.extend(positions[i].latlng);

          markers.push(marker);
          
          var infowindow = new kakao.maps.InfoWindow({
              content:  '<div class="wrap">' + 
                '    <div class="info">' + 
                '        <div class="title">' + 
                           area[i].title + 
                '            <div class="close" onclick="closeInfoWindow()" title="닫기" style="float : right">닫기</div>' + 
                '        </div>' + 
                '        <div class="body">' + 
                '            <div class="img">' +
                `                <img src="`+
                				area[i].first_image+
                				`" width="73" height="70">`+
                '           </div>' + 
                '            <div class="desc">' + 
                `                <div class="ellipsis">`
                			+area[i].addr1
                				+`</div>` + 
                '            </div>' + 
                '        </div>' + 
                '    </div>' +    
                '</div>'// 인포윈도우에 표시할 내용
              });
          
          kakao.maps.event.addListener(marker, 'click', 
          
          makeOverListener(map, marker, infowindow));
        }
        map.setBounds(bounds);
       // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
       // map.setCenter(positions[0].latlng);
      }
    
      function makeOverListener(map, marker, infowindow) {
        return function() {
        closeInfoWindow();
        infos.push(infowindow);
        infowindow.open(map, marker);
      };
}
function closeInfoWindow() {
      for(var idx=0; idx<infos.length; idx++){
        infos[idx].close();
      }
    }

      function moveCenter(lat, lng) {
        map.setCenter(new kakao.maps.LatLng(lat, lng));
      }
