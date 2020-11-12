package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsAdminLoginLogEntity;
import com.tony.tmall.service.UmsAdminLoginLogService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 后台用户登录日志表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsadminloginlog")
public class UmsAdminLoginLogController {
    @Autowired
    private UmsAdminLoginLogService umsAdminLoginLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsadminloginlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsAdminLoginLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsadminloginlog:info")
    public R info(@PathVariable("id") Long id){
		UmsAdminLoginLogEntity umsAdminLoginLog = umsAdminLoginLogService.getById(id);

        return R.ok().put("umsAdminLoginLog", umsAdminLoginLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsadminloginlog:save")
    public R save(@RequestBody UmsAdminLoginLogEntity umsAdminLoginLog){
		umsAdminLoginLogService.save(umsAdminLoginLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsadminloginlog:update")
    public R update(@RequestBody UmsAdminLoginLogEntity umsAdminLoginLog){
		umsAdminLoginLogService.updateById(umsAdminLoginLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsadminloginlog:delete")
    public R delete(@RequestBody Long[] ids){
		umsAdminLoginLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
