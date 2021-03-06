<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>委托方业务列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${base}/static/css/user.css" media="all"/>
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all"/>
    <script type="text/javascript" src="${base}/static/layui/layui.js"></script>
    <style>
        body {
            background-color: #FFFFFF;
            margin: 0 auto;
        }

        .cardDiv {
            box-shadow: 0 0 16px #C5CCD1;
            margin: 0 auto 2%;
            border: 2px solid #F9F9F9;
            border-radius: 5px;
            width: 100%;
        }

        .mainTitle {
            margin-left: 2%;
            margin-top: 20px;
            padding-top: 10px;
            font-size: 18px;
            color: #0C0C0C;
            font-weight: bolder;
            font-family: "Microsoft YaHei", 微软雅黑, "MicrosoftJhengHei", 华文细黑, STHeiti, MingLiu;
        }

        .title {
            margin-left: 30px;
            margin-top: 20px;
            font-size: 12px;
            color: #9F9F9F;
            font-family: "Microsoft YaHei", 微软雅黑, "MicrosoftJhengHei", 华文细黑, STHeiti, MingLiu;
        }


        .flex-container {
            display: -webkit-flex;
            display: flex;
            margin: 10px;
            background-color: #FFFFFF;
        }


        .param {
            margin-top: 10px;
            margin-left: 25px;
            height: 2em;
        }


        .flex-item {

            margin: 20px;
        }

        .edit {
            float: right;
            margin-right: 10%;
            color: #108EE9;
            font-size: 0.8em;
            font-weight: normal;
            cursor: pointer;
        }


        textarea:hover {
            box-shadow: 0 0 1px #C5CCD1;
            border: 1px solid #F9F9F9;
            border-radius: 5px;
        }

        textarea {
            width: 60%;
            border-radius: 5px;
        }

    </style>
</head>
<body class="childrenBody ">
<form class="layui-form">
    <input type="text" name="id" hidden placeholder="公司id" value="${organization.id}" autocomplete="off"
           style="display:none" class="layui-input">



    <!--代理方业务列表-->

    <div class="cardDiv layui-form-item">
        <a>自有船舶数量</a>
        <input type="text" name="shipInterval" placeholder="自有船舶数量" value="${organization.shipInterval}" autocomplete="off"
                class="layui-input">
        <a>租聘船舶数量</a>
        <input type="text" name="rentShipNum" placeholder="租聘船舶数量" value="${organization.rentShipNum}" autocomplete="off"
                class="layui-input">
    </div>
    <#--主营货物-->

    <div class="cardDiv layui-col-space15">
        <div class="layui-card-header">
            主营货物
        </div>

        <div id="payloadTypeContent">
            <#if (OrgPayloadTypes?size>0)>
                <#list OrgPayloadTypes as itselfitemP>
                    <div id="payloadTypeDiv">
                        <div class="layui-form-item">
                            <div class="layui-input-inline">

                                <select class="param" name="cargo" lay-search>
                                    <option value="">请选择公司类型</option>
                                    <#if (OrgPayloadTypes ?size>0)>
                                        <#list AllPayloadTypes as item>
                                            <option value="${item.id}"
                                                    <#if (item.id == itselfitemP.id)>selected</#if> >${item.name}
                                            </option>
                                        </#list>

                                    </#if>
                                </select>
                            </div>


                            <a id="del" class="layui-btn layui-btn-sm delete" style="align-content: center">
                                删除
                            </a>
                        </div>
                    </div>
                </#list>
            </#if>

            <div id="payloadTypeDiv">
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <select class="param" name="cargo" lay-search>
                            <#if (AllPayloadTypes?size>0)>
                                <option value="" selected>请选择公司类型</option>
                                <#list AllPayloadTypes as item>
                                    <option value="${item.id}">${item.name}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                    <p id="del" class="layui-btn layui-btn-sm delete" style="align-content: center">
                        删除
                    </p>
                </div>
            </div>

        </div>


        <div>
            <a id="payloadTypeAdd" class="layui-btn layui-btn-sm" style="align-content: center">
                添加
            </a>
        </div>
    </div>


    <#--主营航线-->
    <div class="cardDiv layui-col-space15">
        <div class="layui-card-header">
            主营航线
        </div>
        <div id="shipRoutesContent">
            <#if (OrgShipRoutes?size>0)>
                <#list OrgShipRoutes as itselfitemP>
                    <div id="shipRouteDiv">
                        <div class="layui-form-item">
                            <div class="layui-input-inline">

                                <select class="param" name="route" lay-search>
                                    <option value="">请选择公司类型</option>

                                    <#list AllShipRoutes as item>
                                        <option value="${item.code}"
                                                <#if (item.id == itselfitemP.id)>selected</#if> >${item.name}
                                        </option>
                                    </#list>

                                </select>
                            </div>

                            <a id="del" class="layui-btn layui-btn-sm delete" style="align-content: center">
                                删除
                            </a>
                        </div>
                    </div>
                </#list>
            </#if>

            <div id="shipRouteDiv">
                <div class="layui-form-item">
                    <#-- <a style="font-size: small;color: #808080;">公司类型</a>-->
                    <div class="layui-input-inline">
                        <select class="param" name="route" lay-search>

                            <option value="" selected>请选择公司类型</option>
                            <#list AllShipRoutes as item>
                                <option value="${item.code}">${item.name}</option>
                            </#list>
                        </select>
                    </div>
                    <p id="del" class="layui-btn layui-btn-sm delete" style="align-content: center">
                        删除
                    </p>
                </div>
            </div>

        </div>

        <div>
            <a id="shipRouteAdd" class="layui-btn layui-btn-sm" style="align-content: center">
                添加
            </a>
        </div>
    </div>


    <#--船舶类型-->
    <div class="cardDiv layui-row layui-col-space15">
        <div class="layui-card">
            <div class="layui-card-header">
                船舶类型
            </div>
            <div class="layui-card-body">
                <div id="ShipTypeContent">
                    <#if (OrgShipTypes?size>0)>
                        <#list OrgShipTypes as itselfitemP>
                            <div id="ShipTypeDiv">
                                <div class="layui-form-item">
                                    <div class="layui-input-inline">

                                        <select class="param" name="code" lay-search>
                                            <option value="">请选择船舶类型</option>
                                            <#if (AllShipTypes?size>0)>
                                                <#list AllShipTypes as item>
                                                    <option value="${item.code}"
                                                            <#if (item.code == itselfitemP.code)>selected</#if> >${item.name}
                                                    </option>
                                                </#list>

                                            </#if>
                                        </select>
                                    </div>


                                    <a id="del" class="layui-btn layui-btn-sm delete" style="align-content: center">
                                        删除
                                    </a>
                                </div>
                            </div>
                        </#list>
                    </#if>

                    <div id="ShipTypeDiv">
                        <div class="layui-form-item">
                            <div class="layui-input-inline">
                                <select class="param" name="code" lay-search>
                                    <#if (AllShipTypes?size>0)>
                                        <option value="" selected>请选择公司类型</option>
                                        <#list AllShipTypes as item>
                                            <option value="${item.code}">${item.name}</option>
                                        </#list>
                                    </#if>
                                </select>
                            </div>

                            <p id="del" class="layui-btn layui-btn-sm delete" style="align-content: center">
                                删除
                            </p>
                        </div>
                    </div>

                </div>


                <div>
                    <a id="ShipTypeAdd" class="layui-btn layui-btn-sm" style="align-content: center">
                        添加
                    </a>
                </div>
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-filter="demo1" lay-submit="">提交</button>
            <button id="close" class="layui-btn layui-btn-primary" type="button">关闭</button>
        </div>
    </div>
