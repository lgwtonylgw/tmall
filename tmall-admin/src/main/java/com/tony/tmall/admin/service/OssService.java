package com.tony.tmall.admin.service;

import com.tony.tmall.admin.model.dto.OssCallbackResult;
import com.tony.tmall.admin.model.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: tony
 * Date: 2020/11/14 16:40
 * Description:
 */
public interface OssService {

    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
