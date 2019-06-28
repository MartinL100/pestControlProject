import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.documentModule.IdiseaseService;
import com.AAAAAA.pestcontrolproject.servic.documentModule.ImouseSernice;
import com.AAAAAA.pestcontrolproject.servic.documentModule.IpestisService;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.MouseServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.PestisServiceImpl;
import org.junit.Test;

public class Tzeng {
    @Test
    public  void diseaseTest(){
//
//        IdiseaseService idiseaseService= new DiseaseServiceImpl();
//        DiseaseBean diseaseBean=new DiseaseBean();
//        diseaseBean.setDiseasePhoto("1.jpg");
//        diseaseBean.setDiseaseMeasure("xian");
//        diseaseBean.setDiseaseHarm("xhj");
//        diseaseBean.setDiseaseLaw("safsa");
//        diseaseBean.setDiseaseSymptom("sa");
//        diseaseBean.setDiseaseSource("sad");
//        diseaseBean.setDiseaseName("asf");
//        boolean b = idiseaseService.AddDisease(diseaseBean);
//        System.out.println(b);
//

    }

    @Test
    public void mouseT(){
//        ImouseSernice mouseService = new MouseServiceImpl();
//        mouseBean mouseBean=new mouseBean();
//        mouseBean.setMouseHarm("123");
//        mouseBean.setMousePhoto("1.jpg");
//        mouseBean.setMousePrevent("456");
//        mouseBean.setMouseNatural("456");
//        mouseBean.setMouseFood("789");
//        mouseBean.setMouseBreed("456");
//        mouseBean.setMouseName("456");
//        boolean b = mouseService.AddMouse(mouseBean);
//        System.out.println(b);
//
//
   }
   @Test
   public void pestisT(){
//        IpestisService ipestisService=new PestisServiceImpl();
//        pestisBean pestisBean=new pestisBean();
//        pestisBean.setPestisAdultImages("1.jpg");
//        pestisBean.setPestisPhoto("2.jpg");
//        pestisBean.setPestisDefense("123");
//        pestisBean.setPestisHarm("456");
//        pestisBean.setPestisEnemy("456");
//        pestisBean.setPestisHost("981");
//        pestisBean.setPestisBreed("645");
//        pestisBean.setPestisName("曾贤富");
//       boolean b = ipestisService.AddPestis(pestisBean);
//       System.out.println(b);

   }
    @Test
    public  void  pestisTest(){
        IpestisService pestisService = new PestisServiceImpl();
        pestisBean pestisBean = pestisService.AllPestis(1);
        System.out.println(pestisBean);


    }
    @Test
    public  void mouseTest(){
        ImouseSernice imouseSernice=new MouseServiceImpl();
        mouseBean mouseBean = imouseSernice.AllMouse(1);
        System.out.println(mouseBean);


    }


}
