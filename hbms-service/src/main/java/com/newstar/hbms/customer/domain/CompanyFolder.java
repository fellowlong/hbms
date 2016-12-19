package com.newstar.hbms.customer.domain;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.io.Serializable;

/**
 * 客户
 *
 * Created by fellowlong on 14-6-4.
 */
public class CompanyFolder implements Serializable {

  /**
   * 主键
   */
  private Long id;

  private Long companyId;
  private Company company;

  private Long folderId;
  private TreeNode folder;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Long getFolderId() {
    return folderId;
  }

  public void setFolderId(Long folderId) {
    this.folderId = folderId;
  }

  public TreeNode getFolder() {
    return folder;
  }

  public void setFolder(TreeNode folder) {
    this.folder = folder;
  }
}