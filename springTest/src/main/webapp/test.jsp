<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    hello world!
    test git!
            访问springMVC的界面！
    <br/>
    <!-- 访问路径最后为.jsp，jsp文件与WEB-INF目录同一级    20190221 -->
    <a href="/springTest/insertClassData.jsp">添加班级信息</a>
    <br/>
    <!-- 访问路径不添加.jsp  20190221 -->
    <a href="/springTest/queryClass">查询全部的班级信息</a>
</body>
</html>