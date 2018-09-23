package com.winston.core;

import java.io.UnsupportedEncodingException;

import com.winston.util.CMDUtil;

/**
 @Author 王钟鑫
 @date 2018年9月13日 上午12:18:32
 * 
 */
public class JavaJudge extends AbstractJudge implements Judge{

	/**
	   编译的方法，由子类实现,
	 @Author Winston.Wang
	 @date 2018年9月13日 上午12:04:31
	 @email 940945444@qq.com
	 @return
	 @param
	 */
	 @Override
	 public String compile(String path){

		//执行编译
		String compile = CMDUtil.execProcessBuider("javac","Main.java",path);
		if(!"".equals(compile)){
			

			return "编译错误："+ compile;	
		}
		
		 compile = CMDUtil.execProcessBuider("java","Main",path);

		return compile;
	 }

}
