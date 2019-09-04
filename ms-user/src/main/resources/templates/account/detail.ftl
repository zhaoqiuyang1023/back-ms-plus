<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>港口信息详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">

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

        .subhead {
            margin-left: 30px;
            margin-top: 20px;
            font-size: 14px;
            font-family: "Microsoft YaHei", 微软雅黑, "MicrosoftJhengHei", 华文细黑, STHeiti, MingLiu;
            color: #000000;
        }

        .subhead1 {
            margin-left: 30px;
            margin-top: 20px;
            font-size: 14px;
            font-family: "Microsoft YaHei", 微软雅黑, "MicrosoftJhengHei", 华文细黑, STHeiti, MingLiu;
            color: #000000;
        }

        .flex-container {
            display: -webkit-flex;
            display: flex;
            margin: 10px;

        / / 实际相当于block-flex，块级容器，宽度同其外层容器 display: inline-flex;
        / / 顾名思义，行级容器，宽度取决于其子元素 width: 980 px;
            background-color: #FFFFFF;
        }

        .flex-container-column {
            display: -webkit-flex;

            display: flex;
            -webkit-flex-direction: column;

            flex-direction: column;

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
        }

        .cancle {
            float: right;
            margin-right: 10%;
            color: #FFEAA5;
            font-size: 0.8em;
            font-weight: normal;
        }

        textarea:hover {
            box-shadow: 0 0 1px #C5CCD1;
            border: 2px solid #F9F9F9;
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
    <div class="cardDiv">
        <input type="text" name="id" hidden placeholder="请输入" value="${organization.id}" autocomplete="off"
               style="display:none" class="layui-input">
        <div class="mainTitle">
            <a>基本信息</a>
            <a id="edit" class="edit">编辑</a>
            <a id="edit" class="cancle">取消</a>
        </div>

        <div class="flex-container">
            <div class="flex-item">
                <a class="title">* 企业当地名称（与注册证书一致）</a>
                <p class="subhead">${organization.nameOfLocal}</p>
                <input type="text" name="nameOfLocal" placeholder="请输入" value="${organization.nameOfLocal}"
                       autocomplete="off"
                       style="display:none" class="layui-input param">
            </div>
            <div class="flex-item">

                <a class="title">* 企业英文名称</a>
                <p class="subhead">${organization.name}</p>
                <input type="text" name="name" placeholder="请输入" value="${organization.name}" autocomplete="off"
                       style="display:none" class="layui-input param">

            </div>
            <div class="flex-item">

                <a class="title">* 企业中文简称</a>
                <p class="subhead">${organization.nameBackups}</p>
                <input type="text" name="nameBackups" placeholder="请输入" value="${organization.nameBackups}"
                       autocomplete="off"
                       style="display:none" class="layui-input param">

            </div>


        </div>
        <div class="flex-container">
            <div class="flex-item">

                <a class="title">* 注册地点</a>
                <p class="subhead">${organization.streetAddress}</p>

                <input type="text" name="streetAddress" placeholder="请输入" value="${organization.streetAddress}"
                       autocomplete="off" style="display:none" class="layui-input param">

            </div>

            <div class="flex-item">

                <a class="title">*统一社会信用号</a>
                <p class="subhead">${organizationApproval.socialCredit}</p>
                <input type="text" name="socialCredit" placeholder="请输入" value="${organizationApproval.socialCredit}"
                       autocomplete="off" style="display:none" class="layui-input param">
            </div>

            <div class="flex-item">


                <div class="layui-form-item">
                    <a class="title">营业期限</a>
                    <p class="subhead">${organization.operatePeriod}</p>
                    <div class="layui-input-inline">
                        <input class="layui-input datetime param" style="display:none" name="operatePeriod"
                               id="dateStart" type="text" value="${organization.operatePeriod}"
                               placeholder="yyyy-MM-dd HH:mm:ss">
                    </div>
                </div>
            </div>


        </div>

        <div class="flex-container-column">
            <div class="flex-item">

                <a class="title">经营范围</a>
                <p class="subhead">${organization.businessType}</p>
                <textarea type="text" name="businessType" placeholder="请输入"
                          autocomplete="off" style="display:none"
                          class="layui-textarea param">${organization.businessType}</textarea>

            </div>

        </div>
    </div>


    <!--联系方式-->

    <div class="cardDiv information">
        <p class="mainTitle">联系方式</p>
        <div class="flex-container">
            <div class="flex-item">
                <a class="title">公司网址</a>
                <p class="subhead">${CMW.value}</p>
                <input type="text" name="CMW" itemId="${organization.id}" itemType="organization" id="${CMW.id}"
                       placeholder="请输入" value="${CMW.value}" autocomplete="off" style="display:none"
                       class="layui-input param contactWay">

            </div>
            <div class="flex-item">

                <a class="title">联系电话</a>
                <p class="subhead">${CMP.value}</p>
                <input type="text" name="CMP" itemId="${organization.id}" itemType="organization" id="${CMP.id}"
                       placeholder="请输入" value="${CMP.value}" autocomplete="off" style="display:none"
                       class="layui-input param contactWay">

            </div>
            <div class="flex-item">

                <a class="title">传真</a>
                <p class="subhead">${CMF.value}</p>
                <input type="text" name="CMF" itemId="${organization.id}" itemType="organization" id="${CMF.id}"
                       placeholder="请输入" value="${CMF.value}" autocomplete="off" style="display:none"
                       class="layui-input param contactWay">

            </div>
        </div>
        <div class="flex-container">
            <div class="flex-item">
                <a class="title">经营地址</a>
                <p class="subhead">${organization.businessAddress}</p>
                <input type="text" name="businessAddress" placeholder="请输入" value="${organization.businessAddress}"
                       autocomplete="off" style="display:none" class="layui-input param">

            </div>
            <div class="flex-item">

                <a class="title">法定代表人</a>
                <p class="subhead">${organization.artificialPerson}</p>
                <input type="text" name="artificialPerson" placeholder="请输入" value="${organization.artificialPerson}"
                       autocomplete="off" style="display:none" class="layui-input param">
            </div>
        </div>
    </div>


    <!--公司介绍-->

    <div class="cardDiv">
        <p class="mainTitle">公司介绍</p>

        <div class="flex-container-column">
            <div class="flex-item">
                <a class="title">详细介绍</a>
                <p class="subhead">${organization.description}</p>
                <textarea type="text" name="description" placeholder="请输入"
                          autocomplete="off" style="display:none"
                          class="layui-textarea param">${organization.description}</textarea>

            </div>
            <div class="flex-item">

                <a class="title">公司简介</a>
                <p class="subhead">${organization.intro}</p>
                <textarea type="text" name="intro" placeholder="请输入"
                          autocomplete="off" style="display:none"
                          class="layui-textarea param">${organization.intro}</textarea>

            </div>
        </div>


    </div>


    <!--企业规模-->

    <div class="cardDiv">
        <p class="mainTitle">企业规模</p>

        <div class="flex-container">
            <div class="flex-item">
                <a class="title">注册资本</a>
                <p class="subhead">${organization.registeredAmount}</p>
                <input type="text" name="registeredAmount" placeholder="注册资本" value="${organization.registeredAmount}"
                       autocomplete="off" style="display:none" class="layui-input param">
            </div>
            <div class="flex-item">

                <a class="title">实缴资本</a>
                <p class="subhead">${organization.contributed}</p>
                <input type="text" name="contributed" placeholder="实缴资本" value="${organization.contributed}"
                       autocomplete="off" style="display:none" class="layui-input param">
            </div>
            <div class="flex-item">

                <a class="title">公司人数</a>
                <p class="subhead1">${userNumber}</p>

            </div>
        </div>
    </div>


    <#--荣誉证书 fileId使用,隔开-->

    <div class="cardDiv">
        <p class="mainTitle">荣誉证书</p>

        <div class="flex-container">
            <#if (HonorCert?exists &&HonorCert?size>0)>
                <#list HonorCert as item>
                    <span class="content">
                        <img style="margin-top: 20px;width: 100px;height: 100px" src="${item.url}"/>
                    </span>
                </#list>
            <#else>
                <div class="content">
                    <img style="margin-top: 20px;width: 100px;height: 100px" src=""/>
                </div>
            </#if>

        </div>
    </div>


    <#--注册证书 fileId使用,隔开-->

    <div class="cardDiv">
        <p class="mainTitle">注册证书</p>

        <div class="flex-container">
            <#if (RegistrationCert?exists &&RegistrationCert?size>0)>
                <#list RegistrationCert as item>
                    <span class="content">
                        <img style="margin-top: 20px;width: 100px;height: 100px" src="${item.url}"/>
                    </span>
                </#list>
            <#else>
                <div class="content">
                    <img style="margin-top: 20px;width: 100px;height: 100px" src=""/>
                </div>
            </#if>
        </div>
    </div>

    <#--企业资质证书-->
    <div class="cardDiv">
        <p class="mainTitle">企业资质证书</p>

        <div class="flex-container">
            <#if (SpecialCert?exists &&SpecialCert?size>0)>
                <#list SpecialCert as item>
                    <span class="content">
                        <img style="margin-top: 20px;width: 100px;height: 100px" src="${item.url}"/>
                    </span>
                </#list>
            <#else>
                <div class="content">
                    <img style="margin-top: 20px;width: 100px;height: 100px" src=""/>
                </div>
            </#if>

        </div>
    </div>

    <#--ISO资质证书-->
    <#--
     <div class="cardDiv">
        <p class="mainTitle">企业资质证书</p>
        <button class="layui-btn" id="ios" type="button">多图片上传</button>
        <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
            预览图：
            <div class="layui-upload-list" id="iosPreview"></div>
        </blockquote>
        <div class="flex-container">
            <#if (ISOCert?exists &&ISOCert?size>0)>
                <#list ISOCert as item>
                    <span class="content"><img style="margin-top: 20px;width: 100px;height: 100px"
                                               src="${item.url}"/></span>
                    <span class="content"><img style="margin-top: 20px;width: 100px;height: 100px" src="${item.url}"/>
                    </span></#list>
            <#else>
                <div class="content">
                    <img style="margin-top: 20px;width: 100px;height: 100px" src=""/>
                </div>
            </#if>

        </div>
    </div>

    -->



    <div style="float: right">

        <div class="layui-form-item">

            <div class="layui-input-block">
                <input type="radio" name="recommendable" value=false title="取消推荐"
                       <#if organization.recommendable==false>checked</#if>>
                <input type="radio" name="recommendable" value=true title="推荐"
                       <#if organization.recommendable==true>checked</#if>>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-filter="demo1" lay-submit="">提交</button>
                <button id="close" class="layui-btn layui-btn-primary" type="button">关闭</button>
            </div>
        </div>
    </div>
</form>

<script src="../../static/layui/layui.js" charset="utf-8"></script>


<script>
    layui.use(['form', 'laydate', 'layer'], function () {
        var array = [];
        var form = layui.form
            , layer = layui.layer
            , laydate = layui.laydate
            , $ = layui.jquery
            , upload = layui.upload;

        // upload.render({
        //     elem: '#ios'
        //     , url: uploadUrl
        //     , multiple: true
        //     , before: function (obj) {
        //         //预读本地文件示例，不支持ie8
        //         obj.preview(function (index, file, result) {
        //             $('#iosPreview').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img">')
        //         });
        //     }
        //     , done: function (res) {
        //         alert()
        //         //上传完毕
        //     }
        //     , error: function (index, upload) {
        //         var tr = demoListView.find('tr#upload-' + index)
        //             , tds = tr.children();
        //         tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
        //         tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        //     }
        //
        // });


        $("#edit").on("click", function () {

            var params = $("#edit").parent().parent().parent().find(".param");
            for (var param of params) {
                $(param).css('display', 'block')
            }
            var subheads = $("#edit").parent().parent().parent().find(".subhead");
            for (var subhead of subheads) {
                $(subhead).css('display', 'none')
            }
        });
        $("#cancle").on("click", function () {

            alert("123");
            var params = $("#edit").parent().parent().parent().find(".param");
            for (var param of params) {
                $(param).css('display', 'none')
            }
            var subheads = $("#edit").parent().parent().parent().find(".subhead");
            for (var subhead of subheads) {
                $(subhead).css('display', 'block')
            }
        });

        //日期时间选择器
        laydate.render({
            elem: '#dateStart'
            , range: '-',
            done: function (value, date) {
                console.log(value);
                var str = value.split('-');
                console.log(str[0]);
                console.log(str[1])
            }
        });


        //监听提交
        var loading;

        form.on('submit(demo1)', function (data) {

            information();
            data.field.globalContactMethodList = array;
            alert(JSON.stringify(data.field));
            loading = layer.load();
            $.ajax({
                type: "POST",
                url: "${base}/account/update",
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
                    layer.close(loading);
                },
                error: function (jqXHR) {
                    layer.close(loading);
                    alert("发生错误：" + jqXHR.status);
                }
            });
            return false;
        });

        $("#close").on("click", function () {
            parent.layer.closeAll();
            layer.close(loading);
        });

        function information() {


            var params = $(".information").find(".contactWay");//封装联系方式

            for (var param of params) {
                var json = {};
                var type = $(param).prop("name");
                var id = $(param).prop("id");
                var itemId = $(param).attr("itemid");
                var itemType = $(param).attr("itemtype");

                var value = $(param).val();

                console.log(itemId);
                console.log(itemType);
                if (typeof value == "undefined" || value == null || value === '') {

                } else {
                    json["id"] = id;
                    json["itemId"] = itemId;
                    json["itemType"] = itemType;
                    json["type"] = type;
                    json["value"] = value;
                }
                if (!$.isEmptyObject(json)) {
                    array.push(json);
                }
            }
        }
    });
</script>
</body>
</html>