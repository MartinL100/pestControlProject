package com.AAAAAA.pestcontrolproject.entity.Selected;

import java.util.List;

public class SysSelectedType {
    /**
     * 下拉类型id
     */
 private long  typeId;
    /**
     * 下拉类型名称
     */
 private String typeName;
    /**
     * 下拉类型key
     */
 private int typeKey;
    /**
     * 下拉类型val
     */
 private String  typeVal;

    public SysSelectedType() {
    }

    public SysSelectedType(long typeId, String typeName, int typeKey, String typeVal) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeKey = typeKey;
        this.typeVal = typeVal;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(int typeKey) {
        this.typeKey = typeKey;
    }

    public String getTypeVal() {
        return typeVal;
    }

    public void setTypeVal(String typeVal) {
        this.typeVal = typeVal;
    }

    @Override
    public String toString() {
        return "SysSelected{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeKey=" + typeKey +
                ", typeVal='" + typeVal + '\'' +
                '}';
    }
}


