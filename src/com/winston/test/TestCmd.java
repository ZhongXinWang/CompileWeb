package com.winston.test;

import java.io.IOException;

import com.winston.util.CMDUtil;
import com.winston.util.FileUtil;

/**
 @Author 王钟鑫
 @date 2018年9月10日 下午11:09:01
 * 
 */
public class TestCmd {

	public static void main(String[] args){
		
		//把代码写到Main.java文件下
		String writeStr = "public class Main {\npublic static void main(String[] args){\nSystem.out.println(\"Hello World\");\n}\n}";
		String filePath = "D://test//Main.java";
		String pythonPath="D://test//python.py";
		FileUtil.writeFile(filePath, writeStr);
		
		String compile = CMDUtil.execProcessBuider("javac","Main.java");
		
		System.out.println(compile);
		//调用CMD命令运行代码
		String exec = CMDUtil.execProcessBuider("java","Main");
		System.out.println(exec);
		
		String pythonStr = "#-*- coding: utf-8 -*-\nprint('hello World')";
		//编译python
		FileUtil.writeFile(pythonPath, pythonStr);
		String compilePython = CMDUtil.execProcessBuider("python","python.py");
		
		System.out.println("python="+compilePython);
	}
}
