package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsResourceEntity;
import com.tony.tmall.service.UmsResourceService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 后台资源表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsresource")
public class UmsResourceController {
    @Autowired
    private UmsResourceService umsResourceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsresource:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsResourceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsresource:info")
    public R info(@PathVariable("id") Long id){
		UmsResourceEntity umsResource = umsResourceService.getById(id);

        return R.ok().put("umsResource", umsResource);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsresource:save")
    public R save(@RequestBody UmsResourceEntity umsResource){
		umsResourceService.save(umsResource);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsresource:update")
    public R update(@RequestBody UmsResourceEntity umsResource){
		umsResourceService.updateById(umsResource);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsresource:delete")
    public R delete(@RequestBody Long[] ids){
		umsResourceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
