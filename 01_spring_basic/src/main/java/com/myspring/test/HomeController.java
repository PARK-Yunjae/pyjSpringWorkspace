package com.myspring.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	_01Member test1 = new _01Member();
	
	@Autowired
	_01Member test2;   // _01Member test2 = member;
	
	@Autowired
	_01Member test3;  // _01Member test2 = member;
	
	@Autowired
	_02UserDAO userDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		System.out.println(">> 1단계 >>  ");
		System.out.println("test1의 주소 = " + test1);
		test1.setNum(100);
		test1.getNum();
		
		System.out.println("test2의 주소 = " + test2);
		System.out.println("test3의 주소 = " + test3);

		test2.setNum(300);
		
		test2.getNum();
		test3.getNum();
		
		System.out.println(">> 2단계 >>  ");
		userDAO.print();
		
		
		return "home";  //"/WEB-INF/"+home+".jsp";
	}
	
}







