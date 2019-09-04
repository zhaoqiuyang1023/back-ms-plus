<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>公司信息列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all"/>
    <link rel="stylesheet" href="${base}/static/css/user.css" media="all"/>

    <style>
        .searDiv {
            display: -webkit-flex;
            display: flex;
            margin: 10px;
        }

        .flex-item {
            margin-left: 20px;
            justify-content: space-around;
        }
    </style>
</head>
<body class="childrenBody">


<fieldset class="layui-elem-field">
    <legend>公司信息检索</legend>
    <div class="layui-field-box">

        <div class="layui-tab layui-tab-brief layui-fluid" lay-filter="TabBrief">
            <ul class="layui-tab-title  layui-row ">

                <li value="" class="layui-this layui-col-sm3 ">全部公司</li>
                <li value="0" class="layui-col-sm3 ">未审核</li>

                <li value="1" class="layui-col-sm3">审核通过</li>

                <li value="2" class="layui-col-sm3">审核未通过</li>

            </ul>
        </div>


        <form class="layui-form" id="searchForm">
            <div class="searDiv">

                <div class="flex-item">
                    <div class="layui-form-item">
                        <label class="layui-form-label">时间</label>
                        <div class="layui-input-inline">
                            <input class="layui-input datetime" name="dateStart" id="dateStart" type="text"
                                   placeholder="yyyy-MM-dd HH:mm:ss">
                        </div>
                    </div>
                </div>

                <div class="flex-item">
                    <div class="layui-form-item">
                        <label class="layui-form-label">公司类型</label>
                        <div class="layui-input-inline">
                            <select id="role" lay-filter="role" name="role" lay-search="" lay-filter="country">
                                <option value="">请选择类型</option>
                                <option value="consignee">代理方</option>
                                <option value="consigner">委托方</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="flex-item">
                    <div class="layui-form-item">
                        <label class="layui-form-label">国家</label>
                        <div class="layui-input-inline">
                            <select id="countryId" name="countryId" lay-search="" lay-filter="country">
                                <option value="">请选择国家</option>
                                <#list countries as item>
                                    <option value="${item.id}">${item.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item flex-item">
                    <label class="layui-form-label">推荐</label>
                    <div class="layui-input-inline">
                        <select  name="recommendable" lay-filter="recommendable">
                            <option value="">是否推荐</option>
                            <option value="1">已推荐</option>
                            <option value="0">未推荐</option>
                        </select>
                    </div>
                </div>
                <div class="flex-item">
                    <div class="layui-form-item">
                        <label class="layui-form-label">公司名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" id="accountName"
                                   placeholder="请输入公司名称"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>

                <div class="flex-item">
                    <div class="layui-form-item">
                        <div class="layui-input-inline">
                            <button class="layui-btn" lay-submit lay-filter="searchForm">查询</button>
                            <button type="reset" class="layui-btn layui-btn-primary" id="reset">重置</button>
                        </div>
                    </div>
                </div>
            </div>

        </form>
    </div>

</fieldset>
<div class="layui-form users_list">
    <table class="layui-table" id="accountTable" lay-filter="accountTable"></table>

    <script type="text/html" id="barOpt">
        <#if hasPermission('adms:account:edit')>
            <a class="layui-btn layui-btn-xs layui-anim layui-anim-scaleSpring" lay-event="edit" title="编辑">编辑</a>
        </#if>
        <#if hasPermission('adms:account:audit')>
            <a class="layui-btn layui-btn-xs layui-anim layui-anim-scaleSpring" lay-event="audit" title="认证">认证</a>
        </#if>
        <#if hasPermission('adms:account:rec')>
            <a class="layui-btn layui-btn-xs layui-anim layui-anim-scaleSpring" lay-event="rec" title="推荐">推荐</a>
        </#if>
        <a class="layui-btn layui-btn-xs layui-anim layui-anim-scaleSpring" lay-event="del" title="删除">删除</a>
    </script>
</div>
<div id="page"></div>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script type="text/javascript" src="${base}/static/js/tools.js"></script>
<script>
    layui.use(['layer', 'laydate', 'form', 'table', 'element'], function () {
        var status = '';
        var name = '';
        var dateStart = '';
        var dateEnd = '';
        var recommendable = '';
        var countryId = '';
        var role = '';
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form,
            element = layui.element,
            laydate = layui.laydate,
            table = layui.table;

        //日期时间选择器
        laydate.render({
            elem: '#dateStart'
            , range: '~',
            done: function (value, date) {
                console.log(value);
                var str = value.split('~');
                dateStart = str[0];
                dateEnd = str[1];
                console.log(dateStart);
                console.log(dateEnd)
            }
        });

        element.on('tab(TabBrief)', function (data) {
            console.log("" + $(this).attr("value")); //获取value的值
            status = $(this).attr("value");
            name = $("#accountName").val();
            table.reload('accountTable', {
                where: { //设定异步数据接口的额外参数，任意设
                    "status": status,
                    "name": name,
                    "dateStart": dateStart,
                    "dateEnd": dateEnd,
                    "countryId": countryId,
                    "recommendable": recommendable,
                    "role": role
                }
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });

        //监听工具条
        table.on('tool(accountTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                var editIndex = layer.open({
                    title: "编辑公司信息",
                    type: 2,
                    area: ['1024px', '900px'],
                    content: "${base}/account/edit/" + data.id,
                    success: function (layero, index) {

                    }
                });
                layer.full(editIndex);
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function () {
                    layer.full(editIndex);
                });
            }
            if (obj.event === 'audit') {
                var audit = layer.open({
                    title: "审核公司",
                    type: 2,
                    area: ['1024', '600px'],
                    content: "/account/audit/" + data.id,
                    success: function (layero, index) {

                    }
                });
                layer.full(audit);
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function () {
                    layer.full(audit);
                });
            }
            if (obj.event === 'rec') {
                $.ajax({
                    type: "POST",
                    url: "/account/rec/" + data.id,
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data.field),
                    dataType: "json",
                    success: function (res) {
                        console.log(res);
                        if (res.success) {
                            layer.msg("操作成功！", {time: 1000}, function () {
                                location.reload();
                            });
                        } else {
                            layer.msg(res.message);
                        }
                    },
                    error: function (jqXHR) {
                        layer.close(loading);
                        alert("发生错误：" + jqXHR.status);
                    }
                });
            }
            if (obj.event === "del") {

                layer.confirm("你确定要删除该公司信息么？", {btn: ['是的,我确定', '我再想想']},
                    function () {
                        $.post("${base}/account/del/" + data.id, function (res) {
                            if (res.success) {
                                $(obj).remove();
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close();
                                layer.msg("删除成功", {time: 1000}, function () {

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
            elem: '#accountTable',
            url: '/account/list',
            method: 'post',
            where: {
                status: status
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
                {field: 'name', title: '名称', width: '12%'},
                {field: 'countryName', title: '国家', width: '10%'},
                {field: 'type', title: '公司类别', width: '10%', templet: '#type'},
                {field: 'verifyStatus', title: '状态', width: '10%', templet: '#titleTpl'},
                {field: 'recommendable', title: '推荐', width: '10%', templet: '#recommendable'},
                {field: 'dateCreate', title: '创建时间', width: '15%'},
                {field: 'dateUpdate', title: '审核时间', width: '15%', templet: '#date'},
                {fixed: 'right', title: '操作', width: '15%', align: 'center', toolbar: '#barOpt'}
            ]]
        };
        table.render(t);


        form.on("submit(searchForm)", function (data) {
            var dd = JSON.stringify(data.field.status = status);

            console.log(dd);
            table.reload('accountTable', {
                where: {
                    "name": $("#accountName").val(),
                    "status": status,
                    "dateStart": dateStart,
                    "dateEnd": dateEnd,
                    "countryId": countryId,
                    "recommendable": recommendable,
                    "role": role
                }
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            //   console.log(JSON.stringify(data.field));

            return false;
        });
        $("#reset").on("click", function () {

            status = '';
            dateStart = '';
            dateEnd = '';
            countryId = '';
            recommendable = '';
        });

        form.on('select(recommendable)', function (data) {
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
            recommendable = data.value;
        });
        form.on('select(country)', function (data) {
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
            countryId = data.value;
        });

        form.on('select(role)', function (data) {
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
            role = data.value;
        });

    })
    ;
</script>

<script type="text/html" id="titleTpl">
    {{#  if(d.verifyStatus =='0'){ }}
    未审核
    {{#  } else if(d.verifyStatus=='1') { }}
    审核通过
    {{# } else{   }}
    <a style="color: red">未通过</a>
    {{#  }}}
</script>

<script type="text/html" id="recommendable">
    {{#  if(d.recommendable){ }}
    已推荐
    {{# } else{   }}
    <a style="color: red">未推荐</a>
    {{#  }}}
</script>

<script type="text/html" id="type">
    {{#  if(d.type =='consignee'){ }}
    代理方
    {{#  } else if(d.type=='consigner') { }}
    委托方
    {{# } else{   }}
    <a style="color: red">信息缺失</a>
    {{#  }}}
</script>




</body>
</html>