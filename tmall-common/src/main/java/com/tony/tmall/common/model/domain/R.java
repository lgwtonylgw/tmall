package com.tony.tmall.common.model.domain;

import com.tony.tmall.common.model.enums.ResultCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020年10月27日 下午9:59:27
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 200);
        put("msg", "success");
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(ResultCode resultCode) {
        return error(resultCode.getCode(), resultCode.getMessage());
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R errorResult(int code, String msg, Object data) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static R ok(Object data) {
        R r = new R();
        r.put("data", data);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    /**
     * 未登录返回结果
     */
    public static R unauthorized(Object data) {
        return R.errorResult(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static R forbidden(Object data) {
        return R.errorResult(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public static R ok() {
        return new R();
    }

    public static R validateFailed(String message) {
        return R.error(ResultCode.VALIDATE_FAILED.getCode(), message);
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
