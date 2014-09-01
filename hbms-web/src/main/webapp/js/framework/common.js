/**
 * User: fellowlong
 * Date: 7/11/12
 * Time: 11:42 AM
 */

jQuery(document).ready(function(){
  $("body").append("<div id='messageWin'></div>");
});

var editAndDeleteBar = "<a href=\"javascript:void(0)\" type=\"edit\">编辑</a>&nbsp;<a href=\"javascript:void(0)\" type=\"delete\">删除</a>";

var viewAndEditAndDeleteBar = "<a href=\"javascript:void(0)\" type=\"view\">查看</a>&nbsp;" + editAndDeleteBar;

function editOrDeleteRow(dataGridId, rowIndex, field, value) {
  var event = event || window.event;
  if(event.srcElement.tagName == "A" && event.srcElement.type == "delete") {
    $("#" + dataGridId).datagrid("deleteRow", rowIndex);
  }
  if(event.srcElement.tagName == "A" && event.srcElement.type == "edit") {
    $("#" + dataGridId).datagrid("selectRow", rowIndex).datagrid("beginEdit", rowIndex);
  }
}

function editOrDeleteRecord(options) {
  var row = getRowByIndex(options.dataGridId, options.rowIndex);
  var event = event || window.event;
  if(event.srcElement.tagName == "A" && event.srcElement.type == "delete") {
    var promptText = "";
    if(options.deletePromptField) {
      if(options.deletePromptField instanceof Array) {
        for(i =0 ; i < options.deletePromptField.length; i++) {
          if(i > 0) {
            promptText += " ";
          }
          promptText += getValueFromJson(options.deletePromptField[i], row);
        }
      } else {
        promptText += getValueFromJson(options.deletePromptField, row);
      }
    }
    $.messager.confirm("警告", "真的要删除[" + promptText + "] ?", function(result) {
      if(result) {
        $.messager.progress({title : "Waiting"});
        var param = {};
        if(options.deleteParameter) {
          for(key in options.deleteParameter) {
            param[key] = getValueFromJson(options.deleteParameter[key], row);
          }
        } else {
          param.id = row.id;
        }
        jQuery.ajax(
          getRandomUrl(contextPath + options.deleteUrl),
          {
            data : param,
            success : function(message) {
              $.messager.progress('close');
              if(showAjaxMessage(message))  {
                options.deleteSuccessFunction(row);
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
  }
  if(window.event.srcElement.tagName == "A" && window.event.srcElement.type == "edit") {
    options.editFunction(row);
  }
  if(window.event.srcElement.tagName == "A" && window.event.srcElement.type == "view") {
    options.viewFunction(row);
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