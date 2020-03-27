package com.dao.impl;

import com.dao.UserDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Effect      Dao实现
 * @Developer llx
 * @Date 2020/3/27
 **/
@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    //增删改
    public int update(String sql, Object[] objects) {
        int result=this.getJdbcTemplate().update(sql,objects);
        return result;
    }
    //查询
    public List findAll(String sql, Object[] objects) {
        return this.getJdbcTemplate().queryForList(sql,objects);
    }
}
