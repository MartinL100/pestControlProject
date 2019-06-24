import com.AAAAAA.pestcontrolproject.dao.userModule.IUserDao;
import com.AAAAAA.pestcontrolproject.entity.userModule.TUser;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test {

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
}
