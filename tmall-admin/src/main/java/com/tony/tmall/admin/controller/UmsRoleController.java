package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsRoleEntity;
import com.tony.tmall.service.UmsRoleService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 后台用户角色表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsrole")
public class UmsRoleController {
    @Autowired
    private UmsRoleService umsRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsrole:info")
    public R info(@PathVariable("id") Long id){
		UmsRoleEntity umsRole = umsRoleService.getById(id);

        return R.ok().put("umsRole", umsRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsrole:save")
    public R save(@RequestBody UmsRoleEntity umsRole){
		umsRoleService.save(umsRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsrole:update")
    public R update(@RequestBody UmsRoleEntity umsRole){
		umsRoleService.updateById(umsRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsrole:delete")
    public R delete(@RequestBody Long[] ids){
		umsRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
