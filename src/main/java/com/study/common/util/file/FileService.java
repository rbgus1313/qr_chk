package com.study.common.util.file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {
	private String path = "/home/upload/images/";
	private final FileMapper fileMapper;

	public Map<String, Object> saveFiles(MultipartFile[] multipartFile) {
		String rootPath = System.getProperty("user.dir");
		System.out.println(rootPath);

		//파일 저장 성공 시 성공내용을 전달하기 위한 Map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int fileGrpSn = fileMapper.getFileGrpSeq();
		int fileSn = 1;
		for(MultipartFile file : multipartFile) {
			File saveFile = new File(path, UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename()));
			FileVO fileVO = new FileVO();
			fileVO.setFileFullPath(saveFile.getPath());
			fileVO.setFileNm(saveFile.getName());
			fileVO.setFileOgnNm(file.getOriginalFilename());
			fileVO.setFileGrpSn(fileGrpSn + "");
			fileVO.setFileSn(fileSn + "");
			fileMapper.saveFileInfo(fileVO);
			try {
				file.transferTo(saveFile);
				fileSn++;
			} catch(Exception ex) {
				System.out.println("저장오류 : " + ex);
			}
		}

		resultMap.put("fileGrpSn", fileGrpSn);

		return resultMap;
	}
}
