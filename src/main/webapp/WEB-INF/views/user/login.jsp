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
            <li>Login Page</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs -->
    <div id="container">
		<form action="${root}/user/login.do" method="post" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="userId">아이디</label></th>
						<td><input type="text" name="userId" id="userId"/></td>
					</tr>
					<tr>
						<th><label for="password">비밀번호</label></th>
						<td><input type="password" name="password" id="password"/></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" value="로그인"/>
							<input type="reset" value="취소"/>
							<a href="${root}/user/findPassword.jsp"> 비밀번호 찾기 </a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
    </div>

  </main><!-- End #main -->

  <%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body></html>