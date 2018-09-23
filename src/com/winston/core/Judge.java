package com.winston.core;

/**
  评判根接口
 @Author 王钟鑫
 @date 2018年9月13日 上午12:12:16
 * 
 */
public interface Judge {

	/**
	  编译的方法，由子类实现 
	 @Author Winston.Wang
	 @date 2018年9月13日 上午12:04:31
	 @email 940945444@qq.com
	 @return
	 @param JudgeType type  那个系统
	 */
	 String compile(String path);
}
