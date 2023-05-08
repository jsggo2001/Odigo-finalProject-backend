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
		<form action="${root}/user/register.do" method="post" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="userId">아이디</label></th>
						<td><input type="text" name="userId" id="userId"/></td>
					</tr>
					<tr>
						<th><label for="nickname">닉네임</label></th>
						<td><input type="text" name="nickname" id="nickname"/></td>
					</tr>
					<tr>
						<th><label for="password">비밀번호</label></th>
						<td><input type="password" name="password" id="password"/></td>
					</tr>
					<tr>
						<th><label for="passwordCheck">비밀번호 확인</label></th>
						<td><input type="password" name="passwordCheck" id="passwordCheck"/></td>
					</tr>
					<tr>
						<th> 
					        Email: <input type="text" id="emailId" name="emailId"> @
					        <select id="emailDomain" name="emailDomain">
					          <option value="gmail.com">gmail.com</option>
					          <option value="naver.com">naver.com</option>
					          <option value="daum.net">daum.net</option>
					          <option value="yahoo.com">yahoo.com</option>
				        	</select>
						</th>

					</tr>
					<tr>
						<th>
					        지역:<select id="location" name="location">
					          <option value="Seoul">Seoul</option>
					          <option value="Busan">Busan</option>
					          <option value="Incheon">Incheon</option>
					          <option value="Jeju">Jeju</option>
					        </select>
						</th>
					</tr>
				</tbody>
			</table>
			<button type="submit" onclick="saveSignUp()"> 회원 가입 </button>
		</form>
      
    </div>

  </main><!-- End #main -->

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body></html>