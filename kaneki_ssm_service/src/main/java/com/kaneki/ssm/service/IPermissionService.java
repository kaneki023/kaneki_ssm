package com.kaneki.ssm.service;

import com.kaneki.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
