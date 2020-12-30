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
 * ע�������
 * */
@WebServlet("/reg")
public class RegServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		     User user=new User();
		 //1:����һ�����̹�����
		 DiskFileItemFactory df=new DiskFileItemFactory();
		 //2:����һ���ļ��ϴ����
		  ServletFileUpload upload=new ServletFileUpload(df);
		  //3:�����ļ��� �õ�һ������ļ���
		  try {
			List<FileItem> items=upload.parseRequest(request);
			//��������ļ���  �ж����ı������ļ�
			for(FileItem item:items){
				if(item.isFormField()){//�ж��Ƿ����ı���
				String name=item.getFieldName();  //��ȡ����name
				String value=item.getString("utf-8");//��ȡ����ֵ
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
					//�ļ�
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
					  //��ȡ��ʱ��  �����
					//  <a href="${resource.url}">${resource.title}</a>
				}
			}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		
	}
	

}
