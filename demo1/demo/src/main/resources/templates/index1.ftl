<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>学生信息页面</title>
    <base th:href="@{/}">
    <link rel="stylesheet" href="layui/css/layui.css">


</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">layout demo</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

            <li class="layui-nav-item layui-hide-xs"><a href="">nav 1</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">nav 2</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">nav 3</a></li>
            <li class="layui-nav-item">
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    tester
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">Your Profile</a></dd>
                    <dd><a href="">Settings</a></dd>
                    <dd><a href="">Sign out</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">menu group 1</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">menu 1</a></dd>
                        <dd><a href="javascript:;">menu 2</a></dd>
                        <dd><a href="javascript:;">menu 3</a></dd>
                        <dd><a href="">the links</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">menu group 2</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">list 1</a></dd>
                        <dd><a href="javascript:;">list 2</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">click menu item</a></li>
                <li class="layui-nav-item"><a href="">the links</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <table class="layui-hide" id="demo" lay-filter="test"></table>
        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
            <a class="layui-btn layui-btn-xs" lay-event="more">更多<i class="layui-icon layui-icon-down"></i></a>
        </script>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.2.1.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;
        // miniPage = layui.miniPage;

        var table = layui.table; //表格
        var dropdown = layui.dropdown;//下拉菜单

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

        // 执行一个 table 实例
        var tableIns = table.render({
            elem: '#demo'
            ,height: 420
            ,url: 'student/findAll' //数据接口（此处为静态数据，仅作演示）
            ,title: '用户表'
            ,page: true //开启分页
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id', title: 'id', width:80, sort: true, fixed: 'left', totalRow: '合计：'}
                ,{field: 'studentNum', title: '学号', width:80}
                ,{field: 'name', title: '姓名', width: 90, sort: false, totalRow: '{{= d.TOTAL_NUMS }}'}
                ,{field: 'phone', title: '联系电话', width: 80, sort: false, totalRow: true}
                ,{field: 'sex', title: '性别', width:80}
                ,{field: 'email', title: 'Email', width:80, sort: false}
                ,{field: 'hobby', title: '爱好', width: 200}

                ,{fixed: 'right', title: '操作', width: 150, align:'center', toolbar: '#barDemo'}
            ]]
        });


        // 头工具栏事件
        table.on('toolbar(test)', function(obj){
            //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.msg('添加');
                    break;

                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                    }
                    break;

                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            };
        });


        // 单元格工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'more'){
                //下拉菜单
                dropdown.render({
                    elem: this //触发事件的 DOM 对象
                    ,show: true //外部事件触发即显示
                    ,data: [{
                        title: '编辑'
                        ,id: 'edit'
                    },{
                        title: '删除'
                        ,id: 'del'
                    }]
                    ,click: function(menudata){
                        if(menudata.id === 'del'){
                            layer.confirm('真的删除行么', function(index) {
                                $.ajax({
                                    url:'student/DeleteStudent',
                                    type: 'post',
                                    data: { 'id': data.id },
                                    dataType: 'json',
                                    async: false,
                                    success: function (res){
                                        console.log(11111111111111111);
                                        if(res.code == 1){
                                            tableIns.reload();
                                        }
                                        layer.msg(res.msg);
                                    },
                                    error: function(res){
                                        console.log(res);
                                        console.log(2222222222);
                                    }
                                });
                                //obj.del(); //删除对应行（tr）的DOM结构
                                //     $.post("student/DeleteStudent",
                                //         {id: data.id } ,
                                //         function(res) {
                                //             if(res.code == 1) {
                                //                 tableIns.reload()
                                //                 console.log("111111111111111111111111111111111")
                                //             }
                                //             layer.msg(res.msg);
                                //         }
                                //     );
                                //     layer.close(index);
                                //     //向服务端发送删除指令
                                // });
                                layer.close(index);
                            });
                        } else if(menudata.id === 'edit'){
                            layer.msg('编辑操作，当前行 ID:'+ data.id);
                        }
                    }
                    ,align: 'right' //右对齐弹出
                    ,style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);' //设置额外样式
                })
            }
        });

    });
</script>
</body>
</html>