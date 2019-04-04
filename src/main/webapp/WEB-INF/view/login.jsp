<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Simple login form</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <script src="../../resources/include/jscripts/login.js"></script>
    <link rel="stylesheet" href="../../resources/include/style/login.css">

</head>

<body>

  <div class="container">
  <div class="login">
  	<h1 class="login-heading">
      <strong>Welcome.</strong> Please login.</h1>
      <form method="post" >
          <div id="labelUser"></div>
        <input id="user" type="text" name="user" placeholder="Username" required="required" class="input-txt" />
          <div id="labelpassword"></div>
          <input id="password" type="password" name="password" placeholder="Password" required="required" class="input-txt" />
          <div class="login-footer">
             <a href="#" class="lnk">
              <span class="icon icon--min">ಠ╭╮ಠ</span> 
              I've forgotten something
            </a>
            <button type="button" class="btn btn--right" id="button">Sign in  </button>
              <a href="http://localhost:8080/registration" class="btn btn--right">Registration</a>


          </div>
      </form>
  </div>
</div>


</body>

</html>
