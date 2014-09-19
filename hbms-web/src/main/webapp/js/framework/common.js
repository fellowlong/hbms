/**
 * User: fellowlong
 * Date: 7/11/12
 * Time: 11:42 AM
 */

$.extend($.fn.validatebox.defaults.rules, {
  minLength: {
    validator: function(value, param){
      return value.length >= param[0];
    },
    message: 'Please enter at least {0} characters.'
  }
});

jQuery(document).ready(function(){
  $("body").append("<div id='messageWin'></div>");
});

function addOrEditOrDeleteOrViewRecord(options) {
  var defaults = {
    dataGridId:undefined,
    type: undefined,
    add : undefined,
    edit : undefined,
    remove : undefined,
    removeUrl : undefined,
    removeParameter : undefined,
    removePromptField : undefined,
    deleteSuccess : undefined,
    view : undefined
  };
  var setting = $.extend(defaults, options);
  var selectedRows = $("#" + setting.dataGridId).datagrid("getSelections");
  if(setting.type == "add" && setting.add) {
      setting.add(setting);
  } else if(setting.type == "remove"){
    if(!selectedRows || selectedRows.length == 0) {
      $.messager.alert('警告','请选择需要的记录！','warning');
      return;
    }
    var param = {};
    var promptText = "";
    for(var i = 0 ; i < selectedRows.length; i++) {
      var row = selectedRows[i];
      //删除参数
      if(setting.removeParameter) {
        for(var key in setting.removeParameter) {
          param[key] =  (param[key] ?  param[key] : "") + (i > 0 ? "," : "") + getValueFromJson(setting.removeParameter[key], row);
        }
      } else {
        param.id = (param.id ? param.id : "") + (i > 0 ? "," : "") + row.id;
      }
      //删除提示
      if(setting.removePromptField) {
        promptText += "<tr><td>";
        if(setting.removePromptField instanceof Array) {
          for(var j =0 ; j < setting.removePromptField.length; j++) {
            promptText += (j > 0 ? "," : "") + getValueFromJson(setting.removePromptField[j], row);
          }
        } else {
          promptText += getValueFromJson(setting.removePromptField, row);
        }
        promptText += "</td></tr>";
      }
    }
    promptText = "<table cellpadding='0' cellspacing='0' border='0'>" + promptText + "</table>"
    $.messager.confirm("警告", "真的要删除 ？ <br/>" + promptText, function(result) {
      if(result) {
        $.messager.progress({title : "Waiting"});
        jQuery.ajax(
          getRandomUrl(contextPath + setting.removeUrl),
          {
            data : param,
            success : function(message) {
              $.messager.progress('close');
              if(showAjaxMessage(message))  {
                setting.deleteSuccess(row);
              }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
              $.messager.progress('close');
              showHtmlMessage(textStatus, XMLHttpRequest.responseText);
            }
          }
        );
      }
    });
  } else if(setting.type == "edit" && setting.edit) {
    if(!selectedRows ||selectedRows.length != 1) {
      $.messager.alert('警告','请选择一条记录进行编辑！','warning');
      return;
    }
    setting.edit(setting, selectedRows[0]);
  } else if(setting.type == "view" && setting.view) {
    if(!selectedRows ||selectedRows.length > 1) {
      $.messager.alert('警告','请选择一条记录进行查看详情！','warning');
      return;
    }
    setting.view(setting, selectedRows[0]);
  } else {
    $.messager.alert('错误', setting.type + '，没有对应的处理器！','error');
  }
}

function getRandomUrl(url) {
    if(url && url.length > 0) {
        url += url.indexOf("?") > -1 ? "&" : "?";
        url += (Math.random() + "").replace("\.","") + "=" + new Date().getTime();
    }
    return url;
}

function getRowByIndex(dataGridId, rowIndex) {
  var row = undefined;
  $.each(jQuery("#" + dataGridId).datagrid("getRows"), function(index, item) {
    if(rowIndex == index) {
      row = item;
      return;
    }
  });
  return row;
}

function clone(obj) {
  var buf;
  if (obj instanceof Array) {
    buf = [];  //创建一个空的数组
    var i = obj.length;
    while (i--) {
      buf[i] = clone(obj[i]);
    }
    return buf;
  }else if (obj instanceof Object){
    buf = {};  //创建一个空对象
    for (var k in obj) {  //为这个对象添加新的属性
      buf[k] = clone(obj[k]);
    }
    return buf;
  }else{
    return obj;
  }
}

function showHtmlMessage(title, message) {
  $('#messageWin').window({
    title: title,
    width: 600,
    height: 500,
    closed: false,
    cache: false,
    content: "<pre>" + message + "</pre>",
    modal: true
  });
}

