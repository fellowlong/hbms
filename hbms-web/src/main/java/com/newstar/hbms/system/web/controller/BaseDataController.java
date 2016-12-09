package com.newstar.hbms.system.web.controller;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.basedata.service.BaseDataService;
import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.mvc.ConfigurableMultiActionController;
import com.newstar.hbms.utils.WebUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


  public void findByCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String code = request.getParameter("code");
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

}
