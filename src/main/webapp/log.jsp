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
    <script src="https://cdn.bootcss.com/jquery/3.4.1/core.js"></script>
    <script>
        function loadlog() {
            var url = "http://www.cxkball.club:2333/log/list";
            $.ajax({
                url: url,
                type: 'POST',
                data: data,
                dataType: 'json',
                contentType: 'application/json',
                success: function (data) {
                    if (data.status !== 200) {
                        alert("系统提示：" + data.message);
                    } else {
                        var logs = data.data;
                        var element = "    <tr>\n" +
                            "        <td>"+logs[i].time+"</td>\n" +
                            "        <td>"+logs[i].note+"</td>\n" +
                            "    </tr>"
                        for (var i = 0; i < logs.length; i++) {
                            $("#log-table").innerHTML+=element;
                        }
                    }
                },
                error: function (xhr, error, exception) {
                    alert("请求发送失败，请刷新浏览器重试或检查网络");
                    alert(exception.toString());
                }
            });
        }
    </script>
</head>
<body>
<h1 style="text-align: center">QG官网日志系统</h1>
<table id="log-table">
    <tr>
        <th>日期</th>
        <th>日志内容</th>
    </tr>
</table>
</body>
</html>