function showAjaxMessage(message){
  var errorMsg = undefined;
  if(message.errors)  {
    var i = 0;
    for(key in message.errors) {
      if(!errorMsg) {
        errorMsg = "";
      }
      if(i > 0) {
        errorMsg += "<br/>";
      }
      errorMsg += message.errors[key];
      i++;
    }
  }
  var warnMsg = undefined;
  if(message.warnings)  {
    var i = 0;
    for(key in message.warnings) {
      if(!warnMsg) {
        warnMsg = "";
      }
      if(i > 0) {
        warnMsg += "<br/>";
      }
      warnMsg += message.warnings[key];
      i++;
    }
  }
  var infoMsg = undefined;
  if(message.infos)  {
    if(message.infos.SUCCESS == true) {
      return true;
    }
    var i = 0;
    for(key in message.infos) {
      if(!infoMsg) {
        infoMsg = "";
      }
      if(i > 0) {
        infoMsg += "<br/>";
      }
      infoMsg += message.infos[key];
      i++;
    }
  }
  if(errorMsg) {
    if(errorMsg.length > 50) {
      showHtmlMessage("错误", errorMsg);
      return false;
    }
    jQuery.messager.alert("错误", errorMsg, "error");
    return false;
  } else if(warnMsg) {
    jQuery.messager.alert("警告", warnMsg, "warning");
    return true;
  } else if(infoMsg) {
    jQuery.messager.alert("信息", infoMsg, "info");
    return true;
  }
}

function getValueFromJson(name, json) {
  if(!name || !json) {
    return undefined;
  }
  if(name.indexOf(".") < 0) {
    return json[name];
  }
  var currentName = name.substring(0, name.indexOf("."));
  return getValueFromJson(name.substr(currentName.length + 1), json[currentName]);
}

function createCoverLayer() {
  $(".mask-layer").detach();
  var maxZIndex = getMaxZIndex();
  $("<div class='mask-layer'></div>").appendTo("body").css({"z-index" : maxZIndex});
  return maxZIndex;
}
function removeCoverLayer() {
  $(".mask-layer").detach();
}

function getMaxZIndex() {
  var maxZ = Math.max.apply(null, $.map($("*"), function (e, n) {
      var position = $(e).css("position");
      if (position == "absolute" || position == "relative" || position == "fixed")
        return parseInt($(e).css('z-index')) || 1;
    })
  );
  return maxZ;
}

function createListItemSelectWin(callback, listItem) {
  $("#listItemSelectWin").detach();
  $("<div id='listItemSelectWin'></div>").appendTo("body");
  $("<table cellspacing='0' cellpadding='0' width='600' align='center' valign='top'><tr><td width='50%' valign='top'><div id='listItemCategoryDgOfListItemSelectWin'></div></td><td width='50%' valign='top'><div id='listItemGdOfListItemSelectWin'></div></td></tr></table>").appendTo("#listItemSelectWin");
  $("#listItemCategoryDgOfListItemSelectWin").datagrid({
    url: '/listItem/findAllCategory.do',
    title : '类别',
    singleSelect: true,
    fitColumns : true,
    ctrlSelect:false,
//    pagination:true,
    pagePosition:"top",
    columns:[[
      {field:'id',align:'right'},
      {field:'value',title:'名称',width:100,align:'left'}
    ]],
    onBeforeLoad : function(param) {
      var columnFields = $('#listItemCategoryDgOfListItemSelectWin').datagrid('getColumnFields');
      var columnFieldNames = "";
      $.each(columnFields, function(i, item){
        columnFieldNames += (i > 0 ? "," : "") + item;
      })
      param.columnFields = columnFieldNames;
      return true;
    },
    onSelect:function(rowIndex, rowData) {
      $("#listItemGdOfListItemSelectWin").datagrid({
        title:'<b>' +rowData.value + "</b> &nbsp; 列表项",
        url: '/listItem/findByBean.do',
        queryParams:{typeId:rowData.id}
      });
    },
    onLoadSuccess:function(data) {
      $.each(data.rows, function(index, item) {
        if(item && listItem && item.id == listItem.typeId) {
          $("#listItemCategoryDgOfListItemSelectWin").datagrid("selectRow", index);
        }
      });
    }
  });
  $("#listItemGdOfListItemSelectWin").datagrid({
    url: null,
    title : '列表项',
    singleSelect: true,
    fitColumns : true,
    ctrlSelect:false,
    toolbar:"#listItemsOfCategoryTb",
//    pagination:true,
    pagePosition:"top",
    columns:[[
      {field:'id',align:'right',hidden:true},
      {field:'value',title:'项目',width:100,align:'left'}
    ]],
    data:[],
    onBeforeLoad : function(param) {
      var columnFields = $('#listItemGdOfListItemSelectWin').datagrid('getColumnFields');
      var columnFieldNames = "";
      $.each(columnFields, function(i, item){
        columnFieldNames += (i > 0 ? "," : "") + item;
      })
      param.columnFields = columnFieldNames;
      return true;
    },
    onLoadSuccess:function(data) {
      $.each(data.rows, function(index, item) {
        if(item && listItem && item.id == listItem.id) {
          $("#listItemGdOfListItemSelectWin").datagrid("selectRow", index);
        }
      });
    }
  });
  var width = 650, height = 380;
  var left = ($(document.body).width() - width)/2;
  var top = ($(document.body).height() - height)/2;
  $("#listItemSelectWin").dialog({
    title: "列表项选择",
    width: width,
    height: height,
    left: left,
    top: top,
    closed: false,
    cache: false,
    modal: false,
    inline : true,
    minimizable : true,
    maximizable : true,
    resizable : true,
    toolbar:[{
      text:'选择',
      iconCls:'icon-ok',
      handler:function(){
        var rowData = $("#listItemGdOfListItemSelectWin").datagrid("getSelected");
        if(!rowData) {
          $.messager.alert("错误", "请选择一个列表项", 'error')
          return;
        }
        callback(rowData);
        $("#listItemSelectWin").dialog("close");
        $("body").remove("#listItemSelectWin");
      }
    }]
  });

}