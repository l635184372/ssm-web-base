<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/27
  Time: 13:25
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
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">微信名：</label></div>
                <div class="weui-cell__bd">
                    <label class="weui-label">${wxUserInfo.nickname}</label>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">性别</label></div>
                <div class="weui-cell__bd">
                    <label class="weui-label">
                        <c:if test="${wxUserInfo.sex == 1}">
                            男
                        </c:if>
                        <c:if test="${wxUserInfo.sex == 0}">
                            女
                        </c:if>
                    </label>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">地址</label></div>
                <div class="weui-cell__bd">
                    <label>${wxUserInfo.country}、${wxUserInfo.province}、${wxUserInfo.city}</label>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">openId</label></div>
                <div class="weui-cell__bd">
                    <label>${wxUserInfo.openid}</label>
                </div>
            </div>
        </div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips">确定</a>
        </div>
    </div>
</div>
</body>
</html>
