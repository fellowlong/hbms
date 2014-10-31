<div class="container" style="width:860px;border: 15 solid #ddd;">

<h1><b>基本信息</b></h1>
<table class="table table-bordered" style="width: 800px">
  <tr>
    <td align="right">姓名:</td>
    <td align="left">${resume.name}</td>
    <td align="right">性别</td>
    <td align="left">${resume.sex}</td>
    <td align="right">年龄</td>
    <td align="left">${resume.age}</td>
  </tr>
  <tr>
    <td align="right">教育背景</td>
    <td align="left">${resume.education}</td>
    <td align="right">婚姻状况</td>
    <td align="left">${resume.marital}</td>
    <td align="right">居住地</td>
    <td align="left">${resume.location}</td>
  </tr>
  <tr>
    <td align="right">电话</td>
    <td align="left">${resume.telephone}</td>
    <td align="right">邮箱</td>
    <td align="left">${resume.email}</td>
    <td align="right">工作年限</td>
    <td align="left">${resume.workYears}</td>
  </tr>
  <tr>
    <td align="right">行业</td>
    <td align="left">${resume.industry}</td>
    <td align="right">公司</td>
    <td align="left">${resume.company}</td>
    <td align="right">职位</td>
    <td align="left">${resume.position}</td>
  </tr>
  <tr>
    <td align="right">薪资</td>
    <td align="left">${resume.salary}</td>
    <td align="right">搜索关键字</td>
    <td align="left">${resume.keyword}</td>
    <td align="right">语言</td>
    <td align="left" colspan="2">${resume.language}</td>
  </tr>
</table>

<h1><b>工作经历</b></h1>
<table class="table table-bordered" style="width: 800px">
  <#list resume.workExperiences as workExperience>
    <tr>
      <td colspan="2">
        <label>${workExperience.startDate} - ${workExperience.endDate} ${workExperience.company} | ${workExperience.industry}</label>
      </td>
    </tr>
    <tr>
      <td width="50" align="right">职位</td>
      <td align="left">${workExperience.position}</td>
    </tr>
    <tr>
      <td width="50" align="right">职责</td>
      <td align="left">${workExperience.responsibility}</td>
    </tr>
  </#list>
</table>

<h1><b>教育经历</b></h1>
<table class="table table-bordered" style="width: 800px">
  <thead>
  <th>名称</th>
  <th>开始时间</th>
  <th>结束时间</th>
  <th>专业</th>
  <th>学历</th>
  <th>类型</th>
  </thead>
  <tbody>
  <#list resume.educationExperiences as educationExperience>
    <tr>
      <td>${educationExperience.school}</td>
      <td>${educationExperience.startDate}</td>
      <td>${educationExperience.endDate}</td>
      <td>${educationExperience.major}</td>
      <td>${educationExperience.degree}</td>
      <td>${educationExperience.type}</td>
    <tr>
  </#list>
  </tbody>
</table>


<h1><b>语言能力</b></h1>
<table class="table table-bordered" style="width: 800px">
  <thead>
    <th>名称</th>
    <th>读写能力</th>
    <th>听说能力</th>
  </thead>
  <tbody>
  <#list resume.languageAbilities as languageAbility>
    <tr>
      <td align="left">${languageAbility.name}</td>
      <td align="left">${languageAbility.readAndWrite}</td>
      <td align="left">${languageAbility.listenAndSpeaking}</td>
    <tr>
  </#list>
</table>

<h1><b>项目经历</b></h1>
<table class="table table-bordered" style="width: 800px">
  <#list resume.projectExperiences as projectExperience>
    <tr>
      <td colspan="6">
      <label>
        ${projectExperience.name} (${projectExperience.startDate} - ${projectExperience.endDate})
      </label>
      </td>
    </tr>
    <tr>
      <td width="90" align="right">项目描述</td><td align="left">${projectExperience.projectDescription}</td>
    </tr>
    <tr>
      <td width="90" align="right">项目职务</td><td align="left">${projectExperience.position}</td>
    </tr>
    <tr>
      <td width="90" align="right">项目职责</td><td align="left">${projectExperience.responsibility}</td>
    </tr>
  </#list>
</table>


<h1><b>证书</b></h1>
<table class="table table-bordered" style="width: 800px">
  <thead>
  <th>名称</th>
  <th>获得时间</th>
  </thead>
  <tbody>
  <#list resume.certificates as certificate>
  <tr>
    <td align="left">${certificate.name}</td>
    <td align="left">${certificate.acquireDate}</td>
  <tr>
  </#list>
</table>



<h1><b>个人评价</b></h1>
<table class="table table-bordered" style="width: 800px">
  <tr>
    <td>${resume.selfEvaluation}</td>
  </tr>
</table>

<h1><b>其他</b></h1>
<table class="table table-bordered" style="width: 800px">
  <tr>
    <td>${resume.other}</td>
  </tr>
</table>

</div>
