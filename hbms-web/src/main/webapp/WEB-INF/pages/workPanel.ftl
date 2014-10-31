<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>控制台 - Bootstrap后台管理系统模版Ace下载</title>
  <meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
  <meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!-- basic styles -->
  <link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="/assets/css/font-awesome.min.css" />

  <!--[if IE 7]>
  <link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css" />
  <![endif]-->

  <!-- page specific plugin styles -->

  <!-- ace styles -->

  <link rel="stylesheet" href="/assets/css/ace.min.css" />
  <link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />
  <link rel="stylesheet" href="/assets/css/ace-skins.min.css" />

  <!--[if lte IE 8]>
  <link rel="stylesheet" href="/assets/css/ace-ie.min.css" />
  <![endif]-->

  <!-- inline styles related to this page -->

  <!-- ace settings handler -->

  <script src="/assets/js/ace-extra.min.js"></script>

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

  <!--[if lt IE 9]>
  <script src="/assets/js/html5shiv.js"></script>
  <script src="/assets/js/respond.min.js"></script>
  <![endif]-->
</head>

<body>
<div class="navbar navbar-default" id="navbar">
<script type="text/javascript">
  try{ace.settings.check('navbar' , 'fixed')}catch(e){}
</script>

<div class="navbar-container" id="navbar-container">
<div class="navbar-header pull-left">
  <a href="#" class="navbar-brand">
    <small>
      <i class="icon-leaf"></i>
      ACE后台管理系统
    </small>
  </a><!-- /.brand -->
</div><!-- /.navbar-header -->

<div class="navbar-header pull-right" role="navigation">
<ul class="nav ace-nav">
<li class="grey">
  <a data-toggle="dropdown" class="dropdown-toggle" href="#">
    <i class="icon-tasks"></i>
    <span class="badge badge-grey">4</span>
  </a>

</li>

<li class="purple">
  <a data-toggle="dropdown" class="dropdown-toggle" href="#">
    <i class="icon-bell-alt icon-animated-bell"></i>
    <span class="badge badge-important">8</span>
  </a>

</li>

<li class="green">
  <a data-toggle="dropdown" class="dropdown-toggle" href="#">
    <i class="icon-envelope icon-animated-vertical"></i>
    <span class="badge badge-success">5</span>
  </a>

</li>

<li class="light-blue">
  <a data-toggle="dropdown" href="#" class="dropdown-toggle">
    <img class="nav-user-photo" src="/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
									Jason
								</span>

    <i class="icon-caret-down"></i>
  </a>

  <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
    <li>
      <a href="#">
        <i class="icon-cog"></i>
        设置
      </a>
    </li>

    <li>
      <a href="#">
        <i class="icon-user"></i>
        个人资料
      </a>
    </li>

    <li class="divider"></li>

    <li>
      <a href="#">
        <i class="icon-off"></i>
        退出
      </a>
    </li>
  </ul>
</li>
</ul><!-- /.ace-nav -->
</div><!-- /.navbar-header -->
</div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
<script type="text/javascript">
  try{ace.settings.check('main-container' , 'fixed')}catch(e){}
</script>

<div class="main-container-inner">
<a class="menu-toggler" id="menu-toggler" href="#">
  <span class="menu-text"></span>
</a>

<div class="sidebar" id="sidebar">
<script type="text/javascript">
  try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
</script>

<div class="sidebar-shortcuts" id="sidebar-shortcuts">
  <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
    <button class="btn btn-success">
      <i class="icon-signal"></i>
    </button>

    <button class="btn btn-info">
      <i class="icon-pencil"></i>
    </button>

    <button class="btn btn-warning">
      <i class="icon-group"></i>
    </button>

    <button class="btn btn-danger">
      <i class="icon-cogs"></i>
    </button>
  </div>

  <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
    <span class="btn btn-success"></span>

    <span class="btn btn-info"></span>

    <span class="btn btn-warning"></span>

    <span class="btn btn-danger"></span>
  </div>
</div><!-- #sidebar-shortcuts -->

<ul class="nav nav-list">
<li class="active">
  <a href="index.html">
    <i class="icon-dashboard"></i>
    <span class="menu-text"> 控制台 </span>
  </a>
