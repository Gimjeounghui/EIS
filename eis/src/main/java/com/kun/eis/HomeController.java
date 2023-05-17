package com.kun.eis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
	
		logger.info("메인 페이지 실행");
		return "/common/index.tiles";
		
	}
	
	@RequestMapping(value="/goLogin")
	public String common() {
		
		logger.info("goLogin.jsp 실행");
		return "/user/common/goLogin.tiles";
		
	}
}