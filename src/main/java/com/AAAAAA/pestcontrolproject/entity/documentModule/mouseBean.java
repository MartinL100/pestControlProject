package com.AAAAAA.pestcontrolproject.entity.documentModule;

/**
 * 鼠害实体类
 */
public class mouseBean {
    /**鼠害id*/
    private int id;
    /**鼠害名称*/
    private String mouseName;
    /**鼠害繁殖*/
    private String mouseBreed;
    /**鼠害食物*/
    private String mouseFood;
    /**鼠害天敌*/
    private String mouseNatural;
    /**鼠害防治措施*/
    private String mousePrevent;
    /**鼠害图片*/
    private String mousePhoto;
    /**主要危害*/
    private String mouseHarm;

    @Override
    public String toString() {
        return "mouseBean{" +
                "id=" + id +
                ", mouseName='" + mouseName + '\'' +
                ", mouseBreed='" + mouseBreed + '\'' +
                ", mouseFood='" + mouseFood + '\'' +
                ", mouseNatural='" + mouseNatural + '\'' +
                ", mousePrevent='" + mousePrevent + '\'' +
                ", mousePhoto='" + mousePhoto + '\'' +
                ", mouseHarm='" + mouseHarm + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMouseName() {
        return mouseName;
    }

    public void setMouseName(String mouseName) {
        this.mouseName = mouseName;
    }

    public String getMouseBreed() {
        return mouseBreed;
    }

    public void setMouseBreed(String mouseBreed) {
        this.mouseBreed = mouseBreed;
    }

    public String getMouseFood() {
        return mouseFood;
    }

    public void setMouseFood(String mouseFood) {
        this.mouseFood = mouseFood;
    }

    public String getMouseNatural() {
        return mouseNatural;
    }

    public void setMouseNatural(String mouseNatural) {
        this.mouseNatural = mouseNatural;
    }

    public String getMousePrevent() {
        return mousePrevent;
    }

    public void setMousePrevent(String mousePrevent) {
        this.mousePrevent = mousePrevent;
    }

    public String getMousePhoto() {
        return mousePhoto;
    }

    public void setMousePhoto(String mousePhoto) {
        this.mousePhoto = mousePhoto;
    }

    public String getMouseHarm() {
        return mouseHarm;
    }

    public void setMouseHarm(String mouseHarm) {
        this.mouseHarm = mouseHarm;
    }


}
