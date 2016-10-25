function saveOrUpdateRecord(url, form, successFunction, errorFunction) {
  $(form).isValid( function(result) {
    if (result) {
      $(form).ajaxSubmit({
        type:"post",
        dataType:"json",
        url:url,
        beforeSubmit: function(arr, $form, options) {
          var notEmptyData = [];
          for(var i = 0 ; i < arr.length ; i++) {
            if (arr[i].value && arr[i].value != null && arr[i].value != "") {
              notEmptyData.push(arr[i]);
            }
          }
          if (notEmptyData.length > 0) {
            while (arr.length > 0) {
              arr.pop();
            }
            for(var j = 0 ; j < notEmptyData.length ; j++) {
              arr.push(notEmptyData[j]);
            }
          }
          return true;
        },
        success: function(result, statusText, xhr) {
          if(result && result.success) {
            if (successFunction) {
              successFunction();
            }
          } else {
            if (errorFunction) {
              errorFunction();
            }
            bootbox.alert("<div class='alert alert-danger'>保存失败，请联系管理员</div>");
          }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
          if (errorFunction) {
            errorFunction();
          }
          bootbox.alert("<div class='alert alert-danger'><br>保存异常，请联系管理员<br></div>");
        }
      });
    }
  });

}

function loadRecord(url, postData, form, successFunction, errorFunction) {
  $.ajax({
    type: "post",
    dataType: "json",
    url: url,
    data: postData,
    timeout: 3000,
    success: function (result, textStatus, jqXHR) {
      $(form).validator("cleanUp");
      if (result && result.success && result.data) {
        var formFields = $(form + " input," + form + " select," + form + " textarea");
        formFields.val(null);
        formFields.text(null);
        formFields.removeAttr("checked");
        if (formFields && formFields.length > 0) {
          for (property in result.data) {
            for (i = 0; i < formFields.length; i++) {
              var formField = formFields[i];
              if (property == $(formField).attr("name")) {
                if ($(formField).is("input")) {
                  if ($(formField).attr("type") == "checkbox") {
                    if (result.data[property] == true) {
                      $(formField).attr("checked", "checked");
                    } else {
                      $(formField).removeAttr("checked");
                    }
                  } else if ($(formField) instanceof Array && $(formField[0]).attr("type") == "radio") {
                    for (radioFormField in $(formField)) {
                      if ($(radioFormField).val() == result.data[property]) {
                        $(radioFormField).attr("checked", "checked");
                      } else {
                        $(radioFormField).removeAttr("checked");
                      }
                    }
                  } else {
                    $(formField).val(result.data[property]);
                  }
                } else if ($(formField).is("select")) {
                  $(formField).val(result.data[property]);
                } else if ($(formField).is("textarea")) {
                  $(formField).val(result.data[property]);
                } else {
                  bootbox.alert("<div class='alert alert-danger'>无效的类型：" + $(formField).attr("name") + "<br></div>");
                }
              }
            }
          }
        }
        if (successFunction) {
          successFunction();
        }
      } else {
        if (errorFunction) {
          errorFunction();
        }
        bootbox.alert("<div class='alert alert-danger'>没有找到数据，请联系管理员<br></div>");
      }
    },
    error: function (XMLHttpRequest, textStatus, errorThrown) {
      if (errorFunction) {
        errorFunction();
      }
      bootbox.alert("<div class='alert alert-danger'>加载数据异常，请联系管理员<br></div>");
    }
  });
}
function disableRecords(url, postData, successFunction, errorFunction) {
  $.ajax({
    type: "post",
    dataType: "json",
    url: url,
    data: postData,
    timeout: 3000,
    success: function (result, textStatus, jqXHR) {
      if (result && result.success) {
        if (successFunction) {
          successFunction();
        }
      } else {
        if (errorFunction) {
          errorFunction();
        }
        bootbox.alert("<div class='alert alert-danger'>删除失败，请联系管理员<br></div>");
      }
    },
    error: function (XMLHttpRequest, textStatus, errorThrown) {
      if (errorFunction) {
        errorFunction();
      }
      bootbox.alert("<div class='alert alert-danger'>删除异常，请联系管理员<br></div>");
    }
  });
}