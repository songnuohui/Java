package com.zt.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.zt.po.User;

/*
 * 注册控制器
 * */
@WebServlet("/reg")
public class RegServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		     User user=new User();
		 //1:创建一个磁盘工厂类
		 DiskFileItemFactory df=new DiskFileItemFactory();
		 //2:创建一个文件上传组件
		  ServletFileUpload upload=new ServletFileUpload(df);
		  //3:解析文件表单 得到一个表单项的集合
		  try {
			List<FileItem> items=upload.parseRequest(request);
			//遍历表单项的集合  判断是文本还是文件
			for(FileItem item:items){
				if(item.isFormField()){//判断是否是文本域
				String name=item.getFieldName();  //获取表单的name
				String value=item.getString("utf-8");//获取输入值
				if("name".equals(name)){
					user.setName(value);
				}
				if("pass".equals(name)){
					user.setPass(value);
				}
				if("address".equals(name)){
					user.setAddress(value);
				}
				}else{
					//文件
					String fileName=item.getName();
					String fileType=fileName.substring(fileName.lastIndexOf("."));
					String newFileName=UUID.randomUUID().toString().replace("-", "")+fileType;
					String path=request.getRealPath("/fileUpload/");
					System.out.println(path);
					File destFile=new File(path,newFileName);
					try {
						item.write(destFile);
						user.setPhoto("fileUpload/"+newFileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(user);
					//dao.save(user)
					  //获取的时候  查对象
					//  <a href="${resource.url}">${resource.title}</a>
				}
			}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		
	}
	

}
