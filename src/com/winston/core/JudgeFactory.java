package com.winston.core;

/**
 语言对象工厂类
 @Author 王钟鑫
 @date 2018年9月13日 下午11:55:35
 * 
 */
public class JudgeFactory {

	
	public static <T extends Object> T getJudge(Class<T> className){
		
		T newInstance = null;
		try {
			
			 newInstance = (T) Class.forName(className.getName()).newInstance();
			 
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newInstance;
	}
	
}
