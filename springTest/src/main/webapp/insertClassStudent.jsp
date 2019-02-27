<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>同时插入班级和人员信息</title>
</head>
<body>
  <h1>插入班级信息</h1>
  <form action="/springTest/insertCS" method="post">
  <table>
   <tr>
     <td>班级名称:</td>
     <td><input type="text" name="class_name"/></td>
   </tr>

   
   <tr>
     <td>人员姓名:</td>
     <td><input type="text" name="name"/></td>
   </tr>
   <tr>
     <td>年龄:</td>
     <td><input type="text" name="age"/></td>
   </tr>
   <tr>
     <td>学号:</td>
     <td><input type="text" name="school_number"/></td>
   </tr>
   <tr>
     <td>班级id:</td>
     <td><input type="text" name="class_s"/></td>
   </tr>
   
   
   <tr>
     <td><input type="submit" value="提交"/></td>
   </tr>
   </table>
  </form> 
</body>
</html>