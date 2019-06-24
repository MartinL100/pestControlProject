package com.AAAAAA.pestcontrolproject.dao.eventModule;

import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;

import java.util.List;
import java.util.Map;

public interface IEventDao {

    /**
     * 根据条件查询事件
     * @param map 查询条件
     * @return 事件集合
     */
    List<Event> findAllEventBy(Map<String,Object> map);

    /**
     *  添加事件
     * @param event
     */
    void addEvent(Event event);

    /**
     * 修改事件信息
     * @param event
     */
    void updateEvent(Event event);




}
