package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.OmsCompanyAddressEntity;
import com.tony.tmall.service.OmsCompanyAddressService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 公司收发货地址表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/omscompanyaddress")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService omsCompanyAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:omscompanyaddress:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = omsCompanyAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:omscompanyaddress:info")
    public R info(@PathVariable("id") Long id){
		OmsCompanyAddressEntity omsCompanyAddress = omsCompanyAddressService.getById(id);

        return R.ok().put("omsCompanyAddress", omsCompanyAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:omscompanyaddress:save")
    public R save(@RequestBody OmsCompanyAddressEntity omsCompanyAddress){
		omsCompanyAddressService.save(omsCompanyAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:omscompanyaddress:update")
    public R update(@RequestBody OmsCompanyAddressEntity omsCompanyAddress){
		omsCompanyAddressService.updateById(omsCompanyAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:omscompanyaddress:delete")
    public R delete(@RequestBody Long[] ids){
		omsCompanyAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
