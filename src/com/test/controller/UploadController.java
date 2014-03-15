package com.test.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件
 * @author hp
 *
 */
@Controller
@RequestMapping("upload")
public class UploadController extends BasicController {
	
	@RequestMapping("file")
	@ResponseBody
	public String uploadFile(@RequestParam(value="file", required=true)MultipartFile[] file, HttpServletRequest request){
		//String fileName = file.getOriginalFilename();
		int size = file.length;
		String p1 = request.getContextPath();
		String p2 = request.getRealPath("");
		String p3 = request.getRealPath("/");//在后面加上\
		
		
		return this.responseJson(true, "the file is uploaded");
	}

}
