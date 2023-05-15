<%@ page import="com.simplilearn.entity.Classes" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.simplilearn.configuration.DatabaseConfiguration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="com.simplilearn.entity.Subject" %><%--
  Created by IntelliJ IDEA.
  User: elif.karaca
  Date: 1.03.2023
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="home.jsp">Back to Main Menu</a><br>
<a href="HTML/addClasses.html">Add Class</a><br>
<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>

<h1>The Following Classes are listed</h1>
<%
    SessionFactory sf = DatabaseConfiguration.getSessionFactory();
    Session hibernateSession = sf.openSession();
    List<Classes> classes = hibernateSession.createQuery("from Classes").list();
%>
<table>
    <tr>
        <th>Class Name</th>
        <th>Subject Name</th>
    </tr>
    <%
        for (Classes clas : classes) {
            out.print("<tr>");
            out.print("<td>" + clas.getClass_name() + "</td>");

            StringBuffer buf = new StringBuffer();
            boolean first = true;
            for (Subject subject : clas.getSubjects()) {
                if (first == true) {
                    buf.append("<td>" + subject.getSubject_name() + "</td>");
                    buf.append("</tr>");
                    first = false;
                } else {
                    buf.append("<tr><td></td>");
                    buf.append("<td>" + subject.getSubject_name() + "</td>");
                    buf.append("</tr>");
                }

            }
            out.print(buf.toString());
        }
    %>
</table>
</body>
</html>
