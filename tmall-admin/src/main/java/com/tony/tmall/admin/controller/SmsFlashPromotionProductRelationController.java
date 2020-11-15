package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsFlashPromotionProductRelationEntity;
import com.tony.tmall.model.vo.SmsFlashPromotionProduct;
import com.tony.tmall.service.SmsFlashPromotionProductRelationService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品限时购与商品关系
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsFlashPromotionProductRelationController", description = "限时购和商品关系管理")
@RequestMapping("/flashProductRelation")
public class SmsFlashPromotionProductRelationController {
    @Autowired
    private SmsFlashPromotionProductRelationService smsFlashPromotionProductRelationService;

    @ApiOperation("批量选择商品添加关联")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody List<SmsFlashPromotionProductRelationEntity> relationList) {
        int count = smsFlashPromotionProductRelationService.create(relationList);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改关联相关信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody SmsFlashPromotionProductRelationEntity relation) {
        relation.setId(id);
        boolean success = smsFlashPromotionProductRelationService.updateById(relation);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("删除关联")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        boolean success = smsFlashPromotionProductRelationService.removeById(id);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取管理商品促销信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        SmsFlashPromotionProductRelationEntity relation = smsFlashPromotionProductRelationService.getById(id);
        return R.ok(relation);
    }

    @ApiOperation("分页查询不同场次关联及商品信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "flashPromotionId") Long flashPromotionId,
                  @RequestParam(value = "flashPromotionSessionId") Long flashPromotionSessionId,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {


        Page<SmsFlashPromotionProductRelationEntity> page = new Page<>(pageNum,pageSize);
        Page<SmsFlashPromotionProduct> flashPromotionProductList = smsFlashPromotionProductRelationService.getList(page,flashPromotionId, flashPromotionSessionId);
        return R.ok(flashPromotionProductList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsFlashPromotionProductRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:info")
    public R info(@PathVariable("id") Long id) {
        SmsFlashPromotionProductRelationEntity smsFlashPromotionProductRelation = smsFlashPromotionProductRelationService.getById(id);

        return R.ok().put("smsFlashPromotionProductRelation", smsFlashPromotionProductRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:save")
    public R save(@RequestBody SmsFlashPromotionProductRelationEntity smsFlashPromotionProductRelation) {
        smsFlashPromotionProductRelationService.save(smsFlashPromotionProductRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:update")
    public R update(@RequestBody SmsFlashPromotionProductRelationEntity smsFlashPromotionProductRelation) {
        smsFlashPromotionProductRelationService.updateById(smsFlashPromotionProductRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:delete")
    public R delete(@RequestBody Long[] ids) {
        smsFlashPromotionProductRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
