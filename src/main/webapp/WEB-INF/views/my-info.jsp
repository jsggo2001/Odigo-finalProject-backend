<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
    <style>
      label {
        display: block;
        margin-bottom: 10px;
      }

      ul {
        list-style: none;
      }

      li {
        margin-bottom: 10px
      }
        
      #container {
        width: 400px;
        margin: 0 auto;
      }
  
      button {
        display: block;
        margin-top: 20px;
      }
      .danger {
        color: red;
      }
  </style>
  <script>
    function logout() {
    }
  </script>
  </head>

      <style>
        label {
          display: block;
          margin: 10px 0;
        }
      </style>
  <main id="main">
  
      <!-- ======= Breadcrumbs ======= -->
      <section class="breadcrumbs">
        <div class="container">
  
          <div class="d-flex justify-content-between align-items-center">
            <ol>
              <li><a href="${root}index.jsp">Home</a></li>
              <li>My Page</li>
            </ol>
          </div>
  
        </div>
      </section><!-- End Breadcrumbs -->
      <div id="container">
        <h1>내 정보</h1>
        <ul>
          <li><strong>아이디:</strong> user123</li>
          <li><strong>이름:</strong> user123</li>
          <li>
            <strong>비밀번호:</strong> <input type="password" id="password" name="password"> 
          </li>
          <li>
            <strong>변경할 비밀번호:</strong> <input type="password" id="password" name="password"> 
          </li>
          <li>
            <strong>비밀번호 확인:</strong> <input type="password" id="password" name="password"> 
          </li>
          <li><strong>이메일:</strong> user123@gmail.com</li>
          <li><strong>지역:</strong> Seoul</li>
        </ul>
        <button>정보 수정</button>
        <button>취소</button>
        <br><br><br>
        <h1 class="danger"> DANGER ZONE </h1>
        <button> 회원 탈퇴 </button>
      </div>
  
    </main><!-- End #main -->
 <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </body></html>