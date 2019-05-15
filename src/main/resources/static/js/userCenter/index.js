var element = layui.element,
layer = layui.layer,
logoutUrl = ipPort + "/user/logout",	
roleAuthUrl = ipPort + "/user/role/auths",
roleAuthJsonUrl = ipPort + "/user/auths",
username;
	

$(function(){
	
	/*
	 * 加载用户名
	 */
	//获取usernum
	var username = getCookie1("name");
	username = username.substr( 1, username.length-2);
	userRole = getCookie1("roleNames");
	var usernum = getCookie1("num");
	usernum = usernum.substr( 1, usernum.length-2);
	$('.userName').text(username);
	$('.adminName').text(username);

	
	var logdata = {};	
	logdata.operateTime = new Date().toLocaleDateString();
	logdata.personid = usernum;
	logdata.personname = username;
	
	logdata.sourcename = "主页";
	
	$.ajax({
	     type: "post",
	     url: ipPort+"/logs",
	     data: JSON.stringify(logdata),
	     async: true, //默认
	     cache: true, //默认
	     contentType: "application/json",
	     dataType: "json",
	     success: function( jsonData ){
	    	 if( jsonData ){
	    		 if( jsonData.state == 0 ){
	    			 console.log('日志保存成功');
	    		 }else{
	    			 console.log('日志保存失败');
	    		 }
	    		 
	    	 }
	     },
	     error:function(){
	    	 layer.msg('请求失败：');
	     }		       
	});
	
	//从cookie 中获取用户角色,用户名字
 	var role=$.cookie('role').replace(/\"/g, "");
    console.log(userRole);
	//为导航栏添加点击事件
	$('#secondMeno >li').each(function(i,obj){
		$(this).click(function(){
			$('#ifra').attr('src', $(this).attr('url') );
		});
	})
	

	//退出事件绑定	
	$('#logout').on('click', logoutCallBack );				
})

/**
 * 退出事件绑定回调函数
 * @type 
 */
function logoutCallBack(){
	console.log( '----------退出事件绑定回调函数----------');
	//关闭链接请求
	$.ajax({
	    url: logoutUrl,
	    type: 'post',
	    data: {},
	    dataType: 'json',
	    success: function (jsonData) {
	    	console.log( jsonData );
	        if (jsonData.state == 302) {
	            location.href = ipPort +  jsonData.data;
	        }else{
	        	layer.msg("登出失败", {icon:2});
	        }
	    }
	});      
	return false;
}