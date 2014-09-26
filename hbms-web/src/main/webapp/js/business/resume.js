/**
 * Created by fellowlong on 2014-08-12.
 */
$('#resumeDgTb a').unbind();
$('#resumeDgTb a').linkbutton();
$('#resumeDgTb a').bind('click', function(event){
  addOrEditOrDeleteOrViewRecord({
    dataGridId:"resumeDg",
    type: $(event.currentTarget).attr("type"),
    add : function(options){
//      enableResumeEditForm();
      $("#resumeEditForm").form("clear");
      $.parser.parse("#resumeEditForm");
      showResumeEditWin("新增简历", false);
    },
    edit : function(options, row) {
      enableResumeEditForm();
      $("#resumeEditForm").form("clear");
      $("#resumeEditForm").form("load", row);
      showResumeEditWin("修改简历：" + row.name, false);
    },
    removeUrl : '/resume/deleteById.do',
    removePromptField : ["name"],
    deleteSuccess : function(){
      $('#resumeDg').datagrid('reload');
    },
    view : function(options, row) {
      $("#resumeEditForm").form("clear");
      $("#resumeEditForm").form("load", row);
      disableResumeEditForm();
      showResumeEditWin("查看简历：" + row.name, false);
    }
  });
});

function showResumeEditWin(title, closed, maxZIndex) {
  var width = 300, height = 230;
  var westWidth = $("#layout").layout("panel", "west").outerWidth();
  var northHeight = $("#layout").layout("panel", "north").outerHeight();
  var left = ($(document.body).width() - width)/2 - westWidth;
  var top = ($(document.body).height() - height)/2 - northHeight;
  $("#resumeEditWin").dialog({
    title: title,
    width: width,
    height: height,
    left: left,
    top: top,
    closed: closed
  });
}

function insertOrUpdateResume() {
  $("#resumeEditForm").form("submit",{
    url: getRandomUrl(contextPath + "/resume/insertOrUpdate.do"),
    onSubmit: function(param){
      return $("#resumeEditForm").form("validate");
    },
    success: function(message) {
      try{
        message =  $.parseJSON(message);
      }catch(exception){
        showHtmlMessage("错误", exception + "\n" + message);
      }
      if(showAjaxMessage(message)) {
        $('#resumeEditWin').dialog({closed:true});
        $("#resumeDg").datagrid("reload");
      }
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      showHtmlMessage(textStatus, XMLHttpRequest.responseText);
    }
  });
}

function enableResumeEditForm() {
  $("#resumeEditForm input").removeAttr("disabled");
  $("#resumeEditForm .easyui-combobox").combo("enable");
  $("#resumeEditTb a[type=add]").linkbutton("enable");
}
function disableResumeEditForm() {
  $("#resumeEditForm input").attr("disabled", true);
  $("#resumeEditForm .easyui-combobox").combo("disable");
  $("#resumeEditTb a[type=add]").linkbutton("disable");
}
