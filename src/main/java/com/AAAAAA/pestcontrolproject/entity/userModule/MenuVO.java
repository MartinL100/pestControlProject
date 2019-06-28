package com.AAAAAA.pestcontrolproject.entity.userModule;

import java.util.List;

public class MenuVO {

    private TPower firstMenu;
    private List<TPower>secendMenu;

    public TPower getFirstMenu() {
        return firstMenu;
    }

    public void setFirstMenu(TPower firstMenu) {
        this.firstMenu = firstMenu;
    }

    public List<TPower> getSecendMenu() {
        return secendMenu;
    }

    public void setSecendMenu(List<TPower> secendMenu) {
        this.secendMenu = secendMenu;
    }
}
