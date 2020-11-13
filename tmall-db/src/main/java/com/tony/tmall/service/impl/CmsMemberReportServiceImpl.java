package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.CmsMemberReportDao;
import com.tony.tmall.entity.CmsMemberReportEntity;
import com.tony.tmall.service.CmsMemberReportService;


@Service("cmsMemberReportService")
public class CmsMemberReportServiceImpl extends ServiceImpl<CmsMemberReportDao, CmsMemberReportEntity> implements CmsMemberReportService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsMemberReportEntity> page = this.page(
                new Query<CmsMemberReportEntity>().getPage(params),
                new QueryWrapper<CmsMemberReportEntity>()
        );

        return new PageUtils(page);
    }

}