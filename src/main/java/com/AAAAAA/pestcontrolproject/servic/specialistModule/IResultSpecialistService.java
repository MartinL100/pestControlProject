package com.AAAAAA.pestcontrolproject.servic.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.ResultSpecialist;

public interface IResultSpecialistService {
    /**
     * 添加专家结果
     *
     * @param resultSpecialist 专家结果对象
     * @return 是否成功过
     */
    public boolean addResultSpecialist(ResultSpecialist resultSpecialist);
}
