import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class mainClass {

	public static void main(String[] args) {
		String arr[] = {
				"안녕하세요",
				"저는 푸주홍입니다"
		};
		writer("d:\\tmp\\newFile.txt", arr);

	}

	public static boolean writer(String path, String[] data) {
		boolean writeOk = false;
		//String filePathString = "d:\\tmp\\newFile.txt";
		File fp = new File(path);
		FileWriter fw;
		try {
			if(fp.createNewFile()) {
				System.out.println("[writer] : 파일 생성 완료");
			} else {
				System.out.println("[writer] : 파일 생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 파일 존재여부
		if(fp.exists()) {
			System.out.println("[writer] : 파일이 존재합니다.");
		}
		// 파일 읽기가능여부
		if(fp.canRead()) {
			System.out.println("[writer] : 파일을 읽을 수 있습니다.");
		}
		
		try {
			fw = new FileWriter(fp);
			for(String d : data) {
				fw.write(d);
			}
			writeOk = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writeOk;
	}
}
