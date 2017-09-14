<%@page import="com.entity.Article"%>
<%@page import="com.entity.Nav"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List <Map>resultList=(List)request.getAttribute("resultList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>党委宣传部</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
	
  </head>
  <body>
  <div class="all">
  
  
	  <div>
	  
	   
	    <jsp:include page="top.jsp"></jsp:include>
	    <jsp:include page="nav.jsp"></jsp:include>
	    
	   </div>
   	
		   <div  class="change">
		   <jsp:include page="main-left.jsp"></jsp:include>
		    	<div class="index-main-box w" style="position:absolute;left:400px; top:300px; margin:0;">
			       <%
			       for(Map map:resultList){
			    	   Nav nav=(Nav)map.get("nav");
			    	   int i=0;
			    	   List <Article>articleList=(List)map.get("articleList");//过来的是对象，需要进行类型转换
			       %>
		      		<div style="border-bottom:1px solid #E5B96F; padding:5px; width:500px;">
		      			<table >
				           <tr ><span class="titlefont"><%=nav.getNav_name() %></span></tr><a class="asheet" href="articleList.html?nav_id=<%=nav.getNav_id() %>" class="more" target="_blank" >MORE</a> 
				           <td>
				              <%if(articleList.size()<1){
				            	  out.println("<td>暂无最新新闻</td>");
				              }else for(Article a:articleList){%>
				              <tr><a class="uncontrolnews" href="item.html?article_id=<%=a.getArticle_id()%>"  style="text-decoration:none; color:black; font-size:15px;" target="_blank"  title="<%=a.getArticle_title() %>"><%=a.getArticle_title() %></a><span><%=a.getArticle_data()%></span></tr>
				              <%} %>
				         </table>
				     </div>
		      	<%} %>
		    </div>
		     <div class="flash" style="position:absolute;top:300px;right:20px;">
		    <img id="obj" src="images/flash2_1.jpg"></img>
		 </div>
		 <div class="downlowd">
		 <span>下载文件</span>
		 	<div>
		 		<p style="padding-bottom:0.2cm;"><a href="<%=basePath%>file/贵州师范学院新媒体建设备案登记表.docx">贵州师范学院新媒体建设备案登记表.docx</a></p>
		 		<p><a href="<%=basePath%>file/文韬苑二楼道德讲堂使用申请表.doc">文韬苑二楼道德讲堂使用申请表.doc</a></p>
		 	</div>
		 </div>
		 <div class="uncontrolright">
		 	<jsp:include page="main-right.jsp"></jsp:include>
		 </div>
  </div>  
	 
	 <script type="text/javascript">
    		var curIndex=0;
			 var timeInterval=1000;
			 var arr=new Array();
			 arr[0]="<%=basePath%>images/flash2_1.jpg";
			 arr[1]="<%=basePath%>images/flash2_2.jpg";
			 arr[2]="<%=basePath%>images/flash2_3.jpg";
			 arr[3]="<%=basePath%>images/flash2_4.jpg";
			 setInterval(changeImg,timeInterval);
			 
			 function changeImg()
			{
			    var obj=document.getElementById("obj");
			    if (curIndex==arr.length-1) 
			    {
			        curIndex=0;
			    }
			    else
			    {
			       curIndex+=1;
			    }
			    obj.src=arr[curIndex];
			}
    
    </script>
     </body>
</html>
