<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${base}/static/jqueryui/select2.min.css"/>
    <style type="text/css">


    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">




    <div class="layui-form-item">
        <label class="layui-form-label"><label style="color: red;width: 100px;">*</label>邮箱</label>
        <div class="layui-input-block">
            <input   class="layui-input layui-elip" name="mail"   lay-verify="required|email"
                      placeholder="邮箱">
        </div>
    </div>



    <div class="layui-tab-item layui-show">
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" id="ok" lay-submit="" lay-filter="save">提交</button>
            </div>
        </div>
    </div>

</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>


<script>
    layui.use(['form', 'jquery', 'layer', 'laydate'], function () {
        var form = layui.form,
            $ = layui.jquery,
            laydate = layui.laydate,
            layer = layui.layer;

        var startTime = '';
        var endTime = '';

        laydate.render({
            elem: '#test10'
            , type: 'datetime'
            , range: '至'
            , done: function (value, date) {
                console.log(value);
                var str = value.split('至');
                startTime = str[0];
                endTime = str[1];
                console.log(str[0]);
                console.log(str[1]);
            }
        });

        form.on('submit(save)', function (data) {
            $("#ok").attr('disabled',true);
            $.ajax({
                type: "POST",
                url: "${base}/forbiddenmail/save",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data.field),
                dataType: "json",
                success: function (res) {
                    if (res.success) {
                        parent.layer.msg("添加成功！", {time: 1000}, function () {
                            parent.layer.closeAll();
                            parent.location.reload();
                        });
                    } else {
                        layer.msg(res.message);
                    }
                    $("#ok").attr('disabled',false);
                },
                error: function (jqXHR) {
                    $("#ok").attr('disabled',false);
                    alert("发生错误：" + jqXHR.status);
                }
            });
            return false;
        });
    });
</script>
</body>
</html>