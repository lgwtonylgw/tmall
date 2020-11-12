package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsMemberTagEntity;
import com.tony.tmall.service.UmsMemberTagService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 用户标签表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsmembertag")
public class UmsMemberTagController {
    @Autowired
    private UmsMemberTagService umsMemberTagService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsmembertag:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberTagService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsmembertag:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberTagEntity umsMemberTag = umsMemberTagService.getById(id);

        return R.ok().put("umsMemberTag", umsMemberTag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsmembertag:save")
    public R save(@RequestBody UmsMemberTagEntity umsMemberTag){
		umsMemberTagService.save(umsMemberTag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsmembertag:update")
    public R update(@RequestBody UmsMemberTagEntity umsMemberTag){
		umsMemberTagService.updateById(umsMemberTag);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsmembertag:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberTagService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
