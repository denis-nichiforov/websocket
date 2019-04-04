<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../../resources/include/style/style.css">
    <script src="../../resources/include/jscripts/socket.js"></script>
</head>
<body>

<h1>hello my host ${answer}</h1>
<form action="" name="form" method="post">
<div class="parent">
    <div class="block">
        <textarea id="tn1"></textarea>
        <p1>name:</p1><input id="in1" name="name">
        <p2>message:</p2><textarea id="tn2" name="message"></textarea>
        <input id="ib1" type="submit" value="SEND" name="submit">
    </div>
</div>
</form>
</body>
</html>
