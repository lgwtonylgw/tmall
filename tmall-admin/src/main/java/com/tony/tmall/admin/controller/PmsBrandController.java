package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.PmsBrandEntity;
import com.tony.tmall.model.dto.PmsBrandParam;
import com.tony.tmall.service.PmsBrandService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 品牌
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;


    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public R getList() {
        return R.ok(pmsBrandService.list());
    }

    @ApiOperation(value = "添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@Validated @RequestBody PmsBrandParam pmsBrandParam) {
        PmsBrandEntity pmsBrand = new PmsBrandEntity();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        boolean success = pmsBrandService.save(pmsBrand);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation(value = "更新品牌")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable("id") Long id,
                    @Validated @RequestBody PmsBrandParam pmsBrandParam) {
        int count = pmsBrandService.updateBrand(id, pmsBrandParam);
        if (count == 1) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R delete(@PathVariable("id") Long id) {
        boolean success = pmsBrandService.removeById(id);
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R getList(@RequestParam(value = "keyword", required = false) String keyword,
                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<PmsBrandEntity> page = new Page<>(pageNum, pageSize);
        Page<PmsBrandEntity> result;
        if (!StringUtils.isEmpty(keyword)) {
            result = pmsBrandService.page(page,
                    new LambdaQueryWrapper<PmsBrandEntity>().like(PmsBrandEntity::getName, keyword));
        } else {
            result = pmsBrandService.page(page);
        }
        return R.ok(result);
    }

    @ApiOperation(value = "根据编号查询品牌信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable("id") Long id) {
        return R.ok(pmsBrandService.getById(id));
    }

    @ApiOperation(value = "批量删除品牌")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public R deleteBatch(@RequestParam("ids") List<Long> ids) {
        Boolean success = pmsBrandService.removeByIds(ids);
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation(value = "批量更新显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateShowStatus(@RequestParam("ids") List<Long> ids,
                              @RequestParam("showStatus") Integer showStatus) {
        PmsBrandEntity pmsBrandEntity = new PmsBrandEntity();
        pmsBrandEntity.setShowStatus(showStatus);

        boolean update = pmsBrandService.update(pmsBrandEntity,
                new LambdaQueryWrapper<PmsBrandEntity>().in(PmsBrandEntity::getId, ids));
        if (update) {
            return R.ok(update);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation(value = "批量更新厂家制造商状态")
    @RequestMapping(value = "/update/factoryStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateFactoryStatus(@RequestParam("ids") List<Long> ids,
                                 @RequestParam("factoryStatus") Integer factoryStatus) {
        PmsBrandEntity pmsBrandEntity = new PmsBrandEntity();
        pmsBrandEntity.setFactoryStatus(factoryStatus);

        boolean update = pmsBrandService.update(pmsBrandEntity,
                new LambdaQueryWrapper<PmsBrandEntity>().in(PmsBrandEntity::getId, ids));
        if (update) {
            return R.ok(update);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        PmsBrandEntity pmsBrand = pmsBrandService.getById(id);

        return R.ok().put("pmsBrand", pmsBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsBrandEntity pmsBrand) {
        pmsBrandService.save(pmsBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsBrandEntity pmsBrand) {
        pmsBrandService.updateById(pmsBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        pmsBrandService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
