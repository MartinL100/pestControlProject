package com.AAAAAA.pestcontrolproject.dao.documentModule;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 病害接口类
 */
public interface IdiseaseDao {

   /**
    * 按对象添加
    * @param diseaseBean
    */
   public int AddDisease(DiseaseBean diseaseBean);

   /**
    * 按id查询信息
    * @param diseaseId 病害id
    * @return
    */
   public DiseaseBean AllDisease( int diseaseId);

   /**
    * 动态查询
    * @param map 条件
    * @return 集合   病害  名称
    */
   public List<DiseaseBean> getListDisease(Map map);

   /**
    * 获得总行数
    * @param map
    * @return
    */
   public int getDisease(Map map);

   /**
    * 初始化面板
    * @return
    */
   public List<DiseaseBean>  getList();

   /**
    * 判断名字是否存在
    * @param diseaseName
    * @return
    */
  public  int getDiseaseByName( String diseaseName);

}
