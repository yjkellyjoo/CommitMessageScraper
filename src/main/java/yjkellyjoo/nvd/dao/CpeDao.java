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

import yjkellyjoo.nvd.model.CpeProductVo;
import yjkellyjoo.nvd.model.CpeVo;
import yjkellyjoo.runtime.dao.NvdDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CPE 테이블 관리 DAO
 * @author Taejun Lee
 * @since 2019.01.16
 */

@Repository("yjkellyjoo.nvd.dao.CpeDao")
public class CpeDao extends NvdDaoSupport {


    /**
     * CPE 단일 레코드 조회
     * @param id 키값
     * @return CPE 레코드
     */
    public CpeVo selectCpe (String id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", id);

        return getSqlSession().selectOne("yjkellyjoo.nvd.dao.CpeDao.selectCpe", paramMap);
    }

    /**
     * 단일 CPE 등록
     * @param cpeData
     */
    public void insertCpe(CpeVo cpeData) {

        getSqlSession().insert("yjkellyjoo.nvd.dao.CpeDao.insertCpe", cpeData);
    }


    /**
     * CPE Array 등록
     * @param cpeArray
     */
    public void insertAllCpes(List<CpeVo> cpeArray) {

        getSqlSession().insert("yjkellyjoo.nvd.dao.CpeDao.insertAllCpes", cpeArray);
    }

    /**
     * CPE_DATA 갱신
     * @param cpeData
     */
    public void updateCpe(CpeVo cpeData) {
        getSqlSession().update("yjkellyjoo.nvd.dao.CpeDao.updateCpe", cpeData);
    }
    
    /**
     * TB_CPE_DATA 테이블 지우기
     */
    public void deleteAllCpeData() {
        getSqlSession().delete("yjkellyjoo.nvd.dao.CpeDao.deleteAllCpeData");
    }
    
    /**
     * TB_CPE_DATA 테이블에서 TB_CPE_PRODUCT로 로딩하기
     * @return
     */
    public int insertAllCpeProductFromCpeData() {
    	
    	return getSqlSession().insert("yjkellyjoo.nvd.dao.CpeDao.insertAllCpeProductFromCpeData");
    }

    /**
     * TB_CPE_PRODUCT 지우기
     */
    public void deleteAllCpeProduct() {
    	
        getSqlSession().delete("yjkellyjoo.nvd.dao.CpeDao.deleteAllCpeProduct");
    }
    
    /**
     * 모든 TB_CPE_PROUCT 조회
     * @return
     */
    public List<CpeProductVo> selectAllCpeProductList() {
    	
    	return getSqlSession().selectList("yjkellyjoo.nvd.dao.CpeDao.selectAllCpeProductList");
    }
    
    /**
     * TB_CPE_PRODUCT 여러건 등록
     * @param vo
     * @return
     */
    public int insertCpeProductList(List<CpeProductVo> voList) {
    	
    	return getSqlSession().insert("yjkellyjoo.nvd.dao.CpeDao.insertCpeProductList", voList);
    }
    
    /**
     * TB_CPE_PRODUCT 단건 등록
     * @param vo
     * @return
     */
    public int insertCpeProduct(CpeProductVo vo) {
    	
    	return getSqlSession().insert("yjkellyjoo.nvd.dao.CpeDao.insertCpeProduct", vo);
    }
    
    /**
     * TB_CPE_PRODUCT 단건 조회
     * @param vendor
     * @param product
     * @return
     */
    public CpeProductVo selectCpeProduct(String vendor, String product) {
    	
    	Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("vendor", vendor);
        paramMap.put("product", product);
        
    	return getSqlSession().selectOne("yjkellyjoo.nvd.dao.CpeDao.selectCpeProduct", paramMap);
    }
}
