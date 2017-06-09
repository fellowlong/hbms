/**
 * Created by wangjinsi on 17-1-10.
 */
;(function ($, window, document, undefined) {
  var CascadedChosen = function (currentRef, children, options) {
    this.currentRef = currentRef;
    this.children = children;
    this.defaults = {
    };
    /*
     children =
      [{
        childRef:$("xxx"),
        options:{
          dataCallback: undefined,//[{value:"",label:""}, {value:"",label:""}]
          url: undefined,
          dataMapper: undefined, //[{value:"",label:""}, {value:"",label:""}]
          selectedData:undefined
        }
      },
      ..
      ]
   */
    this.options = $.extend({}, this.defaults, options);
    var $this = this;
    if (this.children && this.children.length > 0) {
      $(this.currentRef).chosen().change(function (obj) {
        change($this);
        return true;
      });
      change(this);
    }

    function change(cascadedChosen) {
      $(cascadedChosen.children).each(function (index, child) {
        var childRef = child.childRef;
        var options = child.options;
        //先清空
        $(childRef).empty();
        var nodeData = undefined;
        var parentId = $(cascadedChosen.currentRef).val();
        //root或者parent选中值后才会重新加载数据
        if (parentId && parentId.length > 0) {

          if (options.dataCallback) {
            nodeData = options.dataCallback(parentId, childRef, cascadedChosen.currentRef);
          } else {
            $.ajax({
              type: "POST",
              url: options.url + parentId,
              dataType: "json",
              timeout: 3000,
              async: false,
              success: function (data, textStatus, jqXHR) {
                if (data && options.dataMapper) {
                  nodeData = options.dataMapper(data);
                }
              },
              error: function (XMLHttpRequest, textStatus, errorThrown) {
                var tipHtml = "<h5 class='red'><i class=\"icon-warning-sign red bigger-130\"></i>加载失败</h5>";
                bootbox.dialog({
                  message: tipHtml,
                  buttons: {
                    "danger": {
                      "label": "关闭",
                      "className": "btn-sm btn-danger"
                    }
                  }
                });
              }
            });
          }
        }
        if (nodeData && nodeData.length > 0) {
          var selectOptions = "";
          $(nodeData).each(function (index, item) {
            selectOptions += "<option value='" + item.value + "' ";
            if (options.selectedData && $.inArray(item.value, options.selectedData) > -1) {
              selectOptions += " selected ";
            }
            selectOptions += ">" + item.label + "</option>";
          });
          $(childRef).html(selectOptions)
        }
        $(childRef).trigger("chosen:updated");
      });
      $(".chosen-container").css("min-width","150px");
    }
  }


  $.fn.cascadedChosen = function (children, options) {
    return new CascadedChosen(this, children, options);
  }
})(jQuery, window, document);