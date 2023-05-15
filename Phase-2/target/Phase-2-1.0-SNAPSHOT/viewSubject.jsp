<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.simplilearn.entity.Subject" %>
<%@ page import="com.simplilearn.configuration.DatabaseConfiguration" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: elif.karaca
  Date: 2.03.2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<a href="home.jsp">Back to Main Menu</a><br>
<a href="HTML/addSubject.html">Add Subject</a><br>

<h1>The Following Subjects are listed</h1>
<%
    SessionFactory sf = DatabaseConfiguration.getSessionFactory();
    Session hibernateSession = sf.openSession();
    List<Subject> subjects = hibernateSession.createQuery("from Subject").list();
%>
<table>
    <tr>
        <th>Subject Name</th>
    </tr>
    <%
        for (Subject subject : subjects) {
            out.print("<tr>");
            out.print("<td>" + subject.getSubject_name() + "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
