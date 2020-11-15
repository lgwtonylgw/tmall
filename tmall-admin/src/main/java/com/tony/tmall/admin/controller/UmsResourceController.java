package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.admin.service.RedisCacheService;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.UmsResourceEntity;
import com.tony.tmall.security.component.DynamicSecurityMetadataSource;
import com.tony.tmall.service.UmsResourceService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 后台资源
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "UmsResourceController", description = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {
    @Autowired
    private UmsResourceService umsResourceService;

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;
    
    @Autowired
    private RedisCacheService redisCacheService;


    @ApiOperation("添加后台资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody UmsResourceEntity umsResource) {
        umsResource.setCreateTime(new Date());
        boolean success = umsResourceService.save(umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改后台资源")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id,
                    @RequestBody UmsResourceEntity umsResource) {
        umsResource.setId(id);
        boolean success = umsResourceService.updateById(umsResource);
        redisCacheService.delResourceListByResource(id);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("根据ID获取资源详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        UmsResourceEntity umsResource = umsResourceService.getById(id);
        return R.ok(umsResource);
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        boolean success = umsResourceService.removeById(id);
        redisCacheService.delResourceListByResource(id);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(required = false) Long categoryId,
                  @RequestParam(required = false) String nameKeyword,
                  @RequestParam(required = false) String urlKeyword,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsResourceEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<UmsResourceEntity> wrapper = new LambdaQueryWrapper<>();

        if (!StringUtils.isEmpty(nameKeyword)) {
            wrapper.like(UmsResourceEntity::getName, nameKeyword);
        }
        if (!StringUtils.isEmpty(urlKeyword)) {
            wrapper.like(UmsResourceEntity::getUrl, urlKeyword);
        }
        if(categoryId!=null){
            wrapper.eq(UmsResourceEntity::getCategoryId,categoryId);
        }
        
        Page<UmsResourceEntity> umsResourceEntityPage = umsResourceService.page(
                page, wrapper);
        return R.ok(umsResourceEntityPage);
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public R listAll() {
        List<UmsResourceEntity> resourceList = umsResourceService.list();
        return R.ok(resourceList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsresource:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsResourceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsresource:info")
    public R info(@PathVariable("id") Long id) {
        UmsResourceEntity umsResource = umsResourceService.getById(id);

        return R.ok().put("umsResource", umsResource);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsresource:save")
    public R save(@RequestBody UmsResourceEntity umsResource) {
        umsResourceService.save(umsResource);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsresource:update")
    public R update(@RequestBody UmsResourceEntity umsResource) {
        umsResourceService.updateById(umsResource);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsresource:delete")
    public R delete(@RequestBody Long[] ids) {
        umsResourceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
