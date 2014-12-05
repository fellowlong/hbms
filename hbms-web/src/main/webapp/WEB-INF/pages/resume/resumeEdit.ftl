
<div class="row">
  <div class="col-sm-1">
    <div id="resumeEditNavList" class="list-group" style="position: fixed;z-index:999999;">
      <a href="#" class="list-group-item" url="/resume/preInsertOrUpdate.do?id=${resume.id}&view=/resume/resumeBasicInfoEdit.ftl">
        基本信息
      </a>
      <a href="#" class="list-group-item">
        工作经历
      </a>
      <a href="#" class="list-group-item active">
        教育经历
      </a>
      <a href="#" class="list-group-item">
        语言能力
      </a>
      <a href="#" class="list-group-item">
        项目经历
      </a>
      <a href="#" class="list-group-item">
        证书
      </a>
      <a href="#" class="list-group-item">
        个人评价
      </a>
      <a href="#" class="list-group-item">
        其他
      </a>
    </div>
  </div>
  <div class="col-sm-11">
    <div id="resumeEditWorkPanel"></div>
  </div>
</div>
<script>
  $("#resumeEditNavList a").bind("click", function(eventObject){
    $("#resumeEditNavList a").removeClass("active");
    $(eventObject.target).addClass("active");
    workPanelReload("#resumeEditWorkPanel", $(eventObject.target).attr("url"));
  });
  $("#resumeEditNavList a").first().trigger("click");
</script>