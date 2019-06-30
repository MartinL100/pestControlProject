package com.AAAAAA.pestcontrolproject.servic.impl.userModule.temp;

import com.AAAAAA.pestcontrolproject.dao.userModule.temp.IdiseaseDao;
import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.servic.userModule.temp.IDiseaseService;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class DiseaseServiceImpl implements IDiseaseService {


    @Override
    public boolean AddDisease(DiseaseBean diseaseBean) {
        SqlSession session = GetSession.getSession();
        int mapper = session.getMapper(IdiseaseDao.class).getDiseaseByName(diseaseBean.getDiseaseName());
            if (mapper>0){
            session.close();
            return true;
        }else {
            session.getMapper(IdiseaseDao.class).AddDisease(diseaseBean);
            session.commit();
            session.close();
            return false;
        }
    }


    @Override
    public DiseaseBean InquireDisease(int diseaseId) {
        SqlSession session = GetSession.getSession();
        DiseaseBean diseaseBean = session.getMapper(IdiseaseDao.class).AllDisease(diseaseId);

        return diseaseBean;
    }



    @Override
    public List<DiseaseBean> getNameDisease(Map map) {
        SqlSession session = GetSession.getSession();
        List<DiseaseBean> listDisease = session.getMapper(IdiseaseDao.class).getListDisease(map);
        return listDisease;
    }



    @Override
    public int getDisease(Map map) {
        SqlSession session = GetSession.getSession();
        int disease = session.getMapper(IdiseaseDao.class).getDisease(map);
        return disease;
    }



    @Override
    public List<DiseaseBean> getList() {
        SqlSession session = GetSession.getSession();
        List<DiseaseBean> listDisease = session.getMapper(IdiseaseDao.class).getList();
        return listDisease;
    }


    @Override
    public int getDiseaseByName(String diseaseName) {
        return 0;
    }
}
