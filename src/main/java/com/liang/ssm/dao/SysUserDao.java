package com.liang.ssm.dao;

import com.liang.ssm.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
@Repository
public interface SysUserDao {
    List<SysUser> getUserList();
}
