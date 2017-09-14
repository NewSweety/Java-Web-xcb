<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main-right.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style3.css">

  </head>
  
  <body>
    <div class="shouye-right">
    			<p class="lianxi"><a href="" style="text-decoration:none;">联系我们</a>&nbsp;<a href="" style="text-decoration:none;">留言板</a></p>
    			<form id="frm" class="frm" action="search.html" method="get">
       
			         <input name="searchTxt" placeholder="请输入关键字" autocomplete="off" value="<%=request.getAttribute("searchTxt")==null?"":request.getAttribute("searchTxt")%>"/>
			         <input name="p" id="p" type="hidden" complete="off" value=""/> 
		         		<input type="submit" id="submit" value="搜索">
		         
        		</form>
        <div>
    				<div class="banner">
    					<p style="padding:5px;padding-left:10px">工作计划</p>
    				</div>
    				<div class="gongzuojihua">
    					
    				</div>
    			</div>
    			<div>
    				<div class="banner">
    					<p style="padding:5px;padding-left:10px">校报阅读</p>
    				</div>
    				<div class="xiaobaoyuedu">
    					<a href=""><img src="<%=basePath%>images/xiaobao.jpg"></img></a>
    				</div>
    			</div>
    			<div>
    				<div class="banner">
    					<p style="padding:5px;padding-left:10px">风采展示</p>
    				</div>
    				<div class="fengcaizhanshi">
    					
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>
