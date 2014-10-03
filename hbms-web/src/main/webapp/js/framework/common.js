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
  $.messager.progress({title:'请等待', msg:'正在提交...'});
  $(options.form).form("submit",{
    url: getRandomUrl(contextPath + options.url),
    onSubmit: function(param){
      return $(options.form).form("validate");
    },
    success: function(message) {
      $.messager.progress('close');
      try{
        message =  $.parseJSON(message);
      }catch(exception){
        showHtmlMessage("错误", exception + "\n" + message);
      }
      if(showAjaxMessage(message)) {
        options.success();
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

