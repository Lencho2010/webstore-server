package com.geoway.webstore.service;

import com.geoway.webstore.entities.JctbTask;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 15:15
 * @Description:
 */
public interface JctbTaskService {

    int deleteByTaskName(String taskName);

    int insert(JctbTask record);

    JctbTask selectByTaskName(String taskName);

    PageInfo listByTaskNameAndStatus(int page, int rows, String taskName, List<Integer> status);

    List<JctbTask> listByStatus(List<Integer> status);

    int updateProgressByTaskName(JctbTask record);

    int updateStatusByTaskName(JctbTask record);

    int updateProgressAndStatusByTaskName(JctbTask record);

    int updateByPrimaryKey(JctbTask record);
}
