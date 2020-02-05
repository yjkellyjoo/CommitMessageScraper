package yjkellyjoo.nvd.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import yjkellyjoo.nvd.dao.CveDao;

@Slf4j
@Service("yjkellyjoo.nvd.service.NvdCommitService")
public class NvdCommitService {

	@Resource(name = "yjkellyjoo.nvd.dao.CveDao")
	private CveDao cveDao;
	
	public void scrapGitRef() {
		
	}
}
