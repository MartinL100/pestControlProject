package com.AAAAAA.pestcontrolproject.servic.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.ResultSpecialist;

public interface IResultSpecialistService {
    /**
     * 添加专家结果
     * @return 是否成功过
     */
    public boolean addResultSpecialist(String  resultId,String  specialistId);
}
