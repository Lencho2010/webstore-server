package com.geoway.webstore.service;

import com.geoway.webstore.entities.TbsysPara;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lencho
 * @create 2021-09-09 9:18
 * @desc
 */
public interface TbsysParaService {
    TbsysPara findOne(String key);

    boolean update(String key, String value);
}
