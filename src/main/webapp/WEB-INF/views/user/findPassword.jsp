<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/WEB-INF/views/include/head.jsp" %>
    <style>
      #container {
        width: 400px;
        margin: 0 auto;
      }

      button {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
      }

      button:hover {
        background-color: #45a049;
      }

      label {
        display: block;
        margin-bottom: 10px;
      }

      input[type="email"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-bottom: 20px;
      }
  </style>
      <style>
        label {
          display: block;
          margin: 10px 0;
        }
      </style>
    </header><!-- End Header -->
  
    <main id="main">
  
      <!-- ======= Breadcrumbs ======= -->
      <section class="breadcrumbs">
        <div class="container">
  
        </div>
      </section><!-- End Breadcrumbs -->
      <div id="container">
      	<form action="${root}/user/findPassword.do" method="post" class="row">
			<tbody>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="text" name="email" id="email"/></td>
				</tr>
				<tr>
					<th></th>
					<td>
				      	<c:choose>
							<c:when test="${empty password}">
								유효한 이메일을 입력해주세요.
							</c:when>
							<c:otherwise>
								비밀번호는 ${password} 입니다.
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<button type="submit">find Password</button>
			</tbody>
      	</form>
      </div>
  
    </main><!-- End #main -->
  
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  
  
  </body></html>