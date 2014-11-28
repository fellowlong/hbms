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
    <button class="btn btn-sm btn-primary" onclick="$('#workPanel').load('/resume/resumeAddView.do')">
      <i class="icon-plus align-top bigger-125"></i>
      新增
    </button>

    <button class="btn btn-sm btn-primary" onclick="">
      <i class="icon-edit align-top bigger-125"></i>
      编辑
    </button>
</p>

<table border="0" class="table table-striped table-bordered table-hover" style="margin: 0">
  <thead>
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
  <#list resumePagingResult.records as resume>
    <tr>
      <td><a href="#" onclick="$('#workPanel').load('/resume/findById.do?id=${resume.id}');">${resume.name}</a></td>
      <td>${resume.sex}</td>
      <td>${resume.age}</td>
      <td>${resume.education}</td>
      <td>${resume.workYears}</td>
      <td>${resume.location}</td>
      <td>${resume.industry}</td>
      <td>${resume.company}</td>
      <td>${resume.position}</td>
      <td>${resume.createUser}</td>
      <td>${resume.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
      <td>${resume.updateUser}</td>
      <td>${resume.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
    </tr>
  </#list>
  </tbody>
</table>
