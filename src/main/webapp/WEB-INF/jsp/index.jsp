<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/weui.min.css">
</head>
<body>
<div class="page">
    <div class="page__bd" style="height: 100%;">
        <div class="weui-tab">
            <div class="weui-tab__panel">
                <div class="weui-grids" style="width: 100%;height: 100%;">
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_button.png" alt="">
                </div>
                <p class="weui-grid__label">
                Button
                </p>
                </a>
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_cell.png" alt="">
                </div>
                <p class="weui-grid__label">
                Cell
                </p>
                </a>
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_toast.png" alt="">
                </div>
                <p class="weui-grid__label">
                Toast
                </p>
                </a>
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_dialog.png" alt="">
                </div>
                <p class="weui-grid__label">
                Dialog
                </p>
                </a>
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_progress.png" alt="">
                </div>
                <p class="weui-grid__label">
                Progress
                </p>
                </a>
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_msg.png" alt="">
                </div>
                <p class="weui-grid__label">
                Msg
                </p>
                </a>
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_article.png" alt="">
                </div>
                <p class="weui-grid__label">
                Article
                </p>
                </a>
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_actionSheet.png" alt="">
                </div>
                <p class="weui-grid__label">
                ActionSheet
                </p>
                </a>
                <a href="javascript:;" class="weui-grid">
                <div class="weui-grid__icon">
                <img src="${pageContext.request.contextPath}/static/image/weui/icon_nav_icons.png" alt="">
                </div>
                <p class="weui-grid__label">
                Icons
                </p>
                </a>
                </div>
                <div class="weui-footer">
                <p class="weui-footer__text">Copyright &copy; 2008-2016 weui.io</p>
                </div>


            </div>
            <div class="weui-tabbar">
                <a href="javascript:;" class="weui-tabbar__item weui-bar__item_on">
                    <img src="${pageContext.request.contextPath}/static/image/weui/icon_tabbar.png" alt=""
                         class="weui-tabbar__icon">
                    <p class="weui-tabbar__label">微信</p>
                </a>
                <a href="javascript:;" class="weui-tabbar__item">
                    <img src="${pageContext.request.contextPath}/static/image/weui/icon_tabbar.png" alt=""
                         class="weui-tabbar__icon">
                    <p class="weui-tabbar__label">通讯录</p>
                </a>
                <a href="javascript:;" class="weui-tabbar__item">
                    <img src="${pageContext.request.contextPath}/static/image/weui/icon_tabbar.png" alt=""
                         class="weui-tabbar__icon">
                    <p class="weui-tabbar__label">发现</p>
                </a>
                <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx121fa5b05a57e1ba&redirect_uri=http://tis.waw.com.cn/ssm-web/wx/getWxUserInfo&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect" class="weui-tabbar__item">
                    <img src="${pageContext.request.contextPath}/static/image/weui/icon_tabbar.png" alt=""
                         class="weui-tabbar__icon">
                    <p class="weui-tabbar__label">我</p>
                </a>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
        $('.weui-tabbar__item').on('click', function () {
            $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
        });
    });
</script>
</body>
</html>
