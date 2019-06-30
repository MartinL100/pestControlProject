package com.AAAAAA.pestcontrolproject.servlet.userModule;

import com.AAAAAA.pestcontrolproject.entity.userModule.MenuVO;
import com.AAAAAA.pestcontrolproject.entity.userModule.TLog;
import com.AAAAAA.pestcontrolproject.entity.userModule.TPower;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.LogServicImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.PowerServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.ILogSevice;
import com.AAAAAA.pestcontrolproject.servic.userModule.IPowerService;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.CheckString;
import com.AAAAAA.pestcontrolproject.util.UserModuleStringInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    IUserServic userServic = new UserServicImpl();
    ILogSevice logSevice=new LogServicImpl();
    IPowerService powerService=new PowerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String userName=request.getParameter("userName");
            String password=request.getParameter("password");
        Map<String, String> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        //获取登录的对象
       TUser user= userServic.login(map);
            //登录验证
        if(null==user){
            //如果用户为空则返回登录界面，并且返回错误信息
            request.setAttribute("errorInfo", UserModuleStringInfo.USER_IS_NOTEXIST);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            //将user放到session中，属性名字为userObj
                request.getSession().setAttribute("userObj",user);
                //获取角色id
            long roleId=user.getRole().getRoleId();
            Map tempMap=new HashMap();
            tempMap.put("roleId",roleId);
           //查询角色对应的菜单栏集合
            List<TPower> powers= powerService.findMenuPowers(tempMap);
            //筛选power
            List<MenuVO> menuVOList=new ArrayList<>();
            MenuVO menuObj =new MenuVO();
            List<TPower> powerList=new ArrayList<>();

            long key =-1;
            for (TPower power:powers) {
                //判断分组标记
                if(power.getPowerTag()!=key){
                    if(key!=-1){
                        menuObj.setSecendMenu(powerList);
                        menuVOList.add(menuObj);
                    }
                    //重新赋值分组标记
                    key=power.getPowerTag();
                    //创建新的vo对象和新的power集合
                    menuObj=new MenuVO();
                    powerList=new ArrayList<>();
                }
                if(CheckString.isNull(power.getPowerResource())){
                    //筛选一级菜单
                    menuObj.setFirstMenu(power);
                }else {
                    //筛选二级菜单
                    powerList.add(power);
                }
            }

            //添加最后一次循环的菜单栏
            menuObj.setSecendMenu(powerList);
            menuVOList.add(menuObj);




            request.setAttribute("menuVOList",menuVOList);
                //添加登录日志
            TLog log=new TLog();
            log.setLogDescrip(user.getRealName()+UserModuleStringInfo.LOG_INFO);
            logSevice.addLog(log);
            //转发到主窗体
            request.getRequestDispatcher("page/userModule/mainFrame.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
