
<form id="resumeAddForm"
      method="post"
      enctype="multipart/form-data"
      action="/resume/insertOrUpdate.do"
      class="form-horizontal"
      role="form"
      autocomplete="off"
      data-validator-option="{theme:'yellow_right_effect',stopOnError:false, timely:true}">
  <table class="table table-bordered table-striped">
    <tr>
      <td align="right">姓名:</td>
      <td align="left">
        <input type="text" id="name" name="name" placeholder="姓名" data-rule="姓名:required;name"/>
      </td>
      <td align="right">性别</td>
      <td align="left">
        <label>
          <input name="sex" class="ace" type="radio">
          <span class="lbl">男</span>
        </label>
        <label>
          <input name="sex" class="ace" type="radio">
          <span class="lbl">女</span>
        </label>
      </td>
    </tr>
    <tr>
      <td align="right">年龄</td>
      <td align="left">
        <input type="text" id="age" name="age" placeholder="年龄" data-rule="年龄:required;age"/>
      </td>
      <td align="right">婚姻状况</td>
      <td align="left">
        <select class="form-control width-25" id="marital" name="marital">
          <option value="未婚">未婚</option>
          <option value="已婚">已婚</option>
          <option value="离异">离异</option>
        </select>
      </td>
    </tr>
    <tr>
      <td align="right">教育背景</td>
      <td align="left">
        <input type="text" id="education" name="education" placeholder="教育背景"/>
      </td>
      <td align="right">居住地</td>
      <td align="left">
        <input type="text" id="location" name="location" placeholder="居住地"/>
      </td>
    </tr>
    <tr>
      <td align="right">电话</td>
      <td align="left">
        <input type="text" id="telephone" name="telephone" placeholder="电话"/>
      </td>
      <td align="right">邮箱</td>
      <td align="left">
        <input type="text" name="tags" id="form-field-tags" value="" placeholder="邮箱"/>
      </td>
    </tr>
    <tr>
      <td align="right">工作年限</td>
      <td align="left">
        <input type="text" name="workYears" id="workYears" value="" placeholder="工作年限"/>
      </td>
      <td align="right">行业</td>
      <td align="left">
        <input type="text" name="industry" id="industry" value="" placeholder="行业"/>
      </td>
    </tr>
    <tr>
      <td align="right">目前公司</td>
      <td align="left">
        <input type="text" name="company" id="company" value="" placeholder="公司"/>
      </td>
      <td align="right">职位</td>
      <td align="left">
        <input type="text" name="position" id="position" value="" placeholder="职位"/>
      </td>
    </tr>
    <tr>
      <td align="right">薪资</td>
      <td align="left">
        <input type="text" name="salary" id="salary" value="" placeholder="薪资"/>
      </td>
      <td align="right">搜索关键字</td>
      <td align="left">
        <input type="text" name="keyword" id="keyword" value="" placeholder="搜索关键字"/>
      </td>
    </tr>
  </table>
  <div class="clearfix form-actions" align="center">
      <button class="btn btn-info" type="submit">
        <i class="icon-ok bigger-110"></i>
        保存
      </button>

      &nbsp; &nbsp; &nbsp;
      <button class="btn" type="reset">
        <i class="icon-undo bigger-110"></i>
        重置
      </button>
  </div>
</form>