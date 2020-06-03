package fileClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class mainClass {
	public static void main(String[] args) throws Exception {
		//File fp = new File("d:\\project");
		/* 파일목록
		String fileList[] = fp.list();
		for(String iter : fileList) {
			System.out.println(iter);
		}
		
		File[] fileList = fp.listFiles();
		for(File iter : fileList) {
			System.out.println(iter.getName() + " -> " + (iter.isFile() ? "is File" : "is not File"));
		}
		*/
		
		// 파일 생성
		String filePathString = "d:\\tmp\\newFile.txt";
		File fp = new File(filePathString);
		try {
			if(fp.createNewFile()) {
				System.out.println("파일 생성 완료");
			} else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 파일 존재여부
		if(fp.exists()) {
			System.out.println("파일이 존재합니다.");
		}
		// 파일 읽기가능여부
		if(fp.canRead()) {
			System.out.println("파일을 읽을 수 있습니다.");
		}
		
		FileReader fr = new FileReader(fp);
		int c = fr.read();
		while(c != -1) {
			System.out.println((char) c);
			c = fr.read();
		}
		
	}
}
