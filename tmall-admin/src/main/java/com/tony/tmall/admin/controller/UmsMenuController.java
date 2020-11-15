package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.admin.model.dto.UmsMenuNode;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.UmsMenuEntity;
import com.tony.tmall.service.UmsMenuService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 后台菜单
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "UmsMenuController", description = "后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {
    @Autowired
    private UmsMenuService umsMenuService;

    @ApiOperation("添加后台菜单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody UmsMenuEntity umsMenu) {
        umsMenu.setCreateTime(new Date());
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UmsMenuEntity parentMenu = umsMenuService.getById(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
        boolean success = umsMenuService.save(umsMenu);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改后台菜单")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id,
                    @RequestBody UmsMenuEntity umsMenu) {
        umsMenu.setId(id);
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UmsMenuEntity parentMenu = umsMenuService.getById(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
        boolean success = umsMenuService.updateById(umsMenu);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("根据ID获取菜单详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        UmsMenuEntity umsMenu = umsMenuService.getById(id);
        return R.ok(umsMenu);
    }

    @ApiOperation("根据ID删除后台菜单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        boolean success = umsMenuService.removeById(id);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("分页查询后台菜单")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public R list(@PathVariable Long parentId,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsMenuEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<UmsMenuEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsMenuEntity::getParentId, parentId);

        Page<UmsMenuEntity> umsMenuEntityPage = umsMenuService.page(
                page, wrapper);
        return R.ok(umsMenuEntityPage);
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public R treeList() {
        List<UmsMenuEntity> list = umsMenuService.list();
        List<UmsMenuNode> result = list.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, list)).collect(Collectors.toList());
        return R.ok(list);
    }

    @ApiOperation("修改菜单显示状态")
    @RequestMapping(value = "/updateHidden/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
        UmsMenuEntity umsMenu = new UmsMenuEntity();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        boolean success = umsMenuService.updateById(umsMenu);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }


    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    private UmsMenuNode covertMenuNode(UmsMenuEntity menu, List<UmsMenuEntity> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsmenu:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsmenu:info")
    public R info(@PathVariable("id") Long id) {
        UmsMenuEntity umsMenu = umsMenuService.getById(id);

        return R.ok().put("umsMenu", umsMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsmenu:save")
    public R save(@RequestBody UmsMenuEntity umsMenu) {
        umsMenuService.save(umsMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsmenu:update")
    public R update(@RequestBody UmsMenuEntity umsMenu) {
        umsMenuService.updateById(umsMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsmenu:delete")
    public R delete(@RequestBody Long[] ids) {
        umsMenuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
