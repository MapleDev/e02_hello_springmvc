<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
    <title>增加商品</title>
</head>
<body>

    <form action="addProduct" method="post">
        产品名称：<input name="name">
        <br/>
        产品价格：<input name="price" type="number">
        <br/>
        <input type="submit" name="增加商品">
    </form>

</body>
</html>
