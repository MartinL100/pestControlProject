import com.AAAAAA.pestcontrolproject.dao.specialistModule.IConferenceDtoDao;
import com.AAAAAA.pestcontrolproject.dao.specialistModule.ISpecialistDao;
import com.AAAAAA.pestcontrolproject.entity.Dto.ConferenceDto;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialistModuleTest {

    @Test
    public void testJDBC() {
        SqlSession session = GetSession.getSession();
        session.close();
        System.out.println(session);
    }

    //专家的增、删、改、查
    @Test
    public void testSpecialist() {
        SqlSession session = GetSession.getSession();
        ISpecialistDao dao = session.getMapper(ISpecialistDao.class);
        //增
        for (int i = 0; i < 2; i++) {
            dao.addSpecialist(new TSpecialist("cc", "男",
                    "1991-10-10", "1.jpg", "rfdf",
                    "dfd", "13111445566", "432423",
                    "hghg", "2133@qq.com"));
        }
        //删
//int  a =dao.delSpecialistById("4");
//        System.out.println(a);

        //改
//        Map<String, Object> map = new HashMap<>();
//        map.put("specialistTel", "18989898989");
//        map.put("specialistDuty", "我是谁");
//        map.put("specialistUnits", "我在哪儿");
//        map.put("specialistEmail", "bb@qq.com");
//        map.put("specialistId", "1");
//        int a = dao.updateSpecialist(map);

        //查
        //1、根据ID查对象
//       TSpecialist specialist=   dao.findSpecialistById("1");
//        System.out.println(specialist);

        //2、动态查询
//        Map<String, Object> map = new HashMap<>();
//        map.put("startIndex",0);
//        map.put("rowNum",5);
//        List<TSpecialist> list = dao.findSpecialistList(map);
//        for (TSpecialist s : list) {
//            System.out.println(s.toString());
//        }

//        //3、查总行数
//        int a = dao.findCountRow();
//        System.out.println(a);
        session.commit();
        session.close();
    }

    //会商的查询
    @Test
    public void testConference() {
        SqlSession session = GetSession.getSession();
        ConferenceDto conferenceDto = session.getMapper(IConferenceDtoDao.class).findEventByConferenceId("1");
        System.out.println(conferenceDto);


        List<ConferenceDto> list = session.getMapper(IConferenceDtoDao.class).allConference();
        System.out.println(list.size());
    }

}
