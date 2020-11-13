package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsSubjectCommentEntity;
import com.tony.tmall.service.CmsSubjectCommentService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 专题评论表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmssubjectcomment")
public class CmsSubjectCommentController {
    @Autowired
    private CmsSubjectCommentService cmsSubjectCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmssubjectcomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsSubjectCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmssubjectcomment:info")
    public R info(@PathVariable("id") Long id){
		CmsSubjectCommentEntity cmsSubjectComment = cmsSubjectCommentService.getById(id);

        return R.ok().put("cmsSubjectComment", cmsSubjectComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmssubjectcomment:save")
    public R save(@RequestBody CmsSubjectCommentEntity cmsSubjectComment){
		cmsSubjectCommentService.save(cmsSubjectComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmssubjectcomment:update")
    public R update(@RequestBody CmsSubjectCommentEntity cmsSubjectComment){
		cmsSubjectCommentService.updateById(cmsSubjectComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmssubjectcomment:delete")
    public R delete(@RequestBody Long[] ids){
		cmsSubjectCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
