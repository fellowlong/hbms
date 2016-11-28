package com.newstar.hbms.customer.domain;

import com.newstar.hbms.basedata.domain.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户
 *
 * Created by fellowlong on 14-6-4.
 */
public class CompanyIndustry implements Serializable {

  /**
   * 主键
   */
  private Long id;

  private Long companyId;
  private Company company;

  private Long industryId;
  private TreeNode industry;

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

  public Long getIndustryId() {
    return industryId;
  }

  public void setIndustryId(Long industryId) {
    this.industryId = industryId;
  }

  public TreeNode getIndustry() {
    return industry;
  }

  public void setIndustry(TreeNode industry) {
    this.industry = industry;
  }
}