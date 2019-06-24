package com.AAAAAA.pestcontrolproject.util;

import java.util.HashMap;
import java.util.Map;

public class SplitPage {
    /**
     * 分页
     * @param currentPage 当前页
     * @param pageTag 操作标记 first next  targetPage
     * @param rowNum  每页显示的行数
     * @param allRows 数据库查询出的总行数
     * @return  结果包括newCurrentPage：新的当前页；maxPage：最大页；startIndex：查询起始位置
     */
    public static Map<String,Object>SplitPage(int currentPage,String pageTag,int rowNum,int allRows){
        Map<String,Object>map=new HashMap<>();
        //总页数
        int countPage=0;
        //计算总页数
       if(allRows%rowNum==0){
            countPage=allRows/rowNum;
       }else {
           countPage=allRows/rowNum+1;
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
        return map;
    }
}
