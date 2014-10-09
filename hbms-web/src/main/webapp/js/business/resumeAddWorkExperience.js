/**
 * Created by fellowlong on 2014/10/9.
 */
displayOrHiddenWorkExperienceEditWin(false);

function displayOrHiddenWorkExperienceEditWin(isDisplay, title) {
  var width = 300,height = 320,winId = "#workExperienceEditWin";
  showWin(winId, (title ? title : null), width, height, !isDisplay, true, true);
}

function addWorkExperience() {
  $("#workExperienceEditWin").form("clear");
  $("#workExperienceEditWin input[name='operationType']").attr("value", "add");
  displayOrHiddenWorkExperienceEditWin(true, "新增工作经历");
}

function deleteWorkExperience() {
  var row = $("#workExperienceDg").datagrid("getSelected")
  if(row == null) {
    $.messager.alert("提示", "请选择一条需要删除的记录", "info");
  } else {
    $.each($("#workExperienceDg").datagrid("getSelections"), function(index, row) {
      $("#workExperienceDg").datagrid("deleteRow",$("#workExperienceDg").datagrid("getRowIndex", row));
    });
  }
}

function editWorkExperience() {
  var row = $("#workExperienceDg").datagrid("getSelected")
  if(row == null) {
    $.messager.alert("提示", "请选择一条需要编辑的记录", "info");
  } else {
    $("#workExperienceEditWin").form("load", row);
    $("#workExperienceEditWin input[name='operationType']").attr("value", "edit");
    displayOrHiddenWorkExperienceEditWin(true, "编辑工作简历");
  }
}
function viewWorkExperience() {
  var row = $("#workExperienceDg").datagrid("getSelected");
  if(row == null) {
    $.messager.alert("提示", "请选择一条需要查看的记录", "info");
  } else {
    enableOrDisableWorkExperienceForm(false);
    displayOrHiddenWorkExperienceEditWin(true, "查看工作经历");
  }
}
function enableOrDisableWorkExperienceForm(isEnable) {
  $.each($("#workExperienceEditWin input[id^='field']"), function(index, component) {
    $(component).textbox(isEnable ? "enable" : "disable");
  });
  $("#workExperienceEditTb a:first-child").linkbutton(isEnable ? "enable" : "disable");
}

function saveWorkExperience() {
  if(!$("#workExperienceEditForm").form("validate")) {
    return;
  }
  var row = {};
  $.each($("#workExperienceEditForm input"), function(index, item) {
    row[$(item).attr("name")] = $(item).attr("value");
  });
  var operationType = $("#workExperienceEditWin input[name='operationType']").attr("value");
  if(operationType == "add") {
    $("#workExperienceDg").datagrid("appendRow", row);
  } else if(operationType == "edit") {
    var oldRow = $("#workExperienceDg").datagrid("getSelected")
    var index = $("#workExperienceDg").datagrid("getRowIndex", oldRow);
    $("#workExperienceDg").datagrid("updateRow", {index:index,row:row});
  }
  displayOrHiddenWorkExperienceEditWin(false);
}