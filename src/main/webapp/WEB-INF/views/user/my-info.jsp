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
              <li><a href="${root}/index.jsp">Home</a></li>
              <li>My Page</li>
            </ol>
          </div>
  
        </div>
      </section><!-- End Breadcrumbs -->
      <div id="container">
        <h1>내 정보</h1>
     		<form action="${root}/user/update.do" method="post" class="row">
				<table class="table">
					<tbody>
						<tr>
							<td>아이디:<input type="text" id="userId" name="userId" value = "${myInfo.userId}" readonly></td>
						</tr>
						<tr>
							<td>이름: ${myInfo.nickname}</td>
						</tr>
						<tr>
							<td>
					            비밀번호: <input type="password" id="password" name="password"> 
							</td>
						</tr>
						<tr>
							<td>
					            변경할 비밀번호: <input type="password" id="newPassword" name="newPassword"> 
							</td>
						</tr>
						<tr>
							<td>
				            	비밀번호 확인: <input type="password" id="newPasswordCheck" name="newPasswordCheck"> 
							</td>
						</tr>
						<tr>
							<td>이메일: ${myInfo.emailId}@${myInfo.emailDomain}</td>
						</tr>
						<tr>
							<td>지역: ${myInfo.location}</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="정보 수정"/>
		       	<c:choose>
					<c:when test="${empty wrong}">
						비밀번호를 확인해주세요.
					</c:when>
					<c:otherwise>
						정보를 변경했습니다!
					</c:otherwise>
				</c:choose>
			</form>
        <br><br><br>
        <h1 class="danger"> DANGER ZONE </h1>
        <button type="button" onclick="location.href='${root}/user/delete.do?userId=${myInfo.userId}'"> 회원 탈퇴 </button>
      </div>
  
    </main><!-- End #main -->
 <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  </body></html>