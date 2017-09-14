function startPost(){
    	var nav_name=document.getElementById("nav_name").value;
    	var nav_feight=document.getElementById("nav_feight").value;
    	if(nav_name == ""){
    		document.getElementById("err_nav_name").innerHTML="<span class='err'>请输入类别名称。</span>";
    		return;
    	}
    	if(nav_feight == ""){
    		document.getElementById("err_nav_feight").innerHTML="<span class='err'>请输入类别排序权重，值越小越靠前。</span>";
    		return;
    	}
    	if(isNaN(parseInt(nav_feight))){
    		document.getElementById("err_nav_feight").innerHTML="<span class='err'>类别排序权重必须是数字，值越小越靠前。</span>";
    		return;
    	}
    	
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