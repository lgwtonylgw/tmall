package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsHomeRecommendSubjectEntity;
import com.tony.tmall.service.SmsHomeRecommendSubjectService;
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
 * 首页推荐专题
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsHomeRecommendSubjectController", description = "首页专题推荐管理")
@RequestMapping("/home/recommendSubject")
public class SmsHomeRecommendSubjectController {
    @Autowired
    private SmsHomeRecommendSubjectService smsHomeRecommendSubjectService;

    @ApiOperation("添加首页推荐专题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody List<SmsHomeRecommendSubjectEntity> homeBrandList) {
        int count = smsHomeRecommendSubjectService.create(homeBrandList);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateSort(@PathVariable Long id, Integer sort) {
        SmsHomeRecommendSubjectEntity recommendProduct = new SmsHomeRecommendSubjectEntity();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        boolean success = smsHomeRecommendSubjectService.updateById(recommendProduct);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        boolean success = smsHomeRecommendSubjectService.removeByIds(ids);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus) {
        SmsHomeRecommendSubjectEntity record = new SmsHomeRecommendSubjectEntity();
        record.setRecommendStatus(recommendStatus);
        boolean success = smsHomeRecommendSubjectService.update(record,
                new LambdaQueryWrapper<SmsHomeRecommendSubjectEntity>()
                        .in(SmsHomeRecommendSubjectEntity::getId, ids));
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "subjectName", required = false) String subjectName,
                  @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SmsHomeRecommendSubjectEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SmsHomeRecommendSubjectEntity> wrapper = new LambdaQueryWrapper<>();

        if (!StringUtils.isEmpty(subjectName)) {
            wrapper.like(SmsHomeRecommendSubjectEntity::getSubjectName, subjectName);
        }
        if (recommendStatus != null) {
            wrapper.eq(SmsHomeRecommendSubjectEntity::getRecommendStatus, recommendStatus);
        }
        Page<SmsHomeRecommendSubjectEntity> homeBrandList = smsHomeRecommendSubjectService.page(
                page, wrapper);
        return R.ok(homeBrandList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomerecommendsubject:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsHomeRecommendSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomerecommendsubject:info")
    public R info(@PathVariable("id") Long id) {
        SmsHomeRecommendSubjectEntity smsHomeRecommendSubject = smsHomeRecommendSubjectService.getById(id);

        return R.ok().put("smsHomeRecommendSubject", smsHomeRecommendSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomerecommendsubject:save")
    public R save(@RequestBody SmsHomeRecommendSubjectEntity smsHomeRecommendSubject) {
        smsHomeRecommendSubjectService.save(smsHomeRecommendSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomerecommendsubject:update")
    public R update(@RequestBody SmsHomeRecommendSubjectEntity smsHomeRecommendSubject) {
        smsHomeRecommendSubjectService.updateById(smsHomeRecommendSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomerecommendsubject:delete")
    public R delete(@RequestBody Long[] ids) {
        smsHomeRecommendSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
