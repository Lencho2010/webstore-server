package com.geoway.webstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ReportTemplate)实体类
 *
 * @author makejava
 * @since 2021-11-02 14:17:27
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportTemplate implements Serializable {
    private static final long serialVersionUID = -21321451997160761L;
    
    private Long id;
    /**
    * 模板名称
    */
    private String name;
    /**
    * 统计类型，关联report_type表中的type字段
    */
    private String statisticType;
    /**
    * 模板编号
    */
    private String code;
    /**
    * 模板展示排列顺序
    */
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(String statisticType) {
        this.statisticType = statisticType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}