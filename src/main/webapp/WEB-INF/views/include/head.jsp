<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<head>
	
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>OnePage Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${root}/assets/img/favicon.png" rel="icon">
  <link href="${root}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->

  <link href="${root}/assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="${root}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${root}/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${root}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${root}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="${root}/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${root}/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: OnePage
  * Updated: Mar 10 2023 with Bootstrap v5.2.3
  * Template URL: https://bootstrapmade.com/onepage-multipurpose-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  
</head>

<body>

 <!-- ======= Header ======= -->
 <header id="header" class="fixed-top">
  <div class="container d-flex align-items-center justify-content-between">

    <h1 class="logo"><a href="${root}/index.do">Enjoy Trip</a></h1>
    <!-- Uncomment below if you prefer to use an image logo -->
    <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

    <nav id="navbar" class="navbar">
      <ul>
        <li><a class="nav-link scrollto active" href="${root}/index.do#hero">Home</a></li>
        <li><a class="nav-link scrollto" href="${root}/travel/searchTravel">지역별여행지</a></li>
        <li><a class="nav-link scrollto" href="${root}/index.jsp#services">나의여행계획</a></li>
        <li><a class="nav-link scrollto o" href="${root}/index.jsp#portfolio">핫플자랑하기</a></li>
        <li><a class="nav-link scrollto" href="${root}/index.jsp#team">여행정보공유</a></li>
        
        
	<c:choose>
		<c:when test="${empty userId}">
		    <li class="nav-item"><a class="getstarted scrollto" href="${root}/user/login_form.do">로그인</a>
		    <li class="nav-item"><a class="getstarted scrollto" href="${root}/user/register.jsp">회원가입</a></li>
		</c:when>
		<c:otherwise>
		    <a class="getstarted scrollto" href="${root}/user/myInfo.do?userId=${userId}"> ${userId}님 </a>
		    <li class="nav-item"><a class="getstarted scrollto" href="${root}/user/logout.do">로그아웃</a></li>
		</c:otherwise>
	</c:choose>
      </ul>
      <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->

  </div>
</header><!-- End Header -->