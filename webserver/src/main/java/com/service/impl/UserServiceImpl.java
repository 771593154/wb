package com.service.impl;

import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Effect      Service实现
 * @Developer llx
 * @Date 2020/3/27
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //查询
    public List getQueryList(String sql, Object[] objects) {
        List queryList=userDao.findAll(sql,objects);
        return queryList;
    }
    //增删改
    public int getUpdateResult(String sql, Object[] objects) {
        int result=userDao.update(sql,objects);
        return result;
    }
}
