package net.dzikoysk.wildskript.collections.obfuscator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Random;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ObfuscatorUtils {
	
	public static void zip(File input, File output){ 
		byte[] buffer = new byte[1024];
		try{
			FileOutputStream fos = new FileOutputStream(output);
			ZipOutputStream zos = new ZipOutputStream(fos);
			ZipEntry ze = new ZipEntry(input.getPath());
			zos.putNextEntry(ze);
			FileInputStream in = new FileInputStream(input);
			int len;
			while ((len = in.read(buffer)) > 0) zos.write(buffer, 0, len);
			in.close();
			zos.closeEntry();
			zos.close();
		}catch(IOException ex){
		   ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static String unzip(File zip){
		String code = "";
	    try{
	    	ZipFile zipFile = new ZipFile(zip);
	        Enumeration<? extends ZipEntry> entries = zipFile.entries();
	        InputStream is = null;
	        while(entries.hasMoreElements()){
	            ZipEntry entry = entries.nextElement();
	            is = zipFile.getInputStream(entry);
	        }
	        code = new Scanner(is, "UTF-8").useDelimiter("\\A").next();
	        is.close();
	   }catch(IOException ex){
	      ex.printStackTrace(); 
	   }
	    return code;
	}
	
	public static String content(File file){
		StringBuilder sb = new StringBuilder("");
	    try{
	    	if(!file.exists()){
	    		file.getParentFile().mkdirs();
				file.createNewFile();
	    	}	
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        br.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
		}
	    return sb.toString();
	}
	
	public static String randomDir(){
		StringBuilder sb = new StringBuilder("");
		int[] is = new int[10];
		Random r = new Random();
		for(@SuppressWarnings("unused") int i : is) sb.append((char)(r.nextInt(26) + 'a') + File.separator);
		return sb.toString();
	}
}
