
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


</head>
<body>

<div class="ui-layout-north">

</div>

<div class="ui-layout-west" style="background-color: #f2f2f2;padding: 0px">
  <ul class="nav nav-list">
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
              <span class="menu-text">${authority.name}</span>
            </a>
          </li>
        </#list>
      </ul>
    </li>
  </#list>
  </ul>
</div>

<div class="ui-layout-center">
  <div id="workPanel"></div>
</div>



<script src="/js/framework/jquery-2.1.1.js"></script>
<script src="/js/framework/jquery-ui.js"></script>
<script src="/js/framework/bootstrap.js"></script>
<script src="/assets/js/ace-extra.min.js"></script>
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>
<script src="/js/framework/jquery.layout.js"></script>
<script src="/js/framework/validator/jquery.validator.js"></script>
<script src="/js/framework/validator/zh_CN.js"></script>

<script type="text/javascript">
  $(document).ready(function () {
    $('body').layout({
      slidable: true,
      resizable: true,
      livePaneResizing:true,
      north__size:50,
      west__size:200
    });

    $(".nav-list a").bind("click", function(eventObject) {
      $("#workPanel").empty();
      var url = $(eventObject.target).attr("url");
      if(url && url.length > 0) {
        $("#workPanel").html("<img src='/assets/css/images/loading.gif'>正在玩命加载...");
        $("#workPanel").load(url, {}, function(){
        });
      }
    });
  }
  );
</script>
</body>
</html>