<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'addStudentManager.jsp' starting page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

  </head>

  <body>
    <div>
    	<h1>添加商品</h1>
    	<form action="addUser" method="post" enctype="multipart/form-data">
            <input type="text" name="username"><br><br>
            <input type="text" name="password"><br><br>
            <input type="text" name="name"><br><br>
            <input type="text" name="salary"><br><br>
            <input type="text" name="telephone"><br><br>
            <input type="text" name="permission"><br><br>
			<input type="file" name="icon" accept="image/*"/><br><br>
			<input type="submit" value="提交"/>
    	</form>
    </div>
  </body>
</html>
