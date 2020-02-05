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
 * STATUS 테이블 관리 VO
 * @author 	yjkellyjoo
 * @since 	2019. 01. 17.
 */
@Getter
@Setter
public class StatusVo {
	private String type;
	private Timestamp timestamp;
	private String rawData;
}
