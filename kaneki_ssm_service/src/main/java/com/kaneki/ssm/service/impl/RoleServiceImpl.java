package com.kaneki.ssm.service.impl;

import com.kaneki.ssm.dao.IRoleDao;
import com.kaneki.ssm.domain.Permission;
import com.kaneki.ssm.domain.Role;
import com.kaneki.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
         roleDao.save(role);
    }

    @Override
    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(int roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(int roleId, int[] permissionIds) throws Exception {
        for (int permissionId: permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
