package com.winston.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * CMD工具类
 * @author Winston.Wang
 * @version 1.0
 * @date 2018年9月10日
 */
public class CMDUtil {
	
    private CMDUtil() {

    }
    /**
     * 
     * 执行CMD命令
     * @author Winston.Wang
     * @param 
     * @return String
     * @throws
     * 
     * *cmd /c dir 是执行完dir命令后关闭命令窗口
		cmd /k dir 是执行完dir命令后不关闭命令窗口
		cmd /c start dir  会打开一个新窗口后执行dir命令，原窗口会关闭
		cmd /k start dir  会打开一个新窗口后执行dir命令，原窗口不会关闭
		cmd /?  查看帮助信息
		使用标准输出流读不到数据，错误输出流有数据
		进程使用这些流来提供到子进程的输入和获得从子进程的输出。因为有些本机平台仅针对标准输入和输出流提供有限的缓冲区大小，
		如果读写子进程的输出流或输入流迅速出现失败，则可能导致子进程阻塞，甚至产生死锁，需要异步清空流
     */
    public static String exec(String command) {
        String executeCommand ="cmd /c "+command;
        String rs = "";
        Process cmdProcess = null;
        try {
        	
            cmdProcess = Runtime.getRuntime().exec(executeCommand);
            int waitFor = cmdProcess.waitFor();
            //把标准的输出流和错误流都输出出来
            rs += CmdExecuteResultInfo(cmdProcess.getInputStream());
            rs = CmdExecuteResultInfo(cmdProcess.getErrorStream());
            cmdProcess.getOutputStream().close();
            
        } catch (IOException e) {
        	
            e.printStackTrace();
            
        } catch (InterruptedException e) {

        	e.printStackTrace();
		}finally{
        	
        	clearInBackground(cmdProcess.getInputStream());
        	clearInBackground(cmdProcess.getErrorStream());
        }
        return rs;
    }
    
    /**
     *采用ProcessBuilder来管理进程，会自动清空  builder.redirectErrorStream(true);流 
     @Author Winston.Wang
     @date 2018年9月12日 下午10:59:36
     @email 940945444@qq.com
     @return
     @param
     */
    public static String execProcessBuider(String... command) {
    	
        String rs = "";
        //指定读取出来的数据编码,如果是
        String charset = "UTF-8";
        try {
        	
            ProcessBuilder builder = new ProcessBuilder(command[0],command[1]);
            builder.directory(new File(command[2]));
            builder.redirectErrorStream(true);
            Process cmdProcess = builder.start();
            rs = CmdExecuteResultInfo(cmdProcess.getInputStream());
            cmdProcess.getOutputStream().close();
            
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
        return rs;
    }
    
    /**
     * 
     * cmd返回的信息
     * @author Winston.Wang
     * @param 
     * @return String
     * @throws
     */
    private static String CmdExecuteResultInfo(InputStream inputStream) {

    	
        StringBuilder builder = new StringBuilder();
        BufferedReader cmdExecuteInfoReader = null;
        try {

            cmdExecuteInfoReader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
            String cmdExecuteInfoLine;
            while ((cmdExecuteInfoLine = cmdExecuteInfoReader.readLine()) != null) {
                
            	builder.append(cmdExecuteInfoLine);
            	builder.append("\n");
            }
            
            return builder.toString();

        } catch (Exception e) {
        	
            e.printStackTrace();
            
        }finally{
			try {
				if (cmdExecuteInfoReader != null) {

					cmdExecuteInfoReader.close();

				}
			} catch (IOException e) {

				e.printStackTrace();
			}
        }
        return null;
    }
    /**
     *清空流,必须要使用异步来清空
     @Author Winston.Wang
     @date 2018年9月12日 下午10:58:53
     @email 940945444@qq.com
     @return
     @param
     */
    static void clearInBackground(final InputStream is) {  
        new Thread(new Runnable(){  
            public void run(){  
                try{  
                    
                	is.close();
                	
                } catch(IOException e){   

                	e.printStackTrace();
                }  
            }  
        }).start();  
    }
}
