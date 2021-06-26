package com.imageupload.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.imageupload.util.Util;

import DBconnection.DatabaseConnectivity;

@WebServlet("/UploadImageController")
public class UploadImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file_name = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
            return;
        }
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List < FileItem > fields = upload.parseRequest(request);
            Iterator < FileItem > it = fields.iterator();
            if (!it.hasNext()) {
                return;
            }
            while (it.hasNext()) {
                FileItem fileItem = it.next();
                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    if (file_name == null) {
                        if (fileItem.getFieldName().equals("file_name")) {
                        	file_name = fileItem.getString();
                        }
                    }
                } else {
                    if (fileItem.getSize() > 0) {
                    	String filename = Util.getTimeInLong()+fileItem.getName();
                    	String path = "D:/Collage & Tution Work/SEM5&6/FINAL YEAR PROJECT/Workspace for projects/ImageUpload/WebContent/FM_Image/";
                         fileItem.write(new File(path+filename));
                         DatabaseConnectivity databaseConnectivity = DatabaseConnectivity.getInstance();
                         databaseConnectivity.openConnection();
                         System.out.println(path);
                         String sql = "insert product_image(name) values('"+filename+"')";
                         databaseConnectivity.excuteData(sql);
                         databaseConnectivity.closeConnection();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.println("<script type='text/javascript'>");
            out.println("window.location.href='addnewimage.jsp?filename="+file_name+"'");
            out.println("</script>");
            out.close();
        }
	}

}
