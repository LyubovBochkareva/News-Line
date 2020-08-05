package ru.sibers.test.newsline.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@RestController
public class ImagePathController {

	@Value("${upload.path}")
	private String uploadPath;

	/**
	 * Returns a Resource object by file name.
	 *
	 * @param imageFileName file name
	 * @return Resource object by file name
	 */
	@RequestMapping(value = "/img/{filename}")
	public Resource getResource(@PathVariable("filename") String imageFileName) {
		return new FileSystemResource(uploadPath + "/" + imageFileName);
	}
}