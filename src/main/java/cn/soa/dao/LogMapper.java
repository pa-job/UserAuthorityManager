/**  
 * @Title: userMapper.java
 * @Package cn.userCenter.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月9日
 * @version V1.0  
 */

        
package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.LogRecord;
import cn.soa.entity.UserOrganization;


/**
 * @ClassName: userMapper
 * @Description: 日志数据dao层
 * @author zhugang
 * @date 2019年1月9日
 *
 */
@Mapper
public interface LogMapper {
	
	public List<LogRecord> findAll();
	
	public List<LogRecord> findByUserid( @Param("userid") String userid );
	
	public int saveLogBackId( LogRecord logrecord );
	
}
