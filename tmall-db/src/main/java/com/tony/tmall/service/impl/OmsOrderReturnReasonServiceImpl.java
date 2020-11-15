package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.OmsOrderReturnReasonDao;
import com.tony.tmall.entity.OmsOrderReturnReasonEntity;
import com.tony.tmall.service.OmsOrderReturnReasonService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("omsOrderReturnReasonService")
public class OmsOrderReturnReasonServiceImpl extends ServiceImpl<OmsOrderReturnReasonDao, OmsOrderReturnReasonEntity> implements OmsOrderReturnReasonService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderReturnReasonEntity> page = this.page(
                new Query<OmsOrderReturnReasonEntity>().getPage(params),
                new QueryWrapper<OmsOrderReturnReasonEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        if(!status.equals(0)&&!status.equals(1)){
            return 0;
        }
        OmsOrderReturnReasonEntity record = new OmsOrderReturnReasonEntity();
        record.setStatus(status);
        return this.baseMapper.update(record,new LambdaQueryWrapper<OmsOrderReturnReasonEntity>().in(OmsOrderReturnReasonEntity::getId,ids));
    }
}