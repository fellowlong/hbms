<div class="well">
  <div class="form-inline col-xs-11 h50">
    <div class="form-group">
      <label class="control-label textR w70" for="ipt_appList_sysName">系统：</label>
      <input type="text" class="w300 text" id="ipt_appList_sysName" name="uabSysName" value="" readonly="readonly" onclick="appJS.selectSys(this);">
      <input type="hidden" id="ipt_appList_sysNo" name="uabSysId" value="">
      <label class="control-label textR w70" for="keyword">关键字：</label>
      <input type="text" class="w300 text" id="keyword" name="keyword" value="" maxlength="2000" placeholder="应用名称/应用中文名/应用负责人">
    </div>
  </div>
  <div class="form-inline col-xs-1 textC vam h50">
    <button id="searchButton" class="btn btn-primary btn-sm" style="border-width: 2px;" type="button">
      <i class="icon-search"></i> 搜索
    </button>
  </div>
</div>

<p>
    <button class="btn btn-sm btn-primary" onclick="mainWorkPanelReload('/candidate/preInsertOrUpdate.do')">
      <i class="icon-plus align-top bigger-125"></i>
      新增
    </button>

    <button id="resumeEit" class="btn btn-sm btn-primary">
      <i class="icon-edit align-top bigger-125"></i>
      编辑
    </button>
</p>

<table id="resumeList" border="0" class="table table-striped table-bordered table-hover" style="margin: 0">
  <thead>
    <th class="center">
      <label>
        <input class="ace" type="checkbox">
        <span class="lbl"></span>
      </label>
    </th>
    <th>姓名</th>
    <th>性别</th>
    <th>年龄</th>
    <th>教育</th>
    <th>工作年限</th>
    <th>所在地</th>
    <th>行业</th>
    <th>公司</th>
    <th>职位</th>
    <th>创建人</th>
    <th>创建时间</th>
    <th>最后修改人</th>
    <th>最后修改时间</th>
  </thead>
  <tbody>
  <#list resumePagingResult.records as candidate>
    <tr>
      <td class="center">
        <label>
          <input class="ace" type="checkbox" value="${candidate.id}">
          <span class="lbl"></span>
        </label>
      </td>
      <td><a href="#" onclick="workPanel('/candidate/findById.do?id=${candidate.id}');">${candidate.name}</a></td>
      <td>${candidate.sex}</td>
      <td>${candidate.age}</td>
      <td>${candidate.education}</td>
      <td>${candidate.workYears}</td>
      <td>${candidate.location}</td>
      <td>${candidate.industry}</td>
      <td>${candidate.company}</td>
      <td>${candidate.position}</td>
      <td>${candidate.createUser}</td>
      <td>${candidate.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
      <td>${candidate.updateUser}</td>
      <td>${candidate.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
    </tr>
  </#list>
  </tbody>
</table>
<script>
  $('#resumeList th input:checkbox').on('click' , function(){
    var that = this;
    $('#resumeList').find('tr > td:first-child input:checkbox')
        .each(function(){
          this.checked = that.checked;
          $(this).closest('tr').toggleClass('selected');
        });
  });
  $("#resumeEit").on(ace.click_event, function() {
    var checkedItems = [];
    $('#resumeList').find('tr > td:first-child input:checkbox')
        .each(function(){
          if(this.checked) {
            checkedItems.push(this.value);
          }
        });
    if(checkedItems.length == 1) {
      mainWorkPanelReload('/candidate/preInsertOrUpdate.do?id=' + checkedItems[0] + '&view=/candidate/resumeEdit.ftl');
    } else {
      bootbox.dialog({
        message: "<span class='bigger-110'>请选择一条记录</span>",
        buttons: {
          "click" : {
            "label" : "关闭",
            "className" : "btn-sm btn-primary"
            }
          }
      });
    }
  });

</script>
