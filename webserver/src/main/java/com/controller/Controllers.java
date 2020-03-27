package com.controller;


import com.dao.UserDao;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.sun.tracing.dtrace.ArgsAttributes;
import netscape.javascript.JSObject;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Effect     控制层
 * @Developer llx
 * @Date 2020/3/27
 **/
@Controller
@RequestMapping("/user")
public class Controllers {
    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger("日志");
    @RequestMapping(value = "sav")
    @Transactional
    @ResponseBody
    /**
     * @Effect     查询和删除数据
     * @Developer llx
     * @Date 2020/3/27
     **/
    public void sav(HttpServletRequest request, HttpServletResponse response) throws SQLException, JSONException, IOException {
        List<Map<String, Object>>listUser=null;
        JSONObject json=new JSONObject();
        String id = request.getParameter("id");
        int del = Integer.parseInt(request.getParameter("del"));
        json=new JSONObject();
        //查询
        if(del<0){
            String seleSql="SELECT userName,pwd FROM user where id=?";
            listUser=userService.getQueryList(seleSql,new Object[]{id});
            if(listUser.size()>0){
                json.put("userName",listUser.get(0).get("userName"));
                json.put("pwd",listUser.get(0).get("pwd"));
            }
            response.getWriter().print(json);
        }else {
            //删除
            String dell="DELETE FROM user where id=?";
            int result=userService.getUpdateResult(dell,new Object[]{id});
            if(result>0){
                json.put("del","用户id为"+id+"已删除");
                response.getWriter().print(json);
                logger.info("用户id为"+id+"已删除");
            }
        }

    }
    /**
     * @Effect     修改数据
     * @Developer llx
     * @Date 2020/3/27
     **/
    @RequestMapping(value = "edit")
    @Transactional
    public String edit(HttpServletRequest request) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int id = Integer.parseInt(request.getParameter("id2"));
        String insert="UPDATE user set userName=? ,pwd=? where id=?";
        int result=userService.getUpdateResult(insert,new Object[]{username,password,id});
        if(result>0){
            System.out.println("数据修改成功");
            logger.info("数据修改成功");
        }
        return "success";
    }
    /**
     * @Effect     插入数据
     * @Developer llx
     * @Date 2020/3/27
     **/
    @RequestMapping(value = "save")
    public String save(HttpServletRequest request) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String insert="insert into user (userName,pwd)VALUES (?,?)";
        int result=userService.getUpdateResult(insert,new Object[]{username,password});
        if(result>0){
            System.out.println("数据添加成功");
            logger.info("数据添加成功");
        }
        return "success";
    }

}
