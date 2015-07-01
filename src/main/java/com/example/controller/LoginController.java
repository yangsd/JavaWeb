package com.example.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.constants.UserConstant;
import com.example.dao.UserDao;
import com.example.exception.BusinessException;
import com.example.util.JsonUtil;
import com.example.util.RandomCodeUtil;
import com.example.vo.UserVO;

/**
 * Contoller����
 * 
 * @author sdyang
 * @date 2015��6��2�� ����5:14:27
 */
@Controller
@RequestMapping("/finc")
public class LoginController {

	@Resource
	UserDao userDao;

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public @ResponseBody
	Object greeting(HttpServletRequest request) {

		String pk_id = request.getParameter("id");
		UserVO user = new UserVO();
		user.setId(1);
		user.setName("sdyang");
		try {
			// userService.saveUser(user);
			// List<User> users = userService.getAllUser();
			userDao.getUserById(1);

		} catch (BusinessException e) {
			e.printStackTrace();
		}

		String obj = JsonUtil.getInstance().toJson("login");

		return obj;
	}

	/**
	 * ָ���¼ҳ��
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {

		return "login";

	}

	/**
	 * �˳���¼
	 * 
	 * @author sdyang
	 * @date 2015��7��1�� ����11:26:21
	 * @return
	 */
	@RequestMapping(value = "/loginout", method = RequestMethod.GET)
	public String getLoginOutPage() {
		return "login";
	}

	/**
	 * ָ���޷��ʶ�Ȩ��ҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {

		return "denied";

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		return "home";
	}

	/**
	 * ��ת��adminpageҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAadminPage() {
		return "admin";

	}

	@RequestMapping(value = "/randomnum", method = RequestMethod.GET)
	public @ResponseBody
	String randomid(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// ��֤��ͼƬ�Ŀ�ȡ�
		int width = 80;
		// ��֤��ͼƬ�ĸ߶ȡ�
		int height = 20;
		// ��֤���ַ�����
		int codeCount = 4;
		// ����߶�
		int fontHeight = height - 2;
		// X����
		int xx = width / (codeCount + 1);
		// Y����
		int codeY = height - 4;

		String randomCode = RandomCodeUtil.genNumPassword(4);

		// ����������ɵ���֤������ͼƬ��������
		// ����ͼ��buffer
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gra = image.createGraphics();

		// ��ͼ�����Ϊ��ɫ
		gra.setColor(Color.WHITE);
		gra.fillRect(0, 0, width, height);

		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
		// �������塣
		gra.setFont(font);

		// ���߿�
		gra.setColor(Color.BLACK);
		// gra.drawRect(0, 0, width - 1, height - 1);
		Random random = new Random();
		// �������160�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		gra.setColor(Color.BLACK);
		int red = 0, green = 0, blue = 0;
		char c;
		// ��ɫ���ϵ������ֵԽ��RGB��ɫֵԽС����ɫԽ��
		float colorDeep = 2;
		int rgbColorMax = Float.valueOf(255 / colorDeep).intValue();
		for (int i = 0; i < 4; i++) {
			c = randomCode.charAt(i);
			red = random.nextInt(rgbColorMax);
			green = random.nextInt(rgbColorMax);
			blue = random.nextInt(rgbColorMax);
			// �������������ɫ����֤����Ƶ�ͼ���С�
			gra.setColor(new Color(red, green, blue));
			gra.drawString("" + c, (i + 1) * xx, codeY);
		}
		// �ѵ�ǰ����֤�����session�У��Թ���¼ʱ��֤
		request.getSession().setAttribute(
				UserConstant.SESSION_VERIFICATIONCODE, randomCode);
		// ��ֹͼ�񻺴档
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(image, "jpeg", sos);
		sos.close();

		return null;
	}

}
