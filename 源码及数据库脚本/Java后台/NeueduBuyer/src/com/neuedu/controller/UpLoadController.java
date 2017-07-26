package com.neuedu.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.model.Nurse;

@Controller
public class UpLoadController {


	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(Nurse nurse, @RequestParam("file") MultipartFile tmpFile, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("upload");

		if (tmpFile != null) {
			// 获取物理路径
			String targetDirectory = request.getSession().getServletContext().getRealPath("/uploads");
			String tmpFileName = tmpFile.getOriginalFilename(); // 上传的文件名
			int dot = tmpFileName.lastIndexOf('.');
			String ext = ""; // 文件后缀名
			if ((dot > -1) && (dot < (tmpFileName.length() - 1))) {
				ext = tmpFileName.substring(dot + 1);
			}
			// 其他文件格式不处理
			if ("png".equalsIgnoreCase(ext) || "jpg".equalsIgnoreCase(ext) || "gif".equalsIgnoreCase(ext)) {
				// 重命名上传的文件名
				String targetFileName = renameFileName(tmpFileName);
				// 保存的新文件
				File target = new File(targetDirectory, targetFileName);

				try {
					// 保存文件
					FileUtils.copyInputStreamToFile(tmpFile.getInputStream(), target);
				} catch (IOException e) {
					e.printStackTrace();
				}

				//Nurse n = new Nurse();
				///n.setNurseName(nurse.getNurseName());
				nurse.setNursePicture(request.getContextPath() + "/uploads/" + targetFileName);

				modelAndView.addObject("n", nurse);
			}

			return modelAndView;
		}

		return modelAndView;
	}

	public static String renameFileName(String fileName) {
		String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date()); // 当前时间字符串
		int random = new Random().nextInt(10000);
		String extension = fileName.substring(fileName.lastIndexOf(".")); // 文件后缀

		return formatDate + random + extension;
	}

}