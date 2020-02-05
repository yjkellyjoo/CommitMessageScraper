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

import yjkellyjoo.runtime.util.StringUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * TB_CPE_PRODUCT
 * @author 	hyeonggookim
 * @since 	2019. 2. 12.
 */
@Getter
@Setter
public class CpeProductVo {

	private String vendor;
	private String product;
	
	public CpeProductVo(String vendor, String product) {
		this.vendor = vendor;
		this.product = product;
	}
	
	public String getKey() {
		
		return StringUtil.getProductKey(this.vendor, this.product);
	}
}
