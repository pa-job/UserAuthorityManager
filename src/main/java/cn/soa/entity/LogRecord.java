package cn.soa.entity;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
@Validated
public class LogRecord {
	private String lrid;
	private String lname;
	private String operateType;
	private String type;
	private String operateTime;
	private String personid;
	private String personname;
	private String operateName;
	private String sourcename;
	private String remark1;
	private String remark2;
	private String remark3;
}
