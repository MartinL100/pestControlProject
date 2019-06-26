package com.AAAAAA.pestcontrolproject.dao.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;

import java.util.List;

/**
 * 会商事件持久接口
 */
public interface IConferenceDao {


    /**
     * 根据会商ID查询事件对象
     *
     * @param conferenceId 会商ID
     * @return 事件对象
     */
    public Event findEventByConferenceId(String conferenceId);


    //    /**   -- 目前看，可以使用事件接口的动态查询方法，如果可以用，删除此方法
//     * 根据灾情状态查询事件集合
//     * @param stage 灾情状态默认为：无法解决，申请专家会商
//     * @return 事件集合
//     */
//    public List<Event> findEventByStage(String stage);
}
