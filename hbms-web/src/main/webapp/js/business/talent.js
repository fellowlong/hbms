/**
 * Created by fellowlong on 2014-08-12.
 */

$("#resumeList").datagrid({
  url:"/talent/list.do",
  pagination:true,
  title : "DestinationCode管理",
  singleSelect: true,
  fitColumns : true,
  columns:[[
    {field:'id',title:'编号',width:100},
    {field:'name',title:'名称',width:100},
    {field:'lastReportResume.name',title:'简历报告',width:100,align:'right'},
    {field:'lastOriginalResume.name',title:'原始简历',width:100,align:'right'},
    {field:'keyword',title:'关键字',width:100,align:'right'},
    {field:'updateUser',title:'最后修改人',width:100,align:'right'},
    {field:'updateTime',title:'最后修改时间',width:100,align:'right'}
  ]],
  onBeforeLoad : function(param) {
    var columnFields = $('#resumeList').datagrid('getColumnFields');
    var columnFieldNames = "";
    $.each(columnFields, function(i, item){
      columnFieldNames += (i > 0 ? "," : "") + item;
    })
    param.columnFields = columnFieldNames;
    return true;
  }
});


