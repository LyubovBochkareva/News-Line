package ru.sibers.test.newsline.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@Controller
public class MainController {

	@Value("${upload.path}")
	private String uploadPath;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listNews() {
		return "news";
	}
}