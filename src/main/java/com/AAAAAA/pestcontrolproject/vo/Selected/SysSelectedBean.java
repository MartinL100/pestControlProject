package com.AAAAAA.pestcontrolproject.vo.Selected;

import java.util.List;

public class SysSelectedBean {

    /**
     * 下拉id
     */
    private long SelectedId;

    /**
     * 下拉类型
     */
    private String SelectType;

    /**
     * 下拉对应的key
     */
    private int SelectKey;

    /**
     * 下拉的值
     */
    private List<String> SelectValueList;


    public SysSelectedBean() {

    }

    public SysSelectedBean(long selectedId, String selectType, int selectKey, List<String> selectValueList) {
        SelectedId = selectedId;
        SelectType = selectType;
        SelectKey = selectKey;
        SelectValueList = selectValueList;
    }

    public long getSelectedId() {
        return SelectedId;
    }

    public void setSelectedId(long selectedId) {
        SelectedId = selectedId;
    }

    public String getSelectType() {
        return SelectType;
    }

    public void setSelectType(String selectType) {
        SelectType = selectType;
    }

    public int getSelectKey() {
        return SelectKey;
    }

    public void setSelectKey(int selectKey) {
        SelectKey = selectKey;
    }

    public List<String> getSelectValueList() {
        return SelectValueList;
    }

    public void setSelectValueList(List<String> selectValueList) {
        SelectValueList = selectValueList;
    }

    @Override
    public String toString() {
        return "SysSelectedBean{" +
                "SelectedId=" + SelectedId +
                ", SelectType='" + SelectType + '\'' +
                ", SelectKey=" + SelectKey +
                ", SelectValueList=" + SelectValueList +
                '}';
    }
}


