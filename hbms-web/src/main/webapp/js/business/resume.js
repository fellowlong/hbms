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
      if($("#resumeTabs").tabs("getTab", "新增简历")) {
        $("#resumeTabs").tabs("select", "新增简历");
      } else {
        $("#resumeTabs").tabs("add", {
          title: '新增简历',
          href: '/page/candidate/resumeAdd.html',
          selected: true,
          closable:true
        });
      }
    },
    edit : function(options, row) {
      if($("#resumeTabs").tabs("getTab","编辑简历")){
        $("#resumeTabs").tabs("select", "编辑简历");
      } else {
        $("#resumeTabs").tabs(
          "add",
          {
            title: "编辑简历",
            href: "/page/candidate/resumeAdd.html",
            selected: true,
            closable:true
          });
      }
      $('#resumeBasicInfoForm').form('load', row);
      $('#workExperienceDg').datagrid("loadData", row.workExperiences ?  row.workExperiences : []);
      $('#educationExperienceDg').datagrid("loadData", row.educationExperiences ?  row.educationExperiences : []);
      $('#languageAbilityDg').datagrid("loadData", row.languageAbilities ?  row.languageAbilities : []);
      $('#certificateDg').datagrid("loadData", row.certificates ?  row.certificates : []);
      $('#projectExperienceDg').datagrid("loadData", row.projectExperiences ?  row.projectExperiences : []);
      },
    removeUrl : '/candidate/deleteByIds.do',
    removePromptField : ["name"],
    deleteSuccess : function(){
      $('#resumeDg').datagrid('reload');
    },
    view : function(options, row) {
      if($("#resumeTabs").tabs("getTab","查看简历")){
        $("#resumeTabs").tabs("select", "查看简历");
      } else {
        $("#resumeTabs").tabs(
          "add",
          {
            title: "查看简历",
            href: "/page/candidate/resumeAdd.html",
            selected: true,
            closable:true
          });
      }
      var panel = $("#resumeTabs").tabs("getTab", "查看简历");
      $('#resumeBasicInfoForm').form('load', row);
      $('#workExperienceDg').datagrid("loadData", row.workExperiences ?  row.workExperiences : []);
      $('#educationExperienceDg').datagrid("loadData", row.educationExperiences ?  row.educationExperiences : []);
      $('#languageAbilityDg').datagrid("loadData", row.languageAbilities ?  row.languageAbilities : []);
      $('#certificateDg').datagrid("loadData", row.certificates ?  row.certificates : []);
      $('#projectExperienceDg').datagrid("loadData", row.projectExperiences ?  row.projectExperiences : []);
      $.each($(panel).find("[id$='DgTb']"), function(index, item){
        $(item).find("a").linkbutton("disable");
      });
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
