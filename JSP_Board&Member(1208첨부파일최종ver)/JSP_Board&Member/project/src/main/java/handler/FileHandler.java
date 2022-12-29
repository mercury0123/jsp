package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BoardController;

public class FileHandler {
	
	private static final Logger log = LoggerFactory.getLogger(FileHandler.class); 
	
	//파일 이름과 경로를 받아서 파일을 삭제하는 메소드
	//리턴타입 int => 잘 삭제되었는지 check위한 변수 (ex: int isOk)
	public int deleteFile(String imageFileName, String savePath) {
		boolean isDel = true;	//삭제가 잘 이루어졌는지 체크하는 변수
		log.info("deleteFile method 접근");
		log.info("imageFileName : " + imageFileName);
		log.info("savePath : "+savePath);
		
		File fileDir = new File(savePath); //io import
		File removeFile = new File(fileDir+File.separator+imageFileName);
		File removeThumbFile = new File(fileDir+File.separator+"th_"+imageFileName);
		
		//파일이 있어야(존재해야) 삭제가 가능 - exists() : 존재하는지 boolean값
		if (removeFile.exists() || removeThumbFile.exists()) {
			isDel = removeFile.delete(); // delete() boolean값 으로 return. 근데 "int" deleteFile 이므로
			log.info("FileHandler remove : "+(isDel? "삭제성공":"삭제실패"));
			if (isDel) {
				isDel = removeThumbFile.delete();	//원파일이 지워져야 썸네일도 삭제
				log.info("FileHandler remove Thumbnail : "+(isDel? "삭제성공":"삭제실패"));
			}
		}
		log.info("FileHandler remove OK!!");
		return isDel? 1 : 0;	//지워지면 1 리턴 아니면 0 리턴
	}
}