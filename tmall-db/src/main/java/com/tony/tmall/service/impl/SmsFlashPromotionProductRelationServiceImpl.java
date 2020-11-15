package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.SmsFlashPromotionProductRelationDao;
import com.tony.tmall.entity.SmsFlashPromotionProductRelationEntity;
import com.tony.tmall.model.vo.SmsFlashPromotionProduct;
import com.tony.tmall.service.SmsFlashPromotionProductRelationService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("smsFlashPromotionProductRelationService")
public class SmsFlashPromotionProductRelationServiceImpl extends ServiceImpl<SmsFlashPromotionProductRelationDao, SmsFlashPromotionProductRelationEntity> implements SmsFlashPromotionProductRelationService {

    @Autowired
    private SmsFlashPromotionProductRelationDao smsFlashPromotionProductRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsFlashPromotionProductRelationEntity> page = this.page(
                new Query<SmsFlashPromotionProductRelationEntity>().getPage(params),
                new QueryWrapper<SmsFlashPromotionProductRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public int create(List<SmsFlashPromotionProductRelationEntity> relationList) {
        for (SmsFlashPromotionProductRelationEntity relation : relationList) {
            this.baseMapper.insert(relation);
        }
        return relationList.size();
    }

    @Override
    public Page<SmsFlashPromotionProduct> getList(Page<SmsFlashPromotionProductRelationEntity> page, Long flashPromotionId, Long flashPromotionSessionId) {
        return smsFlashPromotionProductRelationDao.getList(page,flashPromotionId,flashPromotionSessionId);
    }

    @Override
    public long getCount(Long flashPromotionId, Long id) {
        return this.baseMapper.selectCount(new LambdaQueryWrapper<SmsFlashPromotionProductRelationEntity>()
        .eq(SmsFlashPromotionProductRelationEntity::getFlashPromotionId,flashPromotionId)
        .eq(SmsFlashPromotionProductRelationEntity::getFlashPromotionSessionId,id));
    }

}