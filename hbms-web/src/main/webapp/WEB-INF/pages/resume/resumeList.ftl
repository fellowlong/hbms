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
      <td><a href="/resume/findById.do?id=${resume.id}" target="_blank">${resume.name}</a></td>
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
