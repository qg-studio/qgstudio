define(['require', 'tools'], function (require) {
    var tools = require('tools');
    var serverUrl = "http://www.cxkball.club:2333";
    $(function () {
        $("button:eq(0)").click(function () {
            var data = {
                username: $("input:eq(0)").val(),
                password: $("input:eq(1)").val()
            };
            if (!tools.verificat.isNotNullTrim(data.username) || !tools.verificat.isNotNullTrim(data.password)) {
                alert("输入不能为空！");
            } else {
                $.ajax({
                    type: "POST",
                    url: serverUrl + "/user/login",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    success: function (data) {
                        if (data.message == "account_not_found") {
                            alert("该账户不存在！");
                        } else if (data.message == "password_incorrect") {
                            alert("密码输入错误！");
                        } else if (data.message == "success") {
                            alert("登录成功！");
                        } else {
                            alert(response.message);
                        }
                    }
                })
            }

        });
    });

});
