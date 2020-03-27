package com.dao;



import java.util.List;


/**
 * @Effect      Dao
 * @Developer llx
 * @Date 2020/3/27
 **/
public interface UserDao {
    public int update(String sql, Object[] objects);
    public List findAll(String sql,Object[] objects);
}
