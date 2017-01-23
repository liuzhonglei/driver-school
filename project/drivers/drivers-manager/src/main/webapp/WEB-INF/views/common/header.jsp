<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- start: Header -->
<div class="navbar" role="navigation">

    <div class="container-fluid">
        <%--侧边菜单切换--%>
        <%--<ul class="nav navbar-nav navbar-actions navbar-left">--%>
            <%--<li class="visible-md visible-lg"><a href="index.html#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>--%>
            <%--<li class="visible-xs visible-sm"><a href="index.html#" id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>--%>
        <%--</ul>--%>

        <form class="navbar-form navbar-left">
            <button type="submit" class="fa fa-search"></button>
            <input type="text" class="form-control" placeholder="Search..."></a>
        </form>
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >免费模板</a></div>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown visible-md visible-lg">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope-o"></i><span class="badge">0</span></a>
                <ul class="dropdown-menu"></ul>
            </li>
            <li class="dropdown visible-md visible-lg">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell-o"></i><span class="badge">0</span></a>
                <ul class="dropdown-menu"></ul>
            </li>
            <li class="dropdown visible-md visible-lg">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-gears"></i></a>
                <ul class="dropdown-menu update-menu" role="menu"></ul>
            </li>
            <li class="dropdown visible-md visible-lg">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <img class="user-avatar" src="assets/img/avatar.jpg" alt="user-mail">
                    ${pageContext.request.userPrincipal.name}
                </a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header">
                        <strong>Account</strong>
                    </li>
                    <li><a href="page-profile.html"><i class="fa fa-user"></i> Profile</a></li>
                    <li><a href="page-login.html"><i class="fa fa-wrench"></i> Settings</a></li>
                    <li><a href="page-invoice.html"><i class="fa fa-usd"></i> Payments <span class="label label-default">10</span></a></li>
                    <li><a href="gallery.html"><i class="fa fa-file"></i> File <span class="label label-primary">27</span></a></li>
                    <li class="divider"></li>
                    <li>
                        <form action="/logout" method="post" id = "logoutForm">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <a href="javascript:document.getElementById('logoutForm').submit();"><i class="fa fa-sign-out"></i> Logout</a>
                    </li>
                </ul>
            </li>
            <li><a href="index.html"><i class="fa fa-power-off"></i></a></li>
        </ul>

    </div>

</div>
<!-- end: Header -->
