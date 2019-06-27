package com.AAAAAA.pestcontrolproject.servic.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.Dto.ConferenceDto;
import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;

import java.util.List;

public interface IConferenceDtoService {
    /**
     * 根据会商ID查询事件对象
     *
     * @param conferenceId 会商ID
     * @return 事件对象
     */
    public ConferenceDto findEventByConferenceId(String conferenceId);

    /**
     * 查询所有的会商事件
     * @return
     */
    public List<ConferenceDto> allConference();
}