</form>


<script>

    layui.use(['form', 'layer'], function () {
        var array = [];
        var loading;
        var form = layui.form
            , layer = layui.layer
            , $ = layui.jquery;

        

        /*港口*/
        $("#payloadTypeAdd").on("click", function () {

            var child = $("#payloadTypeDiv").clone(true);

            $("#payloadTypeContent").append(child);
            resertselect($(child).find('select'));
            form.render('select'); //刷新select选择框渲染
        });

        $("#payloadTypeContent").on("click", ".delete", function () {
            console.log("management内容删除成功");
            console.log($(this).html());
            var ll = $('#payloadTypeContent').children();
            console.log(ll.length);
            if (ll.length > 1) {
                $(this).parent().parent().remove();
            }
        });

        //订单服务

        $("#shipRouteAdd").on("click", function () {
            console.log($(this).html());
            console.log("追加了内容");
            var child = $("#shipRouteDiv").clone(true);

            $("#shipRoutesContent").append(child);
            resertselect($(child).find('select'));
            form.render('select'); //刷新select选择框渲染
        });

        $("#shipRoutesContent").on("click", ".delete", function () {
            console.log("management内容删除成功");
            console.log($(this).html());
            var ll = $('#shipRoutesContent').children();
            console.log(ll.length);
            if (ll.length > 1) {
                $(this).parent().parent().remove();
            }
        });


        /*船舶*/

        $("#ShipTypeAdd").on("click", function () {
            console.log($(this).html());
            console.log("追加了内容");
            var child = $("#ShipTypeDiv").clone(true);

            $("#ShipTypeContent").append(child);
            resertselect($(child).find('select'));
            form.render('select'); //刷新select选择框渲染
        });

        $("#ShipTypeContent").on("click", ".delete", function () {
            console.log("management内容删除成功");
            console.log($(this).html());
            var ll = $('#ShipTypeContent').children();
            console.log(ll.length);
            if (ll.length > 1) {
                $(this).parent().parent().remove();
            }
        });

        function resertselect(domSelect) {
            $(domSelect).each(function (i, j) {
                $(j).find("option:selected").attr("selected", false);
                $(j).find("option").first().attr("selected", true);
                form.render('select')
            });
        }
        //监听提交

        form.on('submit(demo1)', function (data) {

            data.field.cargos = GetJsonData($("#payloadTypeContent"));
            data.field.routes = GetJsonData($("#shipRoutesContent"));
            data.field.shipTypes = GetJsonData($("#ShipTypeContent"));
            console.log(JSON.stringify(data.field).toString());

            $.ajax({
                type: "POST",
                url: "${base}/account/updateConsigner",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data.field),
                dataType: "json",
                success: function (res) {
                    console.log(res);
                    if (res.success) {
                        parent.layer.msg("操作成功！", {time: 1000}, function () {
                            parent.layer.closeAll();
                            parent.location.reload();
                        });
                    } else {
                        layer.msg(res.message);
                    }
                },
                error: function (jqXHR) {
                    alert("发生错误：" + jqXHR.status);
                }
            });
            return false;
        });

        function GetJsonData(content) {
            var list = [];//创建数组
            var childrens = $(content).children();
            for (var i = 0; i < childrens.length; i++) {
                var jsonobj = {};
                var children = childrens[i];
                var params = $(children).find(".param");

                for (var param of params) {
                    var key = $(param).prop("name");//元素属性

                    var value = $(param).val(); //元素值
                    if (typeof value == "undefined" || value == null || value == "") {

                    } else {
                        jsonobj[key] = value;
                    }
                }
                if (!$.isEmptyObject(jsonobj)) {
                    list.push(jsonobj);
                }

            }
            console.log(list);
            return list;
        }

        $("#close").on("click", function () {
            parent.layer.closeAll();
            layer.close(loading);
        });


    });
</script>
</body>
</html>