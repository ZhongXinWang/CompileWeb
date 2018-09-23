package com.winston.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 
 * 文件工具类
 * @author Winston.Wang
 * @version 1.0
 * @date 2018年9月10日
 */
public class FileUtil {
	
    private FileUtil() {

    }
    /**
     * 
     * 创建文件
     * @author Winston.Wang
     * @param 
     * @return void
     * @throws
     */
    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
               
            	file.createNewFile();
            	
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 
     * 简单的描述就是最好的诠释
     * @author Winston.Wang
     * @param 
     * @return void
     * @throws
     */
    public  static void writeFile(String filePath,String writeStr){
    	
    	//文件不存在就创建文件
    	createFile(filePath);
    	//写入文件
    	PrintWriter out = null;
    	 try {
    		 
    		 out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"GBK")));
             out.write(writeStr);
             out.flush();
             out.close();
    		 
         } catch (IOException e) {
        	 
             e.printStackTrace();
             
         }finally{

			if (out != null) {

				out.close();
			}
         }
    	
    }
}
