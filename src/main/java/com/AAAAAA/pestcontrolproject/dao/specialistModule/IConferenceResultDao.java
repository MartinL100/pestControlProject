package com.AAAAAA.pestcontrolproject.dao.specialistModule;
import com.AAAAAA.pestcontrolproject.entity.specialistModule.TConference;

import java.util.List;

/**
 * 事件结果的持久接口
 */
public interface IConferenceResultDao {
    /**
     * 根据会商事件ID查询该事件的结果集合
     * @param conferenceId 会商事件ID
     * @return 会商事件的结果集合
     */

    public List<TConference> findConferenceByConferenceId(String conferenceId);
}
