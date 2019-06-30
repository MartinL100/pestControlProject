package com.AAAAAA.pestcontrolproject.dao.eventModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.TConference;

import java.util.List;

public interface IAddConfDao {

    /**
     * 添加会商事件信息
     * @param eventId
     */
    void addConf(int eventId);

    /**
     * 根据事件Id查询专家会商ID
     * @param EventId
     * @return
     */
    List<TConference> findConfIdByEventId(int EventId);

}
