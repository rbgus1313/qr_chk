package com.study.common.util.file;

import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FileController {
	@ResponseBody
	@GetMapping("/phtoImg/{filename}")
	public Resource showImage(@PathVariable String filename) throws
	MalformedURLException {
	 	return new UrlResource("file:" + "/home/upload/images/" + filename);
	 }
}
