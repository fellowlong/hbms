package com.newstar.hbms.system.web.controller;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.mvc.ConfigurableMultiActionController;
import com.newstar.hbms.mvc.JsonResult;
import com.newstar.hbms.utils.ExceptionUtils;
import com.newstar.hbms.utils.WebUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjinsi on 2016/12/7.
 */
public class BaseDataController extends ConfigurableMultiActionController {

  private TreeService treeService;

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
  }

  public ModelAndView workspace(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("/system/baseDataManager");
  }

  public void findTreeByCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String code = request.getParameter("code");
    assert code != null && !code.isEmpty();
    TreeNode treeNode = treeService.findTreeByAncestorCode(code);
    //解除上级关系，防止json序列化时死递归
    removeParentAndAncestor(treeNode);
    WebUtils.writeWithJson(response, treeNode);
  }

  public void findTreesById(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String code = request.getParameter("id[]");
    assert code != null && !code.isEmpty();
    TreeNode treeNode = treeService.findTreeByAncestorCode(code);
    //解除上级关系，防止json序列化时死递归
    removeParentAndAncestor(treeNode);
    WebUtils.writeWithJson(response, treeNode);
  }

  private void removeParentAndAncestor(TreeNode treeNode) {
    treeNode.setParent(null);
    treeNode.setAncestor(null);
    if (treeNode.getChildren() != null && !treeNode.getChildren().isEmpty()) {
      for (TreeNode perTreeNode : treeNode.getChildren()) {
        removeParentAndAncestor(perTreeNode);
      }
    }
  }

  public void insertOrUpdate(HttpServletRequest request,
                             HttpServletResponse response,
                             TreeNode treeNode) throws Exception {

    JsonResult jsonResult = new JsonResult();
    try {
      int result = treeService.insertOrUpdate(treeNode);
      if (result > 0) {
        jsonResult.setSuccess(true);
        jsonResult.setData(treeNode);
      }
    } catch (Throwable t) {
      logger.error("删除BaseData失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);
  }

  public void disableByIds(HttpServletRequest request, HttpServletResponse response) throws Exception {
    JsonResult jsonResult = new JsonResult();
    try {
      Long id = WebUtils.getLong(request, "id");
      if (id != null) {
        int result = treeService.disableByIds(new Long[]{id});
        if (result > 0) {
          jsonResult.setSuccess(true);
          jsonResult.setData(result);
        }
      }
    } catch (Throwable t) {
      logger.error("删除TreeNode失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);

  }
}
