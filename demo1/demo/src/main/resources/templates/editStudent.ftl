<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>学生信息页面</title>
    <base th:href="@{/}">
    <link rel="stylesheet" href="layui/css/layui.css">

<div class="layuimini-main">

    <div class="layui-form layuimini-form" lay-filter="updateSubmit">
        <input type="hidden" name="id">
        <input type="hidden" name="typeIds" id="typeIds">
        <div class="layui-form-item">
            <label class="layui-form-label required">学生姓名</label>
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
            <label class="layui-form-label required">学号</label>
            <div class="layui-input-block">
                <input type="text" name="identity" lay-verify="required" class="layui-input">
            </div>
        </div>




        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" lay-submit lay-filter="updateSubmit">确认修改</button>
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


        form.render();
        //查询所有的楼宇信息并渲染到select中
        $.get("house/queryAll",{},function (data) {
            var list=data;
            var select =document.getElementById("typeId");
            if(list!=null || list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].id);
                    option.innerText=list[c].numbers;
                    select.appendChild(option);
                    var selectTypeId=$("#typeIds").val();
                    //遍历选中状态
                    if(selectTypeId==list[c].id){
                        option.setAttribute("selected","selected");
                        layui.form.render('select');
                    }
                }
            }
            form.render('select');
        },"json");



        // 当前弹出层，防止ID被覆盖
        var parentIndex = layer.index;

        //监听提交
        form.on('submit(updateSubmit)', function (data) {
            //获取表单中的数据信息
            var datas=data.field;
            addOrUpdateSubmit($,"owner/add",datas);
            return false;
        });

    });
</script>