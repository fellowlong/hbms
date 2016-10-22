
<!DOCTYPE html>
<html>
<head>
  <title>Layout Example</title>
<link rel="stylesheet" href="/css/ui/layout/layout-default-latest.css" />
<link rel="stylesheet" href="/css/bootstrap/bootstrap.css"/>
<link rel="stylesheet" href="/css/bootstrap/bootstrap-theme.css"/>
<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="/assets/css/ace.min.css" />
<link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="/js/framework/validator/jquery.validator.css" />

<style>
  .header {
    background: #F6F6F6;
    padding: 0;
    margin: 0;
  }

</style>
</head>
<body>

<div class="ui-layout-north header" style="padding: 0px;margin: 0px;overflow: hidden;background: #F6F6F6">
</div>

<div class="ui-layout-west" style="background-color: #f2f2f2;padding: 0px">
  <ul id="navList" class="nav nav-list">
  <#list models as module>
    <li>
      <a href="#" class="dropdown-toggle">
        <i class="icon-list"></i>
        <span class="menu-text">${module.name}</span>
        <b class="arrow icon-angle-down"></b>
      </a>
      <ul class="submenu">
        <#list module.authorities as authority>
          <li>
            <a href="#" url="${authority.uri}">
              <i class="icon-double-angle-right"></i>
              ${authority.name}
            </a>
          </li>
        </#list>
      </ul>
    </li>
  </#list>
  </ul>
</div>

<div class="ui-layout-center">
  <div id="mainWorkPanel"></div>
</div>



<script src="/js/framework/jquery-2.1.1.js"></script>
<script src="/js/framework/jquery-ui.js"></script>
<script src="/js/framework/bootstrap.js"></script>
<script src="/assets/js/ace-extra.min.js"></script>
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>
<script src="/assets/js/bootbox.min.js"></script>
<script src="/js/framework/jquery.layout.js"></script>
<script src="/js/framework/validator/jquery.validator.js"></script>
<script src="/js/framework/validator/zh_CN.js"></script>
<script src="/js/framework/common.js"></script>

<script type="text/javascript">
  $(document).ready(function () {
    $('body').layout({
      slidable: true,
      resizable: true,
      livePaneResizing:true,
      north__slidable:false,
      north__resizable:false,
      north__livePaneResizing:false,
      north__closable:false,
      north__showOverflowOnHover:false,
      north__hideTogglerOnSlide:true,
      north__spacing_open:0,
      north__size:50,
      west__size:200
    });

    $("#navList ul li a").bind("click", function(eventObject) {
      $("#navList ul li").removeClass("active");
      $(eventObject.target).parent().addClass("active");
      mainWorkPanelReload($(eventObject.target).attr("url"));
    });
  }
  );
  function mainWorkPanelReload(url, parameter, callback) {
    workPanelReload("#mainWorkPanel", url, parameter, callback);
  }
</script>
</body>
</html>