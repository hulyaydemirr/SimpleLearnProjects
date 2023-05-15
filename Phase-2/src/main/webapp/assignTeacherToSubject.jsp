<%@ page import="com.simplilearn.entity.Subject" %>
<%@ page import="com.simplilearn.entity.Teacher" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.simplilearn.configuration.DatabaseConfiguration" %><%--
  Created by IntelliJ IDEA.
  User: elif.karaca
  Date: 2.03.2023
  Time: 17:10
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

<h1>Assign a Teacher to a Subject</h1>
<%
    SessionFactory sf = DatabaseConfiguration.getSessionFactory();
    Session hibernateSession = sf.openSession();
    List<Teacher> teachers = hibernateSession.createQuery("from Teacher").list();
    List<Subject> subjects = hibernateSession.createQuery("from Subject").list();
%>

<form action="assignTeacher" method="post">
    <table>
        <tr>
            <th>Student Name</th>
            <th>Subject Name</th>
        </tr>
        <tr>
            <td>
                <select name="name">
                    <%
                        for (Teacher teacher : teachers) {
                            out.print("<option>" + teacher.getFirst_name() + " " + teacher.getLast_name());
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
