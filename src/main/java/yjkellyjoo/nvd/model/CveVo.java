/**
 * Copyright (c) 2018 IoTcube, Inc.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of IoTcube, Inc. 
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with IoTcube, Inc.
*/

package yjkellyjoo.nvd.model;


import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

/**
 * CVE_DATA 테이블 관리 VO
 * @author  yjkellyjoo
 * @since 	2019. 1. 29.
 */
@Getter
@Setter
public class CveVo {
	//enumerations
	public enum V3Severity {NULL, NONE, LOW, MEDIUM, HIGH, CRITICAL}
	public enum V2Severity {NULL, LOW, MEDIUM, HIGH}
	
	//TB_CVE_DATA
	private String id;
	private String basicInfo;
	private String affects;
	private String problemType;
	private String cweId;
	private String references;
	private String description;
	private Timestamp publishedDate;
	private Timestamp lastModifiedDate;
	private String configurations;
	private String baseMetricV3;
	private float v3BaseScore;
	private V3Severity v3Severity; 
	private String baseMetricV2;
	private float v2BaseScore;
	private V2Severity v2Severity; 

}