</li>

<#list models as model>
  <li>
    <a href="#" class="dropdown-toggle">
      <i class="icon-list"></i>
      <span class="menu-text">${model.name}</span>
      <b class="arrow icon-angle-down"></b>
    </a>
    <ul class="submenu">
      <#list model.authorities as authority>
        <li <#if authority_index == 1>class="active"</#if>>
          <a href="#" url="${authority.uri}">
            <i class="icon-double-angle-right"></i>
            ${authority.name}
          </a>
        </li>
      </#list>
    </ul>
  </li>
</#list>



</ul><!-- /.nav-list -->

<div class="sidebar-collapse" id="sidebar-collapse">
  <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
</div>

<script type="text/javascript">
  try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
</script>
</div>

<div class="main-content">
<div class="breadcrumbs" id="breadcrumbs">
  <script type="text/javascript">
    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
  </script>

  <ul class="breadcrumb">
    <li>
      <i class="icon-home home-icon"></i>
      <a href="#">首页</a>
    </li>
    <li class="active">控制台</li>
  </ul><!-- .breadcrumb -->

  <div class="nav-search" id="nav-search">
    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
    </form>
  </div><!-- #nav-search -->
</div>

<div id="page-content" class="page-content">

</div><!-- /.page-content -->
</div><!-- /.main-content -->

<div class="ace-settings-container" id="ace-settings-container">
  <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
    <i class="icon-cog bigger-150"></i>
  </div>

  <div class="ace-settings-box" id="ace-settings-box">
    <div>
      <div class="pull-left">
        <select id="skin-colorpicker" class="hide">
          <option data-skin="default" value="#438EB9">#438EB9</option>
          <option data-skin="skin-1" value="#222A2D">#222A2D</option>
          <option data-skin="skin-2" value="#C6487E">#C6487E</option>
          <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
        </select>
      </div>
      <span>&nbsp; 选择皮肤</span>
    </div>

    <div>
      <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
      <label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
    </div>

    <div>
      <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
      <label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
    </div>

    <div>
      <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
      <label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
    </div>

    <div>
      <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
      <label class="lbl" for="ace-settings-rtl">切换到左边</label>
    </div>

    <div>
      <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
      <label class="lbl" for="ace-settings-add-container">
        切换窄屏
        <b></b>
      </label>
    </div>
  </div>
</div><!-- /#ace-settings-container -->
</div><!-- /.main-container-inner -->

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
  <i class="icon-double-angle-up icon-only bigger-110"></i>
</a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->

<#--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>-->

<!-- <![endif]-->

<!--[if IE]>
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>-->
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
  window.jQuery || document.write("<script src='/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
  window.jQuery || document.write("<script src='/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

<script type="text/javascript">
  if("ontouchend" in document) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="/assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="/assets/js/jquery.slimscroll.min.js"></script>
<script src="/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="/assets/js/jquery.sparkline.min.js"></script>
<script src="/assets/js/flot/jquery.flot.min.js"></script>
<script src="/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="/assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->

<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>
<script src="/js/framework/common.js"></script>
<style>
  .modal-backdrop, .modal-backdrop.fade.in {opacity: 0.2;filter: alpha(opacity=20);}
</style>
<script>

  function showWaiting(){
    if($("#winModal")[0]) {
      $("#winModal").addClass("in");
    } else {
      $("body").append("<div id='winModal' name='div_index_winModal' class='modal-backdrop fade in' style='z-index:9999'></div><div id='loadInfo' name='div_index_winModal'>请稍候...</div>");
    }
  }

  function hideWaiting(){
    $("div[name='div_index_winModal']").each(function(){
      $(this).remove();
    });
  }

  $(".nav-list a").bind("click", function(eventObject) {
    var url = $(eventObject.target).attr("url");
    if(url && url.length > 0) {
      createCoverLayer();
      $("#page-content").load(url, {}, function(){
        removeCoverLayer();
      });
    }

  });

</script>

<div class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <div class="modal-body">
        <p>One fine body&hellip;</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</body>
</html>

