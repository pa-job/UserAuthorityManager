
	/**  
     * @Title: UserController.java
 	 * @Package cn.userCenter.controller
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月17日
 	 * @version V1.0  
 	 */

        
package cn.soa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.dao.LogMapper;
import cn.soa.entity.LogRecord;
import cn.soa.entity.UserInfo;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.entity.headResult.UserTableJson;
import cn.soa.service.inter.LogServiceInter;
import cn.soa.service.inter.RoleServiceInter;
import cn.soa.service.inter.UserServiceInter;


/**
  * @ClassName: UserController
  * @Description: 人员管理 - 控制层
  * @author zhugang
  * @date 2019年1月17日
  */
@RestController
@RequestMapping("/logs")
public class LogController {
	private static Logger logger = LoggerFactory.getLogger( LogController.class );
	
	@Autowired
	private LogServiceInter logService;
	
	@GetMapping("")
	public ResultJson<List<LogRecord>> findAllC(){
		logger.debug( "----------查找全部日志-----------" );
		List<LogRecord> logs = logService.findAll();
		if( logs != null ) {
			return new ResultJson<List<LogRecord>>(  0, "查询成功", logs);
		}
		return new ResultJson<List<LogRecord>>(  1, "查询失败或或数据为空", logs);
	}
	
	@GetMapping("/userid")
	public ResultJson<List<LogRecord>> findByUseridC(@RequestParam("userid") String userid ){
		logger.debug( "----------按用户id查找日志-----------" );
		List<LogRecord> logs = logService.findByUserid(userid);
		if( logs != null ) {
			return new ResultJson<List<LogRecord>>(  0, "查询成功", logs);
		}
		return new ResultJson<List<LogRecord>>(  1, "查询失败或或数据为空", logs);
	}
	
	@PostMapping("")
	public ResultJson<Integer> saveOrganBackIdC( @RequestBody LogMapper logrecord ){
		logger.debug( "----------保存日志记录-----------" );
		logger.debug( logrecord.toString() );
		int i = logService.saveOrganBackId( logrecord );
		if( i > 0) {
			return new ResultJson<Integer>(  0, "查询成功", i );
		}
		return new ResultJson<Integer>(  1, "查询失败或或数据为空", i );
	}
	
}
