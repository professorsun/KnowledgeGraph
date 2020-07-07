package com.sanelee.springbootneo4jschool.model;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author sanelee
 * @date 2020/6/3
 **/
@NodeEntity
@Data
public class Profession extends BaseEntity{
    private String name;
    private String description;
    private int pid;
    private String code;
    private String major;
    private String subject;
}
