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
  if($("#navTree").tree("isLeaf", node.target)) {
    $("#workPanel").empty();
    $.ajax(
      getRandomUrl(node.url),
      {
        success: function (data, textStatus, jqXHR) {
          $("#workPanel").html(data);
        },
        dataType: "html"
      });
  }
}