<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main-left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style3.css">
	

  </head>
  
  <body>
    <div class="background" style="background-image:url(image/123.png);">
    	<div class="shouye">
    		<div class="shouye-left">
    			<div style="margin-top:20px">
	    			<p style="color:#FFDC35;">Structure</p>
	    			<p style="color:#EAC100;margin-top:1px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机构设置</p>
    			</div>
    			<div class="jigou">
    				<span>
    					<h1>新闻宣传科</h1>
    					<span class="shouye-left-text" style="font-size:12px;">明义楼161 电话：0851-85816683</span>
    				</span>
    			</div>
    			<div class="jigou">
    				<span>
    					<h1>理论教育科</h1>
    					<span class="shouye-left-text" style="font-size:12px;">明义楼161 电话：0851-85816683</span>
    				</span>
    			</div>
    			<div class="jigou">
    				<span>
    					<h1>校报编辑部</h1>
    					<span class="shouye-left-text" style="font-size:12px;">明义楼161 电话：0851-85816683</span>
    				</span>
    			</div>
    			<div class="jigou">
    				<span>
    					<h1>网络管理科</h1>
    					<span class="shouye-left-text" style="font-size:12px;">明义楼161 电话：0851-85816683</span>
    				</span>
    			</div>
    			<div class="jigou">
    				<span>
    					<h1>综合办公室</h1>
    					<span class="shouye-left-text" style="font-size:12px;">明义楼161 电话：0851-85816683</span>
    				</span>
    				
    			</div>
    			
    			<div class="charact">
    				<p><img src="<%=basePath%>images/name1.jpg" /></p>
    				<div class="name1">
    					<p style="font-size:20px;color:#AE0000">邹晓青</p>
    					<p style="font-size:12px"><b>党委宣传部部长</b></p>
    				</div>
    				<p style="font-size:14px">女，仡佬族，中共党员，硕士研究生，教授。</p>
    			</div>
    			<div class="charact">
    				<p><img src="<%=basePath%>images/name2.jpg" /></p>
    				<div class="name2">
    					<p style="font-size:20px;color:#AE0000">孙筑萍</p>
    					<p style="font-size:12px"><b>党委宣传部副部长</b></p>
    				</div>
    				<p style="font-size:14px">女，汉族，中共党员，高级政工师。</p>
    			</div>
    			<div class="charact">
    				<p><img src="<%=basePath%>images/name3.jpg" /></p>
    				<div class="name3">
    					<p style="font-size:20px;color:#AE0000">孙秀华</p>
    					<p style="font-size:12px"><b>党委宣传部副部长</b></p>
    				</div>
    				<p style="font-size:14px">男，汉族，中共党员，文学博士，副教授。</p>
    			</div>
    		</div>
  </body>
</html>
