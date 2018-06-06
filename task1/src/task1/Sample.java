package task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Files;
import java.util.Scanner;


public class Sample {
public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a path");
	String sPath=sc.nextLine();
	File f1=new File(sPath);
	// getting extension
		String ext=sPath.substring(sPath.length()-4, sPath.length());
		// Checking whether it is exit or not
		if(ext.equals(".jpg") || ext.equals(".png") || ext.equals(".bmp") ) {
			if(f1.exists()) {
				File f2=new File("G:\\uploads"+f1.getName());
				if(Files.copy(f1.toPath(), f2.toPath())!= null) {
					System.out.println("image uploaded successfully..!");
				}else {
					System.out.println("unable to upload...!");
				}
				}else {
					System.out.println("File doesnot exist....!");
					
				
			}
		}
	}
}

