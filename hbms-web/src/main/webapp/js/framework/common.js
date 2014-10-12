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
    if(!selectedRows ||selectedRows.length != 1) {
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
  $(".mask-layer").destroy();
  var maxZIndex = getMaxZIndex();
  $("<div class='mask-layer'></div>").appendTo("body").css({"z-index" : maxZIndex});
  return maxZIndex;
}
function removeCoverLayer() {
  $(".mask-layer").destroy();
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

function postColumnFieldNames(param, dataGridId) {
  var columnFields = $('#' + dataGridId).datagrid('getColumnFields');
  var columnFieldNames = "";
  $.each(columnFields, function(i, item){
    columnFieldNames += (i > 0 ? "," : "") + item;
  })
  param.columnFields = columnFieldNames;
  return true;
}

function submitForm(options) {
  var defaults = {
    form:undefined,
    url:undefined,
    dataGridIds: [],
    successHandler:undefined
  };
  var setting = $.extend(defaults, options);

  $(setting.form).form("submit",{
    url: getRandomUrl(contextPath + options.url),
    onSubmit: function(param){
      var validResult = true;
      if(setting.onSubmit) {
        validResult = setting.onSubmit(param);
      }
      if(!($(setting.form).form("validate"))) {
        validResult = false;
      }
      for(var i = 0;setting.dataGrids && i < setting.dataGrids.length; i++) {
        var dataGrid = setting.dataGrids[i];
        var currentRows = $(dataGrid.id).datagrid("getRows");
        if ((!currentRows || currentRows.length == 0) && dataGrid.notEmpty) {
          validResult = false;
          break;
        }
        param[dataGrid.property] = [];
        var globalIndex = 0;
        var insertedRows = [];
        var updatedRows = [];
        var allRows = $(dataGrid.id).datagrid("getRows");
        for(var j = 0 ; allRows && j < allRows.length; j++) {
          if(allRows[j].crud && allRows[j].crud == "CREATE") {
            insertedRows.push(allRows[j]);
          } else if(allRows[j].crud && allRows[j].crud == "UPDATE") {
            updatedRows.push(allRows[j]);
          }
        }
        for(var j = 0;insertedRows && j < insertedRows.length; j++) {
          insertedRows[j].crud = "CREATE";
          param[dataGrid.property][globalIndex++] = insertedRows[j];
        }
        for(var j = 0;updatedRows && j < updatedRows.length; j++) {
          updatedRows[j].crud = "UPDATE";
          param[dataGrid.property][globalIndex++] = updatedRows[j];
        }
        var deletedRows = $(dataGrid.id).datagrid("getChanges", "deleted");
        for(var j = 0;deletedRows && j < deletedRows.length; j++) {
          deletedRows[j].crud = "DELETE";
          param[dataGrid.property][globalIndex++] = deletedRows[j];
        }
        $.each(param[dataGrid.property], function(index, row) {
          for(var key in row) {
            param[dataGrid.property + "[" + index + "]." + key] = row[key];
          }
        });
        param[dataGrid.property] = undefined;
      }
      if(validResult) {
        $.messager.progress({title: '请等待', msg: '正在提交...'});
      }
      return validResult;
    },
    success: function(message) {
      $.messager.progress('close');
      try{
        message =  $.parseJSON(message);
      }catch(exception){
        showHtmlMessage("错误", exception + "\n" + message);
      }
      if(setting.successHandler) {
        setting.successHandler(message);
      } else if(showAjaxMessage(message)) {
        setting.success(message);
      }
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      $.messager.progress('close');
      showHtmlMessage(textStatus, XMLHttpRequest.responseText);
    }
  });
}

function showWin(winId, title, width, height, closed, isDialog, isInWorkPanel) {
  var westWidth = 0,northHeight = 0;
  if(isInWorkPanel) {
    westWidth = $("#layout").layout("panel", "west").outerWidth();
    northHeight = $("#layout").layout("panel", "north").outerHeight();
  }
  var left = ($(document.body).width() - width)/2 - westWidth;
  var top = ($(document.body).height() - height)/2 - northHeight;
  var options = {
    title: title,
    width: width,
    height: height,
    left: left,
    top: top,
    closed: closed
  };
  if(isDialog) {
    $(winId).dialog(options);
  } else {
    $(winId).window(options);
  }
}

function dataGridEdit(options) {
  var defaults = {
    dataGridId:undefined,
    dataGridTbId:undefined,
    editWinId: undefined,
    editWinWidth:undefined,
    editWinHeight:undefined,
    editWinBaseTitle:undefined,
    editWinFormId: undefined,
    editWinTbId: undefined,
    add : undefined,
    edit : undefined,
    remove : undefined,
    view : undefined
  };
  var setting = $.extend(defaults, options);
  if(setting.dataGridInitData) {
    $(setting.dataGridId).datagrid(
      {
        onBeforeLoad:function(){
          $(setting.dataGridId).datagrid("loadData", setting.dataGridInitData());
          $(setting.dataGridId).datagrid("acceptChanges");
        }
      });
  }
  var editWinVisible = function(isDisplay, title) {
    showWin(
      setting.editWinId,
      (title ? setting.editWinBaseTitle + title : null),
      setting.editWinWidth,
      setting.editWinHeight,
      !isDisplay,
      true,
      true);
  }
  var editWinFormEnable = function(flag) {
    $.each($(setting.editWinFormId + " input[id^='field']"), function(index, component) {
      $(component).textbox(flag ? "enable" : "disable");
    });
    $(setting.editWinTbId + " a:first-child").linkbutton(flag ? "enable" : "disable");
  }

  $(setting.dataGridTbId + " a").unbind();
  $(setting.dataGridTbId + " a[type='add']").bind('click', function(event){
    $(setting.editWinFormId).form("clear");
    $(setting.editWinFormId + " input[name='operationType']").attr("value", "add");
    editWinVisible(true, "新增");
    editWinFormEnable(true);
  });
  $(setting.dataGridTbId + " a[type='edit']").bind('click', function(event){
    var row = $(setting.dataGridId).datagrid("getSelected")
    if(row == null) {
      $.messager.alert("提示", "请选择一条需要编辑的记录", "info");
    } else {
      $(setting.editWinFormId).form("load", row);
      $(setting.editWinFormId +" input[name='operationType']").attr("value", "edit");
      editWinVisible(true, "编辑");
      editWinFormEnable(true);
    }
  });
  $(setting.dataGridTbId + " a[type='remove']").bind('click', function(event){
    var row = $(setting.dataGridId).datagrid("getSelected")
    if(row == null) {
      $.messager.alert("提示", "请选择一条需要删除的记录", "info");
    } else {
      $.each($(setting.dataGridId).datagrid("getSelections"), function(index, row) {
        $(setting.dataGridId).datagrid("deleteRow",$(setting.dataGridId).datagrid("getRowIndex", row));
      });
    }
  });
  $(setting.dataGridTbId + " a[type='view']").bind('click', function(event){
    var row = $(setting.dataGridId).datagrid("getSelected");
    if(row == null) {
      $.messager.alert("提示", "请选择一条需要查看的记录", "info");
    } else {
      editWinFormEnable(false);
      editWinVisible(true, "查看");
    }
  });

  $(setting.editWinTbId + " a").unbind();
  $(setting.editWinTbId + " a[type='save']").bind('click', function(event){
    if(!$(setting.editWinFormId).form("validate")) {
      return;
    }
    var row = {};
    $.each($(setting.editWinFormId + " input"), function(index, item) {
      row[$(item).attr("name")] = $(item).attr("value");
    });
    var operationType = $(setting.editWinFormId + " input[name='operationType']").attr("value");
    if(operationType == "add") {
      row.crud = "CREATE";
      $(setting.dataGridId).datagrid("appendRow", row);
    } else if(operationType == "edit") {
      var oldRow = $(setting.dataGridId).datagrid("getSelected")
      var index = $(setting.dataGridId).datagrid("getRowIndex", oldRow);
      if(!oldRow.crud || oldRow.crud == "UPDATE") {
        row.crud = "UPDATE";
      }
      $(setting.dataGridId).datagrid("updateRow", {index:index,row:row});
    }
    editWinVisible(false);;
  });
  $(setting.editWinTbId + " a[type='cancel']").bind('click', function(event){
    $(setting.editWinId).dialog('close');
  });
}
