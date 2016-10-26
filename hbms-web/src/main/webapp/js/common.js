
function saveOrUpdateRecord(url, form, successFunction, errorFunction) {
  $(form).isValid(function (result) {
    if (result) {
      $(form).ajaxSubmit({
        type: "post",
        dataType: "json",
        url: url,
        beforeSubmit: function (arr, $form, options) {
          var notEmptyData = [];
          for (var i = 0; i < arr.length; i++) {
            if (arr[i].value && arr[i].value != null && arr[i].value != "") {
              notEmptyData.push(arr[i]);
            } else if ($(arr[i]).attr("type") == "checkbox" || $(arr[i]).attr("type") == "radio"){
              notEmptyData.push(arr[i]);
            }
          }
          if (notEmptyData.length > 0) {
            while (arr.length > 0) {
              arr.pop();
            }
            for (var j = 0; j < notEmptyData.length; j++) {
              arr.push(notEmptyData[j]);
            }
          }
          return true;
        },
        success: function (result, statusText, xhr) {
          if (result && result.success) {
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
        error: function (XMLHttpRequest, textStatus, errorThrown) {
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
        var formFields = $(form + " input," + form + " select," + form + " textarea, "+ form + " span[type='formFieldValue']");
        formFields.val(null);
        formFields.removeAttr("checked");
        if (formFields && formFields.length > 0) {
          fillFormFields(result.data, formFields);
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

function fillFormFields(data, formFields, parent) {
  for (property in data) {
    var itemData = data[property];
    if (itemData instanceof Object) {
      fillFormFields(itemData, formFields, property);
    } else {
      for (i = 0; i < formFields.length; i++) {
        var formField = formFields[i];
        var itemName = (parent && parent.length) > 0 ? parent + "." + property : property;
        if (itemName == $(formField).attr("name")) {
          if ($(formField).is("input")) {
            //处理checkbox和radio
            if (($(formField) instanceof Array && ($(formField[0]).attr("type") == "checkbox" || $(formField[0]).attr("type") == "radio"))
                || ($(formField).attr("type") == "checkbox" || $(formField).attr("type") == "radio")) {
              var fromFieldArray = [];
              if ($(formField) instanceof Array) {
                fromFieldArray = $(formField);
              } else {
                fromFieldArray.push($(formField));
              }
              var itemDataArray = [];
              if (itemData instanceof Array) {
                itemDataArray = itemData;
              } else {
                itemDataArray.push(itemData);
              }
              for (perFormField in fromFieldArray) {
                var matched = false;
                for (perItemData in itemDataArray) {
                  if ($(perFormField).val() == perItemData) {
                    matched = true;
                    break;
                  }
                }
                if (matched) {
                  $(perFormField).attr("checked", "checked");
                } else {
                  $(perFormField).removeAttr("checked");
                }
              }
            } else {
              $(formField).val(itemData);
            }
          } else if ($(formField).is("select")) {
            $(formField).val(itemData);
          } else if ($(formField).is("textarea")) {
            $(formField).val(itemData);
          } else if ($(formField).is("span")) {
            $(formField).text(itemData);
          } else {
            bootbox.alert("<div class='alert alert-danger'>无效的类型：" + $(formField).attr("name") + "<br></div>");
          }
        }
      }
    }
  }
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