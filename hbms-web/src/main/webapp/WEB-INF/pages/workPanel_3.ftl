
<!DOCTYPE html>
<html>
<head>
  <title>Layout Example</title>
  <#--<link rel="stylesheet" href="/css/bootstrap/bootstrap.css"/>-->
  <#--<link rel="stylesheet" href="/css/bootstrap/bootstrap-theme.css"/>-->
  <#--<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />-->
  <#--<link rel="stylesheet" href="/assets/css/ace.min.css" />-->
  <#--<link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />-->
  <#--<link rel="stylesheet" href="/assets/css/ace-skins.min.css" />-->


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



<script src="/js/framework/jquery-2.1.1.js"></script>
<#--<script src="/js/framework/bootstrap.js"></script>-->
<#--<script src="/assets/js/ace-extra.min.js"></script>-->
<#--<script src="/assets/js/ace-elements.min.js"></script>-->
<#--<script src="/assets/js/ace.min.js"></script>-->
<script src="/js/framework/jquery.layout.js"></script>
<script src="/js/framework/jquery-ui.js"></script>

<script type="text/javascript">
  $(document).ready(function () {
    /*$('body').layout({
      //	reference only - these options are NOT required because 'true' is the default
      closable:					true	// pane can open & close
      ,	resizable:					true	// when open, pane can be resized
      ,	slidable:					true	// when closed, pane can 'slide' open over other panes - closes on mouse-out
      ,	livePaneResizing:			true

      //	some resizing/toggling settings
      ,	north__slidable:			false	// OVERRIDE the pane-default of 'slidable=true'
      ,	north__togglerLength_closed: '100%'	// toggle-button is full-width of resizer-bar
      ,	north__spacing_closed:		20		// big resizer-bar when open (zero height)
      ,	south__resizable:			false	// OVERRIDE the pane-default of 'resizable=true'
      ,	south__spacing_open:		0		// no resizer-bar when open (zero height)
      ,	south__spacing_closed:		20		// big resizer-bar when open (zero height)

      //	some pane-size settings
      ,	west__minSize:				100
      ,	east__size:					300
      ,	east__minSize:				200
      ,	east__maxSize:				.5 // 50% of layout width
      ,	center__minWidth:			100

      //	some pane animation settings
      ,	west__animatePaneSizing:	false
      ,	west__fxSpeed_size:			"fast"	// 'fast' animation when resizing west-pane
      ,	west__fxSpeed_open:			1000	// 1-second animation when opening west-pane
      ,	west__fxSettings_open:		{ easing: "easeOutBounce" } // 'bounce' effect when opening
      ,	west__fxName_close:			"none"	// NO animation when closing west-pane

      //	enable showOverflow on west-pane so CSS popups will overlap north pane
      ,	west__showOverflowOnHover:	true

      //	enable state management
      ,	stateManagement__enabled:	true // automatic cookie load & save enabled by default

      ,	showDebugMessages:			true // log and/or display messages from debugging & testing code
    });*/

    $('body').layout({
      applyDefaultStyles: true,
      north_slidable: true,
      north_resizable: true,
      west_slidable: true,
      west_resizable: true,
      south_slidable: true,
      south_resizable: true,
      east_slidable: true,
      east_resizable: true
    });
  });
</script>
</body>
</html>