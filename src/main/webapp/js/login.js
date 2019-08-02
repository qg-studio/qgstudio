define(['require', 'tools'], function (require) {
    var tools = require('tools');

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
                    url: "http://www.cxkball.club:2333/user/login",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    success: function (data) {
                        if (data.status == 200) {
                            window.location.href = "http://www.cxkball.club:2333/about-qg.html";
                        }else {
                            alert(data.message);
                        }
                    }
                })
            }

        });
    });

});
