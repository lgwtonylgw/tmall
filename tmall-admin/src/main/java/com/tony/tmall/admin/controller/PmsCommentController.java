package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.PmsCommentEntity;
import com.tony.tmall.service.PmsCommentService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品评价表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmscomment")
public class PmsCommentController {
    @Autowired
    private PmsCommentService pmsCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmscomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmscomment:info")
    public R info(@PathVariable("id") Long id){
		PmsCommentEntity pmsComment = pmsCommentService.getById(id);

        return R.ok().put("pmsComment", pmsComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmscomment:save")
    public R save(@RequestBody PmsCommentEntity pmsComment){
		pmsCommentService.save(pmsComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmscomment:update")
    public R update(@RequestBody PmsCommentEntity pmsComment){
		pmsCommentService.updateById(pmsComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmscomment:delete")
    public R delete(@RequestBody Long[] ids){
		pmsCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
