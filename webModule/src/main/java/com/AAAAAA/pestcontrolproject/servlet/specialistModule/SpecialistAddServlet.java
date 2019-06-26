package com.AAAAAA.pestcontrolproject.servlet.specialistModule;

import com.AAAAAA.pestcontrolproject.entity.specialistModule.TSpecialist;
import com.AAAAAA.pestcontrolproject.servic.impl.specialistModule.ISpecialistServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.specialistModule.ISpecialistService;
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

public class SpecialistAddServlet extends HttpServlet {
    ISpecialistService service = new ISpecialistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得页面的文件和表单文本map
        UploadUtil uploadUtil = new UploadUtil();
        boolean bl = false;
        //得到专家对象
        TSpecialist specialist = new TSpecialist();
        try {
            Map<String, List<FileItem>> map = uploadUtil.getFileItem(req);
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
                //把文件名放入到专家对象
                specialist.setSpecialistPath(fileName);
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
            }
            //图片合法则获取表单数据
            if (bl) {
                for (FileItem form : listForm) {

                    String filedName = form.getFieldName();
                    String val = form.getString("UTF-8");
                    //添加数据
                    if ("specialistName".equals(filedName)) {
                        specialist.setSpecialistName(val);
                    } else if ("specialistSex".equals(filedName)) {
                        if ("1".equals(val)) {
                            val = "男";
                        } else {
                            val = "女";
                        }
                        specialist.setSpecialistSex(val);
                    } else if ("specialistBbirthday".equals(filedName)) {
                        specialist.setSpecialistBirthday(val);
                    } else if ("specialistSpeciality".equals(filedName)) {
                        specialist.setSpecialistSpeciality(val);
                    } else if ("specialistDuty".equals(filedName)) {
                        specialist.setSpecialistDuty(val);
                    } else if ("specialistTel".equals(filedName)) {
                        specialist.setSpecialistTel(val);
                    } else if ("specialistUnits".equals(filedName)) {
                        specialist.setSpecialistUnits(val);
                    } else if ("specialistSite".equals(filedName)) {
                        specialist.setSpecialistSite(val);
                    } else if ("specialistEmail".equals(filedName)) {
                        specialist.setSpecialistEmail(val);
                    }
                }

            }
            if (bl) {
                //验证成功，将数据保存，并返回SpecialistMain.jsp
                service.addSpecialist(specialist);
                resp.sendRedirect("specialistMain");
            } else {
                //验证失败，返回到错误页面

            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
