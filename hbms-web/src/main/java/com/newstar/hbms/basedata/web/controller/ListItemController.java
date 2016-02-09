package com.newstar.hbms.basedata.web.controller;

import com.newstar.hbms.basedata.domain.ListItem;
import com.newstar.hbms.basedata.service.ListItemService;
import com.newstar.hbms.mvc.MessageCollector;
import com.newstar.hbms.utils.WebUtils;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by fellowlong on 2014-09-09.
 */
public class ListItemController extends MultiActionController {

  private ListItemService listItemService;

  private Map<String, Long> listItemCategoryMapping;

  public void setListItemService(ListItemService listItemService) {
    this.listItemService = listItemService;
  }

  public void setListItemCategoryMapping(Map<String, Long> listItemCategoryMapping) {
    this.listItemCategoryMapping = listItemCategoryMapping;
  }

  public void insertOrUpdate(HttpServletRequest request,
                     HttpServletResponse response,
                     ListItem listItem) throws Exception {
    int resultCount = listItem.getId() == null ? listItemService.insert(listItem) : listItemService.update(listItem);
    MessageCollector msgCollector = new MessageCollector();
    if (resultCount == 1) {
      msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    } else {
      msgCollector.addError(WebUtils.ERROR, Boolean.TRUE);
    }
    WebUtils.writeWithJson(response, msgCollector);
  }

  public void deleteById(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
    int resultCount = listItemService.deleteById(WebUtils.getLongArrayBySeparator(request, "id", ","));
    MessageCollector msgCollector = new MessageCollector();
    msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    WebUtils.writeWithJson(response, msgCollector);
  }


  public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<ListItem> listItems = listItemService.findAllCategory();
    WebUtils.writeWithJson(response, listItems);
  }

  public void findByBean(HttpServletRequest request,
                         HttpServletResponse response,
                         ListItem listItem) throws Exception {
    List<ListItem> listItems = listItemService.findByBean(listItem);
    WebUtils.writeWithJson(response, listItems);
  }

  public void findListItemsOfCategoryByCode(HttpServletRequest request,
                         HttpServletResponse response,
                         ListItem listItem) throws Exception {
    List<ListItem> listItems = listItemService.findListItemsOfCategoryByCode(listItem.getCode());
    WebUtils.writeWithJson(response, listItems);
  }

}
