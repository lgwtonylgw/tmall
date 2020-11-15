package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsFlashPromotionEntity;
import com.tony.tmall.service.SmsFlashPromotionService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;



/**
 * 限时购
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsFlashPromotionController", description = "限时购活动管理")
@RequestMapping("/flash")
public class SmsFlashPromotionController {
    @Autowired
    private SmsFlashPromotionService smsFlashPromotionService;


    @ApiOperation("添加活动")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody SmsFlashPromotionEntity flashPromotion) {
        flashPromotion.setCreateTime(new Date());
        boolean success = smsFlashPromotionService.save(flashPromotion);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("编辑活动信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable Long id, @RequestBody SmsFlashPromotionEntity flashPromotion) {
        flashPromotion.setId(id);
        boolean success = smsFlashPromotionService.updateById(flashPromotion);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("删除活动信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@PathVariable Long id) {
        boolean success = smsFlashPromotionService.removeById(id);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable Long id, Integer status) {
        SmsFlashPromotionEntity flashPromotion = new SmsFlashPromotionEntity();
        flashPromotion.setId(id);
        flashPromotion.setStatus(status);
        boolean success = smsFlashPromotionService.updateById(flashPromotion);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取活动详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getItem(@PathVariable Long id) {
        SmsFlashPromotionEntity flashPromotion = smsFlashPromotionService.getById(id);
        return R.ok(flashPromotion);
    }

    @ApiOperation("根据活动名称分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getItem(@RequestParam(value = "keyword", required = false) String keyword,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SmsFlashPromotionEntity> page = new Page<SmsFlashPromotionEntity>(pageNum, pageSize);
        LambdaQueryWrapper<SmsFlashPromotionEntity> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(keyword)){
            wrapper.eq(SmsFlashPromotionEntity::getTitle,keyword);
        }
        Page<SmsFlashPromotionEntity> promotionEntityPage = smsFlashPromotionService.page(page,wrapper);
        return R.ok(promotionEntityPage);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smsflashpromotion:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsFlashPromotionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smsflashpromotion:info")
    public R info(@PathVariable("id") Long id){
		SmsFlashPromotionEntity smsFlashPromotion = smsFlashPromotionService.getById(id);

        return R.ok().put("smsFlashPromotion", smsFlashPromotion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smsflashpromotion:save")
    public R save(@RequestBody SmsFlashPromotionEntity smsFlashPromotion){
		smsFlashPromotionService.save(smsFlashPromotion);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smsflashpromotion:update")
    public R update(@RequestBody SmsFlashPromotionEntity smsFlashPromotion){
		smsFlashPromotionService.updateById(smsFlashPromotion);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smsflashpromotion:delete")
    public R delete(@RequestBody Long[] ids){
		smsFlashPromotionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
