package com.AAAAAA.pestcontrolproject.servlet.documentModule.pestis;

import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.pestisBean;
import com.AAAAAA.pestcontrolproject.servic.documentModule.IpestisService;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.PestisServiceImpl;
import com.AAAAAA.pestcontrolproject.util.CheckString;
import com.AAAAAA.pestcontrolproject.util.FileStringInfo;
import com.AAAAAA.pestcontrolproject.util.UploadUtil;
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

public class AddPestisServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IpestisService ipestisService=new PestisServiceImpl();
        //获得页面的文件和表单文本map
        UploadUtil uploadUtil = new UploadUtil();
        boolean bl = false;
        //得到虫害对象
        pestisBean pestssBean =new pestisBean();
        try {
            Map<String, List<FileItem>> map = uploadUtil.getFileItem(request);
            //获得表单集合
            List<FileItem> listForm = map.get("listForm");
            //获得图片集合
            List<FileItem> listFile = map.get("listFile");
            String afterPathDir = FileStringInfo.filePath; //文件放入的文件夹名
            //获得图片
            for (FileItem file : listFile) {
                String fileName = file.getName();//上传图片的名字
                //验证图片后缀名
                bl = CheckString.verifyFile(fileName, new String[]{"jpg", "png", "gif"});
                if (!bl) {
                    break; //如果验证不成功就结束循环
                }
                //验证成功
                //重新生产新的文件名
                fileName = FileStringInfo.getNewFileName(fileName);
                //把文件名放入到虫害害对象
              pestssBean.setPestisPhoto(fileName);
                OutputStream out = new FileOutputStream(afterPathDir + fileName);
                InputStream in = file.getInputStream();
                byte[] bytes = new byte[1024 * 3];
                int len = 0;
                while ((len = in.read(bytes)) > 0) {
                    //将图片写入文件夹
                    out.write(bytes, 0, len);
                }
                out.close();
                in.close();

                //图片合法则获取表单数据
                if (bl) {
                    for (FileItem form : listForm) {
                        String filedName = form.getFieldName();
                        String val = form.getString("UTF-8");
                        //添加数据
                        if ("pestisName".equals(filedName)) {
                              pestssBean.setPestisName(val);
                        } else if ("pestisBreed".equals(filedName)) {
                            pestssBean.setPestisBreed(val);
                        } else if ("pestisHost".equals(filedName)) {
                            pestssBean.setPestisHost(val);
                        } else if ("pestisEnemy".equals(filedName)) {
                            pestssBean.setPestisEnemy(val);
                        } else if ("pestisHarm".equals(filedName)) {
                            pestssBean.setPestisHarm(val);
                        } else if ("pestisDefense".equals(filedName)) {
                            pestssBean.setPestisDefense(val);
                        } else if ("pestisPhoto".equals(filedName)) {
                            pestssBean.setPestisPhoto(val);
                        }else if ("pestisAdultImages".equals(filedName)){
                            pestssBean.setPestisAdultImages(val);
                        }
                    }

                }
            }
            if (bl) {
                //验证成功，将数据保存，并返回SpecialistMain.jsp
              ipestisService.AddPestis(pestssBean);

                response.sendRedirect("/pestisIndex");
            } else {
                //验证失败，返回到错误页面
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
