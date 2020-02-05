package yjkellyjoo.runtime.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Getter;

/**
 * Dao 지원 클래스
 * @author 	yjkellyjoo
 * @since 	2020. 02. 05.
 */
@Getter
public abstract class GitDaoSupport {

	@Qualifier("dataSourceGit")
	@Autowired
	private SqlSessionTemplate sqlSession;

}
