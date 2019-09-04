<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>认证信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">

    <style>
        body {
            background-color: #F5F6F7;
            font-family: "微软雅黑", arial, sans-serif;
            margin: 0 auto;
        }

        .container {
            box-shadow: rgba(114, 255, 141, 0.59);
            margin: 10px auto;
            width: 900px;
            background-color: #FFFFFF;
            border: 1px solid #FFFFFF; /*不需要边框的时候可以将背景颜色设为透明或者与背景颜色相同的颜色*/
        }

        .head {
            margin-left: 10px;
            margin-top: 20px;
            font-size: 18px;
            height: auto;
        }

        .Image_container {
            display: flex;
            display: -webkit-flex;
            margin-top: 10px;
        }

        .divImage {
            width: 300px;
            height: 300px;
            border: 1px solid #838383;
        }

        .divImage img {
            width: 100%;
            height: 100%;
            margin-left: 10px;
            transform: 1s;
        }

        /*.divImage img:hover {*/
            /*width: 400px;*/
            /*height: 600px;*/
            /*margin-left: 10px;*/
            /*!*          transform: scale(2.0);*!*/
        /*}*/

        .content {
            margin-top: 30px;
            margin-left: 20px;
        }

        .content a {
            color: #838383;
        }

        .content p {
            margin-top: 10px;
        }

    </style>
</head>
<body>
<form class="layui-form">
    <input type="text" name="orgId" value="${organization.id}" hidden>
    <div class="container">
        <p class="head">认证信息</p>
        <div class="content">
            <a>企业名称</a>
            <p>${organization.name}</p>
        </div>

        <#if organization.role=="consignee">
            <div class="content">
                <a>公司类型</a>
                <a>代理方</a>
            </div>
            <div class="content">
                <a>服务港口</a>
                <p>${ports}</p>
            </div>
        <#elseif organization.role=="consigner">
            <div class="content">
                <a>公司类型</a>
                <a>委托方</a>
            </div>
        <#else>
            <div class="content">
                <a>公司类型</a>
                <a>没有公司类型</a>
            </div>
        </#if>

        <div class="content">
            <a>认证证件(三证合一上传营业执照扫描)</a><br>
            <div class="Image_container">
                <#if (certificates?exists&&certificates?size>0)>
                    <#list certificates as item>
                        <div  class="divImage">
                            <img src="${item.url}"/>
                        </div>
                    </#list>
                <#else>
                    <div class="divImage">

                        <img"/>
                    </div>
                </#if>
            </div>
        </div>


        <div class="content">
            <a>管理员邮箱</a>
            <p>${superAdmin}</p>
        </div>
        <div class="content">
            <a>法定代表人</a>
            <p>${organization.artificialPerson}</p>
        </div>


        <div class="content">
            <a>公司联系人</a>
            <#if (peoples?exists&&peoples?size>0)>
                <#list peoples as people>
                    <div>
                        <p style="color: #000000">${people.fullName}</p>
                        <div>
                            <#if (people.contactMethod?size>0)>
                                <#list people.contactMethod as item>
                                    <a style="color: #0C0C0C">${item.type}</a>
                                    <a>${item.value}</a><br>
                                </#list>
                            </#if>
                        </div>
                    </div>
                </#list>
            </#if>
        </div>



        <div class="content">
            <a>公司联系电话</a>
            <p>${CMP.value}</p>
        </div>
        <div class="content">
            <a>公司网址</a>
            <p>${CMW.value}</p>
        </div>
        <div class="content">
            <a>注册地点</a>
            <p>${organization.streetAddress}</p>
        </div>
        <div class="content">
            <a>经营地址</a>
            <p>${organization.businessAddress}</p>
        </div>

        <div class="content">
            <a>备注</a>
            <input type="text" name="remark" style="width: 90%">
        </div>
        <div style="margin-top: 20px;float: right" class="layui-form-item">
            <div class="layui-input-block">
                <input name="verifyStatus" title="未审核" type="radio" <#if organization.verifyStatus==0>checked</#if>
                       value="0">
                <input name="verifyStatus" title="审核通过" type="radio" <#if organization.verifyStatus==1>checked</#if>
                       value="1">
                <input name="verifyStatus" title="审核拒绝" type="radio" <#if organization.verifyStatus==2>checked</#if>
                       value="2">
            </div>
        </div>

        <div style="clear:both;"></div>
        <div class="content" style="float: right">
            <a id="verified" lay-submit lay-filter="verified" style="color: #FFFFFF" class="layui-btn">确定</a>
        </div>

    </div>
</form>
<script src="../../static/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use(['form', 'layer'], function () {
        var form = layui.form
            , layer = layui.layer
            , $ = layui.jquery;


        $("img").click(function () {
            var val=$(this).attr('src');

            window.open(val);

        });


        form.on('submit(verified)', function (data) {
            $.ajax({
                type: "POST",
                url: "/account/audit",
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
                    layer.close(loading);
                    alert("发生错误：" + jqXHR.status);
                }
            });
        });
    });
</script>
</body>
</html>