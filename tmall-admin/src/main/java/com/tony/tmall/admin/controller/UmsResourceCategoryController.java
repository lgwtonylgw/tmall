package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.UmsResourceCategoryEntity;
import com.tony.tmall.service.UmsResourceCategoryService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 资源分类
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "UmsResourceCategoryController", description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService umsResourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public R listAll() {
        List<UmsResourceCategoryEntity> resourceList = umsResourceCategoryService.list();
        return R.ok(resourceList);
    }

    @ApiOperation("添加后台资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody UmsResourceCategoryEntity umsResourceCategory) {
        umsResourceCategory.setCreateTime(new Date());
        boolean success = umsResourceCategoryService.save(umsResourceCategory);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id,
                    @RequestBody UmsResourceCategoryEntity umsResourceCategory) {
        umsResourceCategory.setId(id);
        boolean success = umsResourceCategoryService.updateById(umsResourceCategory);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        boolean success = umsResourceCategoryService.removeById(id);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsresourcecategory:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsResourceCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsresourcecategory:info")
    public R info(@PathVariable("id") Long id) {
        UmsResourceCategoryEntity umsResourceCategory = umsResourceCategoryService.getById(id);

        return R.ok().put("umsResourceCategory", umsResourceCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsresourcecategory:save")
    public R save(@RequestBody UmsResourceCategoryEntity umsResourceCategory) {
        umsResourceCategoryService.save(umsResourceCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsresourcecategory:update")
    public R update(@RequestBody UmsResourceCategoryEntity umsResourceCategory) {
        umsResourceCategoryService.updateById(umsResourceCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsresourcecategory:delete")
    public R delete(@RequestBody Long[] ids) {
        umsResourceCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
