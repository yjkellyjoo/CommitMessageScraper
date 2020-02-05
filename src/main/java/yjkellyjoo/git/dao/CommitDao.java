package yjkellyjoo.git.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import yjkellyjoo.git.model.CommitVo;
import yjkellyjoo.runtime.dao.GitDaoSupport;

@Repository("yjkellyjoo.git.dao.CommitDao")
public class CommitDao extends GitDaoSupport {
	
    /**
     * COMMIT 단일 레코드 조회
     * @param id 키값
     * @return COMMIT 레코드
     */
    public CommitVo selectCommit (String id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("reponame", id);

        return getSqlSession().selectOne("yjkellyjoo.git.dao.CommitDao.selectCommit", paramMap);
    }

    /**
     * 단일 COMMIT 등록
     * @param commitData
     */
    public void insertCommit(CommitVo commitData) {

        getSqlSession().insert("yjkellyjoo.git.dao.CommitDao.insertCommit", commitData);
    }


    /**
     * COMMIT Array 등록
     * @param commitArray
     */
    public void insertAllCommits(List<CommitVo> commitArray) {

        getSqlSession().insert("yjkellyjoo.git.dao.CommitDao.insertAllCommits", commitArray);
    }

    /**
     * COMMIT_DATA 갱신
     * @param commitData
     */
    public void updateCommit(CommitVo commitData) {
        getSqlSession().update("yjkellyjoo.git.dao.CommitDao.updateCommit", commitData);
    }
}
