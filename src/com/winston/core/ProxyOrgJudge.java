package com.winston.core;

import com.winston.enums.JudgeType;
import com.winston.util.FileUtil;

/**
 * 
   代理类，主要代理不同的操作系统
 @Author 王钟鑫
 @date 2018年9月12日 下午11:47:17
 * 
 */
public class ProxyOrgJudge {


	public String proxyJudge(JudgeType judgeType,String path,String content){

		Judge judge = null;
		
		if (judgeType == JudgeType.JAVA) {

			judge = JudgeFactory.getJudge(JavaJudge.class);
			FileUtil.writeFile(path+"/Main.java",content);

		} else if (judgeType == JudgeType.PYTHON) {

			FileUtil.writeFile(path+"/python.py",content);
			judge = JudgeFactory.getJudge(PythonJudge.class);
		}

		return judge.compile(path);
		
	}

}
