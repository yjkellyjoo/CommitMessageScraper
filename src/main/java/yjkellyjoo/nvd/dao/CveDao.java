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
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import yjkellyjoo.nvd.model.CveVo;
import yjkellyjoo.runtime.dao.NvdDaoSupport;

/**
 * CVE 테이블 관리 DAO
 * @author  yjkellyjoo
 * @since 	2019. 1. 29.
 */
@Repository("yjkellyjoo.nvd.dao.CveDao")
public class CveDao extends NvdDaoSupport {

	/**
	 * CVE_DATA 단일 레코드 조회
	 * @param id 키값
	 * @return CVE_DATA 레코드
	 */
	public CveVo selectData(String id) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		
		return getSqlSession().selectOne("yjkellyjoo.nvd.dao.CveDao.selectData", paramMap);
	}
	
	/**
	 * CVE_DATA array 등록
	 * @param CVE_DATA array
	 */
	public void insertAllData(List<CveVo> cveArray) {
		
		getSqlSession().insert("yjkellyjoo.nvd.dao.CveDao.insertAllData", cveArray);
	}
	
	
	/**
	 * CVE_DATA 갱신 
	 * @param CVE_DATA
	 */
	public void updateData(CveVo cve) {
		
		getSqlSession().update("yjkellyjoo.nvd.dao.CveDao.updateData", cve);
	}
	
	/**
	 * CVE_DATA 테이블 지우기
	 */
	public void deleteAllData() {
		
		getSqlSession().delete("yjkellyjoo.nvd.dao.CveDao.deleteAllData");
	}

	/**
	 * CVE 목록 나눠서 조회
	 * @param start
	 * @param end
	 * @return
	 */
	public List<CveVo> selectCveListInLimit(int start, int end) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", end);
		
		return getSqlSession().selectList("yjkellyjoo.nvd.dao.CveDao.selectCveListInLimit", paramMap);
	}
	
}
