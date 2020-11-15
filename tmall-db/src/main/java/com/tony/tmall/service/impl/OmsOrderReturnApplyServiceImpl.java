package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.OmsOrderReturnApplyDao;
import com.tony.tmall.entity.OmsOrderReturnApplyEntity;
import com.tony.tmall.model.dto.OmsUpdateStatusParam;
import com.tony.tmall.model.vo.OmsOrderReturnApplyResult;
import com.tony.tmall.service.OmsOrderReturnApplyService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("omsOrderReturnApplyService")
public class OmsOrderReturnApplyServiceImpl extends ServiceImpl<OmsOrderReturnApplyDao, OmsOrderReturnApplyEntity> implements OmsOrderReturnApplyService {

    @Autowired
    private OmsOrderReturnApplyDao omsOrderReturnApplyDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderReturnApplyEntity> page = this.page(
                new Query<OmsOrderReturnApplyEntity>().getPage(params),
                new QueryWrapper<OmsOrderReturnApplyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int delete(List<Long> ids) {
        return this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {
        return omsOrderReturnApplyDao.getDetail(id);
    }

    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam statusParam) {
        Integer status = statusParam.getStatus();
        OmsOrderReturnApplyEntity returnApply = new OmsOrderReturnApplyEntity();
        if(status.equals(1)){
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else if(status.equals(2)){
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        }else if(status.equals(3)){
            //拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else{
            return 0;
        }
        return this.baseMapper.updateById(returnApply);

    }
}