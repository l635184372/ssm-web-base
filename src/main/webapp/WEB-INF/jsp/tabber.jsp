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
    <a href="javascript:;" class="weui-tabbar__item">
        <img src="${pageContext.request.contextPath}/static/image/weui/icon_tabbar.png" alt=""
             class="weui-tabbar__icon">
        <p class="weui-tabbar__label">我</p>
    </a>
</div>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
        $('.weui-tabbar__item').on('click', function () {
            $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
        });
    });
</script>s