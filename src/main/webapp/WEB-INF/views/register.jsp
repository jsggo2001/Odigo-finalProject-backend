<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
  <style>
      label {
        display: block;
        margin-bottom: 10px;
      }

      #container {
        width: 400px;
        margin: 0 auto;
      }

      button {
        display: block;
        margin-top: 20px;
      }
  </style>

   <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <ol>
            <li><a href="${root}/index.jsp">Home</a></li>
            <li>Register Page</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs -->

    <div id="container">
      <label>
        이름:
        <input type="text" id="username" name="username">
      </label>
      <label>
        아이디:
        <input type="text" id="nickname" name="nickname">
      </label>
      <label>
        비밀번호:
        <input type="password" id="password" name="password">
      </label>
      <label>
        비밀번호확인:
        <input type="password" id="password" name="password">
      </label>
      <label>
        Email:
        <input type="text" id="firstEmail" name="firstEmail"> @
        <select id="lastMeail" name="lastMeail">
          <option value="gmail.com">gmail.com</option>
          <option value="naver.com">naver.com</option>
          <option value="daum.net">daum.net</option>
          <option value="yahoo.com">yahoo.com</option>
        </select>
      </label>
      <label>
        지역:
        <select id="location" name="location">
          <option value="Seoul">Seoul</option>
          <option value="Busan">Busan</option>
          <option value="Incheon">Incheon</option>
          <option value="Jeju">Jeju</option>
        </select>
      </label>
      <button type="submit" onclick="saveSignUp()"> 회원 가입 </button>
    </div>

  </main><!-- End #main -->

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body></html>