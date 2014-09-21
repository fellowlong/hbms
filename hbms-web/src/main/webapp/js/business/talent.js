/**
 * Created by fellowlong on 2014-08-12.
 */
$("#candidateDg").datagrid({
  url:"/candidate/list.do",
  pagination:true,
  title : "人才管理",
  singleSelect: false,
  fitColumns : true,
  toolbar:"#candidateDgTb",
  ctrlSelect:true,
  columns:[[
    {field:'id',title:'选择',checkbox:true,align:'left'},
    {field:'idForView',title:'编号',align:'left', formatter: function(value,row,index){return row.id}},
    {field:'name',title:'名称',width:100,align:'left'},
    {field:'lastReportResume.name',title:'简历报告',width:100,align:'left'},
    {field:'lastOriginalResume.name',title:'原始简历',width:100,align:'left'},
    {field:'keyword',title:'关键字',width:100,align:'left'},
    {field:'updateUser',title:'最后修改人',width:100,align:'left'},
    {field:'updateTime',title:'最后修改时间',width:100,align:'left'}
  ]],
  onBeforeLoad : function(param) {
    var columnFields = $('#candidateDg').datagrid('getColumnFields');
    var columnFieldNames = "";
    $.each(columnFields, function(i, item){
      columnFieldNames += (i > 0 ? "," : "") + item;
    })
    param.columnFields = columnFieldNames;
    return true;
  },
  onLoadSuccess: function(){
    initCandidateDgToolbarBtn();
    createCandidateEditWin("人才编辑", true);
  }
});

function initCandidateDgToolbarBtn() {
  $('#candidateDgTb a').unbind();
  $('#candidateDgTb a').linkbutton();
  $('#candidateDgTb a').bind('click', function(event){
    addOrEditOrDeleteOrViewRecord({
      dataGridId:"candidateDg",
      type: $(event.currentTarget).attr("type"),
      add : function(options){
        $("#candidateEditForm").form("clear");
        createCandidateEditWin("新增人才", false);
      },
      edit : function(options, row) {
        $("#candidateEditForm").form("load", row);
        createCandidateEditWin("修改人才：" + row.name, false);
      },
      removeUrl : '/candidate/deleteById.do',
      removePromptField : ["name"],
      deleteSuccess : function(){
        $('#candidateDg').datagrid('reload');
      }
    });
  });
}

function createCandidateEditWin(title, closed, maxZIndex) {
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
  $("#candidateEditTabs").tabs({
    width: width,
    height: height - 20
  }),
  initResumeReportDgAndOriginalResumeDgToolbarBtn();
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
  $('#originalResumeDgTb a').linkbutton();
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
