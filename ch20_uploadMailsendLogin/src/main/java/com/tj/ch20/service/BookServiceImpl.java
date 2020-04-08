package com.tj.ch20.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch20.dao.BookDao;
import com.tj.ch20.dto.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	String backupPath = "D:/mega_IT/source/9_Spring/ch20_uploadMailsendLogin/src/main/webapp/upload/";

	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(Book book) {
		return bookDao.bookList(book); // 페이징 처리는 컨트롤러에서 하려나 봄?
	}

	@Override
	public int cntBook(Book book) {
		return bookDao.cntBook(book);
	}

	@Override
	public Book getBook(int bNum) {
		return bookDao.getBook(bNum);
	}

	@Override
	public int registerBook(Book book, MultipartHttpServletRequest mRequest) {
		
		String uploadPath = mRequest.getRealPath("upload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] fileNames = {"",""};
		int i = 0;
		
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			fileNames[i] = mFile.getOriginalFilename();
			
			if(fileNames[i]!=null && !fileNames[i].equals("")) {
				if(new File(uploadPath+fileNames[i]).exists()) {
					fileNames[i] = System.currentTimeMillis()+"_"+fileNames[i];
				}
				try {
					mFile.transferTo(new File(uploadPath+fileNames[i]));
					System.out.println("서버에 저장된 파일: "+uploadPath+fileNames[i]);
					System.out.println("백업 파일: "+backupPath+fileNames[i]); // 서버에 파일 저장						
					
					int result=fileCopy(uploadPath+fileNames[i], backupPath+fileNames[i]);
					System.out.println(result==1?i+"복사성공":i+"복사실패");				
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}			
			}else {
				
			}
			i++;
		}			
		book.setbImg1(fileNames[0]);
		book.setbImg2(fileNames[1]);
		
		return bookDao.registerBook(book);			
	}

	@Override
	public int modifyBook(Book book, MultipartHttpServletRequest mRequest) {

		String uploadPath = mRequest.getRealPath("upload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] fileNames = {"",""};
		int i = 0;
		
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			fileNames[i] = mFile.getOriginalFilename();
			
			if(fileNames[i]!=null && !fileNames[i].equals("")) {
				if(new File(uploadPath+fileNames[i]).exists()) {
					fileNames[i] = System.currentTimeMillis()+"_"+fileNames[i];
				}
				try {
					mFile.transferTo(new File(uploadPath+fileNames[i]));
					System.out.println("서버에 저장된 파일: "+uploadPath+fileNames[i]);
					System.out.println("백업 파일: "+backupPath+fileNames[i]); // 서버에 파일 저장						
					
					int result=fileCopy(uploadPath+fileNames[i], backupPath+fileNames[i]);
					System.out.println(result==1?i+"복사성공":i+"복사실패");				
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}			
			}else {
				
			}
			i++;
		}			
		book.setbImg1(fileNames[0]);
		book.setbImg2(fileNames[1]);
		
		return bookDao.registerBook(book);		
	}

	@Override
	public int deleteBook(int bNum) {
		return bookDao.deleteBook(bNum);
	}

	private int fileCopy(String serverFile, String backupFile) {
		int isCopy = 0;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			File sFile = new File(serverFile);
			byte[] buff = new byte[(int)sFile.length()];
			while(true) {
				int nRead = is.read(buff);
				if(nRead== -1) break;
				os.write(buff, 0, nRead);
			}
			isCopy = 1;
		} catch (IOException e) {
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
