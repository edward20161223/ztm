<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>插入班级信息</title>
</head>
<body>
  <h1>插入班级信息</h1>
  <form action="/springTest/insertBanji" method="post">
  <table>
   <tr>
     <td>班级名称:</td>
     <td><input type="text" name="class_name"/></td>
   </tr>
   <tr>
     <td>班级创建日期:</td>
     <td><input type="text" name="create_time"/></td>
   </tr>
   <tr>
     <td><input type="submit" value="提交"/></td>
   </tr>
   </table>
  </form> 
</body>
</html>