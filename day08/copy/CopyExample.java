package copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) {
		System.out.println("파일 복사 시작");
//		copyImageFileByte();
		copyTextFile();
		System.out.println("파일 복사 완료");
	}

	// 1byte씩 스트림
	public static void copyImageFileByte() {
//		String sourceFilename = "Curi_01.jpg";
//		String targetFilename = "Curi_01_copied.jpg";
		String sourceFilename = "AtMyOwnPace.txt";
		String targetFilename = "AtMyOwnPace_copied.txt";
		
		
		try {
			InputStream fis = new FileInputStream(sourceFilename);
			OutputStream fos = new FileOutputStream(targetFilename);
			
			while (true) {
				int bytedata = fis.read();
				if (bytedata == -1) break;
//				System.out.println(bytedata);
				fos.write(bytedata);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 100byte씩 스트림
	public static void copyImageFileByteArr() {
		String sourceFilename = "Curi_01.jpg";
		String targetFilename = "Curi_01_copied.jpg";
		
		try {
			InputStream fis = new FileInputStream(sourceFilename);
			OutputStream fos = new FileOutputStream(targetFilename);
			
			while (true) {
				byte[] byteArr = new byte[100];
				int numBytes = fis.read(byteArr);
				if (numBytes == -1) break;
				fos.write(byteArr);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyTextFile() {
		String sourceFilename = "AtMyOwnPace.txt";
		String targetFilename = "AtMyOwnPace_copied2.txt";
		
		try (FileReader fr = new FileReader(sourceFilename);
			 FileWriter fw = new FileWriter(targetFilename)){
			
			while (true) {
				int chardata = fr.read();
				if (chardata == -1) break;
//				System.out.println("ch : " + chardata);
				fw.write(chardata);
			}
			
//			fw.close();	try()괄호 안에 객체를 만들어두면 알아서 close 해줌.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
