<%@ page import="com.simplilearn.entity.Classes" %>
<%@ page import="com.simplilearn.entity.Subject" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="com.simplilearn.configuration.DatabaseConfiguration" %><%--
  Created by IntelliJ IDEA.
  User: elif.karaca
  Date: 2.03.2023
  Time: 11:54
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

<h1>Assign a Subject to a Class</h1>
<%
    SessionFactory sf = DatabaseConfiguration.getSessionFactory();
    Session hibernateSession = sf.openSession();
    List<Classes> classes = hibernateSession.createQuery("from Classes").list();
    List<Subject> subjects = hibernateSession.createQuery("from Subject").list();
%>
<form action="assignSubject" method="post">
    <table>
        <tr>
            <th>Class Name</th>
            <th>Subject Name</th>
        </tr>
        <tr>
            <td>
                <select name="class">
                    <%
                        for (Classes clas : classes) {
                            out.print("<option>" + clas.getClass_name());
                            out.print("</option>");
                        }
                    %>
                </select>
            </td>

            <td>
                <select name="subject">
                    <%
                        for (Subject subject : subjects) {
                            out.print("<option>" + subject.getSubject_name());
                            out.print("</option>");
                        }
                    %>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form>
</body>
</html>
