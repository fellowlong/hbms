/**
 * Created by fellowlong on 2014-08-12.
 */
function disableOrEnable(title, index) {
  var resumeId = $("#resumeEditForm input[name='id']").val();
  if(resumeId != null && resumeId.length > 0) {
    return;
  } else if(title != "基本信息") {
    $("#resumeEditTabs").tabs("disableTab", title);
  }
}

function loadResumeForEdit(row) {
  $("#resumeEditForm").form("clear");
  $("#resumeEditForm").form("load", row);
}

$('#workExperienceOfResumeDgTb a').unbind();
$('#workExperienceOfResumeDgTb a').linkbutton();
$('#workExperienceOfResumeDgTb a').bind('click', function(event){
  addOrEditOrDeleteOrViewRecord({
    dataGridId:"workExperienceOfResumeDg",
    type: $(event.currentTarget).attr("type"),
    add : function(options){
    },
    edit : function(options, row) {
    },
    remove : function(options, row) {
    },
    view : function(options, row) {
    }
  });
});



function insertOrUpdateResume(isNext) {
  var isNew = ($("#resumeEditForm input[name='id']").val() == null || $("#resumeEditForm input[name='id']").val().length == 0)
  var tabTitle = isNew ? "新增简历" : "编辑简历";
  submitForm({
    form:"#resumeEditForm",
    url:"/candidate/insertOrUpdate.do",
    successHandler:function(message) {
      if(isNew && message.id && message.id != null) {
        $.messager.alert("新增简历成功", "新增简历成功，请添加其他信息", "info")
        $("#resumeEditForm input[name='id']").val(message.id);
        var tabs = $("#resumeEditTabs").tabs("tabs");
        $.each(tabs, function(index, item) {
          $("#resumeEditTabs").tabs("enableTab", index);
        });
        if(isNext) {
          $("#resumeTabs").tabs("close", tabTitle);
        }
      } else {
        $.messager.alert("新增简历失败", "请联系管理员", "error");
      }
    }
  });
}