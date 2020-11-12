package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsAlbumEntity;
import com.tony.tmall.service.PmsAlbumService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 相册表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/pmsalbum")
public class PmsAlbumController {
    @Autowired
    private PmsAlbumService pmsAlbumService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsalbum:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsAlbumService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsalbum:info")
    public R info(@PathVariable("id") Long id){
		PmsAlbumEntity pmsAlbum = pmsAlbumService.getById(id);

        return R.ok().put("pmsAlbum", pmsAlbum);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsalbum:save")
    public R save(@RequestBody PmsAlbumEntity pmsAlbum){
		pmsAlbumService.save(pmsAlbum);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsalbum:update")
    public R update(@RequestBody PmsAlbumEntity pmsAlbum){
		pmsAlbumService.updateById(pmsAlbum);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsalbum:delete")
    public R delete(@RequestBody Long[] ids){
		pmsAlbumService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
