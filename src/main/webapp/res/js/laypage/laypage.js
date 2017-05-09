/*! layPage-v1.3.0 分页组件 License MIT  http://laypage.layui.com/ By 贤心 */
; !
function() {
    "use strict";

    function a(d) {

        var e = "laypagecss";
        a.dir = "dir" in a ? a.dir: f.getpath + "/skin/laypage.css",
        new f(d),
        a.dir && !b[c](e) && f.use(a.dir, e)
    }
    a.v = "1.3";
    var b = document,
    c = "getElementById",
    d = "getElementsByTagName",
    e = 0,
    f = function(a) {
        var b = this,
        c = b.config = a || {};
        c.item = e++,
        b.render(!0)
    };
    f.on = function(a, b, c) {
        return a.attachEvent ? a.attachEvent("on" + b,
        function() {
            c.call(a, window.even)
        }) : a.addEventListener(b, c, !1),
        f
    },
    f.getpath = function() {
        var a = document.scripts,
        b = a[a.length - 1].src;
        return b.substring(0, b.lastIndexOf("/") + 1)
    } (),
    f.use = function(c, e) {
        var f = b.createElement("link");
        f.type = "text/css",
        f.rel = "stylesheet",
        f.href = a.dir,
        e && (f.id = e),
        b[d]("head")[0].appendChild(f),
        f = null
    },
    f.prototype.type = function() {
        var a = this.config;
        return "object" == typeof a.cont ? void 0 === a.cont.length ? 2 : 3 : void 0
    },
    f.prototype.view = function() {
        var b = this,
        c = b.config,
        d = [],
        e = {};
        // 此处负责打印表格下部的分页信息
        if (c.pages = 0 | c.pages, c.curr = 0 | c.curr || 1, c.groups = "groups" in c ? 0 | c.groups: 5, c.first = "first" in c ? c.first: "&#x9996;&#x9875;", c.last = "last" in c ? c.last: "&#x5C3E;&#x9875;", c.prev = "prev" in c ? c.prev: "&#x4E0A;&#x4E00;&#x9875;", c.next = "next" in c ? c.next: "&#x4E0B;&#x4E00;&#x9875;", c.pages <= 1) return "";
        for (c.groups > c.pages && (c.groups = c.pages), e.index = Math.ceil((c.curr + (c.groups > 1 && c.groups !== c.pages ? 1 : 0)) / (0 === c.groups ? 1 : c.groups)), c.curr > 1 && c.prev && d.push('<a href="javascript:;" class="laypage_prev" data-page="' + (c.curr - 1) + '">' + c.prev + "</a>"), e.index > 1 && c.first && 0 !== c.groups && d.push('<a href="javascript:;" class="laypage_first" data-page="1"  title="&#x9996;&#x9875;">' + c.first + "</a><span>&#x2026;</span>"), e.poor = Math.floor((c.groups - 1) / 2), e.start = e.index > 1 ? c.curr - e.poor: 1, e.end = e.index > 1 ?
        function() {
            var a = c.curr + (c.groups - e.poor - 1);
            return a > c.pages ? c.pages: a
        } () : c.groups, e.end - e.start < c.groups - 1 && (e.start = e.end - c.groups + 1); e.start <= e.end; e.start++) e.start === c.curr ? d.push('<span class="laypage_curr" ' + (/^#/.test(c.skin) ? 'style="background-color:' + c.skin + '"': "") + ">" + e.start + "</span>") : d.push('<a href="javascript:;" data-page="' + e.start + '">' + e.start + "</a>");
        return c.pages > c.groups && e.end < c.pages && c.last && 0 !== c.groups && d.push('<span>&#x2026;</span><a href="javascript:;" class="laypage_last" title="&#x5C3E;&#x9875;"  data-page="' + c.pages + '">' + c.last + "</a>"),
        e.flow = !c.prev && 0 === c.groups,
        (c.curr !== c.pages && c.next || e.flow) && d.push(function() {
            return e.flow && c.curr === c.pages ? '<span class="page_nomore" title="&#x5DF2;&#x6CA1;&#x6709;&#x66F4;&#x591A;">' + c.next + "</span>": '<a href="javascript:;" class="laypage_next" data-page="' + (c.curr + 1) + '">' + c.next + "</a>"
        } ()),
        '<div style="float: right;"   name="laypage' + a.v + '" class="laypage_main laypageskin_' + (c.skin ?
        function(a) {
            return /^#/.test(a) ? "molv": a
        } (c.skin) : "default") + '" id="laypage_' + b.config.item + '">' + d.join("") +
        function() {
            return c.skip ? '<span class="laypage_total"><label>&#x5230;&#x7B2C;</label><input type="number" min="1" onkeyup="this.value=this.value.replace(/\\D/, \'\');" class="laypage_skip"><label>&#x9875;</label><button type="button" class="laypage_btn">&#x786e;&#x5b9a;</button></span>': ""
        } () + "</div>"
    },
    f.prototype.jump = function(a) {
        if (a) {
            for (var b = this,
            c = b.config,
            e = a.children,
            g = a[d]("button")[0], h = a[d]("input")[0], i = 0, j = e.length; j > i; i++)"a" === e[i].nodeName.toLowerCase() && f.on(e[i], "click",
            function() {
                var a = 0 | this.getAttribute("data-page");
                c.curr = a,
                b.render()
            });
            g && f.on(g, "click",
            function() {
                var a = 0 | h.value.replace(/\s|\D/g, "");
                a && a <= c.pages && (c.curr = a, b.render())
            })
        }
    },
    f.prototype.render = function(a) {
        var d = this,
        e = d.config,
        f = d.type(),
        g = d.view();
        2 === f ? e.cont.innerHTML = g: 3 === f ? e.cont.html(g) : b[c](e.cont).innerHTML = g,
        e.jump && e.jump(e, a),
        d.jump(b[c]("laypage_" + e.item)),
        e.hash && !a && (location.hash = "!" + e.hash + "=" + e.curr)
    },
    "function" == typeof define ? define(function() {
        return a
    }) : "undefined" != typeof exports ? module.exports = a: window.laypage = a
} ();

/* 自定义样式 */

var falg = false;
var da;
var pageIndex = 1;
var message = "";
// 执行自编js的进入后台分页查询方法的执行方法
// --url：查询的地址
// --index:查询的首页
function firstLoadData(url, indexs) {

    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        async: false,
        data: {
            'pageIndex': indexs
        },
        success: function(data) {

            da = data;

            // 解析分页信息

            laypage({
                cont: 'pageSystem',
                pages: data.pageUtil.pageCount,
                curr: indexs,
                skip: true,
                // 是否开启跳页
                skin: '#056DAA',
                // 皮肤
                groups: 4,
                jump: function(obj) {
                    $(".laypage_skip").css("width", "58px");
                    $(".laypage_skip").val(indexs);
                    $(".laypage_total").append("<a>共" + data.pageUtil.totolCount + "条数据/共" + data.pageUtil.pageCount + "页</a>");

                    // 第一次加载不执行
                    if (falg) {
                        firstLoadData1(url, obj.curr);

                    }
                    // 执行自己页面的js方法loadData（输出接收的map中的数据）
                    loadData(da.dataList);

                    falg = true;
                    $(".laypage_btn").text("跳到");
                    $(".laypage_btn").css("background-color", "#056DAA");
                    $(".laypage_btn").css("color", "#FFF");

                    if (data.pageUtil.pageCount == 1) {
                        var str = "<div style='float: right;' name='laypage1.3' class='laypage_main laypageskin_molv' id='laypage_0'><span class='laypage_curr'>1</span><span>共" + data.pageUtil.totolCount + "条数据/共" + data.pageUtil.pageCount + "页</spa></div>";
                        $("#pageSystem").append(str);
                    }

                }
                // 连续显示分页数
            })
        }
    });

}

function firstLoadData1(url, index) {

    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        async: false,
        data: {
            'pageIndex': index
        },
        success: function(data) {
            $(".laypage_skip").val(index);

            da = data;

            pageIndex = index;
            var Length = 0;
            for (var item in da.dataList) {

                Length++;

            }

            if (Length == 1) {
                pageIndex = pageIndex - 1;

                if (pageIndex <= 0) {
                    pageIndex = 1;
                }

            }

        }

    });

}