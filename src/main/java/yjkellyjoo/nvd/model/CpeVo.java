package yjkellyjoo.nvd.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * CPE DATA 테이블 관리 VO
 * @author Taejun Lee
 * @since 2019. 1. 16.
 */
@Getter @Setter
public class CpeVo {

    private String name;
    private String vendor;
    private String product;
    private String version;
    private Boolean deprecated;
    private String title;
    private String references;
    private String metadata;
    private Timestamp modificationDate;
    private int nvdId;
    private int deprecatedByNvdId;
    private String cpe23ItemName;
    private String cpe23Deprecation;
    private Timestamp deprecationDate;
    private String deprecatedBy;
}
