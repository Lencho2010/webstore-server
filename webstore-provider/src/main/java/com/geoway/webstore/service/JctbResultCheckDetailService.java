package com.geoway.webstore.service;

import com.geoway.webstore.dto.JctbResultCheckDetailDto;
import com.geoway.webstore.entity.JctbResultCheckDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (JctbResultCheckDetail)表服务接口
 *
 * @author makejava
 * @since 2021-09-16 17:22:55
 */
public interface JctbResultCheckDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JctbResultCheckDetail queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JctbResultCheckDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param jctbResultCheckDetail 实例对象
     * @return 实例对象
     */
    JctbResultCheckDetail insert(JctbResultCheckDetail jctbResultCheckDetail);

    /**
     * 修改数据
     *
     * @param jctbResultCheckDetail 实例对象
     * @return 实例对象
     */
    JctbResultCheckDetail update(JctbResultCheckDetail jctbResultCheckDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    int batchInsert(@Param("records") List<JctbResultCheckDetail> records);

    int deleteByTaskName(String taskName);

    List<JctbResultCheckDetail> listByTaskName(String taskName);

    List<JctbResultCheckDetailDto> listByTaskName2(String taskName);
}