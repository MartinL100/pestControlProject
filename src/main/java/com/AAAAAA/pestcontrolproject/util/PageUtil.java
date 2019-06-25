package com.AAAAAA.pestcontrolproject.util;

public class PageUtil {
    //当前页
    private  int currentPage=1;
    //总行数
    private  int allCount=0;
    //总页数
    private  int allPage=0;
    //起始位置
    private  int startPage=0;
    //每页显示多少行
    private  int countPage=5;

    /**
     * 修改当前页
     * @param currentPage
     */
    public void setCurrentPage(int currentPage,String pageTag) {
        switch (pageTag){
            case "firstPage":
                this.currentPage=1;
                break;
            case "nextPage":
                if(currentPage==this.allPage){
                    this.currentPage=1;
                }else {
                    this.currentPage = currentPage + 1;
                }
                break;
            case "prevPage":
                if(currentPage==1){
                    this.currentPage=this.allPage;
                }else {
                    this.currentPage = currentPage - 1;
                }
                break;
            case "lastPage":
                this.currentPage=this.allPage;
                break;
                default:
                    this.currentPage=1;
        }

    }
    //计算总页数
    public void setAllPage() {
        //获得总行数
        if(this.allCount%this.countPage==0){
                 this.allPage=allCount/this.countPage;
        }else{
            this.allPage=allCount/this.countPage+1;
        }
    }

    /**
     * 计算起始位置
     */
    public void setStartPage() {
       this.startPage=(this.currentPage-1)*countPage;
    }








    public int getCurrentPage() {
        return currentPage;
    }



    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getAllPage() {
        return allPage;
    }


    public int getStartPage() {
        return startPage;
    }



    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }
}
