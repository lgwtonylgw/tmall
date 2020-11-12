package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsAlbumPicEntity;
import com.tony.tmall.service.PmsAlbumPicService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 画册图片表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/pmsalbumpic")
public class PmsAlbumPicController {
    @Autowired
    private PmsAlbumPicService pmsAlbumPicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsalbumpic:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsAlbumPicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsalbumpic:info")
    public R info(@PathVariable("id") Long id){
		PmsAlbumPicEntity pmsAlbumPic = pmsAlbumPicService.getById(id);

        return R.ok().put("pmsAlbumPic", pmsAlbumPic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsalbumpic:save")
    public R save(@RequestBody PmsAlbumPicEntity pmsAlbumPic){
		pmsAlbumPicService.save(pmsAlbumPic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsalbumpic:update")
    public R update(@RequestBody PmsAlbumPicEntity pmsAlbumPic){
		pmsAlbumPicService.updateById(pmsAlbumPic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsalbumpic:delete")
    public R delete(@RequestBody Long[] ids){
		pmsAlbumPicService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
