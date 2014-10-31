<!DOCTYPE html>
<html>
<head>
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <META HTTP-EQUIV="Expires" CONTENT="-1">
  <meta charset="utf-8">
  <title>HBMS</title>
  <link rel="stylesheet" href="/css/bootstrap/bootstrap.css"/>
  <link rel="stylesheet" href="/css/bootstrap/bootstrap-theme.css"/>
  <link rel="stylesheet" href="/assets/css/font-awesome.min.css" />
  <link rel="stylesheet" href="/assets/css/ace.min.css" />
  <link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />
  <link rel="stylesheet" href="/assets/css/ace-skins.min.css" />
</head>
<body >

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
          <li <#if authority_index == 1>class="active"></#if>>
            <a href="${authority.uri}">
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
</div>
</div>

<script src="/js/framework/jquery-2.1.1.js"></script>
<script src="/js/framework/bootstrap.js"></script>
<script src="/assets/js/ace-extra.min.js"></script>
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>

</body>
</html>