package com.companyname.hbms.basedata.web.controller;

import com.companyname.hbms.basedata.dao.ListItemDao;
import com.companyname.hbms.basedata.domain.ListItem;
import com.companyname.hbms.basedata.service.ListItemService;
import com.companyname.hbms.mvc.MessageCollector;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by fellowlong on 2014-09-09.
 */
public class ListItemController extends MultiActionController {

  private ListItemService listItemService;

  public void setListItemService(ListItemService listItemService) {
    this.listItemService = listItemService;
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
    int resultCount = listItemService.deleteById(WebUtils.getLongArrayBySpearator(request, "id", ","));
    MessageCollector msgCollector = new MessageCollector();
    msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    WebUtils.writeWithJson(response, msgCollector);
  }


  public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
    PagingResult<ListItem> pagingResult = listItemService.findAllCategory(WebUtils.getPageRange(request));
    WebUtils.writeForEasyUIDataGrid(request, response, pagingResult);

  }
  public void findByBean(HttpServletRequest request,
                         HttpServletResponse response,
                         ListItem listItem) throws Exception {
    PagingResult<ListItem> pagingResult = listItemService.findByBean(listItem, WebUtils.getPageRange(request));
    WebUtils.writeForEasyUIDataGrid(request, response, pagingResult);

  }

}
