package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.SmsHomeAdvertiseDao;
import com.tony.tmall.entity.SmsHomeAdvertiseEntity;
import com.tony.tmall.service.SmsHomeAdvertiseService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Service("smsHomeAdvertiseService")
public class SmsHomeAdvertiseServiceImpl extends ServiceImpl<SmsHomeAdvertiseDao, SmsHomeAdvertiseEntity> implements SmsHomeAdvertiseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeAdvertiseEntity> page = this.page(
                new Query<SmsHomeAdvertiseEntity>().getPage(params),
                new QueryWrapper<SmsHomeAdvertiseEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Page<SmsHomeAdvertiseEntity> listByPage(String name, Integer type, String endTime, Integer pageSize, Integer pageNum) {
        Page<SmsHomeAdvertiseEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SmsHomeAdvertiseEntity> wrapper = new LambdaQueryWrapper<>();

        if (!StringUtils.isEmpty(name)) {
            wrapper.like(SmsHomeAdvertiseEntity::getName,name);
        }
        if (type != null) {
            wrapper.eq(SmsHomeAdvertiseEntity::getType,type);
        }
        if (!StringUtils.isEmpty(endTime)) {
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = null;
            try {
                start = sdf.parse(startStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date end = null;
            try {
                end = sdf.parse(endStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (start != null && end != null) {
                wrapper.between(SmsHomeAdvertiseEntity::getEndTime,start,end);
            }
        }
        return this.baseMapper.selectPage(page,wrapper);
    }

}