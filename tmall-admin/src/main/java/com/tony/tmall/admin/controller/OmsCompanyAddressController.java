package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.OmsCompanyAddressEntity;
import com.tony.tmall.service.OmsCompanyAddressService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 公司收发货地址
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("companyAddress")
@Api(tags = "OmsCompanyAddressController", description = "收货地址管理")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService omsCompanyAddressService;

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list() {
        List<OmsCompanyAddressEntity> companyAddressList = omsCompanyAddressService.list();
        return R.ok(companyAddressList);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = omsCompanyAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		OmsCompanyAddressEntity omsCompanyAddress = omsCompanyAddressService.getById(id);

        return R.ok().put("omsCompanyAddress", omsCompanyAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OmsCompanyAddressEntity omsCompanyAddress){
		omsCompanyAddressService.save(omsCompanyAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OmsCompanyAddressEntity omsCompanyAddress){
		omsCompanyAddressService.updateById(omsCompanyAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		omsCompanyAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
