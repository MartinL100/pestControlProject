import com.AAAAAA.pestcontrolproject.dao.userModule.IUserDao;
import com.AAAAAA.pestcontrolproject.entity.userModule.TRole;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.RoleServicImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.userModule.UserServicImpl;
import com.AAAAAA.pestcontrolproject.servic.userModule.IRoleServic;
import com.AAAAAA.pestcontrolproject.servic.userModule.IUserServic;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserModuleTest {

    @Test
    public void testConnect(){
       SqlSession sqlSession= GetSession.getSession();
        System.out.println(sqlSession);
    }
    @Test
    public void testUser(){
        Map map = new HashMap();
        map.put("userName",'3');
        map.put("password",'3');
        IUserDao dao= GetSession.getSession().getMapper(IUserDao.class);
        TUser user=dao.login(map);
        System.out.println(user.getRole().getRoleId());
    }
    @Test
    public void testRole(){

        IRoleServic servic = new RoleServicImpl();
        List<TRole> roleList =servic.findAllrolesList();
        System.out.println(roleList.size());
    }
@Test
    public void addUserTest(){
        IUserServic servic=new UserServicImpl();
        TUser user=new TUser();
        TRole role = new TRole();
        role.setRoleId(3);
        user.setUserName("HH");
        user.setUserPassword("1");
         user.setRealName("黄飞鸿");
         user.setRole(role);
        String info =servic.addUser(user);
    System.out.println(info);
    }
}