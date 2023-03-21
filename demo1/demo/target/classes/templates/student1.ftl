<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>学生编辑页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <base th:href="@{/}">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="js/jquery-2.2.1.js"></script>
    <script src="layui/layui.js" charset="utf-8"></script>

</head>
<div class="layuimini-main">

    <div class="layui-form layuimini-form">
        <div class="layui-form-item">
            <label class="layui-form-label required">学生信息</label>
            <div class="layui-input-block">
                <input type="text" name="username" lay-verify="required" lay-reqtext="学生姓名不能为空"
                       placeholder="请输入学生姓名" value="" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">学生电话</label>
            <div class="layui-input-block">
                <input type="text" name="tel" lay-verify="required" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked="">
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email" lay-verify="required" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label required">爱好</label>
            <div class="layui-input-block">
                <input type="text" name="hobby" lay-verify="required" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['form', 'table','laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            table = layui.table,
            laydate=layui.laydate,
            $ = layui.$;

        // 日期
        // laydate.render({
        //     elem: '#date',
        //     trigger:'click'
        // });
        form.render();
        //查询所有的楼宇信息并渲染到select中
        $.get("student/findAll",{},function (data) {
            var list=data;
            var select =document.getElementById("Id");
            if(list!=null || list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].id);
                    option.innerText=list[c].numbers;
                    select.appendChild(option);
                }
            }
            form.render('select');
        },"json");



        // 当前弹出层，防止ID被覆盖
        var parentIndex = layer.index;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            //获取表单中的数据信息
            var datas=data.field;
            addOrUpdateSubmit($,"owner/add",datas);
            return false;
        });

    });
</script>

</body>
</html>
