<%@page import="com.entity.Nav"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List <Nav>list=(List)request.getAttribute("navList");
if(list==null)return;
%>
<body>
<div class="top1">
    	<div class="logo">
    			<img src="<%=basePath%>images/logo.png" />
    	</div>
    	<div class="nav">
	    	<div class="nav-box">
	         <ul class="w">
	           <li class="active"><a href="http://www.gznc.edu.cn/">学校首页</a></li>
	           <li class="active"><a href="index.html">首页</a></li>
	           <%for(Nav nav:list) {%>
	           <li><a href="articleList.html?nav_id=<%=nav.getNav_id() %>" target="_blank"><%=nav.getNav_name() %></a></li>
	          <%} %>
	         </ul>
			</div>
    	<!-- <form id="frm" action="search.html" method="get">
       
         <input name="searchTxt" placeholder="请输入关键字" autocomplete="off" value="<%=request.getAttribute("searchTxt")==null?"":request.getAttribute("searchTxt")%>"/>
         <input name="p" id="p" type="hidden" complete="off" value=""/> 
         <input type="submit" id="submit" value="搜索">
         
        </form>  -->
    	</div>
    	<div class="campus">
    		<img src="<%=basePath%>images/index_bg01.jpg" class="picture" />
    	</div>
</div>
</body>