<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>Simple registration form</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


    <script src="../../resources/include/jscripts/ajax.js"></script>
    <link rel="stylesheet" href="../../resources/include/style/login.css">

</head>

<body>

<div class="container">
    <div class="login">
        <h1 class="login-heading">
            <strong>Welcome.</strong> Please register.</h1>
        <form method="post">
            <div id="labelUser"></div>
            <input type="text" id="user" placeholder="Username" required="required" class="input-txt" />
            <div id="labelpassword"></div>
            <input type="password" id="password" placeholder="Password" required="required" class="input-txt" />
            <div id="labelpasswordRepeat"></div>
            <input type="password" id="passwordRepeat" placeholder="Password Repeat" required="required" class="input-txt" />
            <div class="login-footer">
                <a href="#" class="lnk">
                    <span class="icon icon--min">ಠ╭╮ಠ</span>
                    I've forgotten something
                </a>
                <a href="http://localhost:8080/login"  class="btn btn--right">Login</a>

                <button type="button" class="btn btn--right" id="button">Registration  </button>
            </div>
        </form>
    </div>
</div>


</body>

</html>
