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
    <a href="/springTest/insertClassData.jsp">添加班级信息</a><br/>
    
    <!-- 访问路径不添加.jsp  20190221 -->
    <a href="/springTest/queryClass">查询全部的班级信息</a><br/>
    
    <!-- redis测试  20190221 -->
    <a href="/springTest/redisTest">redis测试，添加获取数据</a><br/>
    
    <!-- 查询缓存redis，如果缓存中有则，直接返回缓存中的对象，如果缓存中没有，则查找数据库中的数据对象，并将对象保存在缓存中  20190225 -->
    <a href="/springTest/getClassById?id=10">测试redis缓存数据功能，结合数据库查询</a><br/>
    
    <!-- 测试spring+mybatis中的事务管理  20190227 -->
    <a href="/springTest/insertClassStudent.jsp">测试spring-redis中的事务</a><br/>
    
    
</body>
</html>

