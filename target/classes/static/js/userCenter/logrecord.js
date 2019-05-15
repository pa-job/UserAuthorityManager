$(function(){
	
	/**
	 * 参数定义
	 */
	var table = layui.table,
		layer = layui.layer,
		gUrl = ipPort + "/logs",
		gUrlByNum = ipPort + "/logs/userid";
	
	//获取usernum
	var username = getCookie1("name");
	username = username.substr( 1, username.length-2);
	var usernum = getCookie1("num");
	usernum = usernum.substr( 1, usernum.length-2);
	userRole = getCookie1("roleNames");
	$('.userName').text(username);
	$('.adminName').text(username);

	var logdata = {};	
	logdata.operateTime = new Date().toLocaleDateString();
	logdata.personid = usernum;
	logdata.personname = username;
	logdata.sourcename = "日志管理";
	
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

	/**
	 * 页面初始化
	 */
	//表格初始化
	ajax( 'get', gUrl, {}, getLogsSF, false );
	
	/*
	 * 表格初始化请求成功回调函数
	 */
	function getLogsSF( data ){
		console.log( '---------表格初始化请求成功回调函数----------' );
		//console.log( data );
		generateBTable( 'user_table', data );
	}
	$('#search').on('click',function(){
		ajax( 'get', gUrlByNum, {"userid":$.trim( $('#search_value').val() ) }, getLogsByNumSF );
	})
	
	
	/*
	 * 搜索请求成功回调函数
	 */
	function getLogsByNumSF( data ){
		console.log( '--------搜索请求成功回调函数--------' );
		console.log( data );
		var arr = [];
		arr.push(data);
		//执行重载
		$( '#tableDiv' ).empty().append(' <table class="layui-hide" id="user_table" lay-filter="user_table"></table>');
		generateBTable( 'user_table', data );
	}

	/*
	 * 生成前台表格
	 */
	function generateBTable( id, data ){
		table.render({
			elem : '#' + id,
			title: '用户数据表',
			data : data,
			page : true,
			even : true,			
			autoSort : false,
			count : data.length,
			curr : 0,
			limit : 10,
			limits : [ 10, 13, 20, 25, 30 ],
			layout : [ 'prev', 'page', 'next', 'skip',
					'count', 'limit' ],
			cols : [ [
				{type: 'numbers',title:'序号', align:'center'}
		    	,{field:'lrid', title:'id',  fixed: 'left', hide: true, align:'center'}
		    	,{field:'operateTime', title:'访问时间',   align:'center'}
		    	,{field:'personid', title:'用户id',  align:'center'}
		    	,{field:'personname', title:'用户姓名',  align:'center'}
		    	,{field:'sourcename', title:'资源名称', align:'center'}
			] ],
			id: 'testReload',
			done : function(res, curr, count) {
			}
		});
	}
	
	
	
})