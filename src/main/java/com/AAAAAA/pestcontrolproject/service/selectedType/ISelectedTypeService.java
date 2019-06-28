package com.AAAAAA.pestcontrolproject.service.selectedType;

import com.AAAAAA.pestcontrolproject.entity.Selected.SysSelectedType;

import java.util.List;

public interface ISelectedTypeService {

    /**
     * 根据下拉框的id得到对应数据
     * @param SelectedId
     * @return
     */
    public SysSelectedType getSelectedValueByID(long SelectedId);




    /**
     * 通过下拉框类型得到下拉框集合
     * @param TypeName 下拉框类型名称
     * @return 下拉框集合
     */
    public List<SysSelectedType> getSelectValueListByTypeName(String TypeName);

    /**
     * 得到所有班级下拉框
     * @return 班级下拉框集合
     */
    public List<SysSelectedType> getAllClass();

}
