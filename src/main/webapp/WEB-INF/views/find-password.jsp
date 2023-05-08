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
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter your email address" required>
        <button type="submit">Reset Password</button>
      </div>
  
    </main><!-- End #main -->
  
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
  
  
  </body></html>