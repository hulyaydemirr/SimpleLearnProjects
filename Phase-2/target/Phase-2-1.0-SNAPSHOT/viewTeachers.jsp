<%@ page import="com.simplilearn.entity.Teacher" %>
<%@ page import="com.simplilearn.entity.Subject" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="com.simplilearn.configuration.DatabaseConfiguration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: elif.karaca
  Date: 2.03.2023
  Time: 14:10
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
<a href="HTML/addTeacher.html">Add Teacher</a><br>
<a href="assignTeacherToSubject.jsp">Assign Teacher to Subject</a><br>

<h1>The Following Teachers are listed</h1>
<%
    SessionFactory sf = DatabaseConfiguration.getSessionFactory();
    Session hibernateSession = sf.openSession();
    List<Teacher> teachers = hibernateSession.createQuery("from Teacher").list();
%>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Assigned Class</th>
    </tr>
    <%
        for (Teacher teacher : teachers) {
            out.print("<tr>");
            out.print("<td>" + teacher.getFirst_name() + "</td>");
            out.print("<td>" + teacher.getLast_name() + "</td>");

            StringBuffer buf = new StringBuffer();
            boolean first = true;
            for (Subject subject : teacher.getSubjects()) {
                if (first == true) {
                    buf.append("<td>" + subject.getSubject_name() + "</td>");
                    buf.append("</tr>");
                    first = false;
                } else {
                    buf.append("<tr><td></td><td></td>");
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