<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-Cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Document</title>
</head>
<style>
    body{
        font-size:12px
    }
</style>
<body style="width: 50%;margin: 0 25%;">
<script type="text/javascript">
    var write_sceen_time = (+new Date());
</script>
<div>
    <div>
        <div>
            <div>
                <h2>
                    公安部预约平台考试预约流程！
                </h2>
                <div>
                    <em >2017-02-14</em>
                    <a href="http://www.msrdjxx.com/">眉山市瑞达驾校</a>
                    <span>眉山市瑞达驾校</span>
                </div>
                <div>
                    <p><span style="font-family: 微软雅黑; font-size: 13px;">驾驶人考试预约系统，将全国统一采用公安部预约平台：</span><span style="font-family: 微软雅黑; color:rgb(0, 0, 255);font-size: 13px;">http//:sc122.gov.cn/</span><br></p>
                    <p><span style=";font-family:微软雅黑;font-size:13px">交通安全综合服务管理平台。</span></p>
                    <p style="margin-top:0;margin-right:0;margin-bottom:0;margin-left:0;text-indent:0;padding:0 0 0 0 ;line-height:23px;background:rgb(255,255,255)"><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-weight: bold;font-size: 13px">预约模式：</span><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px">按照公布的机动车驾驶人考试计划，用户可以自主选择考试场地、考试时间、考试场次提出考试预约申请。在停止接受考试预约申请前，用户可以在互联网办理取消预约。在预约结果公布时间当天，该考试计划将在互联网上截止预约，系统应按照以下规则安排考试：</span>
                    </p>
                    <p style="margin-top:0;margin-right:0;margin-bottom:0;margin-left:0;text-indent:0;padding:0 0 0 0 ;line-height:23px;background:rgb(255,255,255)"><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、首次预约科目一考试的，以受理用户初次申领机动车驾驶证等业务的时间为排序时间；</span>
                    </p>
                    <p style="margin-top:0;margin-right:0;margin-bottom:0;margin-left:0;text-indent:0;padding:0 0 0 0 ;line-height:23px;background:rgb(255,255,255)"><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、非首次预约科目一考试的，以上次考试时间为排序时间；</span>
                    </p>
                    <p style="margin-top:0;margin-right:0;margin-bottom:0;margin-left:0;text-indent:0;padding:0 0 0 0 ;line-height:23px;background:rgb(255,255,255)"><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、考试预约成功的用户因自身原因取消预约的，以取消预约时间为排序时间；</span>
                    </p>
                    <p style="margin-top:0;margin-right:0;margin-bottom:0;margin-left:0;text-indent:0;padding:0 0 0 0 ;line-height:23px;background:rgb(255,255,255)"><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、同时符合第二项、第三项情形的，以最近时间为排序时间。</span>
                    </p>
                    <p style="margin-top:0;margin-right:0;margin-bottom:0;margin-left:0;text-indent:0;padding:0 0 0 0 ;line-height:23px;background:rgb(255,255,255)"><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px">排名在前面的优先安排考试。系统安排完毕后，将在互联网反馈公示预约结果。</span>
                    </p>
                    <p style="margin-top:0;margin-right:0;margin-bottom:0;margin-left:0;text-indent:0;padding:0 0 0 0 ;line-height:23px;background:rgb(255,255,255)"><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px">用户在互联网登录后，点击【驾驶证业务】→【考试预约】业务功能办理。</span>
                    </p>
                    <p><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px;background: rgb(255, 255, 255)">考试预约申请</span><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px;background: rgb(255, 255, 255)">提交成功后，系统生成业务流水号，用户根据该业务流水号可以在网办进度中查询该流水的预约受理状态。系统将在预约结果公示时间当天安排考试，并在首页热点公布栏目下的</span>
                        <span
                                style="font-family: 微软雅黑;color: rgb(0, 102, 204);letter-spacing: 0;font-size: 13px;background: rgb(255, 255, 255)">【驾驶人考试预约结果公布】</span><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px;background: rgb(255, 255, 255)">公布预约结果，同时将会发送短信告知您预约结果。</span>
                    </p>
                    <p><span style="font-family: 微软雅黑;color: rgb(62, 62, 62);letter-spacing: 0;font-size: 13px;background: rgb(255, 255, 255)">现将预约平台考试预约流程公布如下：</span>
                    </p>
                    <div>
                        <div>
                            <h5><i></i>考试预约</h5>
                        </div>
                        <p>用户初次申领机动车驾驶证或者申请增加大型客车（A1）、牵引车（A2）、城市公交车（A3）、中型客车（B1）、大型货车（B2）、小型汽车（C1）、小型自动挡汽车（C2）、残疾人专用小型自动挡载客汽车（C5）准驾车型，参加机动车驾驶人考试的，可以通过互联网平台办理考试预约。</p>
                        <p><b>普通预约模式：</b>按照公布的机动车驾驶人考试计划，用户可以自主选择考试场地/考试区域、考试时间、考试场次提出考试预约申请。在停止接受考试预约申请前，用户可以在互联网办理取消预约。在预约结果公布时间当天，该考试计划将在互联网上截止预约，系统应按照以下规则安排考试：</p>
                        <p>1、首次预约科目一考试的，以受理用户初次申领机动车驾驶证等业务的时间为排序时间；</p>
                        <p>2、非首次预约科目一考试的，以上次考试时间为排序时间；</p>
                        <p>3、考试预约成功的用户因自身原因取消预约的，以取消预约时间为排序时间；</p>
                        <p>4、同时符合第二项、第三项情形的，以最近时间为排序时间。</p>
                        <p>排名在前面的优先安排考试。系统安排完毕后，将在互联网反馈公示预约结果。</p>
                        <p><b>优先预约模式：</b>驾驶人考试优先预约业务仅针对申请人学习驾驶证明有效期不足6个月的，每个科目可以在互联网优先预约1次考试。学员优先预约时，按照公布的机动车驾驶人考试计划，用户可以自主选择考试场地、考试时间、考试场次提出考试预约申请。只要预约申请成功且学员不存在其他法规规定的不符合考试预约情形，就安排考试。</p>
                        <p>1、申请人预约成功后，不能在互联网取消预约，因故不能按照预约时间参加考试的，应当提前一日到车管所申请取消预约。</p>
                        <p>2、申请人需携带身份证明在预约的考场和时间参加考试，未按时参加考试的，判定该次考试不合格。</p>
                        <p>用户在互联网登录后，点击【驾驶证业务】→【考试预约】业务功能办理。</p>
                        <p><b>办理业务用户类型：</b>互联网注册的个人用户。</p>
                        <h5>♦ 业务流程及操作说明</h5>
                        <p><b>普通考试预约</b></p>
                        <p>【选择考试科目】→【业务须知】→【选择考试地点】→【选择考试场次】→【确认并提交】</p>
                        <p><b>优先考试预约</b></p>
                        <p>【选择考试科目】→【业务须知】→【选择考试地点】→【选择考试场次】→【确认并提交】</p>
                        <hr style="border:3 double #987cb9" width="100%" color="#987cb9" size="6">
                        <h5>&nbsp;普通考试预约流程</h5>
                        <p><b><span>步骤1：【选择考试科目】</span></a></b></p>
                        <p>在该步骤，会显示用户的基本信息，用户需选择预约科目，点击【开始普通预约】进入步骤2【业务须知】。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/normal-step1.png" style="width:75%;height:75%;">
                        </div>
                        <p><b><span>步骤2：【业务须知】</span></a></b></p>
                        <p>在该步骤，用户需阅读考试预约业务须知，在阅读完毕后，点击【阅读并同意】进入步骤3【选择考试地点】。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/normal-step2.png" style="width:75%;height:75%;">
                        </div>
                        <p ><b><span>步骤3：【选择考试地点】</span></a></b>
                        </p>
                        <p>在该步骤，用户需选择考试日期和考试区域，点击【下一步】进入步骤4【选择考试场次】。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/normal-step3.png" style="width:75%;height:75%;">
                        </div>
                        <p><b><span>步骤4：【选择考试场次】</span></a></b>
                        </p>
                        <p>界面会显示用户预约本科目的当前优先级排名。系统按照以下规则生成用户优先级排名：</p>
                        <p>1、首次预约科目一考试的，以受理用户初次申领机动车驾驶证等业务的时间为排序时间；</p>
                        <p>2、非首次预约科目一考试的，以上次考试时间为排序时间；</p>
                        <p>3、考试预约成功的用户因自身原因取消预约的，以取消预约时间为排序时间；</p>
                        <p>4、同时符合第二项、第三项情形的，以最近时间为排序时间。</p>
                        <p>该排名仅供参考，以最后的公示结果为准。</p>
                        <p>系统提供两种预约模式：自主选择考试场次，服从系统安排考试。如果选择自主选择考试场次的模式，系统会显示用户选中的预约申请起止时间段内的所有的考试场次列表，用户可以选择某一场次或者多个场次进行预约，选择完成后，点击【下一步】进入步骤5【确认并提交】，如下图所示。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/normal-step4.png" style="width:75%;height:75%;">
                        </div>
                        <p>如果选择服从系统安排考试的模式，系统会在用户选中的预约申请起止时间段内的自动匹配符合条件的考试场次，点击【下一步】进入步骤5【确认并提交】，如下图所示。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/normal-step4-1.png" style="width:75%;height:75%;">
                        </div>
                        <p><b><span>步骤5：【确认并提交】</span></a></b>
                        </p>
                        <p>该步骤显示用户的预约信息，再次确认信息以后，点击【获取验证码】，系统会发送6位验证码到用户绑定的手机，用户输入手机验证码后，点击【提交预约申请信息】完成考试预约。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/normal-step5.png" style="width:75%;height:75%;">
                        </div>
                        <h5>&nbsp;优先考试预约流程</h5>

                        <p><b><span>步骤1：【选择考试科目】</span></a></b>
                        </p>
                        <p>在该步骤，会显示用户的基本信息，用户需选择预约科目，对于满足优先考试预约条件的用户，点击【开始优先预约】进入步骤2【业务须知】。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/green-step1.png" style="width:75%;height:75%;">
                        </div>
                        <p><b><span>步骤2：【业务须知】</span></a></b>
                        </p>
                        <p>在该步骤，用户需阅读考试预约业务须知，在阅读完毕后，点击【阅读并同意】进入步骤3【选择考试地点】。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/green-step2.png" style="width:75%;height:75%;">
                        </div>
                        <p><b><span>步骤3：【选择考试地点】</span></a></b>
                        </p>
                        <p>在该步骤，用户需选择考试日期和考试区域，点击【下一步】进入步骤4【选择考试场次】。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/green-step3.png" style="width:75%;height:75%;">
                        </div>
                        <p><b><span>步骤4：【选择考试场次】</span></a></b>
                        </p>
                        <p>学员优先预约时，可以选择具有空余优先预约名额的考试场次进行预约。只要预约申请成功且学员不存在其他法规规定的不符合考试预约情形，就安排考试。</p>
                        <p>优先预约模式下，只提供自选模式，选择完成后，点击【下一步】进入步骤5【确认并提交】，如下图所示。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/green-step4.png" style="width:75%;height:75%;">
                        </div>
                        <p><b><span>步骤5：【确认并提交】</span></a></b>
                        </p>
                        <p>该步骤显示用户的预约信息，再次确认信息以后，点击【获取验证码】，系统会发送6位验证码到用户绑定的手机，用户输入手机验证码后，点击【提交预约申请信息】完成考试预约。</p>
                        <div style="text-align: center;">
                            <img src="${ctx}/images/document/green-step5.png" style="width:75%;height:75%;">
                        </div>
                        <h5><span>注意事项</span></a></h5>

                        <p>1、 申请预约考试前请认真阅读使用须知，了解在互联网预约考试的相关要求和责任。</p>
                        <p>2、 用户预约申请成功后，可以在网办进度中查询该预约的受理状态，如果预约成功，可打印预约凭证。</p>
                        <p>3、 系统将在预约结果公示时间当天安排考试，用户可以通过网办进度、驾驶人考试预约结果公布、短信及时获取预约结果。</p>
                    </div>
                    <p>
                    <p><span style=";font-family:微软雅黑;font-size:12px">预约申请提交成功，注意查看预约结果公布日期。</span>
                    </p>
                    <p><span style="font-family:微软雅黑"><span style="font-size: 12px; line-height: 20.3636px;"><br>&nbsp; &nbsp; &nbsp; 各位不用担心，准备考试的，不准备考试的宝宝们都抓紧时间注册登录试试，看看手机号码是否能接收验证码，不能的话，及时告知我们。有任何不懂的、不明白的、不清楚的可以电话咨询，微信咨询，或者到办公室咨询。咨询电话：028-37623747。</span></span>
                    </p>
                    <p><span style="font-family:微软雅黑"><span style="font-size: 12px; line-height: 20.3636px;"><br></span></span>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>