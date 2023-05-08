<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<%@ include file="/WEB-INF/views/include/head.jsp" %>

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center">
    <div class="container position-relative aos-init aos-animate" data-aos="fade-up" data-aos-delay="100">
      <div class="row justify-content-center">
        <div class="col-xl-7 col-lg-9 text-center">
          <h1>Enjoy Trip</h1>
          
        </div>
      </div>
      <div class="text-center">
		<c:choose> 
			<c:when test="${empty userId}">
        	<a href="${root}/user/login_form.do" class="btn-get-started scrollto">Get Started</a>
        	</c:when>
        	<c:otherwise>
        	<a href="${root}/index.jsp" class="btn-get-started scrollto">Get Started</a>
        	</c:otherwise>
        </c:choose>
      </div>

      <div class="row icon-boxes">
        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0 aos-init aos-animate" data-aos="zoom-in" data-aos-delay="200">
          <div class="icon-box">
            <div class="icon"><i class="ri-stack-line"></i></div>
            <h4 class="title"><a href="${root}/travel/searchTravel.do">지역별여행지</a></h4>
            <p class="description">지역별 여행지 정보를 키워드를 통해서 검색 해 보세요</p>

          </div>
        </div>

        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0 aos-init aos-animate" data-aos="zoom-in" data-aos-delay="300">
          <div class="icon-box">
            <div class="icon"><i class="ri-palette-line"></i></div>
            <h4 class="title"><a href="${root}/index.jsp">나의여행계획</a></h4>
            <p class="description">여행경로, 숙박, 관광지, 예상금액등 나만의 멋진 계힉을 공유하세요.</p>
          </div>
        </div>

        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0 aos-init aos-animate" data-aos="zoom-in" data-aos-delay="400">
          <div class="icon-box">
            <div class="icon"><i class="ri-command-line"></i></div>
            <h4 class="title"><a href="${root}/index.jsp">핫플자랑하기</a></h4>
            <p class="description">우리지역의 핫플레이스를 더 핫하게 만들수 있도록 자랑 하세요.</p>
          </div>
        </div>

        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0 aos-init aos-animate" data-aos="zoom-in" data-aos-delay="500">
          <div class="icon-box">
            <div class="icon"><i class="ri-fingerprint-line"></i></div>
            <h4 class="title"><a href="${root}/index.jsp">여행정보공유</a></h4>
            <p class="description">나만의 여행 꿀팁들을 공유하여 모두와 함께 즐거운 여행을 즐길 수 있도록 정보를 공유해주세요.</p>
          </div>
        </div>
      </div>
    </div>
  </section><!-- End Hero -->
  <%@ include file="/WEB-INF/views/include/footer.jsp" %>
</html>