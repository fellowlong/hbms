/**
 * User: fellowlong
 * Date: 3/7/13
 * Time: 1:45 PM
 */
var contextPath = "";

var workPanelFactoryConfig = [
    {
      name: "配置管理",
      children:
      [
        {
          name : "全局配置管理",
          url : contextPath + "/page/talent.html"
        },
        {
          name : "环境管理",
          url : contextPath + "/pages/environmentManage.html"
        },
        {
          name : "Destination管理",
          url : contextPath + "/pages/destinationManage.html"
        },
        {
          name : "应用管理",
          url :contextPath + "/pages/appManage.html"
        },
        {
          name : "过滤器管理",
          url :contextPath + "/pages/filterManage.html"
        },
        {
          name : "生产者管理",
          url : contextPath + "/pages/messageManage.html"
        },
        {
          name : "消费者管理",
          url : contextPath + "/pages/consumerManage.html"
        }
      ]
    },
    {
      name: "监听管理",
      children:
      [
        {
          name : "Service管理",
          url : contextPath + "/pages/listenerServiceManage.html"
        },
        {
          name : "监听配置",
          url : contextPath + "/pages/listenerManage.html"
        }
      ]
    },
    {
      name: "调度管理",
      children:
      [
        {
          name : "调度数据源管理",
          url : contextPath + "/pages/scheduleDataSourceManage.html"
        },
        {
          name : "调度类型管理",
          url : contextPath + "/pages/scheduleTaskTypeManage.html"
        },
        {
          name : "调度队列管理",
          url : contextPath + "/pages/scheduleQueueManage.html"
        }
      ]
    },
  {
    name: "查询机",
    children:
      [
        {
          name : "查询机",
          url : contextPath + "/pages/queryMachine.html"
        }
      ]
  }
];

jQuery(document).ready(function () {
  var navTreeData = [];
  $.each(workPanelFactoryConfig, function(moduleIndex, module){
    var children = [];
    $.each(module.children, function(funcIndex, func) {
      children.push({id: moduleIndex + "" + funcIndex, text: func.name, url: func.url});
    });
    navTreeData.push({id: moduleIndex, text:module.name, children:children});
  });
  $("#navTree").tree({
    animate:true,
    data: navTreeData,
    onSelect: openFuncPanel
  });
});

function openFuncPanel(node) {
  alert(node.url);
}

/*
jQuery(document).ready(function () {
  //创建功能菜单
  var menuPanelContent = "";
  $.each(workPanelFactoryConfig, function(outIndex, item) {
    var menuItemBundle = "";
    if (item.children && item.children.length > 0) {
      $.each(item.children, function (innerIndex, item) {
        menuItemBundle += "<div id=\"menuItem-" + outIndex + "-" + innerIndex + "\" " +
                               "url=\"" + item.url + "\" " +
                               "class=\"ui-selectable-item\">" + item.name + "</div>";
      });
      menuItemBundle = "<div id=\"menuItemBundle-" + outIndex + "\">" + menuItemBundle + "</div>"
    }
    //每个抽屉的标题
    menuPanelContent += "<h7>" + item.name + "</h7>";
    //每个抽屉的内容
    menuPanelContent += "<div style=\"margin: 0px;padding: 0px;\">" + menuItemBundle + "</div>";
  });
  $("#menuPanel").append(menuPanelContent);
  //创建布局
  $("body").layout({
    scrollToBookmarkOnLoad:true,
    defaults: {},
    livePaneResizing:true,
    north__closable:false,
    north__resizable:false,
    north__spacing_open:0,
    north__size:50,
    west__size:200,
    west__onresize:$.layout.callbacks.resizePaneAccordions
  });
  $("#menuPanel").accordion({
    heightStyle:	"fill",
    collapsible:false,
    active : 0,
    activate: function(event, ui ) {
      $("div[id^=menuItem] div").removeClass("ui-selected");
    }
  });

  $("div[id^=menuItemBundle]").selectable({
    selected:function(event, ui) {
      $("#workPanel").empty();
      $.ajax(
        getRandomUrl($(ui.selected).attr("url")),
        {
          success: function (data, textStatus, jqXHR) {
            $("#workPanel").html(data);
          },
          dataType: "html"
        });
    }

  });
  $("div[id^=menuItemBundle] div").hover(
    function() {
      $(this).addClass("ui-selecting")
    },
    function() {
      $(this).removeClass("ui-selecting")
    }
  );
});
*/