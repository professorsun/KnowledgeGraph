package com.sanelee.springbootneo4jschool.model;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author sanelee
 * @date 2020/6/3
 **/
@NodeEntity
@Data
public class School extends BaseEntity{
    private String name;
    private String areaname;
    private String description;
    private Integer scid;
    private Integer rank;
    private String region;
    private String type;
    private String department;
    private Integer is985;
    private Integer is211;
    private Integer isdoublefirstclass;
    private String schoolweb;
    private Integer foundingyear;


}
