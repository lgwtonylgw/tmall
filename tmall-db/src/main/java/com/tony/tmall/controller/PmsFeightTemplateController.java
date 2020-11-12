package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsFeightTemplateEntity;
import com.tony.tmall.service.PmsFeightTemplateService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 运费模版
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsfeighttemplate")
public class PmsFeightTemplateController {
    @Autowired
    private PmsFeightTemplateService pmsFeightTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsfeighttemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsFeightTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsfeighttemplate:info")
    public R info(@PathVariable("id") Long id){
		PmsFeightTemplateEntity pmsFeightTemplate = pmsFeightTemplateService.getById(id);

        return R.ok().put("pmsFeightTemplate", pmsFeightTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsfeighttemplate:save")
    public R save(@RequestBody PmsFeightTemplateEntity pmsFeightTemplate){
		pmsFeightTemplateService.save(pmsFeightTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsfeighttemplate:update")
    public R update(@RequestBody PmsFeightTemplateEntity pmsFeightTemplate){
		pmsFeightTemplateService.updateById(pmsFeightTemplate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsfeighttemplate:delete")
    public R delete(@RequestBody Long[] ids){
		pmsFeightTemplateService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
