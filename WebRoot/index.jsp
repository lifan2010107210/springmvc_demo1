<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="/springmvc_demo1/user/hello5.do" method="POST">
   
    <input type="submit">
    </form>
    
    <form action="/springmvc_demo1/user/add2.do" method="POST">
    	名字:<input type="text" name="name">
    	年龄:<input type="text" name="age">
    	<input type="submit">
    </form>
    
     文件上传:<br>
    <form action="/springmvc_demo1/user/upload.do" 
    		method="POST" enctype="multipart/form-data">
    	文件:<input type="file" name="xxx">
    	<input type="submit">
    </form>
    
    
    
    <script src="//cdn.bootcss.com/jquery/1.8.2/jquery.min.js"></script>ss
    <script type="text/javascript">
    	$.post("/springmvc_demo1/user/validateLoginname.do",{},function(data){
    		alert(data);
    	});
    </script>
    
    
  </body>
</html>
