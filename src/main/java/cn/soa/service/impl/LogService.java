
	/**  
     * @Title: userService.java
 	 * @Package cn.userCenter.service.impl
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.soa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import cn.soa.dao.LogMapper;
import cn.soa.dao.UserInfoMapper;
import cn.soa.dao.UserMapper;
import cn.soa.entity.LogRecord;
import cn.soa.entity.UserInfo;
import cn.soa.entity.UserOrganization;
import cn.soa.service.inter.LogServiceInter;
import cn.soa.service.inter.UserServiceInter;
import cn.soa.util.GlobalUtil;
import cn.soa.dao.UserRoleMapper;



	/**
 	 * @ClassName: userService
 	 * @Description: 用户信息服务  - 业务层
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */
@Service
public class LogService implements LogServiceInter{
	private static Logger logger = LoggerFactory.getLogger( LogService.class );

	@Autowired
	private LogMapper logMapper;

	@Override
	public List<LogRecord> findAll(){
		try {
			List<LogRecord> logs = logMapper.findAll();
			return logs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public List<LogRecord> findByUserid( String userid ){
		try {
			List<LogRecord> logs = logMapper.findByUserid(userid);
			return logs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public int saveOrganBackId( LogMapper logrecord ) {
		try {
			LogRecord l = new LogRecord();
			int i = logMapper.saveLogBackId( l );
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}	
	}
	
}
