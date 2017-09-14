<%@page import="com.tools.MyFuns"%>
<%@page import="com.action.bean.ActionBean,com.entity.ArticlePojo,com.entity.Nav"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ActionBean actionBean=new ActionBean();
/*List <ArticlePojo>list=actionBean.queryArticle();
List <Map>list=actionBean.queryArticleMap();*/
//获取各参数
int p=MyFuns.string2Int(request.getParameter("p"));
String nav_id=request.getParameter("nav_id");
String article_title=request.getParameter("article_title");
System.out.println("article_title-----"+article_title);
if(p<0){
	response.sendRedirect("articleList.jsp");
}
Map resultMap=actionBean.queryArticleByPage(p,nav_id,article_title);
List <Map>list=(List)resultMap.get("list");/*actionBean.queryArticleMapByPage(p);*/
int rows=(Integer)resultMap.get("rows");
if(p>0&&list.size()<1){
	response.sendRedirect("articleList.jsp");
}
List<Nav> navList=(List)resultMap.get("navList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
  </head>
  
  <body>
  	<div class="main-frame">
    <jsp:include page="top.jsp"></jsp:include> 
    <jsp:include page="left.jsp"></jsp:include>
    <div class="right">
   <div class="admin">
       <h1 class="title">新闻信息管理<a href="admin/main.jsp" class="back-btn">返回主页</a></h1>
       <table class="tab" cellspacing="0">
       <tr>
          <td colspan="5">
          <form action="admin/articleList.jsp" method="post" id="frm">
             <label>新闻类别：</label>
               <select name="nav_id">
                  <option value="">==请选择新闻类别==</option>
                  <%for(Nav nav:navList){
                	  out.println("<option "+(nav.getNav_id().equals(nav_id)?"selected='selected'":"")+"value=\""+nav.getNav_id()+"\">"+nav.getNav_name()+"</option>");
                  }
                  
                  %>
               </select>
               <label>标题</label>
               <input type="text" name="article_title" id="article_title" value="<%=article_title==null?"":article_title %>"/>
               <input type="hidden" name="p" id="go_page_number" value="<%=p %>">
               <input type="submit" value="搜索"/>
               </form>
          </td>
       </tr>
       <tr><td style="width:40px;">选择</td><td class="text-center" style="width:40px;">序号</td><td >新闻标题</td><td >新闻类别</td><td>发布时间</td></tr>
       <%
       int i=10*p;
       int totalPages=(rows%10==0?rows/10:(rows/10+1));
         for(Map map:list){
       %>
     <tr>
       <td><input type="radio" name="rad" value="<%=map.get("article_id")%>" autocomplete="off"/></td>
       <td><%=++i %></td>
       <td><%=map.get("article_title")%></td>
       <td ><%=map.get("nav_name") %></td>
       <td><%=map.get("article_data") %></td>
     </tr>
        <% 
        }
       %>
       <tr id="underline">
		       <td colspan="5" class="page">
		       <span>共有<%=rows %>条记录</span><span>当前是第<%=p+1%>页</span>
		       <%if(p>0) {%>
		       <a href="javascript:void(0)" onclick="go2Page(0)">第一页</a>
		       <a href="javascript:void(0)" onclick="go2Page(<%=p-1 %>)">上一页</a>
		       <%} %>
		       <%if(p<totalPages-1){ %>
		       <a href="javascript:void(0)" onclick="go2Page(<%=p+1 %>)">下一页</a>
		       <a href="javascript:void(0)" onclick="go2Page(<%=totalPages-1 %>)">最后一页</a>
		       <%} %>
		       <span>共<%=totalPages%>页</span>
		       <%if(totalPages>1) { %>
		       <span>转到第
		            <select onchange="go2Page(this.value)">
		               <%for(int j=0;j<totalPages;j++){%>
		               <option value="<%=j%>"<%=j==p?"selected='selected'":""%>><%=j+1%></option>
		               <%} %>
		            </select>
		                   页
		       </span>
		       <%} %>
		       </td>
       </tr>
       <tr><td colspan="5" style="border-bottom: 0">
       <a class="btn" href="admin/addArticle.jsp">添加新闻</a>
       <a class="btn" href="javascript:void(0)" onclick="updataNews()">修改</a>
        <a class="btn" href="javascript:void(0)" onclick="deleteNews()">删除</a>
       </td></tr>
       </table>
    </div>
    </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include> 
    <div class="win-box" id="win-box">
    <h2 class="win-title">修改新闻管理<span onclick="closeNavwindow(0);">&times;</span></h2>
    <iframe src="" id="update-win"></iframe>
    </div>
    <script type="text/javascript">
    function go2Page(n){
    	document.getElementById("go_page_number").value=n;
    	document.getElementById("frm").submit();
    }
    function selectedRow(){
    	var ms=document.getElementsByName("rad");
    	var obj=null;
    	for(var i=0;i<ms.length;i++){
    		if(ms[i].checked){
    			obj=ms[i];
    			break;
    		}
    	}
    	if(null==obj){
    		alert("请选择一行在操作。");
    	}
    	return obj;
    }
    function updataNav(){
    	var obj=selectedRow();
    	if(obj==null)return;
    	updateNavwindow("admin/editNav.jsp?nav_id="+obj.value);
    	
    }
    function updataNews(){
    	var obj=selectedRow();
    	if(obj==null)return;
    	location="admin/editArticle.jsp?article_id="+obj.value;
    	
    }
    function deleteNews(){
    	  var obj=selectedRow();
    	  alert(obj.value);
      	  if(obj.value==null)return;
      	  if(confirm("删除后数据不能恢复，你确定要删除当前新闻吗？")){
      		 location="admin/deleteNews?article_id="+obj.value;
          }
       
    function updataManager(){
    	var obj=selectedRow();
    	if(obj==null)return;
    	location="admin/editManager.jsp?manager_id="+obj.value;
    }
      function deleteNav(){
    	  var obj=selectedRow();
    	  alert(obj.value);
      	  if(obj.value==null)return;
      	  if(confirm("你确定要删除当前类别吗？")){
      		 location="admin/deleteNav?nav_id="+obj.value;
      	  }
      function updateNavwindow(url){
    	  document.getElementById("win-box").style.display="block";
    	  document.getElementById("update-win").src=url;
      }
      function closeNavwindow(f){
    	  document.getElementById("win-box").style.display="none";
    	  if(f==1){
    		  location=location;
    	  }
      }}}
    </script>
  </body>
</html>
