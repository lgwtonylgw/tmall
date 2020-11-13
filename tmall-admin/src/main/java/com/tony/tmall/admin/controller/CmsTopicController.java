package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsTopicEntity;
import com.tony.tmall.service.CmsTopicService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 话题表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmstopic")
public class CmsTopicController {
    @Autowired
    private CmsTopicService cmsTopicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmstopic:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsTopicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmstopic:info")
    public R info(@PathVariable("id") Long id){
		CmsTopicEntity cmsTopic = cmsTopicService.getById(id);

        return R.ok().put("cmsTopic", cmsTopic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmstopic:save")
    public R save(@RequestBody CmsTopicEntity cmsTopic){
		cmsTopicService.save(cmsTopic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmstopic:update")
    public R update(@RequestBody CmsTopicEntity cmsTopic){
		cmsTopicService.updateById(cmsTopic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmstopic:delete")
    public R delete(@RequestBody Long[] ids){
		cmsTopicService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
