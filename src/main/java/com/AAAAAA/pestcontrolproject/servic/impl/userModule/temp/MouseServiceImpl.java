package com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp;

import com.AAAAAA.pestcontrolproject.dao.userModule.temp.ImouseDao;
import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IMouseService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MouseServiceImpl implements IMouseService {
    @Override
    public List<mouseBean> getLIstMouse() {
        SqlSession session = GetSession.getSession();
        List<mouseBean> listMouse = session.getMapper(ImouseDao.class).getListMouse();


        return listMouse;
    }

    @Override
    public mouseBean AllMouse(int MouseId) {
        SqlSession session = GetSession.getSession();
        mouseBean mouseBean = session.getMapper(ImouseDao.class).AllMouse(MouseId);

        return mouseBean;
    }

    @Override
    public boolean AddMouse(mouseBean mouseBean) {
        SqlSession session = GetSession.getSession();
        int mouseByName = session.getMapper(ImouseDao.class).getMouseByName(mouseBean.getMouseName());
        if (mouseByName>0){
         session.close();
         return true;
        }else {
           session.getMapper(ImouseDao.class).AddMouse(mouseBean);
           session.commit();
            session.close();
        return false;
        }
    }

    @Override
    public int getMouuseByName(String mouseName) {
        return 0;
    }

    @Override
    public List<mouseBean> getNameMouse(Map map) {
        SqlSession session = GetSession.getSession();
        List<mouseBean> nameMouse = session.getMapper(ImouseDao.class).getByMouse(map);
        return nameMouse;
    }

    @Override
    public int getMouse(Map map) {
        SqlSession session = GetSession.getSession();
        int mouse = session.getMapper(ImouseDao.class).getCountMouse(map);
        return mouse;
    }
}
