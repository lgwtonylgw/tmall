package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.CmsTopicCommentEntity;
import com.tony.tmall.service.CmsTopicCommentService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 专题评论表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmstopiccomment")
public class CmsTopicCommentController {
    @Autowired
    private CmsTopicCommentService cmsTopicCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmstopiccomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsTopicCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmstopiccomment:info")
    public R info(@PathVariable("id") Long id){
		CmsTopicCommentEntity cmsTopicComment = cmsTopicCommentService.getById(id);

        return R.ok().put("cmsTopicComment", cmsTopicComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmstopiccomment:save")
    public R save(@RequestBody CmsTopicCommentEntity cmsTopicComment){
		cmsTopicCommentService.save(cmsTopicComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmstopiccomment:update")
    public R update(@RequestBody CmsTopicCommentEntity cmsTopicComment){
		cmsTopicCommentService.updateById(cmsTopicComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmstopiccomment:delete")
    public R delete(@RequestBody Long[] ids){
		cmsTopicCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
