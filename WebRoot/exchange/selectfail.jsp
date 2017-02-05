<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.label {
	width: 20%
}

.controler {
	width: 80%
}
</style>
<script type="text/javascript" src="js/Calendar3.js"></script>
</head>

</head>

<body>
	<h1>抱歉,我们还没买到你要的图书，请输入你想买的书籍，我们一有，将马上联系你</h1>
	<br>
<h1>请输入你想买的图书的基本信息</h1>
	<hr>
	<form name="regForm" action="servlet/BuyerServlet" method="post">
		<table border="0" width="800" cellspacing="0" cellpadding="0">
			<tr>
				<td class="lalel">书名：</td>
				<td class="controler"><input type="text" name="book_name" /></td>
			</tr>
			<tr>
				<td class="label">作者：</td>
				<td class="controler"><input type="text" name="zuozhe_name"></td>

			</tr>
			<tr>
				<td class="label">出版社：</td>
				<td class="controler"><input type="text" name="chubanshe_name"></td>

			</tr>
			
			<tr>
				<td class="label">你的姓名</td>
				<td class="controler"><input type="text" name="buyer_name"></td>

			</tr>
			<tr>
				<td class="label">你的电话号码</td>
				<td class="controler"><input type="text" name="phone"></td>

			</tr>
			<!--  <tr>
			    	<td class="label">性别：</td>
			    	<td class="controler"><input type="radio" name="gender" checked="checked" value="男">男<input type="radio" name="gender" value="女">女</td>
			    	
			    </tr>
			
			    <tr>
			    	<td class="label">自我介绍：</td>
			    	<td class="controler">
			    		<textarea name="introduce" rows="10" cols="40"></textarea>
			    	</td>
			    </tr>-->
			 
			    <tr>
			    	<td colspan="1" align="center">
			    		<input type="submit" value="提交"/>&nbsp;&nbsp;
			    	    <input type="reset" value="取消"/>&nbsp;&nbsp;
			    	</td>
			    </tr>
		</table>
	</form>
</body>
</html>
