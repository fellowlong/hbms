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



function insertOrUpdateResume() {
  var isNew = ($("#resumeEditForm input[name='id']").val() == null || $("#resumeEditForm input[name='id']").val().length == 0)
  submitForm({
    form:"#resumeBasicInfoForm",
    url:"/resume/insertOrUpdate.do",
    dataGrids:[
      {id:"#workExperienceDg",property:"workExperiences"},
      {id:"#educationExperienceDg",property:"educationExperiences"},
      {id:"#languageAbilityDg",property:"languageAbilities"},
      {id:"#certificateDg",property:"certificates"},
      {id:"#projectExperienceDg",property:"projectExperiences"}
    ],
    successHandler:function(message) {
      if(isNew && message.id && message.id != null) {
        $.messager.alert("新增简历成功", "新增简历成功，可以到简历维护列表中查看", "info")
      } else {
        $.messager.alert("新增简历失败", "请联系管理员", "error");
      }
    }
  });
}

