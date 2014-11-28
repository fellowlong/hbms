<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Simple Layout Demo</title>

<link type="text/css" rel="stylesheet" href="/css/ui/layout/layout-default-latest.css" />


<!-- LAYOUT v 1.3.0 -->
<script type="text/javascript" src="/js/framework/jquery-2.1.1.js"></script>
<script type="text/javascript" src="/js/framework/jquery-ui.js"></script>
<script type="text/javascript" src="/js/framework/jquery.layout.js"></script>

<script type="text/javascript">


  var myLayout;

  $(document).ready(function () {

    // this layout could be created with NO OPTIONS - but showing some here just as a sample...
    // myLayout = $('body').layout(); -- syntax with No Options

    myLayout = $('body').layout({

      //	reference only - these options are NOT required because 'true' is the default
      closable:					true	// pane can open & close
      ,	resizable:					true	// when open, pane can be resized
      ,	slidable:					true	// when closed, pane can 'slide' open over other panes - closes on mouse-out
      ,	livePaneResizing:			true
    });
});
</script>


</head>
<body>

<!-- manually attach allowOverflow method to pane -->
<div class="ui-layout-north">

</div>

<!-- allowOverflow auto-attached by option: west__showOverflowOnHover = true -->
<div class="ui-layout-west">

</div>

<div class="ui-layout-south">
</div>

<div class="ui-layout-east">
</div>

<div class="ui-layout-center">
</div>

</body>
</html>