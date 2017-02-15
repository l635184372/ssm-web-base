package com.liang.ssm.service.impl;

import com.liang.ssm.dao.SysUserDao;
import com.liang.ssm.entity.SysUser;
import com.liang.ssm.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Liangqx on 2016/12/14.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService{

    @Resource
    private SysUserDao sysUserDao;

    public List<SysUser> getUserList(){
        return sysUserDao.getUserList();
    }
}
