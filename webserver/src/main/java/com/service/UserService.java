package com.service;



import java.util.List;
/**
 * @Effect      Service
 * @Developer llx
 * @Date 2020/3/27
 **/

public interface UserService {
    public List getQueryList(String sql,Object[] objects);
    public int getUpdateResult(String sql,Object[] objects);
}
