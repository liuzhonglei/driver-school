<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="keywords" content="驾校,驾驶员,培训,学车,练车,眉山驾校,彭州驾校" />
	<meta name="description" content="" />

	<!-- stylesheets css -->
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ctx}/css/animate.min.css" />
  	<link rel="stylesheet" href="${ctx}/css/et-line-font.css" />
	<link rel="stylesheet" href="${ctx}/css/font-awesome.min.css" />
  	<link rel="stylesheet" href="${ctx}/css/vegas.min.css" />
	<link rel="stylesheet" href="${ctx}/css/style.css" />
    <title>眉山市瑞达驾校</title>
</head>
<body id="app">

<!-- preloader section -->
<section class="preloader">
	<div class="sk-circle">
       <div class="sk-circle1 sk-child"></div>
       <div class="sk-circle2 sk-child"></div>
       <div class="sk-circle3 sk-child"></div>
       <div class="sk-circle4 sk-child"></div>
       <div class="sk-circle5 sk-child"></div>
       <div class="sk-circle6 sk-child"></div>
      <div class="sk-circle7 sk-child"></div>
       <div class="sk-circle8 sk-child"></div>
       <div class="sk-circle9 sk-child"></div>
       <div class="sk-circle10 sk-child"></div>
       <div class="sk-circle11 sk-child"></div>
       <div class="sk-circle12 sk-child"></div>
     </div>
</section>

<!-- home section -->
<section id="home">
	<div class="container">
		<div class="row">

			<div class="col-md-offset-2 col-md-8 col-sm-12">
				<div class="home-thumb">
					<h1 class="wow fadeInUp" data-wow-delay="0.4s">瑞达驾校欢迎您!</h1>
          			<h3 class="wow fadeInUp" data-wow-delay="0.6s">眉山市瑞达驾校,专业从事 <strong>驾驶员</strong> 培训 <strong>20余</strong> 年!</h3>
          			<%--<a href="#about" class="btn btn-lg btn-default smoothScroll wow fadeInUp hidden-xs" data-wow-delay="0.8s">详细信息</a>--%>
        			<%--<a href="#" data-toggle="modal" data-target="#modal1" class="btn btn-lg btn-success smoothScroll wow fadeInUp" data-wow-delay="1.0s">报名缴费</a>--%>
				</div>
			</div>

		</div>
	</div>		
</section>

<!-- about section -->
<section id="about">
	<div class="container">
		<div class="row">

      <div class="col-md-6 col-sm-12">
        <img src="${ctx}/images/school.jpg" class="img-responsive wow fadeInUp" alt="眉山瑞达" />
      </div>

			<div class="col-md-6 col-sm-12">
				<div class="about-thumb">
					<div class="section-title">
						<h1 class="wow fadeIn" data-wow-delay="0.2s">眉山市瑞达驾校</h1>
						<h3 class="wow fadeInUp" data-wow-delay="0.4s">专业从事驾驶员培训20余年</h3>
					</div>
					<div class="wow fadeInUp" data-wow-delay="0.6s">
						<p>
                            瑞达驾校(原交通驾校), 创建于一九八四年，隶属于北京市交通委员会所属市交通学校有机组成部分。承担眉山市交通学校在校学生驾驶实习培训任务，并且为社会人士考取驾照提供优质服务。瑞达驾校管理严谨，拥有严格的教学和管理制度，教练车每年受检，确保车况良好，利于学员学习。我校实行计时制培训，您可以随时安排预约训练与考试（训练期间驾校无休息日）。
                        </p>
						<p>报名电话：028-37623747</p>
					</div>
				</div>
			</div>

		</div>
	</div>
</section>


<!-- feature section -->
<section id="feature">
  <div class="container">
    <div class="row">
      
      <svg preserveAspectRatio="none" viewBox="0 0 100 102" height="100" width="100%" version="1.1" xmlns="http://www.w3.org/2000/svg" class="svgcolor-light">
        <path d="M0 0 L50 100 L100 0 Z"></path>
      </svg>

      <div class="col-md-4 col-sm-6">
        <div class="media wow fadeInUp" data-wow-delay="0.4s">
          <div class="media-object media-left">
            <i class="icon icon-laptop"></i>
          </div>
          <div class="media-body">
            <h2 class="media-heading">更快捷</h2>
            <p>我们提供更快捷服务！</p>
          </div>
        </div>
      </div>

      <div class="col-md-4 col-sm-6">
        <div class="media wow fadeInUp" data-wow-delay="0.8s">
          <div class="media-object media-left">
            <i class="icon icon-refresh"></i>
          </div>
          <div class="media-body">
            <h2 class="media-heading">更安全</h2>
            <p>我们提供更安全服务！</p>
          </div>
        </div>
      </div>

      <div class="col-md-4 col-sm-8">
        <div class="media wow fadeInUp" data-wow-delay="1.2s">
          <div class="media-object media-left">
            <i class="icon icon-chat"></i>
          </div>
          <div class="media-body">
            <h2 class="media-heading">更可靠</h2>
            <p>我们提供更可靠服务！</p>
          </div>
        </div>
      </div>

      <div class="clearfix text-center col-md-12 col-sm-12">
        <a href="#contact" class="btn btn-default smoothScroll">投诉建议</a>
      </div>

    </div>
  </div>
