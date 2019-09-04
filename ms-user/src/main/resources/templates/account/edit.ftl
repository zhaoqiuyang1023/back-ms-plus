<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>公司信息编辑</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${base}/static/jqueryui/select2.min.css"/>

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
            cursor: pointer;
        }

        .cancle {
            float: right;
            margin-right: 10%;
            color: #FFEAA5;
            font-size: 0.8em;
            font-weight: normal;
            cursor: pointer;
        }

        .consigne {
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

        .certificate {
            padding: 10px;
            background-color: #FFFFFF;
        }

        #iosPreview {
            padding: 10px;
            background-color: #FFFFFF;
        }

        .iosclone {
            float: left;
            padding-top: 10px;
            padding-bottom: 10px;
            border: 1px solid #B9BFC4;
            border-radius: 5px;
            align-content: center;
            margin-left: 10px;
            width: 200px;
            text-align: center;
            height: 200px;
        }

        .iosclone :hover {

            /**/ /*box-shadow: 0 0 1px #f00;*/
            border: 1px solid #dedede
        }


    </style>
</head>
<body class="childrenBody ">

<form class="layui-form">
    <div class="cardDiv">
        <input type="text" id="orgId" name="id" hidden placeholder="公司id" value="${organization.id}" autocomplete="off"
               style="display:none" class="layui-input">
        <input type="text" name="cerId" hidden placeholder="证书id" value="${cerId}" autocomplete="off"
               style="display:none" class="layui-input">
        <input type="text" name="approvalId" hidden placeholder="企业统一授权码" value="${organization.approvalId}">
        <div class="mainTitle">
            <a>基本信息</a>
            <#--<a id="edit" class="edit">编辑</a>-->
            <a id="consigne" class="consigne">业务列表</a>
            <#--   <a id="cancle" class="cancle">取消</a>-->
        </div>

        <div class="flex-container">
            <div class="flex-item layui-form-item">
                <a class="title">* 企业当地名称（与注册证书一致）</a>

                <input type="text" name="nameOfLocal" lay-verify="required" placeholder="请输入" value="${organization.nameOfLocal}"
                       autocomplete="off"
                       class="layui-input param">
            </div>
            <div class="flex-item layui-form-item">
                <a class="title">* 企业英文名称</a>

                <input type="text" name="name" lay-verify="required" placeholder="请输入" value="${organization.name}"
                       autocomplete="off"
                       class="layui-input param">

            </div>
            <div class="flex-item layui-form-item">

                <a class="title">* 公司名称(中文)</a>

                <input type="text" name="nameBackups" lay-verify="required" placeholder="请输入" value="${organization.nameBackups}"
                       autocomplete="off"
                       class="layui-input param">

            </div>


        </div>
        <div class="flex-container">
            <div class="flex-item layui-form-item">

                <a class="title">* 注册地点</a>


                <input type="text" name="streetAddress" lay-verify="required" placeholder="请输入" value="${organization.streetAddress}"
                       autocomplete="off" class="layui-input param">

            </div>

            <div class="flex-item layui-form-item">

                <a class="title">*统一社会信用号</a>

                <input type="text" name="socialCredit"  placeholder="请输入"
                       value="${organizationApproval.socialCredit}" lay-verify="required"
                       autocomplete="off" class="layui-input param">
            </div>

            <div class="flex-item layui-form-item">


                <div class="layui-form-item">
                    <a class="title">营业期限</a>
                    <#--<div class="layui-input-inline">-->
                    <input class="layui-input datetime param" name="operatePeriod"
                           id="dateStart" type="text" value="${organization.operatePeriod}"
                           placeholder="yyyy-MM-dd HH:mm:ss">
                    <#--</div>-->
                </div>
            </div>


        </div>

        <div class="flex-container-column">
            <div class="flex-item">

                <a class="title">经营范围</a>
                <#--<textarea type="text" name="businessType" placeholder="请输入"-->
                <#--autocomplete="off"-->
                <#--class="layui-textarea param">${organization.businessType}</textarea>-->

                <select lay-ignore style="width: 100%;border-color: #1AA094" class="js-example-basic-multiple"
                        name="states"
                        multiple="multiple">

                    <#list allbusinessTypes as item>
                        <option value="${item.code}"
                                <#list orgbusinessTypes as orgitem>
                                    <#if (item.id == orgitem.id)>selected</#if>
                                </#list>
                        >
                            ${item.name}
                        </option>
                    </#list>
                </select>
            </div>

        </div>
    </div>


    <!--联系方式-->

    <div class="cardDiv information">
        <p class="mainTitle">联系方式</p>
        <div class="flex-container">
            <div class="flex-item">
                <a class="title">公司网址</a>
                <input type="text" name="CMW" itemId="${organization.id}" itemType="organization" id="${CMW.id}"
                       placeholder="请输入" value="${CMW.value}" autocomplete="off"
                       class="layui-input param contactWay">

            </div>
            <div class="flex-item">

                <a class="title">联系电话</a>

                <input type="text" name="CMP" itemId="${organization.id}" itemType="organization" id="${CMP.id}"
                       placeholder="请输入" value="${CMP.value}" autocomplete="off"
                       class="layui-input param contactWay">

            </div>
            <div class="flex-item">

                <a class="title">传真</a>

                <input type="text" name="CMF" itemId="${organization.id}" itemType="organization" id="${CMF.id}"
                       placeholder="请输入" value="${CMF.value}" autocomplete="off"
                       class="layui-input param contactWay">

            </div>
        </div>
        <div class="flex-container">
            <div class="flex-item">
                <a class="title">经营地址</a>

                <input type="text" name="businessAddress" placeholder="请输入" value="${organization.businessAddress}"
                       autocomplete="off" class="layui-input param">

            </div>
            <div class="flex-item">

                <a class="title">法定代表人</a>

                <input type="text" name="artificialPerson" placeholder="请输入" value="${organization.artificialPerson}"
                       autocomplete="off" class="layui-input param">
            </div>
        </div>
    </div>


    <!--公司介绍-->

    <div class="cardDiv">
        <p class="mainTitle">公司介绍</p>

        <div class="flex-container-column">
            <div class="flex-item">
                <a class="title">详细介绍</a>

                <textarea type="text" name="description" placeholder="请输入"
                          autocomplete="off"
                          class="layui-textarea param">${organization.description}</textarea>

            </div>
            <div class="flex-item">

                <a class="title">公司简介</a>

                <textarea type="text" name="intro" placeholder="请输入"
                          autocomplete="off"
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

                <input type="text" name="registeredAmount" placeholder="注册资本" value="${organization.registeredAmount}"
                       autocomplete="off" class="layui-input param">
            </div>
            <div class="flex-item">

                <a class="title">实缴资本</a>

                <input type="text" name="contributed" placeholder="实缴资本" value="${organization.contributed}"
                       autocomplete="off" class="layui-input param">
            </div>
            <div class="flex-item">

                <a class="title">公司人数</a>

                <input type="text" name="numberOfEmployee" placeholder="公司人数" value="${organization.numberOfEmployee}"
                       autocomplete="off" class="layui-input param">

            </div>

            <div class="flex-item">

                <a class="title">公司规模</a>
                <div class="layui-form-item">
                    <select name="enterpriseScale">
                        <#if (scaleOfCompany?size>0)>
                            <option value="">请选择</option>
                            <#list scaleOfCompany as item>
                                <option value="${item.code}"
                                        <#if (item.code == organization.enterpriseScale)>selected</#if>>${item.name}</option>
                            </#list>
                        </#if>
                        <select>
                </div>

            </div>
        </div>
    </div>


    <#--企业营业执照-->


    <div class="cardDiv layui-upload">
        <p class="mainTitle">企业营业执照</p>
        <div class="certificate layui-upload-list">
            <div class="cerPreview" id="cerPreview">
                <#if (certificates?exists &&certificates?size>0)>
                    <#list certificates as item>
                        <div id="iosclone" class="iosclone">
                            <img name="${item.id}" style="width: 150px;height: 150px" src=${item.url} alt="">
                            <p id="fileName" style="font-size: 12px;">${item.originName}</p>

                            <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                               style="font-size: 12px; align-self: center;text-align: center;cursor:pointer;"><i
                                        class="layui-icon"></i>
                            </a>
                        </div>

                    </#list>
                </#if>
                <div id="iosclone" class="iosclone">
                    <img id="cerImg" name="" style="width: 150px;height: 150px"
                         src="../../static/images/uploadplace.png"
                         alt="">
                    <p id="fileName" style="font-size: 12px;display: none"></p>

                    <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                       style="font-size: 12px;display: none; align-self: center;text-align: center;cursor:pointer;"><i
                                class="layui-icon"></i>
                    </a>

                </div>

            </div>
        </div>
        <div style="clear: both">

        </div>
    </div>


    <#--荣誉证书 fileId使用,隔开-->


    <div class="cardDiv layui-upload">
        <p class="mainTitle">荣誉证书</p>
        <div class="certificate layui-upload-list">
            <div class="honPreview" id="honPreview">
                <#if (HonorCert?exists &&HonorCert?size>0)>
                    <#list HonorCert as item>
                        <div id="iosclone" class="iosclone">
                            <img <#--id="honImg" class="honImg"--> name="${item.id}" style="width: 150px;height: 150px"
                                                                   src=${item.url} alt="">
                            <p id="fileName" style="font-size: 12px;">${item.originName}</p>

                            <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                               style="font-size: 12px; align-self: center;text-align: center;cursor:pointer;"><i
                                        class="layui-icon"></i>
                            </a>
                        </div>

                    </#list>
                </#if>
                <div id="iosclone" class="iosclone">
                    <img id="honImg" name="" style="width: 150px;height: 150px"
                         src="../../static/images/uploadplace.png"
                         alt="">
                    <p id="fileName" style="font-size: 12px;display: none"></p>

                    <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                       style="font-size: 12px;display: none; align-self: center;text-align: center;cursor:pointer;"><i
                                class="layui-icon"></i>
                    </a>

                </div>

            </div>
        </div>
        <div style="clear: both">

        </div>
    </div>


    <#--注册证书 fileId使用,隔开-->

    <div class="cardDiv layui-upload">
        <p class="mainTitle">注册证书</p>
        <div class="certificate layui-upload-list">
            <div class="regPreview" id="regPreview">
                <#if (RegistrationCert?exists &&RegistrationCert?size>0)>
                    <#list RegistrationCert as item>
                        <div id="iosclone" class="iosclone">
                            <img <#--id="regImg" class="regImg"--> name="${item.id}" style="width: 150px;height: 150px"
                                                                   src=${item.url} alt="">
                            <p id="fileName" style="font-size: 12px;">${item.originName}</p>

                            <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                               style="font-size: 12px;align-self: center;text-align: center;cursor:pointer;"><i
                                        class="layui-icon"></i>
                            </a>
                        </div>

                    </#list>
                </#if>
                <div id="iosclone" class="iosclone">
                    <img id="regImg" name="" style="width: 150px;height: 150px"
                         src="../../static/images/uploadplace.png"
                         alt="">
                    <p id="fileName" style="font-size: 12px;display: none"></p>

                    <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                       style="font-size: 12px;display: none; align-self: center;text-align: center;cursor:pointer;"><i
                                class="layui-icon"></i>
                    </a>

                </div>

            </div>
        </div>
        <div style="clear: both">

        </div>
    </div>


    <#--企业资质证书-->

    <div class="cardDiv layui-upload">
        <p class="mainTitle">企业资质证书</p>
        <div class="certificate layui-upload-list">
            <div class="spePreview" id="spePreview">
                <#if (SpecialCert?exists &&SpecialCert?size>0)>
                    <#list SpecialCert as item>
                        <div id="iosclone" class="iosclone">
                            <img <#--id="speImg" class="speImg"--> name="${item.id}" style="width: 150px;height: 150px"
                                                                   src=${item.url} alt="">
                            <p id="fileName" style="font-size: 12px;">${item.originName}</p>

                            <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                               style="font-size: 12px; align-self: center;text-align: center;cursor:pointer;"><i
                                        class="layui-icon"></i>
                            </a>
                        </div>

                    </#list>
                </#if>
                <div id="iosclone" class="iosclone">
                    <img id="speImg" name="" style="width: 150px;height: 150px"
                         src="../../static/images/uploadplace.png"
                         alt="">
                    <p id="fileName" style="font-size: 12px;display: none"></p>

                    <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                       style="font-size: 12px;display: none; align-self: center;text-align: center;cursor:pointer;"><i
                                class="layui-icon"></i>
                    </a>

                </div>

            </div>
        </div>
        <div style="clear: both">

        </div>
    </div>


    <#--ISO资质证书-->

    <div class="cardDiv layui-upload">
        <p class="mainTitle">ISO资质证书</p>
        <div class="certificate layui-upload-list">
            <div class="iosPreview" id="iosPreview">
                <#if (ISOCert?exists &&ISOCert?size>0)>
                    <#list ISOCert as item>
                        <div id="iosclone" class="iosclone">
                            <img <#--id="addImg" class="addImg"--> name="${item.id}" style="width: 150px;height: 150px"
                                                                   src=${item.url} alt="">
                            <p id="fileName" style="font-size: 12px;">${item.originName}</p>

                            <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                               style="font-size: 12px; align-self: center;text-align: center;cursor:pointer;"><i
                                        class="layui-icon"></i>
                            </a>
                        </div>

                    </#list>
                </#if>
                <div id="iosclone" class="iosclone">
                    <img id="addImg" name="" style="width: 150px;height: 150px"
                         src="../../static/images/uploadplace.png"
                         alt="">
                    <p id="fileName" style="font-size: 12px;display: none"></p>

                    <a id="del" class="layui-btn layui-btn-primary layui-btn-sm del"
                       style="font-size: 12px;display: none; align-self: center;text-align: center;cursor:pointer;"><i
                                class="layui-icon"></i>
                    </a>

                </div>

            </div>
        </div>
        <div style="clear: both">

        </div>
    </div>


    <div style="float: right">

        <div class="layui-form-item">

            <div class="layui-input-block">
                <input type="radio" name="visibleStatus" value=0 title="不可见"
                       <#if organization.visibleStatus==0>checked</#if>>
                <input type="radio" name="visibleStatus" value=1 title="可见"
                       <#if organization.visibleStatus==1>checked</#if>>
            </div>



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
<script src="${base}/static/jqueryui/jquery.js"></script>
<script src="${base}/static/jqueryui/select2.min.js"></script>

