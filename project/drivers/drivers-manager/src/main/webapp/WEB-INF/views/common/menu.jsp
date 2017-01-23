<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid content">
    <div class="row">
        <!-- start: Main Menu -->
        <div class="sidebar ">

            <div class="sidebar-collapse">
                <div class="sidebar-header t-center">
                    <span><img class="text-logo" src="${ctx}/upload/logo/logo.jpg" class="img-circle"></span>
                </div>
                <div class="sidebar-menu">
                    <ul class="nav nav-sidebar">
                        <li><a href="${ctx}/index.html"><i class="fa fa-laptop"></i><span class="text"> 工作台</span></a></li>
                        <li>
                            <a href="#"><i class="fa fa-car"></i><span class="text"> 驾校管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="${ctx}/school.html"><i class="fa fa-car"></i><span class="text"> 驾校信息管理</span></a></li>
                                <li><a href="${ctx}/schooltuition.html"><i class="fa fa-heart-o"></i><span class="text"> 学费管理</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-user-md"></i><span class="text"> 教练管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="${ctx}/coach.html"><i class="fa fa-user"></i><span class="text"> 教练信息</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-user-md"></i><span class="text"> 车辆管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="${ctx}/car.html"><i class="fa fa-user"></i><span class="text"> 车辆信息</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users"></i><span class="text"> 学员管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="${ctx}/cadet.html"><i class="fa fa-user"></i><span class="text"> 学员信息管理</span></a></li>
                                <li><a href="${ctx}/cadetpay.html"><i class="fa fa-envelope"></i><span class="text"> 学员缴费信息管理</span></a></li>
                                <li><a href="${ctx}/cadetcourse.html"><i class="fa fa-envelope"></i><span class="text"> 学员课程管理</span></a></li>
                            </ul>
                        </li>
                        <li><a href="${ctx}/order.html"><i class="fa fa-phone-square"></i><span class="text"> 订单管理</span></a></li>
                        <li><a href="${ctx}/suggestion.html"><i class="fa fa-phone-square"></i><span class="text"> 投诉建议管理</span></a></li>
                        <li>
                            <a href="#"><i class="fa fa-male"></i><span class="text"> 系统管理员</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="${ctx}/sysmanagers.html"><i class="fa fa-male"></i><span class="text"> 管理员信息</span></a></li>
                                <li><a href="${ctx}/register.html"><i class="fa fa-envelope"></i><span class="text"> 注册</span></a></li>
                                <li><a href="${ctx}/sysmanager.html"><i class="fa fa-heart-o"></i><span class="text"> 基本信息</span></a></li>
                                <li><a href="${ctx}/password.html"><i class="fa fa-envelope"></i><span class="text"> 修改密码</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o"></i><span class="text"> 统计信息</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="${ctx}/cadet_pay_statistics.html"><i class="fa fa-bar-chart-o"></i><span class="text"> 学员缴费金额统计</span></a></li>
                                <li><a href="${ctx}/cadet_num_statistics.html"><i class="fa fa-bar-chart-o"></i><span class="text"> 学员人数统计</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bell"></i><span class="text"> 微信公众号管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="${ctx}/wxInfo.html"><i class="fa fa-bell"></i><span class="text"> 公众号基本信息维护</span></a></li>
                                <li><a href="${ctx}/wxfans.html"><i class="fa fa-bell"></i><span class="text"> 公众号粉丝管理</span></a></li>
                                <li><a href="${ctx}/message.html"><i class="fa fa-bell"></i><span class="text"> 图文消息管理</span></a></li>
                                <li><a href="${ctx}/template.html"><i class="fa fa-bell"></i><span class="text"> 模板消息管理</span></a></li>
                                <li><a href="${ctx}/custome.html"><i class="fa fa-bell"></i><span class="text"> 客服管理</span></a></li>
                                <li><a href="${ctx}/shucai.html"><i class="fa fa-bell"></i><span class="text"> 素材管理</span></a></li>
                                <li><a href="${ctx}/menu.html"><i class="fa fa-bell"></i><span class="text"> 菜单管理</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bell"></i><span class="text"> 系统管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="${ctx}/log.html"><i class="fa fa-bell"></i><span class="text"> 用户访问日志</span></a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="sidebar-footer">

                <div class="sidebar-brand">
                    眉山瑞达
                </div>

                <ul class="sidebar-terms">
                    <li><a href="index.html">团队</a></li>
                    <li><a href="index.html">隐私 </a></li>
                    <li><a href="index.html">帮助</a></li>
                    <li><a href="index.html">关于</a></li>
                </ul>

                <div class="copyright text-center">
                    <small>欢迎 <i class="fa fa-coffee"></i> 访问 <a href="http://www.msrdjxx.com/" title="官网" target="_blank">眉山瑞达官网</a></small>
                </div>
            </div>

        </div>
        <!-- end: Main Menu -->
    </div>
</div>