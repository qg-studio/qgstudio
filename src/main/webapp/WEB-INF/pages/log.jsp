<%--
  Created by IntelliJ IDEA.
  User: Misterchaos
  Date: 2019-07-29
  Time: 下午 04:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QG官网日志系统</title>
    <meta charset="utf-8">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script>
        setInterval(function loadlog(page) {
            var url = "http://localhost:8081/log/list";
            var data = {
                page: page,
                pageSize: 20
            };
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: 'json',
                contentType: 'application/x-www-form-urlencoded',
                success: function (data) {
                    if (data.status !== 200) {
                        alert("系统提示：" + data.message);
                    } else {
                        var logs = data.data.data;
                        document.getElementById("log-table").innerHTML="        <thead>\n" +
                            "        <tr>\n" +
                            "            <th>日期</th>\n" +
                            "            <th>日志内容</th>\n" +
                            "        </tr>\n" +
                            "        </thead>";
                        for (var i = 0; i < logs.length; i++) {
                            var element = "    <tr>\n" +
                                "        <td>" + logs[i].time + "</td>\n" +
                                "        <td>" + logs[i].note + "</td>\n" +
                                "    </tr>";
                            document.getElementById("log-table").innerHTML += element;
                        }
                    }
                },
                error: function (xhr, error, exception) {
                    alert("请求发送失败，请刷新浏览器重试或检查网络");
                    alert(exception.toString());
                }
            });
        },5000);
    </script>
</head>
<body>
<h1 style="text-align: center">QG官网日志系统</h1>
<hr/>
<div class="panel panel-default">
    <table id="log-table" class="table table-striped">
        <thead>
        <tr>
            <th>日期</th>
            <th>日志内容</th>
        </tr>
        </thead>
    </table>
</div>
</body>
<style>
    .panel {
        margin-left: 20px;
        margin-right: 20px;
    }
</style>
</html>
