package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsHomeBrandEntity;
import com.tony.tmall.service.SmsHomeBrandService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 首页推荐品牌
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsHomeBrandController", description = "首页品牌管理")
@RequestMapping("/home/brand")
public class SmsHomeBrandController {
    @Autowired
    private SmsHomeBrandService smsHomeBrandService;

    @ApiOperation("添加首页推荐品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody List<SmsHomeBrandEntity> homeBrandList) {
        int count = smsHomeBrandService.create(homeBrandList);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改品牌排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateSort(@PathVariable Long id, Integer sort) {
        SmsHomeBrandEntity homeBrand = new SmsHomeBrandEntity();
        homeBrand.setId(id);
        homeBrand.setSort(sort);
        boolean success = smsHomeBrandService.updateById(homeBrand);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量删除推荐品牌")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        boolean success = smsHomeBrandService.removeByIds(ids);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus) {
        SmsHomeBrandEntity record = new SmsHomeBrandEntity();
        record.setRecommendStatus(recommendStatus);
        boolean success = smsHomeBrandService.update(record,
                new LambdaQueryWrapper<SmsHomeBrandEntity>()
                        .in(SmsHomeBrandEntity::getId, ids));
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("分页查询推荐品牌")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "brandName", required = false) String brandName,
                  @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SmsHomeBrandEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SmsHomeBrandEntity> wrapper = new LambdaQueryWrapper<>();

        if (!StringUtils.isEmpty(brandName)) {
            wrapper.like(SmsHomeBrandEntity::getBrandName, brandName);
        }
        if (recommendStatus != null) {
            wrapper.eq(SmsHomeBrandEntity::getRecommendStatus, recommendStatus);
        }
        Page<SmsHomeBrandEntity> homeBrandList = smsHomeBrandService.page(
                page, wrapper);
        return R.ok(homeBrandList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomebrand:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsHomeBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomebrand:info")
    public R info(@PathVariable("id") Long id) {
        SmsHomeBrandEntity smsHomeBrand = smsHomeBrandService.getById(id);

        return R.ok().put("smsHomeBrand", smsHomeBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomebrand:save")
    public R save(@RequestBody SmsHomeBrandEntity smsHomeBrand) {
        smsHomeBrandService.save(smsHomeBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomebrand:update")
    public R update(@RequestBody SmsHomeBrandEntity smsHomeBrand) {
        smsHomeBrandService.updateById(smsHomeBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomebrand:delete")
    public R delete(@RequestBody Long[] ids) {
        smsHomeBrandService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
