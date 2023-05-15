<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.simplilearn.entity.Classes" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="com.simplilearn.configuration.DatabaseConfiguration" %>
<%@ page import="com.simplilearn.entity.Subject" %>
<%@ page import="com.simplilearn.entity.Teacher" %>
<%@ page import="com.simplilearn.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: elif.karaca
  Date: 2.03.2023
  Time: 17:24
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
<%String clas = request.getParameter("class");%>
<h1>Class Report for <%=clas%>
</h1>

<%
    SessionFactory sf = DatabaseConfiguration.getSessionFactory();
    Session hibernateSession = sf.openSession();
    List<Classes> classes = hibernateSession.createQuery("from Classes cl where cl.class_name='" + clas + "'").list();
    Classes clasForReport = classes.get(0);
%>
<table>
    <tr>
        <th>Subject Name</th>
        <th>Teacher Name</th>
    </tr>
    <%
        for (Subject subject : clasForReport.getSubjects()) {
            out.print("<tr>");
            out.print("<td>" + subject.getSubject_name() + "</td>");
            out.print("<td>" + getTeacherName(subject) + "</td>");
            out.print("</tr>");
        }
    %>
</table>
<%!
    public String getTeacherName(Subject subject) {
        Teacher teacher = subject.getTeacher();
        String name;
        String lname;

        if (teacher != null) {
            name = teacher.getFirst_name();
            lname = teacher.getLast_name();

            return name + " " + lname;
        } else {
            return "No teacher assigned";
        }
    }
%>
<table>
    <br>
    <tr>
        <th>Listed Students</th>
    </tr>
    <%
        for (Student student : clasForReport.getStudents()) {
            out.print("<tr>");
            out.print("<td>" + student.getFname() + " " + student.getLname() + "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
