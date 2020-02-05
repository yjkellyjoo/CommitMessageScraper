/**
 * Copyright (c) 2018 IoTcube, Inc.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of IoTcube, Inc.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with IoTcube, Inc.
*/

package yjkellyjoo.nvd.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import yjkellyjoo.nvd.model.StatusVo;
import yjkellyjoo.runtime.dao.NvdDaoSupport;

import lombok.extern.slf4j.Slf4j;


/**
 * STATUS 테이블 관리 DAO
 * @author 	yjkellyjoo
 * @since 	2019. 01. 17.
 */
@Slf4j
@Repository("yjkellyjoo.nvd.dao.StatusDao")
public class StatusDao extends NvdDaoSupport {

	/**
	 * STATUS 단일 레코드 조회
	 * @param type 키값
	 * @return STATUS 레코드
	 */
	public StatusVo selectStatus(String type) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("type", type);

		return getSqlSession().selectOne("yjkellyjoo.nvd.dao.StatusDao.selectStatus", paramMap);
	}

	/**
	 * STATUS 등록
	 * @param STATUS
	 */
	public void insertStatus(StatusVo status) {
		log.debug("insert :{}", status.getType());
		getSqlSession().insert("yjkellyjoo.nvd.dao.StatusDao.insertStatus", status);
	}


	/**
	 * STATUS 갱신
	 * @param STATUS
	 */
	public void updateStatus(StatusVo status) {

		getSqlSession().update("yjkellyjoo.nvd.dao.StatusDao.updateStatus", status);
	}

}
