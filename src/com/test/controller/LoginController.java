package com.test.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	private int width = 90;// ����ͼƬ��width
	private int height = 20;// ����ͼƬ��height
	private int codeCount = 4;// ����ͼƬ����ʾ��֤��ĸ���
	private int xx = 15;
	private int fontHeight = 18;
	private int codeY = 16;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	//
	@RequestMapping(value = "/login")
	public String loginPage(String error, Model mv) {
		if (StringUtils.isNotEmpty(error)) {
			mv.addAttribute("error", "���µ�¼");
		}
		return "login";
	}

	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	@ResponseBody
	public String loginValidate(HttpServletRequest request, @RequestParam("username") String username, String code){
		
		String sessionCode = (String) request.getSession().getAttribute("imageCode");
		if(sessionCode != null && !"".equals(code)){
			if(sessionCode.equals(code)){
				System.out.println("the imageCode is right");
				
				return "welecome to tomcat";
			}
		}
		request.getSession().removeAttribute("imageCode");
		//System.out.println("the imageCode is right");
		return "fail to login";
	}
	
	@RequestMapping("/imageCode")
	public void imageCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String imageCode = (String) session.getAttribute("imageCode");
		if (imageCode == null || "".equals(imageCode)) {
			// ����ͼ��buffer
			BufferedImage buffImg = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			// Graphics2D gd = buffImg.createGraphics();
			// Graphics2D gd = (Graphics2D) buffImg.getGraphics();
			Graphics gd = buffImg.getGraphics();
			// ����һ���������������
			Random random = new Random();
			// ��ͼ�����Ϊ��ɫ
			gd.setColor(Color.WHITE);
			gd.fillRect(0, 0, width, height);

			// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
			Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
			// �������塣
			gd.setFont(font);

			// ���߿�
			gd.setColor(Color.BLACK);
			gd.drawRect(0, 0, width - 1, height - 1);

			// �������40�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
			gd.setColor(Color.BLACK);
			for (int i = 0; i < 40; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				gd.drawLine(x, y, x + xl, y + yl);
			}

			// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
			StringBuffer randomCode = new StringBuffer();
			int red = 0, green = 0, blue = 0;

			// �������codeCount���ֵ���֤�롣
			for (int i = 0; i < codeCount; i++) {
				// �õ������������֤�����֡�
				String code = String.valueOf(codeSequence[random.nextInt(36)]);
				// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
				red = random.nextInt(255);
				green = random.nextInt(255);
				blue = random.nextInt(255);

				// �������������ɫ����֤����Ƶ�ͼ���С�
				gd.setColor(new Color(red, green, blue));
				gd.drawString(code, (i + 1) * xx, codeY);

				// ���������ĸ�����������һ��
				randomCode.append(code);
			}

			session.setAttribute("imageCode", randomCode.toString());
			// ��ֹͼ�񻺴档  
			response.setHeader("Pragma", "no-cache");  
			response.setHeader("Cache-Control", "no-cache");  
			response.setDateHeader("Expires", 0);  
	  
			response.setContentType("image/jpeg");  
	  
	        // ��ͼ�������Servlet������С�  
	        ServletOutputStream sos = response.getOutputStream();  
	        ImageIO.write(buffImg, "jpeg", sos);  
	        sos.close();  
		}
	}
}
