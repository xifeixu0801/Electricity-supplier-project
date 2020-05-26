/**
 * 
 */
package com.neuedu.shop.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 徐习飞
 * @date 2020年5月8日下午3:20:06
 */
@Controller
public class CodeController {

	public static final int WIDTH = 100;// 生成的图片的宽度
	public static final int HEIGHT = 22;// 生成的图片的高度

	@RequestMapping(value = "/back/code.code", method = RequestMethod.GET)
	public void Code(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		// 在内存中创建一张图片
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 得到图片
		Graphics g = bi.getGraphics();
		// 设置图片背景色
		Color c = new Color(200, 150, 255);
		g.setColor(c);// 背景颜色
		g.fillRect(0, 0, WIDTH, HEIGHT);// 背景框
		// 设置字体、字号
		g.setFont(new Font("微软雅黑", Font.BOLD, 16));
		// 字母数字组合：
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVEXYZ0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

		Random r = new Random();
		int len = ch.length;
		int index;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			index = r.nextInt(len);// 随机获得一个起始位置
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));// 给字体一个随机的颜色
			g.drawString(ch[index] + "", (i * 18) + 8, 16);
			sb.append(ch[index]);
			g.drawLine(r.nextInt(80), r.nextInt(40), r.nextInt(80), r.nextInt(40));
		}
System.out.println(sb.toString());
		// 将生成的验证码绑定到session中
		request.getSession().setAttribute("checkcode", sb.toString());// 将生产的验证码保存下来，以便之后的检验输入是否一致
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}
}
