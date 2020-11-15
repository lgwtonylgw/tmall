package com.tony.tmall.admin.model.dto;

import com.tony.tmall.entity.UmsMenuEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 * Created by tony on 2020/2/4.
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenuEntity {
    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}
