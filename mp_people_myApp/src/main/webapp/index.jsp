<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <b>Hello, people!</b>
    <p>
    <form method="POST" action="/people">
       <table>
           <tr><td>firstName</td><td><input type="text" name="firstName"</td></tr>
           <tr><td>lastName</td><td><input type="text" name="lastName"</td></tr>
           <tr><td>patronymic</td><td><input type="text" name="patronymic"</td></tr>
           <tr><td>sex</td><td>
               <input name="sex" type="radio" value="Male"> Male
               <input name="sex" type="radio" value="Woman"> Woman
           </td></tr>
           <tr><td>age</td><td><input type="number" name="age"</td></tr>
           <tr><td>profession</td><td><input type="text" name="profession"</td></tr>
           <tr><td>status</td><td><input type="text" name="status"</td></tr>


           <tr><td align="right" colspan="2"><input type="submit" value="Отправить"></td></tr>
       </table>
    </form>
</body>
</html>

