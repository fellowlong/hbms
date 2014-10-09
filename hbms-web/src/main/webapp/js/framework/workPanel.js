/**
 * User: fellowlong
 * Date: 3/7/13
 * Time: 1:45 PM
 */
var contextPath = "";

var workPanelFactoryConfig = [
  {
    name: "候选人管理",
    children: [
      {
        name: "候选人管理",
        url: contextPath + "/page/candidate.html"
      }
    ]
  },
  {
    name:"简历管理",
    children:[
        {
          name : "简历维护",
          url : contextPath + "/page/resume/resumeList.html"
        },
        {
          name : "简历入库",
          url : contextPath + "/page/resume/resumeAdd.html"
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
    name: "基础资料",
    children:
      [
        {
          name : "下拉列表",
          url : contextPath + "/page/listItem.html"
        }
      ]
  }
];

$(document).ready(function () {
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
  $("#workPanel").panel("clear");
  if($("#navTree").tree("isLeaf", node.target)) {
    $("#workPanel").panel('refresh',node.url);
    var title = $("#navTree").tree("getParent", node.target).text + "<img src='/css/ui/easyui/icons/right2.png' width='40' height='20' style='vertical-align: middle'>" + node.text;
    $("#layout").layout("panel", "center").panel("setTitle", title);
  }
}