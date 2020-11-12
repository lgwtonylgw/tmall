package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.CmsHelpDao;
import com.tony.tmall.entity.CmsHelpEntity;
import com.tony.tmall.service.CmsHelpService;


@Service("cmsHelpService")
public class CmsHelpServiceImpl extends ServiceImpl<CmsHelpDao, CmsHelpEntity> implements CmsHelpService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsHelpEntity> page = this.page(
                new Query<CmsHelpEntity>().getPage(params),
                new QueryWrapper<CmsHelpEntity>()
        );

        return new PageUtils(page);
    }

}