</section>

<!-- contact section -->
<section id="contact">
	<div class="container">
		<div class="row">

			<div class="col-md-offset-2 col-md-8 col-sm-12">
				<div class="section-title">
					<h1 class="wow fadeInUp" data-wow-delay="0.3s">投诉建议</h1>
					<p class="wow fadeInUp" data-wow-delay="0.6s">在使用过程中出现任何问题请反馈给我们，我们一定会及时解决，谢谢.</p>
				</div>
				<div class="contact-form wow fadeInUp" data-wow-delay="1.0s">
					<form id="contact-form">
                        <div class="col-md-6 col-sm-6">
                          	<input name="name" type="text" class="form-control" placeholder="姓名" v-model="req.content.name" required="required" />
                        </div>
                        <div class="col-md-6 col-sm-6">
                          	<input name="phone" type="text" class="form-control" placeholder="电话号码" v-model="req.content.mobile" required="required" />
                        </div>
           			  	<div class="col-md-12 col-sm-12">
				   			<textarea name="message" class="form-control" placeholder="内容" rows="6" v-model="req.content.content" required="required"></textarea>
           			  	</div>
						<div class="col-md-offset-3 col-md-6 col-sm-offset-2 col-sm-8">
							<input name="submit" type="submit" class="form-control submit" value="提交宝贵意见" v-on:click="submit($event)"/>
						</div>
					</form>
				</div>
			</div>
	
		</div>
	</div>
</section>

<div id="suggestion-modal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <p>谢谢你的宝贵意见！！！</p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- footer section -->

<footer>
	<div class="container">
		<div class="row">

      <svg class="svgcolor-light" preserveAspectRatio="none" viewBox="0 0 100 102" height="100" width="100%" version="1.1" xmlns="http://www.w3.org/2000/svg">
        <path d="M0 0 L50 100 L100 0 Z"></path>
      </svg>

      <div class="col-md-4 col-sm-6">
        <h2>comila</h2>
          <div class="wow fadeInUp" data-wow-delay="0.3s">
             <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque luctus lacus nulla, eget varius justo tristique ut. Etiam a tellus magna.</p>
             <p class="copyright-text">Copyright &copy; 2016 Your Company <br />
          </div>
      </div>

      <div class="col-md-1 col-sm-1"></div>

      <div class="col-md-4 col-sm-5">
        <h2>地理位置</h2>
        <p class="wow fadeInUp" data-wow-delay="0.6s">
          四川省,<br/>
          眉山市 <br/>
          彭山
        </p>
        <ul class="social-icon">
          <li><a href="#" class="fa fa-facebook wow bounceIn" data-wow-delay="0.9s"></a></li>
          <li><a href="#" class="fa fa-twitter wow bounceIn" data-wow-delay="1.2s"></a></li>
          <li><a href="#" class="fa fa-behance wow bounceIn" data-wow-delay="1.4s"></a></li>
          <li><a href="#" class="fa fa-dribbble wow bounceIn" data-wow-delay="1.6s"></a></li>
        </ul>
      </div>

		</div>
	</div>
</footer>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">眉山市瑞达驾校</a></div>
<!-- modal -->
<%--<div class="modal fade" id="modal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
  <%--<div class="modal-dialog">--%>
      <%--<div class="modal-content modal-popup">--%>
        <%--<div class="modal-header">--%>
          <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
          <%--<h2 class="modal-title">眉山瑞达驾校学费</h2>--%>
            <%--<h4 class="modal-title">2000元</h4>--%>
        <%--</div>--%>
        <%--<form>--%>
          <%--<input name="fullname" type="text" class="form-control" id="fullname" placeholder="姓名" v-model="pay.content.username"/>--%>
          <%--<input name="email" type="text" class="form-control" id="email" placeholder="电话号码" v-model="pay.content.mobile"/>--%>
          <%--<input name="submit" type="submit" class="form-control" id="submit" value="确认支付" v-on:click="apply($event)"/>--%>
        <%--</form>--%>
        <%--<p>感谢您的信任!</p>--%>
      <%--</div>--%>
  <%--</div>--%>
<%--</div>--%>


<!-- Back top -->
<a href="#back-top" class="go-top"><i class="fa fa-angle-up"></i></a>

<!-- javscript js -->
<script src="${ctx}/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootbox.js/bootbox.js" type="text/javascript"></script>
<script src="${ctx}/js/vegas.min.js" type="text/javascript"></script>

<script src="${ctx}/js/wow.min.js" type="text/javascript"></script>
<script src="${ctx}/js/smoothscroll.js" type="text/javascript"></script>
<script src="${ctx}/js/custom.js" type="text/javascript"></script>

<script src="${ctx}/js/jweixin-1.0.0.js" type="text/javascript"></script>
<script src="${ctx}/js/weixin.js" type="text/javascript"></script>
<script src="${ctx}/plugins/vue/dist/vue.js" type="text/javascript"></script>
<script src="${ctx}/js/pay/SuggestionService.js" type="text/javascript"></script>
<script src="${ctx}/js/pay/suggestion.js" type="text/javascript"></script>

</body>
</html>