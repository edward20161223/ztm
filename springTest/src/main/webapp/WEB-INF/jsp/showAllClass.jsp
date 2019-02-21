<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style>
#middle{ margin:0 auto; width:500px; height:100px;}
</style>
</head>
<body>

  <div id='middle'>
    <br>
    <!-- 可以获取到id值 -->
    <table border="1">
        <tr>
            <th>id</th>
            <th>班级名称</th>
            <th>创建时间</th>
        </tr>
        <c:forEach items="${requestScope.BJ}" var="BJ">
            <tr> 
                <td>${BJ.class_id}</td>
                <td>${BJ.class_name}</td>
                <td>${BJ.create_time}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
    
    <br>
    <!-- 结果集无id值显示 --> 
    <!-- 
    ${requestScope.BJ}
    -->
    
</body>
</html>