package com.drezz.entity.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface StudentFileService {
	public String save(MultipartFile file) throws IOException;

}
