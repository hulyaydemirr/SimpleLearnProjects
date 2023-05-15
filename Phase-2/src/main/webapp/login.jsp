<%@ page import="org.hibernate.type.ObjectType" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Portal</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
<h1><%= "Welcome to Student Portal!" %>
</h1>
<hr>
</form>
<hr/>
<form action="/loginServlet" method="post">

    <div class="center">
        <label>Email: </label>
        <input type="email" name="email"/><br/>

        <br>

        <label>Password: </label>
        <input type="password" name="password"/><br/>

        <br>

        <input type="submit" value="submit"/>
        <input type="reset" value="reset"/>
        <br>
        <%
            Object message = request.getAttribute("errorMessage");
            if (message != null) { %>
        <span style="color:red;"><%=message.toString()%></span>
        <%}%>
    </div>

</form>
</body>
</html>