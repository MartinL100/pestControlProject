package com.AAAAAA.pestcontrolproject.servlet.documentModule;


import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.DiseaseServiceImpl;
import com.AAAAAA.pestcontrolproject.util.StringInfo;
import org.apache.commons.fileupload.FileItem;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class UploadServlet extends HttpServlet {

                       DiseaseServiceImpl service=new DiseaseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          //获得页面的文件和表单文本map
        UploadServlet uploadUtil=new UploadServlet();
        boolean bl=false;
        //学生对象
        DiseaseBean diseaseBean = new DiseaseBean();
        Map<String, List<FileItem>> map= uploadUtil.getFileItem(request);
        //获得表单集合
        List<FileItem> listForm=   map.get("listForm");
        //获得文件集合
        List<FileItem> listFile=   map.get("listFile");
        String  afterPathDir=StringInfo.filePath; //文件放入的文件夹名
        //获得文件
        for (FileItem file:listFile) {
         String fileName=   file.getName();//上传图片的名字
            //做验证
//              bl=  Verify.verifyFile(fileName,new String[]{"jpg","doc"});
//                 if(!bl){
//                     break; //如果验证不成功就结束循环
//                 }
             //验证成功
            //重新生产新的文件名
            fileName= StringInfo.getNewFileName(fileName);
            //把文件名放入到实体对象中
         //   diseaseBean.setImgPath(fileName);

            OutputStream out=new FileOutputStream(afterPathDir+ fileName );
            InputStream in= file.getInputStream();
            byte[]bytes=new byte[1024];
            int len=0;
            while ((len=in.read(bytes))>0){
                //写
                out.write(bytes,0,len);
            }
            out.close();
            in.close();

        }

        if(bl) { //文件合法才去获取表单数据
            //打印出表单数据
            for (FileItem form : listForm) {

                String filedName = form.getFieldName();
                String val = form.getString("UTF-8");
                if (filedName.equals("diseaseName")) {
                    diseaseBean.setDiseaseName(val);
                } else if (filedName.equals("diseaseHarm")) {
                    diseaseBean  .setDiseaseHarm(val);
                }

            }

        }

        if(bl){
            //成功
               //把表单数据持久化
           service.AddDisease(diseaseBean);
          //重定向到查询servlet
            response.sendRedirect("student.lovo");
        }else{
            //失败
            request.setAttribute("errorImg", StringInfo.ERRORFILE);
            request.getRequestDispatcher("upload.jsp").forward(request,response);
        }

    }

    private Map<String, List<FileItem>> getFileItem(HttpServletRequest request) {
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
