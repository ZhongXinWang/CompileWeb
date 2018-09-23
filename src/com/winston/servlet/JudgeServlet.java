package com.winston.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winston.core.ProxyOrgJudge;
import com.winston.enums.JudgeType;
import com.winston.util.CMDUtil;
import com.winston.util.FileUtil;

/**
 * Servlet implementation class JudgeServlet
 */
@WebServlet("/JudgeServlet")
public class JudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProxyOrgJudge proxyOrgJudge;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JudgeServlet() {
        super();
        proxyOrgJudge = new ProxyOrgJudge();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String contextPath = request.getSession().getServletContext().getRealPath("/main");
		String type = request.getParameter("type");
		String content = request.getParameter("data");
		if("".equals(content) || content == null){
			
			response.getWriter().println("输入结果不许为空");
			return;
		}
		JudgeType judge = JudgeType.PYTHON;
		
		if("0".equals(type)){
			
			judge = JudgeType.JAVA;
		}
		
		String str = proxyOrgJudge.proxyJudge(judge, contextPath,content);
		response.getWriter().println(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
