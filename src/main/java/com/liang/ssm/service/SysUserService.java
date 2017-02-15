package com.liang.ssm.service;

import com.liang.ssm.entity.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public interface SysUserService {
    List<SysUser> getUserList();
}
