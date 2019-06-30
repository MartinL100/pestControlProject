package com.AAAAAA.pestcontrolproject.servlet.eventModule;

import com.AAAAAA.pestcontrolproject.entity.eventModule.Event;
import com.AAAAAA.pestcontrolproject.servic.impl.eventModule.EventServiceImpl;
import com.AAAAAA.pestcontrolproject.servic.eventModule.IEventService;
import com.AAAAAA.pestcontrolproject.util.UploadUtil;
import com.AAAAAA.pestcontrolproject.util.Verify;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class eventAddServlet extends HttpServlet {
    IEventService service = new EventServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Event event=new Event();
        UploadUtil uploadUtil= new UploadUtil();
        boolean bl=false;
        try {
            Map<String, List<FileItem>> map= uploadUtil.getFileItem(request);
            //获得表单集合
            List<FileItem> listForm= map.get("listForm");
            //获得表单数据
            for (FileItem form : listForm) {
                String filedName = form.getFieldName();
                String val = form.getString("UTF-8");
                String regex="\\d+";

                //验证数据格式
                if (filedName.equals("plan")) {
                    event.setPlan(val);
                } else if (filedName.equals("occurTime")) {
                   event.setOccurTime(val);
                }else if (filedName.equals("areaId")) {
                    if (!val.matches(regex)){
                        break;}
                    event.setAreaId(Integer.parseInt(val));
                }else if (filedName.equals("classId")) {
                    if (!val.matches(regex)){
                        break;}
                    event.setClassId(Integer.parseInt(val));
                }else if (filedName.equals("disasterStage")) {
                    if (!val.matches(regex)){
                        break;}
                    event.setDisasterStage(Integer.parseInt(val));
                } else if (filedName.equals("disasterType")) {
                    if (!val.matches(regex)){
                        break;}
                    event.setDisasterType(Integer.parseInt(val));
                } else if (filedName.equals("eventArea")) {
                    event.setEventArea(val);
                }else if (filedName.equals("eventDescribe")) {
                    event.setEventDescribe(val);
                }else if (filedName.equals("eventLoss")) {
                    event.setEventLoss(val);
                }else if (filedName.equals("eventName")) {
                    event.setEventName(val);
                }else if (filedName.equals("findWay")) {
                    if (!val.matches(regex)){
                        break;}
                    event.setFindWay(Integer.parseInt(val));
                }
            }

            //获得文件集合
            List<FileItem> listFile=   map.get("listFile");

            String  afterPathDir= FileStringInfo.FILEPATH; //文件放入的文件夹名
            //获得文件
            for (FileItem file:listFile) {
                String fileName=   file.getName();//上传图片的名字
                //做验证
                bl= Verify.verifyFile(fileName,new String[]{"jpg","png"});
                if(!bl){
                    break; //如果验证不成功就结束循环
                }
                //验证成功
                //重新生产新的文件名
                Date date=new Date();
                fileName= date.getTime()+FileStringInfo.getNewFileName(fileName);

                //把文件名放入到实体对象中
                event.setPhotoPath(fileName);

                OutputStream out=new FileOutputStream(afterPathDir+ fileName );
                InputStream in= file.getInputStream();
                byte[]bytes=new byte[1024];
                int len=0;
                while ((len=in.read(bytes))>0){
                    //写入文件
                    out.write(bytes,0,len);
                }
                out.close();
                in.close();
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


        // 将添加对象加入数据库
        service.eventAdd(event);

        //返回事件主页面
        response.sendRedirect("eventMainServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
