<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="entity.Seller"%>
<%@ page import="com.imooc.dao.*"%>
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
</head>

<body>
	<h1>你查询的结果有</h1>
	<br>

	<%
		
		String book_name = request.getParameter("book_name");
		//创建list集合
		List<Seller> gs = new ArrayList<Seller>();
		gs = SellerDao.selectBooksByBook_name(book_name);
		//遍历list集合
		for (Seller seller : gs) {
//		System.out.println("--------------------------");
	%>
	----------------------------------<br>
	<%=seller.getBook_name()%>的书名为：<%=seller.getBook_name()%><br>
	<%=seller.getBook_name()%>的作者为：<%=seller.getZuozhe_name()%><br>
	<%=seller.getBook_name()%>的出版社为：<%=seller.getChubanshe_name()%><br>
	<%
		}
	%>
</body>
</html>
