package com.AAAAAA.pestcontrolproject.servic.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.ConferenceResult;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.ResultSpecialist;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TConference;

import java.util.List;

public interface IConferenceResultService {
    /**
     * 根据会商事件ID查询该事件的结果集合
     *
     * @param conferenceId 会商事件ID
     * @return 会商事件的结果集合
     */

    public List<ConferenceResult> findConferenceByConferenceId(String conferenceId);

    /**
     * 添加会商结果
     *
     * @param conferenceResult 会商结果对象
     * @return 是否成功
     */
    public boolean addConferenceResult(ConferenceResult conferenceResult);
}
