$("#listItemCategoryGd").datagrid({
  url:'/listItem/findAllCategory.do',
  title : '所有类别',
  singleSelect: false,
  fitColumns : true,
  ctrlSelect:true,
  toolbar:"#listItemCategoryTb",
  pagination:true,
  columns:[[
    {field:'id',checkbox:true,align:'right'},
    {field:'value',title:'值',width:100, align:'left'}
  ]],
  onSelect:function(rowIndex, rowData) {
    refreshListItemsOfCategoryDg();
  },
  onUnselect : function(rowIndex, rowData) {
    refreshListItemsOfCategoryDg();
  },
  onBeforeLoad : function(param) {
    var columnFields = $('#listItemCategoryGd').datagrid('getColumnFields');
    var columnFieldNames = "";
    $.each(columnFields, function(i, item){
      columnFieldNames += (i > 0 ? "," : "") + item;
    })
    param.columnFields = columnFieldNames;
    return true;
  },
  onLoadSuccess: function(){
    initDataGridToolbarBtn();
    initListItemsOfCategoryDg();
    refreshListItemsOfCategoryDg();
    createListItemEditWin("listItemCategoryGd", "", true, 0);
  }
});

function initListItemsOfCategoryDg() {
  $("#listItemsOfCategoryDg").datagrid({
    url: null,
    title : '列表项',
    singleSelect: false,
    fitColumns : true,
    ctrlSelect:true,
    toolbar:"#listItemsOfCategoryTb",
    pagination:true,
    columns:[[
      {field:'id',checkbox:true,align:'right'},
      {field:'value',title:'值',width:100,align:'left'},
      {field:'typeId',title:'类型编号',width:100,align:'left', hidden:true}
    ]],
    data:null,
    onBeforeLoad : function(param) {
      var columnFields = $('#listItemsOfCategoryDg').datagrid('getColumnFields');
      var columnFieldNames = "";
      $.each(columnFields, function(i, item){
        columnFieldNames += (i > 0 ? "," : "") + item;
      })
      param.columnFields = columnFieldNames;
      return true;
    }

  });
}

function initDataGridToolbarBtn() {
  $('#listItemCategoryTb a').linkbutton();
  $('#listItemCategoryTb a').unbind();
  $('#listItemCategoryTb a').bind('click', function(event){
    addOrEditOrDeleteOrViewRecord({
      dataGridId:"listItemCategoryGd",
      type: $(event.currentTarget).attr("type"),
      add : addListItem,
      edit : editListItem,
      removeUrl : '/listItem/deleteById.do',
      removePromptField : ["value"],
      deleteSuccess : function(){
        $('#listItemCategoryGd').datagrid('reload');
      }
    });
  });
  $('#listItemsOfCategoryTb a').linkbutton();
  $('#listItemsOfCategoryTb a').unbind();
  $('#listItemsOfCategoryTb a').bind('click', function(event){
    addOrEditOrDeleteOrViewRecord({
      dataGridId:"listItemsOfCategoryDg",
      type: $(event.currentTarget).attr("type"),
      add : addListItem,
      edit : editListItem,
      removeUrl : '/listItem/deleteById.do',
      removePromptField : ["value"],
      deleteSuccess : function(){
        refreshListItemsOfCategoryDg();
      }
    });
  });
}

function refreshListItemsOfCategoryDg() {
  var selectedRows = $("#listItemCategoryGd").datagrid("getSelections");
  if(selectedRows && selectedRows.length > 0) {
    $("#listItemsOfCategoryDg").datagrid({
      title:'<b>' + selectedRows[0].value + "</b> &nbsp; 列表项",
      url: '/listItem/findByBean.do',
      queryParams:{typeId:selectedRows[0].id}
    });
  } else {
    $("#listItemsOfCategoryDg").datagrid({url:null, data:[]});
  }
}

function createListItemEditWin(dataGridId, title, closed, maxZIndex) {
  var width = 280, height = 150;
  var westWidth = $("#layout").layout("panel", "west").outerWidth();
  var northHeight = $("#layout").layout("panel", "north").outerHeight();
  var left = ($(document.body).width() - width)/2 - westWidth;
  var top = ($(document.body).height() - height)/2 - northHeight;
  $("#listItemEditWin").dialog({
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
      $("#listItemEditTb a[type='save']").unbind();
      $("#listItemEditTb a[type='save']").linkbutton({disabled : false});
      $("#listItemEditTb a[type='save']").bind('click', function(event){
        $("#listItemEditTb a[type='save']").linkbutton("disable");
        insertOrUpdateListItem(dataGridId)
      });
      $("#listItemEditTb a[type='cancel']").unbind();
      $("#listItemEditTb a[type='cancel']").linkbutton();
      $("#listItemEditTb a[type='cancel']").bind('click', function(event){
        $("#listItemEditWin").dialog({closed : true});
      });
    },
    onClose : function() {
      removeCoverLayer();
    }
  });
}


function addListItem(options) {
  var title = "";
  var row = {};
  if(options.dataGridId == "listItemCategoryGd") {
    title = "新增类别";
  }
  if(options.dataGridId == "listItemsOfCategoryDg") {
      var selectedRows = $("#listItemCategoryGd").datagrid("getSelections");
      if(selectedRows && selectedRows.length == 1) {
        row.typeId = selectedRows[0].id;
      } else {
        $.messager.alert("警告", "请选择需要增加列表项的类别", "warn");
        return false;
      }
    title = "新增“" + selectedRows[0].value +"”的列表项";
  }
  createListItemEditWin(options.dataGridId, title, false);
  $("#listItemEditForm").form("clear");
  $("#listItemEditForm").form("load",row);
}


function editListItem(options, row) {
  var title = "";
  if(options.dataGridId == "listItemCategoryGd") {
    title = "编辑类别：" + row.value;
  }
  if(options.dataGridId == "listItemsOfCategoryDg") {
    var selectedRows = $("#listItemCategoryGd").datagrid("getSelections");
    title = "编辑列表项：" + selectedRows[0].value + " => " + row.value;
  }
  createListItemEditWin(options.dataGridId, title, false);
  $("#listItemEditForm").form("clear");
  row.dataGridId = options.dataGridId;
  $("#listItemEditForm").form("load",row);
}

function insertOrUpdateListItem(dataGridId) {
  $("#listItemEditForm").form("submit",{
    url: getRandomUrl(contextPath + "/listItem/insertOrUpdate.do"),
    onSubmit: function(param){
      return $("#listItemEditForm").form("validate");
    },
    success: function(message) {
      try{
        message =  $.parseJSON(message);
      }catch(exception){
        $("#listItemEditTb a[type='save']").linkbutton("enable");
        showHtmlMessage("错误", exception + "\n" + message);
      }
      if(showAjaxMessage(message)) {
        $('#listItemEditWin').dialog({closed:true});
        if(dataGridId == "listItemCategoryGd") {
          $("#" + dataGridId).datagrid("reload");
        } else if(dataGridId == "listItemsOfCategoryDg") {
          refreshListItemsOfCategoryDg();
        }
      }
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      showHtmlMessage(textStatus, XMLHttpRequest.responseText);
    }
  });
}
