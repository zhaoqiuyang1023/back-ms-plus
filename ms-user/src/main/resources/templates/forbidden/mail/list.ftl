<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录限制列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all"/>
</head>
<body class="childrenBody">
<fieldset class="layui-elem-field">
    <legend>邮箱限制列表</legend>
    <div class="layui-field-box">
        <form class="layui-form" id="searchForm">
            <div class="layui-form-item">
                <div class="layui-col-sm1">
                    <div class="layui-inline">
                        <a class="layui-btn layui-btn-normal" id="addAnnouncement"><i
                                    class="layui-icon">&#xe654;</i>添加</a>
                    </div>
                </div>

                <label class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="userName" id="userName"
                           placeholder="请输入名称"
                           autocomplete="off" class="layui-input">
                </div>

                <label class="layui-form-label">时间</label>
                <div class="layui-input-inline">
                    <input class="layui-input datetime" name="test10" id="test10" type="text"
                           placeholder="yyyy-MM-dd HH:mm:ss">
                </div>

                <label class="layui-form-label">公司</label>
                <div class="layui-input-inline">
                    <select id="accountName" lay-filter="accountName" name="accountName" lay-search=""
                            lay-filter="accountName">
                        <option value="">请选择公司</option>
                        <#list accounts as item >
                            <option value="${item.name}">${item.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="searchForm">查询</button>
                    <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

</fieldset>
<div class="layui-form users_list">
    <table class="layui-table" id="AnnouncementTable" lay-filter="AnnouncementTable"></table>

    <script type="text/html" id="barOpt">

        <a class="layui-btn layui-btn-xs layui-anim layui-anim-scaleSpring" style="background-color: red"
           lay-event="down" title="解除">解除限制</a>

    </script>
</div>
<#--<div id="page"></div>-->
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['layer', 'laytpl', 'form', 'jquery', 'table', 'laydate', 'element'], function () {
        let startTime = null;
        let endTime = null;

        let layer = layui.layer,
            $ = layui.jquery,
            form = layui.form,
            laydate = layui.laydate,
            table = layui.table;

        laydate.render({
            elem: '#test10'
            , type: 'datetime'
            , range: '至'
            , done: function (value, date) {
                console.log(value);
                let str = value.split('至');
                startTime = str[0];
                endTime = str[1];
                console.log(str[0]);
                console.log(str[1]);
            }
        });


        $("#addAnnouncement").on("click", function () {
            layer.open({
                title: "添加信息",
                type: 2,
                area: ['960px', '540px'],
                content: "${base}/forbiddenmail/add",
                success: function () {

                }
            });

        });
        //监听工具条
        table.on('tool(AnnouncementTable)', function (obj) {
            var data = obj.data;

            if (obj.event === 'down') {

                layer.confirm("你确定吗？", {btn: ['是的,我确定', '我再想想']},
                    function () {
                        $.post("${base}/forbiddenmail/del/" + data.id, function (res) {
                            if (res.success) {
                                table.reload('AnnouncementTable', {
                                    where: {

                                    }
                                    , page: {
                                        curr: 1 //重新从第 1 页开始
                                    }
                                });
                                layer.close();
                                layer.msg("下架成功，请重新刷新", {time: 1000}, function () {

                                });
                            } else {
                                layer.msg(res.message);
                            }
                        });
                    }
                )
            }
        });

        var t = {
            elem: '#AnnouncementTable',
            url: '/forbiddenmail/list',
            method: 'post',
            where: {

            },
            page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                groups: 7, //只显示 1 个连续页码
                first: "首页", //显示首页
                last: "尾页", //显示尾页
                limits: [3, 10, 20, 30]
            },
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            cols: [[
                {field: 'mail', title: '账号', align: 'left', width: '20%'},
                {field: 'dateCreate', title: '创建时间', width: '15%'},
                // {field: 'dateUpdate', title: '修改时间', width: '15%'},
                {field: 'accountName', title: '所属公司', width: '18%'},
                {field: 'emailStatus', title: '状态', width: '10%', templet: '#titleTp1'},
                {fixed: 'right', title: '操作', width: '10%', align: 'center', toolbar: '#barOpt'}
            ]]
        };
        table.render(t);


        form.on("submit(searchForm)", function (data) {
            table.reload('AnnouncementTable', {
                where:{
                    "userName": $("#userName").val(),
                    "accountName": $("#accountName").val(),
                    "startTime": startTime,
                    "endTime": endTime
                }
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            return false;
        });
        $("#reset").on('click',function () {
            //监听提交
            startTime = null;
            endTime = null;
            form.render();
        })
    })
    ;
</script>

<script type="text/html" id="titleTp1">
    {{#  if(d.ipStatus==1){ }}
    已恢复
    {{#  } else{  }}
    黑名单
    {{#  }}}
</script>
</body>
</html>