package com.AAAAAA.pestcontrolproject.dao.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.ConferenceResult;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TConference;

import java.util.List;

/**
 * 事件结果的持久接口
 */
public interface IConferenceResultDao {
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
     * @return 受影响的行数
     */
    public int addConferenceResult(ConferenceResult conferenceResult);

    /**
     * 根据会商ID查询结果ID
     *
     * @param ConferenceID 会商ID
     * @return 会商结果对象
     */
    public ConferenceResult findResultByConference(String ConferenceID);
}
