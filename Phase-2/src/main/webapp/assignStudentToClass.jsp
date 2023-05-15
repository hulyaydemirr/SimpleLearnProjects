<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.simplilearn.entity.Student" %>
<%@ page import="com.simplilearn.entity.Classes" %>
<%@ page import="java.util.List" %>
<%@ page import="com.simplilearn.configuration.DatabaseConfiguration" %><%--
  Created by IntelliJ IDEA.
  User: elif.karaca
  Date: 2.03.2023
  Time: 16:25
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

<h1>Assign a Student to a Class</h1>
<%
    SessionFactory sf = DatabaseConfiguration.getSessionFactory();
    Session hibernateSession = sf.openSession();
    List<Student> students = hibernateSession.createQuery("from Student").list();
    List<Classes> classes = hibernateSession.createQuery("from Classes").list();
%>
<form action="assignStudent" method="post">
    <table>
        <tr>
            <th>Student Name</th>
            <th>Class Name</th>
        </tr>
        <tr>
            <td>
                <select name="name">
                    <%
                        for (Student student : students) {
                            out.print("<option>" + student.getFname() + " " + student.getLname());
                            out.print("</option>");
                        }
                    %>
                </select>
            </td>

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
        </tr>
    </table>
    <input type="submit" value="Submit">
</form>

</body>
</html>
