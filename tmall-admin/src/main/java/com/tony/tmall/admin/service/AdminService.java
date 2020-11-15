package com.tony.tmall.admin.service;

import com.tony.tmall.admin.model.dto.UmsAdminParam;
import com.tony.tmall.admin.model.dto.UpdateAdminPasswordParam;
import com.tony.tmall.entity.UmsAdminEntity;
import com.tony.tmall.entity.UmsRoleEntity;

import java.util.List;

/**
 * Author: tony
 * Date: 2020/11/15 17:03
 * Description:
 */
public interface AdminService {
    UmsAdminEntity register(UmsAdminParam umsAdminParam);

    String login(String username, String password);

    String refreshToken(String token);

    UmsAdminEntity getAdminByUsername(String username);

    List<UmsRoleEntity> getRoleList(Long id);

    boolean update(Long id, UmsAdminEntity admin);

    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    boolean delete(Long id);

    int updateRole(Long adminId, List<Long> roleIds);
}
