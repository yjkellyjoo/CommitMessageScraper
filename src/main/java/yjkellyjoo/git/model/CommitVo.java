package yjkellyjoo.git.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommitVo {

    private String reponame;
    private String commitId;
    private boolean nvdBool;
    private boolean cveBool;
    private String message;
}
