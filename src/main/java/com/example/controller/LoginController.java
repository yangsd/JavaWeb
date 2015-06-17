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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exception.BusinessException;
import com.example.service.itf.IUserService;
import com.example.util.JsonUtil;
import com.example.util.RandomCodeUtil;
import com.example.vo.UserVO;

/**
 * Contoller测试
 * 
 * @author sdyang
 * @date 2015年6月2日 下午5:14:27
 */
@Controller
@RequestMapping("/html")
public class LoginController {

	@Resource
	IUserService userService;

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
			userService.getUserById(1);

		} catch (BusinessException e) {
			e.printStackTrace();
		}

		String obj = JsonUtil.getInstance().toJson("login");

		return obj;
	}

	/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView index(HttpServletRequest request) {

		return new ModelAndView("/html/login.jsp");
	}
*/
	/**
	 * 指向登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(
			@RequestParam(value = "error", required = false) boolean error,
			ModelMap model) {

		if (error == true) {
			// Assign an error message
			model.put("error",
					"You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		return "login";

	}

	/**
	 * 指定无访问额权限页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {

		return "deniedpage";

	}
	
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String getCommonPage() {
		return "commonpage";
	}

	/**
	 * 跳转到adminpage页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAadminPage() {
		return "adminpage";

	}
	
	@RequestMapping(value = "/randomnum", method = RequestMethod.GET)
    public @ResponseBody
    String randomid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 验证码图片的宽度。
        int width = 80;
        // 验证码图片的高度。
        int height = 20;
        // 验证码字符个数
        int codeCount = 4;
        // 字体高度
        int fontHeight = height - 2;
        // X坐标
        int xx = width / (codeCount + 1);
        // Y坐标
        int codeY = height - 4;

        String randomCode = RandomCodeUtil.genNumPassword(4);

        // 这里根据生成的验证码生成图片，并返回
        // 定义图像buffer
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D gra = image.createGraphics();

        // 将图像填充为白色
        gra.setColor(Color.WHITE);
        gra.fillRect(0, 0, width, height);

        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
        // 设置字体。
        gra.setFont(font);

        // 画边框。
        gra.setColor(Color.BLACK);
        // gra.drawRect(0, 0, width - 1, height - 1);
        Random random = new Random();
        // 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
        gra.setColor(Color.BLACK);
        int red = 0, green = 0, blue = 0;
        char c;
        // 颜色深度系数，数值越大，RGB颜色值越小，颜色越深
        float colorDeep = 2;
        int rgbColorMax = Float.valueOf(255 / colorDeep).intValue();
        for (int i = 0; i < 4; i++) {
            c = randomCode.charAt(i);
            red = random.nextInt(rgbColorMax);
            green = random.nextInt(rgbColorMax);
            blue = random.nextInt(rgbColorMax);
            // 用随机产生的颜色将验证码绘制到图像中。
            gra.setColor(new Color(red, green, blue));
            gra.drawString("" + c, (i + 1) * xx, codeY);
        }
        // 把当前的验证码存入session中，以供登录时验证
        request.getSession().setAttribute("VALIDATION_KEY", randomCode);
        // 禁止图像缓存。
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
