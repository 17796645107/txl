<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>商品后台管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		a{
			text-decoration: none;
			color:black;
		}
		a:HOVER {
			color:red;
		}
		div{
			margin-left:35px;

		}
		body{
			background-color: rgb(250,250,255);
		}
	</style>
  </head>

  <body>
  	<div>
  		<table>
  			<tr>
  				<td><a href="findUser" target="link">查看通讯录</a></td>
  			</tr>
            <tr>
                <td><a href="forwordAdd" target="link">添加同学</a></td>
            </tr>
  		</table>
  	</div>
  </body>
</html>
