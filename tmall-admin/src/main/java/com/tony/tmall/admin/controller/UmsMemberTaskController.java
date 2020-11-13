package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsMemberTaskEntity;
import com.tony.tmall.service.UmsMemberTaskService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 会员任务表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsmembertask")
public class UmsMemberTaskController {
    @Autowired
    private UmsMemberTaskService umsMemberTaskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsmembertask:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberTaskService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsmembertask:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberTaskEntity umsMemberTask = umsMemberTaskService.getById(id);

        return R.ok().put("umsMemberTask", umsMemberTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsmembertask:save")
    public R save(@RequestBody UmsMemberTaskEntity umsMemberTask){
		umsMemberTaskService.save(umsMemberTask);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsmembertask:update")
    public R update(@RequestBody UmsMemberTaskEntity umsMemberTask){
		umsMemberTaskService.updateById(umsMemberTask);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsmembertask:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberTaskService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
