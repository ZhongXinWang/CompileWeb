<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java菜鸟起飞HelloWorld</title>
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script>

	$(function(){
		
		
		$('#btn').click(function(){
			
			var content = $('#content').val();
			debugger
			var select = $('#type').val();
		$.post("JudgeServlet", {
							data : content,
							type:select
							}, function(result) {
								
								$('#rs').html(result);
							});	
						});
	          });
</script>
</head>
<body>
	
	<div style="width:55%;float:left;">
	
	    <h1>java菜鸟起飞HelloWorld</h1>
		<textarea id="content" style="width:100%;height:300px;"></textarea>
		<select id="type" style="width:100px;padding:2px;margin:10px auto;">
			<option value="0" selectd>java</option>
			<option value="1">python</option>
		</select>
		<br/>
		<button id="btn" style="width:200px;margin:10px auto;padding:5px;">提交</button>
	</div>
	<div style="width:40%;float:right;">
	 			<h1>输出结果：</h1>
	        	<h1 id="rs" style="border:1px solid red;padding:10px 10px;">
	        	结果输出处
	        	</h1>
	</div>
	
</body>

</html>