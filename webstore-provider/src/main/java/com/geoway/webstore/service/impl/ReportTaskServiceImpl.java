package com.geoway.webstore.service.impl;

import com.geoway.webstore.converter.JctbTaskConverter;
import com.geoway.webstore.dto.JctbTaskDto;
import com.geoway.webstore.entities.JctbTask;
import com.geoway.webstore.entity.ReportTask;
import com.geoway.webstore.dao.ReportTaskDao;
import com.geoway.webstore.service.ReportTaskService;
import com.geoway.webstore.util.IDWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

/**
 * (ReportTask)表服务实现类
 *
 * @author makejava
 * @since 2021-11-02 11:38:23
 */
@Service("reportTaskService")
public class ReportTaskServiceImpl implements ReportTaskService {

    @Resource
    private IDWorker idWorker;

    @Resource
    private ReportTaskDao reportTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReportTask queryById(Long id) {
        return this.reportTaskDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ReportTask> queryAllByLimit(int offset, int limit) {
        return this.reportTaskDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param reportTask 实例对象
     * @return 实例对象
     */
    @Override
    public ReportTask insert(ReportTask reportTask) {
        reportTask.setId(idWorker.nextId());
        reportTask.setCreateTime(new Date());
        if (reportTask.getStatus().equals(2)) {
            reportTask.setStartTime(new Date());
        }
        this.reportTaskDao.insert(reportTask);
        return reportTask;
    }

    /**
     * 修改数据
     *
     * @param reportTask 实例对象
     * @return 实例对象
     */
    @Override
    public ReportTask update(ReportTask reportTask) {
        this.reportTaskDao.update(reportTask);
        return this.queryById(reportTask.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.reportTaskDao.deleteById(id) > 0;
    }

    @Override
    public PageInfo listByNameAndChargePerson(int page, int rows, String name, String chargePerson) {
        PageHelper.startPage(page, rows);
        ReportTask record = ReportTask.builder().chargePerson(chargePerson).name(name).build();
        List<ReportTask> list = reportTaskDao.queryAll(record);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<String> listChargePerson() {
        return this.reportTaskDao.listChargePerson();
    }


}