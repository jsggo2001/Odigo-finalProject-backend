<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<script type="text/javascript" charset="utf-8">
	sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");
</script>

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>지역별 관광정보</h2>
          <ol>
            <li><a href="${root}/index.jsp">Home</a></li>
            <li>지역별 관광정보</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs -->

    <section class="inner-page">
      <div class="container" style="margin-top: -40px;">
        <select id="search-area" class="form-select me-2 search">
          <option value="null" selected>검색 할 지역 선택</option>
        </select>
        <select id="search-content-id" class="form-select me-2 search">
          <option value="null" selected>관광지 유형</option>
          <option value="12">관광지</option>
          <option value="14">문화시설</option>
          <option value="15">축제공연행사</option>
          <option value="25">여행코스</option>
          <option value="28">레포츠</option>
          <option value="32">숙박</option>
          <option value="38">쇼핑</option>
          <option value="39">음식점</option>
        </select>
        <select id="search-gu-id" class="form-select me-2 search">
          <option value="0" selected>군/구</option>
          
        </select>
        <input
          id="search-keyword"
          class="form-control me-2 search"
          type="search"
          placeholder="검색어"
          aria-label="검색어"
        />
        <button id="btn-search" class="btn btn-outline-success" type="button">검색</button>
        <!-- kakao map start -->
      <div id="map" class="mt-3" style="width: 100%; height: 500px; margin-left: 10px; margin-top : 110px;"></div>
      <!-- kakao map end -->
      </div>


      

      <script src="${root}/assets/js/key.js"></script>

      <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ea948ca1959359f34e669fcc0ba5e6b4&libraries=services,clusterer,drawing"
    ></script>
    <script type="text/javascript" src="${root}/assets/js/list.js"></script>
    </section>

  </main><!-- End #main -->

<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</html>
