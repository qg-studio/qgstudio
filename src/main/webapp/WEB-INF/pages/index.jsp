<html>
<body>
<h2>Hello QG studio !</h2>
<form action="/intro/upload" method="post" enctype="multipart/form-data">
    <input type="file" multiple name="uploads">
    <input type="submit">
</form>

<form action="/user/login" method="post" enctype="multipart/form-data">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="登陆">
</form>


<img src="/upload/0b5cac257da44114b7c034b20294993f.jpg">
<form action="award/import" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="file" /><br/>
    <input type="submit" value="上传" />
</form>

</body>
</html>
