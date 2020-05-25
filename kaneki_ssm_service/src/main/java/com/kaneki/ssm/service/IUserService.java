package com.kaneki.ssm.service;

import com.kaneki.ssm.domain.Role;
import com.kaneki.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {//扩展IUserService完成登录
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(int id) throws Exception;

    List<Role> findOtherRoles(int id) throws Exception;

    void addRoleToUser(int id, String[] roleIds) throws Exception;
}
