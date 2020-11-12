package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsMenuEntity;
import com.tony.tmall.service.UmsMenuService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 后台菜单表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsmenu")
public class UmsMenuController {
    @Autowired
    private UmsMenuService umsMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsmenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsmenu:info")
    public R info(@PathVariable("id") Long id){
		UmsMenuEntity umsMenu = umsMenuService.getById(id);

        return R.ok().put("umsMenu", umsMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsmenu:save")
    public R save(@RequestBody UmsMenuEntity umsMenu){
		umsMenuService.save(umsMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsmenu:update")
    public R update(@RequestBody UmsMenuEntity umsMenu){
		umsMenuService.updateById(umsMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsmenu:delete")
    public R delete(@RequestBody Long[] ids){
		umsMenuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
