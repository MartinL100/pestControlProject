import com.AAAAAA.pestcontrolproject.dao.eventModule.IEventDao;
import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.util.GetSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {


    @Test
    public void test(){

        SqlSession session= GetSession.getSession();

        IEventDao dao= session.getMapper(IEventDao.class);
        Event newone=new Event("虫害","2019-06-24",1,"飞娃多得很","img/1.jpg",1,1,1,1,"十万元","十亩地","喷洒农药");
//        dao.addEvent(newone);
//        newone.setEventId(1);

        Map<String,Object> map=new HashMap<>();
        map.put("eventId",4);
//        dao.updateEvent(newone);
//        map.put("eventName","虫害");
//        map.put("startTime","2019-06-16");
        List<Event> list=dao.findAllEventBy(map);
        session.commit();
        session.close();
        System.out.println(list.toString());

    }


}
