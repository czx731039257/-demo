<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html>
<head>
    <title>easyui</title>
    <link rel="stylesheet" type="text/css" href="css/background.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" type="text/css"/>
    <link rel="stylesheet" href="easyui/themes/icon.css" type="text/css"/>


    <style type="text/css">
        .define-head {
            font-family: Verdana, Geneva, sans-serif;
            background-color: #EFEFEF;
            height: 55px;
            overflow: hidden;
        }

        .define-head .define-logo {
            height: 52px;
            width: 50%;
            float: left;
        }

        .define-head .define-logo #LoginTopLine {
            letter-spacing: 2px;
            margin: 8px 0px 0px 10px;
            text-shadow: 3px 1px 6px #fff;
            color: #15428B;
            font-size: 26px;
            height: 30px;
            line-height: 30px;
            padding-left: 55px;
        }

        .define-head .define-logo #LoginBotoomLine {
            letter-spacing: 1px;
            text-shadow: 3px 1px 6px #fff;
            color: #15428B;
            font-size: 12px;
            height: 15px;
            line-height: 15px;
            padding-left: 65px;
        }
    </style>
</head>

<body class="easyui-layout">
<div data-options="region:'north',border:false,split:false" style="height:40px; overflow:hidden">
    <div class="define-head">
        <div class="define-logo">
            <div id="LoginTopLine">留言管理系统</div>
        </div>
    </div>
</div>
<div data-options="region:'south',border:false" style="height:20px;">
    <div class="define-bottom">

    </div>
</div>
<div data-options="region:'center',border:false">
    <div style="width:100%;height:100%;position: relative;">
        <div id="LeftMenuDiv" style="width: 202px;height:100%;display: inline-block; background-color: green;">
            <div class="easyui-panel" title="菜单列表" style="width:100%;height:100%;overflow-x:hidden;overflow-y:auto;"
                 data-options="onOpen:onPanelOpen">
                <div id="LeftMenu" style="">
                </div>
            </div>
        </div>

        <div id="mainTab" class="easyui-tabs" data-options="fit:true,onSelect:onTabSelect"
             style="display: inline-block; position: absolute;">
            <div title="首页" data-options="closable:false" style="overflow:hidden;background-color:#fff;">
                <iframe scrolling="auto" frameborder="0" src="" style="width:100%;height:100%"></iframe>
            </div>
        </div>
    </div>
</div>

</body>
</html>

<script type="text/javascript">
    $(function () {
        $('#LeftMenu').sidemenu({
            data: [{
                text: '留言管理',
                iconCls: 'icon-more',
                state: 'open',
                children: [{
                    text: '个人留言',
                    url: 'personmessages'
                }, {
                    text: '同组的留言',
                    url: 'groupmessages'
                }, {
                    text: '全部留言',
                    url: 'allmessages'
                }]
            }, {
                text: '用户管理',
                iconCls: 'icon-more',
                children: [{
                    text: '个人用户'
                }, {
                    text: '所有用户'
                }]
            }],
            onSelect: onSideMenuSelect,
            border: false
        });
    });

    function onPanelOpen() {
        var panel = $(this);
        var _1e = panel.panel("header").children("div.panel-tool");
        _1e.children("a.panel-tool-collapse").hide();

        var _20 = "layout-button-left";// + _1f[dir];
        var t = _1e.children("a." + _20);
        if (!t.length) {
            t = $("<a href=\"javascript:;\"></a>").addClass(_20).appendTo(_1e);
            t.bind("click", {dir: "left"}, function (e) {
                if (e.target.className == "layout-button-right") {
                    e.target.className = "layout-button-left"
                    onWestExpand();
                    panel.panel("setTitle", panel.titleTemp);
                    panel.panel('resize', {
                        width: 202
                    });

                    var leftMenuDiv = $('#LeftMenuDiv');
                    leftMenuDiv.each(function () {
                        this.style.width = '202px';
                    });
                } else {
                    e.target.className = "layout-button-right"
                    onWestCollapse();
                    var opt = panel.panel('options');
                    panel.titleTemp = opt.title;
                    panel.panel("setTitle", "");
                    panel.panel('resize', {
                        width: 42
                    });

                    var leftMenuDiv = $('#LeftMenuDiv');
                    leftMenuDiv.each(function () {
                        this.style.width = '42px';
                    });
                }

                return false;
            });
        }
        //$(this).panel("options").collapsible ? t.show() : t.hide();
    }

    function onTabSelect(title, index) {
        var tabs = $('#mainTab');
        var tab = tabs.tabs('getTab', index);
        var menus = $('#LeftMenu');
        if (menus.hasClass('sidemenu')) {
            var opts = menus.sidemenu("options");
            changeMenuSelect(menus, opts, tab[0].id);
        }
    }

    function onWestCollapse() {
        var opts = $('#LeftMenu').sidemenu('options');
        if (opts.collapsed != 'collapse') {
            $('#LeftMenu').sidemenu('collapse');
            $('#LeftMenu').sidemenu('resize', {
                width: 40
            });
        }
    }

    function onWestExpand() {
        var opts = $('#LeftMenu').sidemenu('options');
        if (opts.collapsed != 'expand') {
            $('#LeftMenu').sidemenu('expand');
            $('#LeftMenu').sidemenu('resize', {
                width: 200
            });
        }
    }

    function onSideMenuSelect(item) {
        if (!$('#mainTab').tabs('exists', item.text)) {
            $('#mainTab').tabs('add', {
                title: item.text,
                content: '<iframe scrolling="auto" frameborder="0"  src="' + item.url + '" style="width:100%;height:99%;"></iframe>',
                closable: true,
                icon: item.iconCls,
                id: item.id
            });
        } else {
            $('#mainTab').tabs('select', item.text);
        }
        addTabMenu();
    }

    function addTabMenu() {
        /* ˫���ر�TABѡ� */
        $(".tabs-inner").dblclick(function () {
            var subtitle = $(this).children(".tabs-closable").text();
            $('#mainTab').tabs('close', subtitle);
        });
        /* Ϊѡ����Ҽ� */
        $(".tabs-inner").bind('contextmenu', function (e) {
            $('#tab_menu').menu('show', {
                left: e.pageX,
                top: e.pageY
            });

            var subtitle = $(this).children(".tabs-closable").text();

            $('#tab_menu').data("currtab", subtitle);
            $('#mainTab').tabs('select', subtitle);
            return false;
        });
    }

    function changeMenuSelect(menus, opts, selectId) {
        var menutrees = menus.find(".sidemenu-tree");
        menutrees.each(function () {
            var menuItem = $(this);
            changeMenuStyle(menuItem, opts, selectId);
        });

        var tooltips = menus.find(".tooltip-f");
        tooltips.each(function () {
            var menuItem = $(this);
            var tip = menuItem.tooltip("tip");
            if (tip) {
                tip.find(".sidemenu-tree").each(function () {
                    changeMenuStyle($(this), opts, selectId);
                });
                menuItem.tooltip("reposition");
            }
        });
    }

    function changeMenuStyle(menuItem, opts, selectId) {
        menuItem.find("div.tree-node-selected").removeClass("tree-node-selected");
        var node = menuItem.tree("find", selectId);
        if (node) {
            $(node.target).addClass("tree-node-selected");
            opts.selectedItemId = node.id;
            menuItem.trigger("mouseleave.sidemenu");
        }

        changeMenuSelect(menuItem);
    }
</script>