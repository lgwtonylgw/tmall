package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.CmsHelpEntity;
import com.tony.tmall.service.CmsHelpService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 帮助表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmshelp")
public class CmsHelpController {
    @Autowired
    private CmsHelpService cmsHelpService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmshelp:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsHelpService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmshelp:info")
    public R info(@PathVariable("id") Long id){
		CmsHelpEntity cmsHelp = cmsHelpService.getById(id);

        return R.ok().put("cmsHelp", cmsHelp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmshelp:save")
    public R save(@RequestBody CmsHelpEntity cmsHelp){
		cmsHelpService.save(cmsHelp);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmshelp:update")
    public R update(@RequestBody CmsHelpEntity cmsHelp){
		cmsHelpService.updateById(cmsHelp);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmshelp:delete")
    public R delete(@RequestBody Long[] ids){
		cmsHelpService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
