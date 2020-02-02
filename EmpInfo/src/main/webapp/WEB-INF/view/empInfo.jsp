<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Information</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<h1>Welcome to Employee Information application</h1>
<div class="">
<div class="form-group row">
<input type="text" readonly class="form-control-plaintext"
id="staticEmail" value="">
<!-- https://www.baeldung.com/spring-file-upload -->
<form:form action="" modelAttribute="empbean" method="post" enctype="multipart/form-data">  
<table>
<tr>
<td>EmpId:</td>
<td><form:input path=""  readonly="true"/></td>
</tr>
<tr>    
<td>EmpName: </td>   
<td><form:input path=""  /></td>  
</tr>
<tr>    
<td>EmpSalary: </td>   
<td><form:input path=""  /></td>  
</tr>
<tr>    
<td>EmpCity: </td>   
<td><form:input path=""  /></td>  
</tr>
<tr>    
<td>EmpGender: </td>   
<td>Male : <form:radiobutton path=""  value="M"/><br>
Female : <form:radiobutton path=""  value="F"/></td>  
</tr>
<tr>    
<td>EmpAge: </td>   
<td><form:input path=""  /></td>  
</tr>
<tr>    
<td>EmpAge: </td>   
<td><input type="file" id="file" name="file" /></td>  
</tr>
<tr>    
<td>EmpSkills: </td>
<td>
JAVA : <form:checkbox path="empSkills"  value="Java"/>
WEbservice : <form:checkbox path="empSkills"  value="WS"/>
Hibernate : <form:checkbox path="empSkills"  value="HBM"/>
Spring : <form:checkbox path="empSkills"  value="SPRING"/>
Python : <form:checkbox path="empSkills"  value="PY"/>
</td>  
</tr>
<tr>    
<td colspan="2"><input type="submit" value="Save" class="btn btn-success"/></td>    
</tr>             
</table>
</form:form>
</div>
<hr>
<table class="table table-striped">
<thead>
<tr>
      <th scope="col">EmpId</th>
      <th scope="col">EmpName</th>
      <th scope="col">EmpAge</th>
      <th scope="col">EmpSalary</th>
      <th scope="col">EmpCity</th>
      <th scope="col">Actions</th>
    </tr>
</thead>
<%-- <c:forEach items="" var=""> --%>
<!-- <tbody> -->
<!-- <tr> -->
<%-- <th scope="row"><c:out value=""/></th> --%>
<%-- <td><c:out value=""/></td> --%>
<%-- <td><c:out value=""/></td> --%>
<%-- <td><c:out value=""/></td> --%>
<%-- <td><c:out value=""/></td> --%>
<!-- <td> -->
<%-- <a href="/newjavamvc/emp/save/edit/<c:out value=""/>">EDIT</a><br> --%>
<%-- <a href="/newjavamvc/emp/save/delete/<c:out value=""/>">DELETE</a><br> --%>
<!-- </td> -->
<!-- </tr> -->
<!-- </tbody> -->
<%-- </c:forEach> --%>

</table>
</div>
</body>
</html>