<script src="${base}/static/layui/layui.js" charset="utf-8"></script>


<script>
    layui.use(['form', 'laydate', 'upload', 'layer'], function () {
        var array = [];

        var loading;
        var form = layui.form
            , layer = layui.layer
            , laydate = layui.laydate
            , $ = layui.jquery
            , upload = layui.upload;


        $(".iosclone").on("click", "#del", function () {
            //  iosPreview
            var child = $(this).parent().children();
            if (child.length > 1) {
                $(this).parent().remove();
            }
        });


        $(function () {
            $(".js-example-basic-multiple").select2({
                placeholder: "选择服务类型"
            });
            console.log("初始化")
            imguoload($("#cerImg"));
            imguoload($("#regImg"));
            imguoload($("#speImg"));
            imguoload($("#honImg"));
            imguoload($("#addImg"));
        });


        function imguoload(data) {
            upload.render({
                elem: data
                , url: "${uploadUrl}" //uploadUrl
                , multiple: true
                , auto: true //选择文件后不自动上传
                , field: 'files' //MultipartFile file 对应，layui默认就是file,要改动则相应改动
                , before: function (obj) {
                    loading = layer.load();

                    obj.preview(function (index, file, result) {
                        console.log("预览" + index);
                        var imagediv = $(data).parent().clone(this);
                        var image = $(imagediv).children("img");
                        var fileName = $(imagediv).children("#fileName");
                        var filedel = $(imagediv).children("#del");
                        $(filedel).css('display', "inline");
                        $(fileName).css('display', "block");
                        $(image).attr("id", index);
                        $(fileName).html(file.name);
                        $(image).attr('src', result);
                        $(image).attr('alt', file.name);
                        $(imagediv).insertBefore($(data).parent());
                    });
                }
                , done: function (res, index, upload) {
                    layer.msg("上传成功" + index);
                    var indexImg = $("#" + index + "");
                    if (res.code == 0) {
                        $(indexImg).attr("name", res.data[0].id);
                        $(indexImg).attr('disabled', "true");//添加disabled属性
                        layer.msg("上传成功");
                        var obj = res.data[0];
                        console.log(obj["id"]);
                        /* alert(JSON.stringify(res));*/
                    }
                    layer.close(loading);

                }
                , error: function (index, upload) {
                    layer.msg("上传失败");
                    layer.msg(uploadUrl);
                    layer.close(loading);
                }
            });
        }


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
        $("#consigne").on('click', function () {
            var id = $("#orgId").val();
            //   var value = $(param).val();
            var editIndex = layer.open({
                title: "业务列表",
                type: 2,
                area: ['1024px', '900px'],
                content: "${base}/account/consigne/" + id,
                success: function (layero, index) {

                }
            });
            layer.full(editIndex);
            //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
            $(window).resize(function () {
                layer.full(editIndex);
            });
        });
        $("#cancle").on("click", function () {

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
            , range: '至',
            done: function (value, date) {
                console.log(value);
                var str = value.split('至');
                console.log(str[0]);
                console.log(str[1])
            }
        });


        //监听提交

        form.on('submit(demo1)', function (data) {

            information();//联系方式
            data.field.globalContactMethodList = array;
            data.field.license = inforImage($("#cerPreview"));
            data.field.iso = inforImage($("#iosPreview"));
            data.field.hon = inforImage($("#honPreview"));
            data.field.reg = inforImage($("#regPreview"));
            data.field.spe = inforImage($("#spePreview"));
            /*  alert(JSON.stringify(data.field));*/
            data.field.businessType = "";
            var businessTypes = $('.js-example-basic-multiple').val();
            var strbusinerr = "";
            if(businessTypes!=null){
                for (var i = 0; i < businessTypes.length; i++) {
                    strbusinerr = strbusinerr + businessTypes[i] + ","
                }
            }
            if (strbusinerr.length > 0) {
                data.field.businessType = strbusinerr.substring(0, strbusinerr.lastIndexOf(','));
            }
            console.log(JSON.stringify(data.field));
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

            for (var i = 0; i < params.length; i++) {
                var param = params[i];
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

        function inforImage(data) {
            var str = "";
            var params = $(data).find("img");//图片

            for (var i = 0; i < params.length; i++) {
                var param = params[i];
                var id = $(param).prop("name");
                console.log(id);

                if (typeof id == "undefined" || id == null || id === '') {

                } else {
                    str = str + id + ",";
                }
            }
            console.log(str);
            return str.substring(0, str.lastIndexOf(','));

        }
    });
</script>
</body>
</html>