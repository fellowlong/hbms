/**
 * Created by fellowlong on 2017/2/24.
 */
;(function ($, window, document, undefined) {

  var MultiSelector = function (element, options) {
    this.element = element;
    this.defaults = {
        /*
        initData = [{value: 1, label: "值1"},{value: 2, label: "值2"}]
         */
      initData : undefined,
      code: undefined,
      formFieldsMapping: undefined,
      isMultiFormField: undefined
    };
    if (!options.openSelectDialog) {
      alert("无效的参数：openSelectDialog 不能为空");
      return;
    }
    this.options = $.extend({}, this.defaults, options);
  }

    MultiSelector.prototype = {

    init: function () {
        $(this.element).addClass("multiSelector");
        var html = "<div class='input-group'>";
        html += "<div class='multiSelectorLabel'></div>";
        html += "<span class='input-group-btn'>";
        html += "<button type='button' class='btn btn-xs btn-primary'>";
        html += "<i class='ace-icon fa fa-search bigger-130'></i>选择";
        html += "</button>";
        html += "</span>";
        html += "</div>";
        $(this.element).append(html);
        var rootThis = this;
        $(this.element).children("div").first().find("button").on("click", function (eventObj) {
            rootThis.options.openSelectDialog();
        });
        if (this.options.initData) {
            this.addItems(this.options.initData);
        }
    },

    addItems: function(items) {
      var formFields = this.options.formFieldsMapping
      var itemHtml = "";
      for (var i = 0 ; i < items.length; i++) {
        itemHtml += "<span class='badge badge-primary'>" + items[i].name;
        itemHtml += "<a href='javascript:void()' data-id='" + items[i].id +"'><i class='ace-icon fa fa-remove icon-only'></i></a>";
        $(formFields).each(function (index, formFieldItem) {
          var parsedValue = items[i][formFieldItem.treeNodeAttr];
          itemHtml += "<input type='hidden' rawname='" + formFieldItem.rawName + "' value='" + parsedValue + "'>";
        });
        itemHtml += "</span>";
        if (!this.options.isMultiFormField) {
            break;
        }
      }
      var itemElement = $(this.element).children("div").first().children("div").first();
      if (!this.options.isMultiFormField) {
          itemElement.empty();
      }
      itemElement.append(itemHtml);
      reCalValueIndex(itemElement);

      itemElement.find("a").unbind();
      itemElement.find("a").on("click", function (obj) {
        $(obj.currentTarget).parent().remove();
        reCalValueIndex(itemElement);
      });


      function reCalValueIndex(itemElement) {
        //重新编号，防止跳号，spring无法绑定到array或list上
        $(formFields).each(function (index, formFieldItem) {
          var valueInputs = itemElement.find("input[rawname='" + formFieldItem.rawName + "']");
          if (valueInputs && valueInputs.length > 0) {
            for(var i = 0 ; i < valueInputs.length; i++) {
              var parsedName = formFieldItem.rawName.replace("#index#", i);
              $(valueInputs[i]).attr("name", parsedName);
            }
          }
        });
      }
    }

  }

  $.fn.multiSelector = function (options) {
    var multiSelector = new MultiSelector(this, options);
      multiSelector.init();
    return multiSelector;
  }

})(jQuery, window, document);