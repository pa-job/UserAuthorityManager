$(function(){
	
	/**
	 * 参数定义
	 */
	var table = layui.table,
		layer = layui.layer,
		gUrl = ipPort + "/logs",
		gUrlByNum = ipPort + "/logs/userid";
		

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
		console.log( data );
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
//		console.log( data );
		var arr = [];
		arr.push(data);
		//执行重载
		$( '#tableDiv' ).empty().append(' <table class="layui-hide" id="user_table" lay-filter="user_table"></table>');
		generateBTable( 'user_table', arr );
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
		    	,{field:'operateTime', title:'操作时间',   align:'center'}
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