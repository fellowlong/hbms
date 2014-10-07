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
          href: '/page/resume/resumeEdit.html',
          selected: true
        });
      }
     /* enableResumeEditForm();
      $("#resumeEditForm").form("clear");
      $.parser.parse("#resumeEditForm");
      $("#attachUriContainer").empty();
      $("#attachUriContainer").append("<input name=\"attachUri\" type=\"text\" style=\"width:200px\">");
      $('#attachUriContainer input').filebox({required:true,width:200,buttonText:'选择',prompt:'选择简历文件'});
      showResumeEditWin("新增简历", false);*/
    },
    edit : function(options, row) {
      $("#resumeTabs").tabs("add", {title:"New Resume", href:"page/resume/resumeEdit.html"});
     /* enableResumeEditForm();
      $("#resumeEditForm").form("clear");
      $('#resumeEditWin #candidateId').textbox('enable');
      $("#attachUriContainer").empty();
      $("#attachUriContainer").append("<input name=\"attachUri\" type=\"text\" style=\"width:200px\">");
      $('#attachUriContainer input').textbox({
        required: false,
        editable: false,
        width: 200,
        buttonText: '删除',
        buttonIcon: 'icon-remove',
        onClickButton: function () {
          $("#attachUriContainer").empty();
          $("#attachUriContainer").append("<input name=\"attachUri\" type=\"text\" style=\"width:200px\">")
          $('#attachUriContainer input').filebox({required: true, width: 200, buttonText: '选择', prompt: '选择简历文件'});
      }});
      $("#resumeEditForm").form("load", row);
      $('#resumeEditWin #candidateId').textbox('setValue', row.candidate.id).textbox('setText', row.candidate.name);
      showResumeEditWin("修改简历：" + row.name, false);*/
    },
    removeUrl : '/resume/deleteByIds.do',
    removePromptField : ["name"],
    deleteSuccess : function(){
      $('#resumeDg').datagrid('reload');
    },
    view : function(options, row) {
      $("#resumeEditForm").form("clear");
      $("#attachUriContainer").empty();
      $("#attachUriContainer").append("<input name=\"attachUri\" type=\"text\" style=\"width:200px\">");
      $('#attachUriContainer input').textbox({required: false, editable: false, width: 200});
      $("#resumeEditForm").form("load", row);
      $('#resumeEditWin #candidateId').textbox('setValue', row.candidate.id).textbox('setText', row.candidate.name);
      $('#resumeEditWin #candidateId').textbox('disable');
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
  submitForm({
    form:"#resumeEditForm",
    url:"/resume/insertOrUpdate.do",
    success:function() {
      $('#resumeEditWin').dialog({closed:true});
      $("#resumeDg").datagrid("reload");
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
