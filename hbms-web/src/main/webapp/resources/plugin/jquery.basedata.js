/**
 * Created by wangjinsi on 2016/12/13.
 */

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
    "baseData": function (code, formFieldName, isMultiFormField) {
      ///<summary>
      /// 基础数据选择插件
      ///</summary>
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
})(jQuery);