package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tony.tmall.admin.model.dto.SmsFlashPromotionSessionDetail;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsFlashPromotionSessionEntity;
import com.tony.tmall.service.SmsFlashPromotionProductRelationService;
import com.tony.tmall.service.SmsFlashPromotionSessionService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 限时购场次表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsFlashPromotionSessionController", description = "限时购场次管理")
@RequestMapping("/flashSession")
public class SmsFlashPromotionSessionController {
    @Autowired
    private SmsFlashPromotionSessionService smsFlashPromotionSessionService;

    @Autowired
    private SmsFlashPromotionProductRelationService smsFlashPromotionProductRelationService;


    @ApiOperation("添加场次")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody SmsFlashPromotionSessionEntity promotionSession) {
        promotionSession.setCreateTime(new Date());
        boolean success = smsFlashPromotionSessionService.save(promotionSession);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改场次")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody SmsFlashPromotionSessionEntity promotionSession) {
        promotionSession.setId(id);
        boolean success = smsFlashPromotionSessionService.updateById(promotionSession);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改启用状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateStatus(@PathVariable Long id, Integer status) {
        SmsFlashPromotionSessionEntity promotionSession = new SmsFlashPromotionSessionEntity();
        promotionSession.setId(id);
        promotionSession.setStatus(status);
        boolean success = smsFlashPromotionSessionService.updateById(promotionSession);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("删除场次")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        boolean success = smsFlashPromotionSessionService.removeById(id);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取场次详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        SmsFlashPromotionSessionEntity promotionSession = smsFlashPromotionSessionService.getById(id);
        return R.ok(promotionSession);
    }

    @ApiOperation("获取全部场次")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list() {
        List<SmsFlashPromotionSessionEntity> promotionSessionList = smsFlashPromotionSessionService.list();
        return R.ok(promotionSessionList);
    }

    @ApiOperation("获取全部可选场次及其数量")
    @RequestMapping(value = "/selectList", method = RequestMethod.GET)
    @ResponseBody
    public R selectList(Long flashPromotionId) {
        List<SmsFlashPromotionSessionDetail> result = new ArrayList<>();
        LambdaQueryWrapper<SmsFlashPromotionSessionEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SmsFlashPromotionSessionEntity::getStatus, 1);
        List<SmsFlashPromotionSessionEntity> list = smsFlashPromotionSessionService.list(wrapper);

        for (SmsFlashPromotionSessionEntity promotionSession : list) {
            SmsFlashPromotionSessionDetail detail = new SmsFlashPromotionSessionDetail();
            BeanUtils.copyProperties(promotionSession, detail);
            long count = smsFlashPromotionProductRelationService.getCount(flashPromotionId, promotionSession.getId());
            detail.setProductCount(count);
            result.add(detail);
        }
        return R.ok(result);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smsflashpromotionsession:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsFlashPromotionSessionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smsflashpromotionsession:info")
    public R info(@PathVariable("id") Long id) {
        SmsFlashPromotionSessionEntity smsFlashPromotionSession = smsFlashPromotionSessionService.getById(id);

        return R.ok().put("smsFlashPromotionSession", smsFlashPromotionSession);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smsflashpromotionsession:save")
    public R save(@RequestBody SmsFlashPromotionSessionEntity smsFlashPromotionSession) {
        smsFlashPromotionSessionService.save(smsFlashPromotionSession);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smsflashpromotionsession:update")
    public R update(@RequestBody SmsFlashPromotionSessionEntity smsFlashPromotionSession) {
        smsFlashPromotionSessionService.updateById(smsFlashPromotionSession);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smsflashpromotionsession:delete")
    public R delete(@RequestBody Long[] ids) {
        smsFlashPromotionSessionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
