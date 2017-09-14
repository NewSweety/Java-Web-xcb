<%@page import="com.entity.Manager"%>
<%@page import="com.action.bean.ActionBean"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String manager_id=request.getParameter("manager_id");
ActionBean actionBean=new ActionBean();
Manager manager= actionBean.queryManagerById(manager_id);
if(null==manager){
	response.sendRedirect("managerList.jsp");
	return;
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改管理员信息</title>
    
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
    <h1 class="title">修改管理员信息<a href="admin/managerList.jsp" class="back-btn">返回</a></h1>
    <form action="admin/editManager" id="frm" method="post">
    <table>
    <tr><td>登录账号：</td><td><input id="manager_id" name="manager_id" 
    readonly="readonly" autocomplete="off" maxlength="10" type="text" value="<%=manager.getManager_id()%>"/></td><td id="err_manager_id"></td></tr>
    <tr><td>真实姓名：</td><td><input id="manager_name" name="manager_name" autocomplete="off" maxlength="20" type="text" value="<%=manager.getManager_name()%>"/></td><td id="err_manager_name"></td></tr>
    <tr><td></td><td><a class="btn" onclick="startPost();" href="javascript:void(0)">保存</a></td></tr>
    </table>
    </form>
    </div>
    </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include> 
    <script type="text/javascript">
    function valiInput(id,msg,n){
    	var val=document.getElementById(id).value; 
    	if(val==""||val.length<2){
    		document.getElementById("err_"+id).innerHTML="<span class='err'>"+msg+"</span>";
    		return false;
    	}else{
    		document.getElementById("err_"+id).innerHTML="<span class='succese'>验证通过</span>";
    		return true;
    	}
    }
    function valiPwd(){
    	if(document.getElementById("manager_pwd").value!=document.getElementById("re_manager_pwd").value){
    		document.getElementById("err_re_manager_pwd").innerHTML="<span class='err'>两次输入的密码不一样。</span>";
    		return false;
    	}
      return true;
    }
    function startPost(){
    	var ipts=["manager_name"];
    	var lens=[2];
    	var msg=["请输入真实姓名，至少2位。"];
    	var flag=true;
    	for(var i=0;i<ipts.length;i++){
    		flag=valiInput(ipts[i],msg[i],lens[i])&&flag;
    	}
    	
    	if(!flag)return;
    	document.getElementById("frm").submit();
    	/* var manager_id=document.getElementById("manager_id").value;
     	var manager_name=document.getElementById("manager_name").value;
    	var manager_pwd=document.getElementById("manager_pwd").value;
    	var re_manager_pwd=document.getElementById("re_manager_pwd").value; 
    	if(manager_id==""||manager_id.length<3){
    		document.getElementById("err_manager_id").innerHTML="<span class='err'>请输入登录账号，至少3位。</span>";
    	}else{
    		document.getElementById("err_manager_id").innerHTML="<span class='succese'>验证通过</span>";
    	}
 */
    }
    </script>
  </body>
</html>
