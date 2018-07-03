<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
    <title>uploadImage</title>
</head>
<body>

    <form action="uploadImage" method="post" enctype="multipart/form-data">
        选择图片:<input name="image" type="file" accept="image/*">
        <br/>
        <input type="submit" value="上传">
    </form>

</body>
</html>
