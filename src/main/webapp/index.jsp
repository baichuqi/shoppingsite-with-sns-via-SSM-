<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.bai.springboot.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> <!--常用函数标签库-->
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->

<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>

<form action="Product" method="post">
id:<input type="number" name="productId">
name:<input type="text" name="productName">
categoryid:<input type="number" name="categoryId">
price:<input type="number" name="price">
code:<input type="number" name="productCode">
<input type="submit" value="submit">
</form>

<form action="Product" method="DELETE">
 id : <input type="number" name="id">
 <input type="submit" value="submit">
</form>
</body>
</html>
