package com.AAAAAA.pestcontrolproject.util;

import java.util.HashMap;
import java.util.Map;

public class SplitPage {
    /**
     * 分页
     * @param currentPageString 当前页
     * @param pageTag 操作标记 first next  targetPage
     * @param rowNum  每页显示的行数
     * @param allRows 数据库查询出的总行数
     * @return  结果包括newCurrentPage：新的当前页；maxPage：最大页；startIndex：查询起始位置
     */
    public static Map<String,Object>SplitPage(String currentPageString,String pageTag,int rowNum,int allRows){
        Map<String,Object>map=new HashMap<>();
        //总页数
        int countPage=0;
        //计算总页数
       if(allRows%rowNum==0){
            countPage=allRows/rowNum;
       }else {
           countPage=allRows/rowNum+1;
       }
       //判断当前页，如果为空则默认显示第一页
        if(!CheckString.isNum(currentPageString)){
            currentPageString="1";
        }
        //将当前页转化为int
       int currentPage=Integer.parseInt(currentPageString);
        //如果标记为null则跳转到第一页
        if(CheckString.isNull(pageTag)){
            pageTag="1";
        }
       //判断操作标记
        switch (pageTag){
            //标记为下一页
            case "next":
                //如果为最大页则跳转到第一页
                if(currentPage>=countPage){
                    currentPage=1;
                }else {
                    currentPage+=1;
                }

                break;
                //标记为上一页
            case "prev":
                if(currentPage<=1){
                    currentPage=countPage;
                }else {
                    currentPage-=1;
                }

                break;
                //标记为输入的页数
          default:
              //如果标记不是数字或者为空，默认调到第一页
              if(!CheckString.isNum(pageTag)){
                  pageTag="1";
              }
            //判断输入的页码是否在搜索范围内
              currentPage=Integer.parseInt(pageTag);
              //页码大于最大页，则调到最大页
              if(currentPage>countPage){
                  currentPage=countPage;
              }
              //页码小于1，则跳到第一页
              if(currentPage<1){
                  currentPage=1;
              }
        }
        int startIndex=(currentPage-1)*rowNum;
        map.put("newCurrentPage",currentPage);
       map.put("maxPage",countPage);
       map.put("startIndex",startIndex);
        map.put("rowNum",rowNum);
        return map;
    }
}
