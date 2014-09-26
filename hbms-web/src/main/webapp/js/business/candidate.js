/**
 * Created by fellowlong on 2014-08-12.
 */
$('#candidateDgTb a').unbind();
$('#candidateDgTb a').linkbutton();
$('#candidateDgTb a').bind('click', function(event){
  addOrEditOrDeleteOrViewRecord({
    dataGridId:"candidateDg",
    type: $(event.currentTarget).attr("type"),
    add : function(options){
      enableCandidateEditForm();
      $("#candidateEditForm").form("clear");
      showCandidateEditWin("新增候选人", false);
    },
    edit : function(options, row) {
      enableCandidateEditForm();
      $("#candidateEditForm").form("clear");
      $("#candidateEditForm").form("load", row);
      showCandidateEditWin("修改候选人：" + row.name, false);
    },
    removeUrl : '/candidate/deleteById.do',
    removePromptField : ["name"],
    deleteSuccess : function(){
      $('#candidateDg').datagrid('reload');
    },
    view : function(options, row) {
      $("#candidateEditForm").form("clear");
      $("#candidateEditForm").form("load", row);
      disableCandidateEditForm();
      showCandidateEditWin("查看候选人：" + row.name, false);
    }
  });
});

function showCandidateEditWin(title, closed, maxZIndex) {
  var width = 540, height = 370;
  var westWidth = $("#layout").layout("panel", "west").outerWidth();
  var northHeight = $("#layout").layout("panel", "north").outerHeight();
  var left = ($(document.body).width() - width)/2 - westWidth;
  var top = ($(document.body).height() - height)/2 - northHeight;
  $("#candidateEditWin").dialog({
    title: title,
    width: width,
    height: height,
    left: left,
    top: top,
    closed: closed
  });
}

function insertOrUpdateCandidate() {
  $("#candidateEditForm").form("submit",{
    url: getRandomUrl(contextPath + "/candidate/insertOrUpdate.do"),
    onSubmit: function(param){
      return $("#candidateEditForm").form("validate");
    },
    success: function(message) {
      try{
        message =  $.parseJSON(message);
      }catch(exception){
        showHtmlMessage("错误", exception + "\n" + message);
      }
      if(showAjaxMessage(message)) {
        $('#candidateEditWin').dialog({closed:true});
        $("#candidateDg").datagrid("reload");
      }
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      showHtmlMessage(textStatus, XMLHttpRequest.responseText);
    }
  });
}

function enableCandidateEditForm() {
  $("#candidateEditForm input").removeAttr("disabled");
  $("#candidateEditForm .easyui-combobox").combo("enable");
  $("#candidateEditTb a[type=add]").linkbutton("enable");
}
function disableCandidateEditForm() {
  $("#candidateEditForm input").attr("disabled", true);
  $("#candidateEditForm .easyui-combobox").combo("disable");
  $("#candidateEditTb a[type=add]").linkbutton("disable");
}


function initResumeReportDgAndOriginalResumeDgToolbarBtn() {
  $('#resumeReportDgTb a').unbind();
  $('#resumeReportDgTb a').linkbutton();
  $('#resumeReportDgTb a').bind('click', function(event){
    addOrEditOrDeleteOrViewRecord({
      dataGridId:"resumeReportDg",
      type: $(event.currentTarget).attr("type"),
      add : function(options){
        $("#resumeEditForm").form("clear");
        createResumeEditWin("新增简历报告", false, "resumeReportDg");
      },
      edit : function(options, row) {
        $("#resumeEditForm").form("load", row);
        createResumeEditWin("修改简历报告：" + row.name, false, "resumeReportDg");
      },
      removeUrl : '/resume/deleteById.do',
      removePromptField : ["name"],
      deleteSuccess : function(){
        $('#resumeReportDg').datagrid('reload');
      }
    });
  });
  $('#originalResumeDgTb a').unbind();
  $('#originalResumeDgTb a').bind('click', function(event){
    addOrEditOrDeleteOrViewRecord({
      dataGridId:"originalResumeDg",
      type: $(event.currentTarget).attr("type"),
      add : function(options){
        $("#resumeEditForm").form("clear");
        createResumeEditWin("新增原始简历", false);
      },
      edit : function(options, row) {
        $("#resumeEditForm").form("load", row);
        createResumeEditWin("修改原始简历：" + row.name, false);
      },
      removeUrl : '/resume/deleteById.do',
      removePromptField : ["name"],
      deleteSuccess : function(){
        $('#originalResumeDg').datagrid('reload');
      }
    });
  });
}

function createResumeEditWin(title, closed, dataGridId) {
  var width = 250, height = 210;
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
  $('#resumeEditTb a:first').unbind();
  $('#resumeEditTb a:first').linkbutton();
  $('#resumeEditTb a:first').bind('click', function(event){
    insertOrUpdateResume(dataGridId);
  });
}

function insertOrUpdateResume(dataGridId) {
  $("#resumeEditForm").form("clear");
//  $("#" + dataGridId).datagrid("insertRow", );
  /*
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
        if(dataGridId == "") {
          $("#resumeDg").datagrid("reload");
        }
      }
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      showHtmlMessage(textStatus, XMLHttpRequest.responseText);
    }
  });*/
}
