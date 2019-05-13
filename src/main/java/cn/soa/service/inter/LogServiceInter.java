
	/**  
     * @Title: userServiceInter.java
 	 * @Package cn.userCenter.service.inter
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.soa.service.inter;

import java.util.List;
import java.util.Map;

import cn.soa.dao.LogMapper;
import cn.soa.entity.LogRecord;
import cn.soa.entity.UserInfo;
import cn.soa.entity.UserOrganization;


/**
 	 * @ClassName: userServiceInter
 	 * @Description: 
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */

public interface LogServiceInter {

	List<LogRecord> findAll();

	List<LogRecord> findByUserid(String userid);

	int saveOrganBackId(LogMapper logrecord);
	
}
