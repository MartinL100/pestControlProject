package com.AAAAAA.pestcontrolproject.servlet.documentModule.mouse;

import com.AAAAAA.pestcontrolproject.entity.documentModule.DiseaseBean;
import com.AAAAAA.pestcontrolproject.entity.documentModule.mouseBean;
import com.AAAAAA.pestcontrolproject.servic.documentModule.ImouseSernice;
import com.AAAAAA.pestcontrolproject.servic.impl.documentModule.MouseServiceImpl;
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

public class AddMouseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ImouseSernice mouseService = new MouseServiceImpl();
        //获得页面的文件和表单文本map
        UploadUtil uploadUtil = new UploadUtil();
        boolean bl = false;
        //得到虫害对象
        mouseBean mouseBean=new mouseBean();
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
                mouseBean.setMousePhoto(fileName);
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
                        if ("mouseName".equals(filedName)) {
                            mouseBean.setMouseName(val);
                        } else if ("mouseBreed".equals(filedName)) {
                            mouseBean.setMouseBreed(val);
                        } else if ("mouseFood".equals(filedName)) {
                           mouseBean.setMouseFood(val);
                        } else if ("mouseNatural".equals(filedName)) {
                            mouseBean.setMouseNatural(val);
                        } else if ("mousePrevent".equals(filedName)) {
                            mouseBean.setMousePrevent(val);
                        } else if ("mousePhoto".equals(filedName)) {
                            mouseBean.setMousePhoto(val);
                        } else if ("mouseHarm".equals(filedName)) {
                         mouseBean.setMouseHarm(val);
                        }
                    }

                }
            }
            if (bl) {
                //验证成功，将数据保存，并返回SpecialistMain.jsp
                mouseService.AddMouse(mouseBean);

                response.sendRedirect("/mouseIndex");
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
