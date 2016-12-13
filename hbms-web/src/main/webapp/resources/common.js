/**
 * User: fellowlong
 * Date: 7/11/12
 * Time: 11:42 AM
 */

function getRandomUrl(url) {
    if(url && url.length > 0) {
        url += url.indexOf("?") > -1 ? "&" : "?";
        url += (Math.random() + "").replace("\.","") + "=" + new Date().getTime();
    }
    return url;
}

function clone(obj) {
  var buf;
  if (obj instanceof Array) {
    buf = [];  //创建一个空的数组
    var i = obj.length;
    while (i--) {
      buf[i] = clone(obj[i]);
    }
    return buf;
  }else if (obj instanceof Object){
    buf = {};  //创建一个空对象
    for (var k in obj) {  //为这个对象添加新的属性
      buf[k] = clone(obj[k]);
    }
    return buf;
  }else{
    return obj;
  }
}

function getValueFromJson(name, json) {
  if(!name || !json) {
    return undefined;
  }
  if(name.indexOf(".") < 0) {
    return json[name];
  }
  var currentName = name.substring(0, name.indexOf("."));
  return getValueFromJson(name.substr(currentName.length + 1), json[currentName]);
}

function getMaxZIndex() {
  var maxZ = Math.max.apply(null, $.map($("*"), function (e, n) {
      var position = $(e).css("position");
      if (position == "absolute" || position == "relative" || position == "fixed")
        return parseInt($(e).css('z-index')) || 1;
    })
  );
  return maxZ;
}

//sample:扩展jquery对象的方法，bold()用于加粗字体。
(function ($) {
  $.fn.extend({
    "bold": function () {
      ///<summary>
      /// 加粗字体
      ///</summary>
      return this.css({ fontWeight: "bold" });
    }
  });
})(jQuery);