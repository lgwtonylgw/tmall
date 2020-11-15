package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsMemberLevelEntity;
import com.tony.tmall.service.UmsMemberLevelService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 会员等级
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "UmsMemberLevelController", description = "会员等级管理")
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService umsMemberLevelService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation("查询所有会员等级")
    @ResponseBody
    public R list(@RequestParam("defaultStatus") Integer defaultStatus) {
        List<UmsMemberLevelEntity> memberLevelList = umsMemberLevelService.list(
                new LambdaQueryWrapper<UmsMemberLevelEntity>()
                        .eq(UmsMemberLevelEntity::getDefaultStatus, defaultStatus));
        return R.ok(memberLevelList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsmemberlevel:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsMemberLevelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsmemberlevel:info")
    public R info(@PathVariable("id") Long id) {
        UmsMemberLevelEntity umsMemberLevel = umsMemberLevelService.getById(id);

        return R.ok().put("umsMemberLevel", umsMemberLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsmemberlevel:save")
    public R save(@RequestBody UmsMemberLevelEntity umsMemberLevel) {
        umsMemberLevelService.save(umsMemberLevel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsmemberlevel:update")
    public R update(@RequestBody UmsMemberLevelEntity umsMemberLevel) {
        umsMemberLevelService.updateById(umsMemberLevel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsmemberlevel:delete")
    public R delete(@RequestBody Long[] ids) {
        umsMemberLevelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
