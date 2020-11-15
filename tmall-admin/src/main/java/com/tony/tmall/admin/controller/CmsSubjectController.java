package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsSubjectEntity;
import com.tony.tmall.service.CmsSubjectService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品专题管理
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("subject")
@Api(tags = "CmsSubjectController", description = "商品专题管理")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService cmsSubjectService;


    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public R listAll() {
        List<CmsSubjectEntity> subjectList = cmsSubjectService.list();
        return R.ok().put("data", subjectList);
    }

    @ApiOperation(value = "根据专题名称分页获取专题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R getList(@RequestParam(value = "keyword", required = false) String keyword,
                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        PageUtils subjectList = cmsSubjectService.listByName(keyword, pageNum, pageSize);
        return R.ok(subjectList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = cmsSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        CmsSubjectEntity cmsSubject = cmsSubjectService.getById(id);

        return R.ok().put("cmsSubject", cmsSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CmsSubjectEntity cmsSubject) {
        cmsSubjectService.save(cmsSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CmsSubjectEntity cmsSubject) {
        cmsSubjectService.updateById(cmsSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        cmsSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
