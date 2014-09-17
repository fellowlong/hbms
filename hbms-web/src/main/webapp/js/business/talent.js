/**
 * Created by fellowlong on 2014-08-12.
 */
$("#talentList").datagrid({
  url:"/talent/list.do",
  pagination:true,
  title : "人才管理",
  singleSelect: false,
  fitColumns : true,
  toolbar:"#talentTb",
  ctrlSelect:true,
  columns:[[
    {field:'id',title:'选择',checkbox:true,align:'left'},
    {field:'idForView',title:'编号',align:'left', formatter: function(value,row,index){return row.id}},
    {field:'name',title:'名称',width:100,align:'left'},
    {field:'lastReportResume.name',title:'简历报告',width:100,align:'left'},
    {field:'lastOriginalResume.name',title:'原始简历',width:100,align:'left'},
    {field:'keyword',title:'关键字',width:100,align:'left'},
    {field:'updateUser',title:'最后修改人',width:100,align:'left'},
    {field:'updateTime',title:'最后修改时间',width:100,align:'left'}
  ]],
  onBeforeLoad : function(param) {
    var columnFields = $('#talentList').datagrid('getColumnFields');
    var columnFieldNames = "";
    $.each(columnFields, function(i, item){
      columnFieldNames += (i > 0 ? "," : "") + item;
    })
    param.columnFields = columnFieldNames;
    return true;
  },
  onLoadSuccess: function(){
    $('#talentTb a').linkbutton();
    createTalentEditWin("人才编辑", false);
  }
});

function createTalentEditWin(title, closed) {
  var width = 550, height = 450;
  var westWidth = $("#layout").layout("panel", "west").outerWidth();
  var northHeight = $("#layout").layout("panel", "north").outerHeight();
  var left = ($(document.body).width() - width)/2 - westWidth;
  var top = ($(document.body).height() - height)/2 - northHeight;
  $("#talentEditWin").dialog({
    title: title,
    width: width,
    height: height,
    left: left,
    top: top,
    closed: closed,
    cache: false,
    modal: false,
    inline : true,
    onOpen : function(){
      $("#talentEditTb a[type='save']").unbind();
      $("#talentEditTb a[type='save']").linkbutton({disabled : false});
      $("#talentEditTb a[type='save']").bind('click', function(event){
        $("#talentEditTb a[type='save']").linkbutton("disable");
      });
      $("#talentEditTb a[type='cancel']").unbind();
      $("#talentEditTb a[type='cancel']").linkbutton();
      $("#talentEditTb a[type='cancel']").bind('click', function(event){
        $("#talentEditWin").dialog({closed : true});
      });
    }
  });
}


