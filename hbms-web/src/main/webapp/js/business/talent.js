/**
 * Created by fellowlong on 2014-08-12.
 */
$("#talentDg").datagrid({
  url:"/talent/list.do",
  pagination:true,
  title : "人才管理",
  singleSelect: false,
  fitColumns : true,
  toolbar:"#talentDgTb",
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
    var columnFields = $('#talentDg').datagrid('getColumnFields');
    var columnFieldNames = "";
    $.each(columnFields, function(i, item){
      columnFieldNames += (i > 0 ? "," : "") + item;
    })
    param.columnFields = columnFieldNames;
    return true;
  },
  onLoadSuccess: function(){
    initTalentDgToolbarBtn();
    createTalentEditWin("人才编辑", true);
  }
});

function initTalentDgToolbarBtn() {
  $('#talentDgTb a').unbind();
  $('#talentDgTb a').linkbutton();
  $('#talentDgTb a').bind('click', function(event){
    addOrEditOrDeleteOrViewRecord({
      dataGridId:"talentDg",
      type: $(event.currentTarget).attr("type"),
      add : addTalent,
      edit : editTalent,
      removeUrl : '/talent/deleteById.do',
      removePromptField : ["name"],
      deleteSuccess : function(){
        $('#talentDg').datagrid('reload');
      }
    });
  });
}

function createTalentEditWin(title, closed, maxZIndex) {
  var width = 600, height = 460;
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
//    zIndex: maxZIndex + 1099999990,
    closed: closed,
    onOpen : function(){
      $('#sexOfTalent').combo({
        required:true,
        multiple:false
      });
      $('#itemOfSexOfTalent').appendTo($('#sexOfTalent').combo('panel'));
      $('#itemOfSexOfTalent input').click(function(){
        var v = $(this).val();
        var s = $(this).next().text();
        $('#sexOfTalent').combo('setValue', v).combo('setText', s).combo('hidePanel');
      });

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
    },
    onClose : function() {
      removeCoverLayer();
    }
  });
}

function addTalent(options) {
  createTalentEditWin("新增人才", false, 99999);
}


function editTalent(options, row) {
  createTalentEditWin("修改人才：" + row.name, false);
}


