package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsSubjectEntity;
import com.tony.tmall.service.CmsSubjectService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 专题表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmssubject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService cmsSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmssubject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmssubject:info")
    public R info(@PathVariable("id") Long id){
		CmsSubjectEntity cmsSubject = cmsSubjectService.getById(id);

        return R.ok().put("cmsSubject", cmsSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmssubject:save")
    public R save(@RequestBody CmsSubjectEntity cmsSubject){
		cmsSubjectService.save(cmsSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmssubject:update")
    public R update(@RequestBody CmsSubjectEntity cmsSubject){
		cmsSubjectService.updateById(cmsSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmssubject:delete")
    public R delete(@RequestBody Long[] ids){
		cmsSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
