package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.PmsProductEntity;
import com.tony.tmall.model.dto.PmsProductParam;
import com.tony.tmall.model.dto.PmsProductQueryParam;
import com.tony.tmall.model.vo.PmsProductResult;
import com.tony.tmall.service.PmsProductService;
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
 * 商品信息
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@Api(tags = "PmsProductController", description = "商品管理")
@RequestMapping("/product")
public class PmsProductController {
    @Autowired
    private PmsProductService pmsProductService;


    @ApiOperation("创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody PmsProductParam productParam) {
        int count = pmsProductService.create(productParam);
        if (count > 0) {
            return R.ok(count);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getUpdateInfo(@PathVariable Long id) {
        PmsProductResult productResult = pmsProductService.getUpdateInfo(id);
        return R.ok(productResult);
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody PmsProductParam productParam) {
        int count = pmsProductService.updates(id, productParam);
        if (count > 0) {
            return R.ok(count);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R getList(PmsProductQueryParam productQueryParam,
                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<PmsProductEntity> productList = pmsProductService.listByPage(productQueryParam, pageSize, pageNum);
        return R.ok(productList);
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public R getList(String keyword) {
        LambdaQueryWrapper<PmsProductEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PmsProductEntity::getDeleteStatus, 0);
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(PmsProductEntity::getName, keyword);
            wrapper.or().eq(PmsProductEntity::getDeleteStatus, 0).like(PmsProductEntity::getProductSn, keyword);
        }
        List<PmsProductEntity> productList = pmsProductService.list(wrapper);
        return R.ok(productList);
    }

    @ApiOperation("批量修改审核状态")
    @RequestMapping(value = "/update/verifyStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                @RequestParam("verifyStatus") Integer verifyStatus,
                                @RequestParam("detail") String detail) {
        int count = pmsProductService.updateVerifyStatus(ids, verifyStatus, detail);
        if (count > 0) {
            return R.ok(count);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("批量上下架")
    @RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                 @RequestParam("publishStatus") Integer publishStatus) {
        PmsProductEntity productEntity = new PmsProductEntity();
        productEntity.setPublishStatus(publishStatus);
        Boolean success = pmsProductService.update(productEntity, new LambdaQueryWrapper<PmsProductEntity>()
                .in(PmsProductEntity::getId, ids));
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("批量推荐商品")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("recommendStatus") Integer recommendStatus) {
        PmsProductEntity productEntity = new PmsProductEntity();
        productEntity.setRecommandStatus(recommendStatus);
        Boolean success = pmsProductService.update(productEntity, new LambdaQueryWrapper<PmsProductEntity>()
                .in(PmsProductEntity::getId, ids));
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateNewStatus(@RequestParam("ids") List<Long> ids,
                             @RequestParam("newStatus") Integer newStatus) {
        PmsProductEntity productEntity = new PmsProductEntity();
        productEntity.setNewStatus(newStatus);
        Boolean success = pmsProductService.update(productEntity, new LambdaQueryWrapper<PmsProductEntity>()
                .in(PmsProductEntity::getId, ids));
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                @RequestParam("deleteStatus") Integer deleteStatus) {
        PmsProductEntity productEntity = new PmsProductEntity();
        productEntity.setDeleteStatus(deleteStatus);
        Boolean success = pmsProductService.update(productEntity, new LambdaQueryWrapper<PmsProductEntity>()
                .in(PmsProductEntity::getId, ids));
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproduct:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproduct:info")
    public R info(@PathVariable("id") Long id) {
        PmsProductEntity pmsProduct = pmsProductService.getById(id);

        return R.ok().put("pmsProduct", pmsProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproduct:save")
    public R save(@RequestBody PmsProductEntity pmsProduct) {
        pmsProductService.save(pmsProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproduct:update")
    public R update(@RequestBody PmsProductEntity pmsProduct) {
        pmsProductService.updateById(pmsProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproduct:delete")
    public R delete(@RequestBody Long[] ids) {
        pmsProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
