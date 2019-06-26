package com.AAAAAA.pestcontrolproject.servic.eventModule;


import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;

import java.util.List;
import java.util.Map;

public interface IEventService {

    /**
     * 根据id 修改事件灾情阶段、方案信息
     * @param event
     */
    void eventUpdate(Event event);

    /**
     * 添加事件信息
     * @param event
     */
    void eventAdd(Event event);

    /**
     * 按条件查找对应的事件信息
     * @param map 条件集合
     * @return
     */
    List<Event> findAllByMap(Map<String,Object> map);




}
