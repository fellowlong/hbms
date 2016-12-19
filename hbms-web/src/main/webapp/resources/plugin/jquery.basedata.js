/**
 * Created by wangjinsi on 2016/12/13.
 */
;(function ($, window, document, undefined) {

  var dialogTemplate =
    '<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="baseDataSelectDialogTitle" aria-hidden="true">' +
    '<div class="modal-dialog">' +
    '<div class="modal-content">' +
    '<div class="modal-header">' +
    '<button type="button" class="close" data-dismiss="modal">' +
    '<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>' +
    '</button>' +
    '<h4 class="modal-title" id="baseDataSelectDialogTitle">选择</h4>' +
    '</div>' +
    '<div class="modal-body"><ul class="ztree"></ul></div>' +
    '<div class="modal-footer">' +
    '<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>' +
    '<button id="selectBaseData" type="button" class="btn btn-primary">选择</button>' +
    '</div>' +
    '</div>' +
    '</div>' +
    '</div>';

  var BaseDataSelector = function (element, options) {
    this.element = element;
    this.defaults = {
      initData : undefined,
      initServerData : undefined,
      code: undefined,
      formFieldName: undefined,
      isMultiFormField: undefined
    };
    this.options = $.extend({}, this.defaults, options);
    this.treeSetting = {
      check: {
        enable: true,
        chkStyle: this.options.isMultiFormField ? "checkbox" : "radio",
        chkboxType: { "Y": "", "N": "" }
      }
    };
  }

  BaseDataSelector.prototype = {

    init: function () {
      $(this.element).addClass("baseDataSelector");
      var html = "<div class='input-group'>";
      html += "<div class='baseDataSelectorLabel'></div>";
      html += "<span class='input-group-btn'>";
      html += "<button type='button' class='btn btn-xs btn-primary'>";
      html += "<i class='ace-icon fa fa-search bigger-130'></i>选择";
      html += "</button>";
      html += "</span>";
      html += "</div>";
      html += "<div>" + dialogTemplate + "</div>";
      $(this.element).append(html);
      var rootThis = this;
      $(this.element).children("div").first().find("button").on("click", function (eventObj) {
        rootThis.openSelectDialog();
      });
      $(this.element).children("div").last().find("button").last().on("click", function (obj) {
        var treeObj = rootThis.tree;
        var selectedNodes = treeObj.getCheckedNodes(true);
        var pathedNames = [];
        for (var i = 0 ; i < selectedNodes.length; i++){
          pathedNames[i] = getPathedNodeNameFromZtree(selectedNodes[i]);
        }
        for (var i = 0 ; i < selectedNodes.length; i++){
          selectedNodes[i].name = pathedNames[i];
        }
        rootThis.addItems(selectedNodes);
        $(rootThis.element).children("div").last().children().first().modal('hide');
      });
      if (this.options.initData) {
        this.addItems(this.options.initData);
      } else if(this.options.initServerData) {
        var initData = [];
        //服务器端的node结构转换成ztree的node结构
        $(this.options.initServerData).each(function (index, serverNode) {
          var node = {name : getPathedNodeNameFromServer(serverNode), id : serverNode.id};
          initData.push(node);
        });
        this.addItems(initData);
      }
    },

    addItems: function(items) {
      var formFieldName = this.options.formFieldName;
      var itemHtml = "";
      for (var i = 0 ; i < items.length; i++) {
        var parseFormFieldName = formFieldName.replace("#index#", i);
        itemHtml += "<span class='badge badge-primary'>" + items[i].name;
        itemHtml += "<a href='javascript:void()' data-id='" + items[i].id +"'><i class='ace-icon fa fa-remove icon-only'></i></a>";
        itemHtml += "<input type='hidden' name='" + parseFormFieldName + "' value='" + items[i].id + "'>";
        itemHtml += "</span>";
      }
      var itemElement = $(this.element).children("div").first().children("div").first();
      itemElement.append(itemHtml);
      reCalValueIndex(itemElement);

      itemElement.find("a").unbind();
      itemElement.find("a").on("click", function (obj) {
        $(obj.currentTarget).parent().remove();
        reCalValueIndex(itemElement);
      });

      function reCalValueIndex(itemElement) {
        //重新编号，防止跳号，spring无法绑定到array或list上
        var values = itemElement.find("input");
        if (values && values.length > 0) {
          for(var i = 0 ; i < values.length; i++) {
            $(values[i]).attr("name", formFieldName.replace("#index#", i));
          }
        }
      }
    },

    openSelectDialog : function () {
      var dialogElement = $(this.element).children("div").children().last();
      dialogElement.modal('show');
      var rootThis = this;
      $.ajax({
        type: "POST",
        url: "/baseData/findTreeByCode.do",
        data: {code:this.options.code},
        dataType: "json",
        timeout: 3000,
        success: function(data, textStatus, jqXHR){
          var treeNodes = convertToTreeNodes(data);
          dialogElement.find(".modal-title").text("选择  " + treeNodes[0]['name']);
          rootThis.tree = $.fn.zTree.init(dialogElement.find("ul"), rootThis.treeSetting, treeNodes);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
          var tipHtml = "<h5 class='red'><i class=\"icon-warning-sign red bigger-130\"></i>加载失败</h5>";
          bootbox.dialog({
            message: tipHtml,
            buttons: {
              "danger" : {
                "label" : "关闭",
                "className" : "btn-sm btn-danger"
              }
            }
          });
        }
      });
    }
  }

  function convertToTreeNodes(serverData) {
    var treeNodeData = [];
    $(serverData).each(function (index, itemData) {
      var node = {name : itemData.label, id:itemData.id};
      treeNodeData.push(node);
      if (itemData.parent && itemData.parent != null) {
        node.getParentNode()
      }
      if (itemData.children && itemData.children.length > 0) {
        var children = convertToTreeNodes(itemData.children);
        node.children = children;
      }
    });
    return treeNodeData;
  }

  function getPathedNodeNameFromZtree(node) {
    var name = node.name;
    if (node.getParentNode() && node.getParentNode() != null) {
      name = getPathedNodeNameFromZtree(node.getParentNode()) + "/" + name;
    }
    return name.charAt(0) == '/' ? name : "/" + name;
  }

  function getPathedNodeNameFromServer(node) {
    var name = node.label;
    if (node.parent && node.parent != null) {
      name = getPathedNodeNameFromServer(node.parent) + "/" + name;
    }
    return name.charAt(0) == '/' ? name : "/" + name;

  }
  
  $.fn.baseDataSelector = function (options) {
    var selector = new BaseDataSelector(this, options);
    selector.init();
    return selector;
  }
  
})(jQuery, window, document);
/*

//sample:扩展jquery对象的方法，bold()用于加粗字体。
(function ($) {

  var methods = {
    addItem: function(options) {
      // this
    },
    show: function() {
      // is
    },
    hide: function() {
      // good
    },
    update: function(content) {
      // !!!
    }
  };


  $.fn.extend({
    ///<summary>
    /// 基础数据选择插件
    ///</summary>
    "baseData": function (options) {
      var defaults = {
        code : undefined,
        formFieldName : undefined,
        isMultiFormField : undefined
      };
      this.options = $.extend({}, defaults, options);

      $(this).addClass("input-group");
      var baseDataSource = this;
      var html = "<div class='baseDataSelectorLabel'></div>";
      html += "<div class='baseDataSelectorValue'></div>";
      html += "<span class='input-group-btn'>";
      html += "<button type='button' class='btn btn-xs btn-primary'>";
      html += "<i class='ace-icon fa fa-search bigger-130'></i>选择";
      html += "</button>";
      html += "</span>";
      $(this).append(html);
      $(this).find("button").on("click", function (obj) {
        openBaseDataSelectDialog(code, isMultiFormField, function(selectedItems){
          var valuesHtml = "";
          var labelsHtml = "";
          for (var i = 0 ; i < selectedItems.length; i++) {
            var parseFormFieldName = formFieldName.replace("#index#", i);
            valuesHtml += "<input type='hidden' name='" + parseFormFieldName + "' value='" + selectedItems[i].id + "'>";
            labelsHtml += "<span class='badge badge-primary'>" + selectedItems[i].name;
            labelsHtml += "<a href='#' data-id='" + selectedItems[i].id +"'><i class='ace-icon fa fa-remove icon-only'></i></a>";
            labelsHtml += "</span>";
          }
          $(baseDataSource).children(".baseDataSelectorValue").append(valuesHtml)
          $(baseDataSource).children(".baseDataSelectorLabel").append(labelsHtml);
          $(baseDataSource).find("a").unbind();
          $(baseDataSource).find("a").on("click", function (obj) {
            $(baseDataSource).find(".baseDataSelectorValue input[value=" + $(obj.currentTarget).data("id") + "]").remove();
            //重新编号，防止跳号，spring无法绑定到array或list上
            var values = $(baseDataSource).find(".baseDataSelectorValue input");
            if (values && values.length > 0) {
              for(var i = 0 ; i < values.length; i++) {
                $(values[i]).attr("name", formFieldName.replace("#index#", i));
              }
            }
            $(obj.currentTarget).parent().remove();
          });
        });
      });
      return;
    }
  });
  $.fn.baseData.addItem = function (items) {
    return "<strong>" + str + "</strong>";
  }
})(jQuery);*/
