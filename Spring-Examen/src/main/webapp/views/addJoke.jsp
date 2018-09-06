<%--
  Created by IntelliJ IDEA.
  User: didiercolaes
  Date: 06/09/2018
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <title>add joke</title>
</head>
<body>
<br/>
<form method=POST action='joke'>
    <div class='form-group row'>
        <div class='col-xs-4'>
            <label for='firstName'>First Name : </label>
            <input type='text' class='form-control' name='firstName' id='firstName'>
        </div>
    </div>
    <div class='form-group row'>
        <div class='col-xs-4'>
            <label for='lastName'>Last Name : </label>
            <input type='text' class='form-control' name='lastName' id='lastName'>
        </div>
    </div>
    <input type=SUBMIT value='Save'>
</form>
</body>
</html>
