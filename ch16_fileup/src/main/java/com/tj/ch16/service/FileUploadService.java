package com.tj.ch16.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileUploadService {
	public boolean FileUp(MultipartHttpServletRequest mRequest, Model model) {
		boolean isUpload = false; // copy 성공하면 true 리턴, 실패하면 false 리턴 예정
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:/mega_IT/source/9_Spring/ch16_fileup/src/main/webapp/upload/";
		String[] fileNames = new String[3];
		int i = 0;
		
		Iterator<String> params = mRequest.getFileNames(); // file1, file2, file3를 읽어온다.
		while(params.hasNext()) { // params.hasNext()있으면 진행한다.
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 파일 객체 
			String originalFileName = mFile.getOriginalFilename(); // 업로드 했을 때 원래 이름
			fileNames[i] = originalFileName;
			if(fileNames[i]!=null && !fileNames[i].equals("")) { // 첨부함
				if(new File(uploadPath+fileNames[i]).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재하는 경우 -> 파일 이름을 변경해서 저장한다.
					fileNames[i] = System.currentTimeMillis()+fileNames[i];
				}//if
				try {
					mFile.transferTo(new File(uploadPath+fileNames[i]));
					System.out.println("서버에 저장된 파일: "+uploadPath+fileNames[i]);
					System.out.println("백업 파일: "+backupPath+fileNames[i]);
					isUpload = fileCopy(uploadPath+fileNames[i], backupPath+fileNames[i]); // copy 성공하면 true 리턴, 실패하면 false 리턴 (밑에 메소드 이뜸.)
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} // 서버에 파일을 저장하는 로직
			} // if
			i++; // params의 개수만큼 진행된다.
		}// while
		model.addAttribute("fileNames", fileNames); // 배열 통째로 어트리븉
		return isUpload;
	}
	private boolean fileCopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int)file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte==-1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {		
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}
