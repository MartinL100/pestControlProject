package com.AAAAAA.pestcontrolproject.dao.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.ResultSpecialist;

public interface IResultSpecialistDao {
    /**
     * 添加专家结果
     * @return 受影响的行数
     */
    public int addResultSpecialist( String  resultId,String  specialistId);
}
