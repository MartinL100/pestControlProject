package com.AAAAAA.pestcontrolproject.dao.documentModule;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;

import java.util.List;
import java.util.Map;

public interface ImouseDao {
   /**
    * 初始化页面
    * @return
    */
   public List<mouseBean>getListMouse();

   /**
    * 按id查询所有信息
    * @param mouseId
    * @return
    */
   public  mouseBean AllMouse(int mouseId);

   /**
    * 添加
    * @param mouseBean
    * @return
    */

   public int AddMouse(mouseBean mouseBean);

   /**
    * 判断名字是否存在
    * @param mouseName
    * @return
    */

   public int getMouseByName(String mouseName);

   /**
    * 动态查询
    * @param map
    * @return
    */

   public List<mouseBean>getByMouse(Map map);

   /**
    * 获得总行数
    * @param map
    * @return
    */
   public int getCountMouse(Map map);



}
