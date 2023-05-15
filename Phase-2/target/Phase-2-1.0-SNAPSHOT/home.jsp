<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<p> This is home page!</p>
<%
    Object email = request.getAttribute("email");
    if (email != null) { %>
<span style="color:red;"><%=email.toString()%></span>
<%}%>
<p>What you want to do?</p>
<table>
    <tr>
        <th>Add Items</th>
        <th>View Items</th>
    </tr>
    <tr>
        <td><a href="HTML/addClasses.html">Add Class</a><br/></td>
        <td><a href="viewClass.jsp">View Classes</a><br/></td>
    </tr>
    <tr>
        <td><a href="HTML/addSubject.html">Add Subject</a><br/></td>
        <td><a href="viewSubject.jsp">View Subjects</a><br/></td>
    </tr>
    <tr>
        <td><a href="HTML/addTeacher.html">Add Teacher</a><br/></td>
        <td><a href="viewTeachers.jsp">View Teachers</a><br/></td>
    </tr>
    <tr>
        <td><a href="HTML/addStudent.html">Add Student</a><br/></td>
        <td><a href="viewStudent.jsp">View Students</a><br/></td>
    </tr>
</table>
<br>
<a href="assignStudentToClass.jsp">Assign Student to Class</a><br>
<a href="assignTeacherToSubject.jsp">Assign Teacher to Class</a><br>
<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>
<a href="chooseClassReport.jsp">Choose Class for report</a>
</body>
</html>