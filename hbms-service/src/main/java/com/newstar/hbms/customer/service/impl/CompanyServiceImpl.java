package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.customer.dao.CompanyDao;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.domain.CompanyFolder;
import com.newstar.hbms.customer.domain.CompanyIndustry;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fellowlong on 2016/10/22.
 */
public class CompanyServiceImpl implements CompanyService {

  private CompanyDao companyDao;

  private TreeService treeService;

  public void setCompanyDao(CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
  }

  @Override
  public int insertOrUpdate(Company company) {
    int count = 0;
    if (company.getId() != null) {
      count = companyDao.update(company);
      companyDao.cleanIndustries(company.getId());
      companyDao.cleanFolders(company.getId());
    } else {
      count = companyDao.insert(company);
    }
    if (company.getIndustries() != null) {
      for (CompanyIndustry companyIndustry : company.getIndustries()) {
        companyIndustry.setCompanyId(company.getId());
        companyDao.insertIndustry(companyIndustry);
      }
    }
    if (company.getFolders() != null) {
      for (CompanyFolder companyFolder : company.getFolders()) {
        companyFolder.setCompanyId(company.getId());
        companyDao.insertFolder(companyFolder);
      }
    }
    return count;
  }

  @Override
  public int disable(Long[] customerIds) {
    return companyDao.disable(customerIds);
  }

  @Override
  public int enable(Long[] customerIds) {
    return companyDao.enable(customerIds);
  }

  @Override
  public PagingResult<Company> findByBean(Company company, PageRange pageRange) {
    PagingResult<Company> pagingResult = companyDao.findByBean(company, pageRange);
    fillSubObject(pagingResult.getRecords());
    return pagingResult;
  }

  @Override
  public List<Company> findByIds(Long[] ids) {
    List<Company> companies = companyDao.findByIds(ids);
    fillSubObject(companies);
    return companies;
  }

  private void fillSubObject(List<Company> companies) {
    if (companies == null || companies.isEmpty()) {
      return;
    }
    Set<Long> treeNodeIds = new HashSet<Long>();
    Set<Long> companyIds = new HashSet<Long>();
    for (Company company : companies) {
      companyIds.add(company.getId());
      if (company.getCompanyTypeId() != null) {
        treeNodeIds.add(company.getCompanyTypeId());
      }
      if (company.getCityId() != null) {
        treeNodeIds.add(company.getCityId());
      }
      if (company.getNatureId() != null) {
        treeNodeIds.add(company.getNatureId());
      }
      if (company.getPropertyRightStructureId() != null) {
        treeNodeIds.add(company.getPropertyRightStructureId());
      }
    }
    List<CompanyIndustry> companyIndustries =
        companyDao.findIndustriesByCompanyIds(companyIds.toArray(new Long[companyIds.size()]));
    if (companyIndustries != null && !companyIndustries.isEmpty()) {
      for (CompanyIndustry companyIndustry : companyIndustries) {
        treeNodeIds.add(companyIndustry.getIndustryId());
      }
    }
    List<CompanyFolder> companyFolders =
        companyDao.findFoldersByCompanyIds(companyIds.toArray(new Long[companyIds.size()]));
    if (companyFolders != null && !companyFolders.isEmpty()) {
      for (CompanyFolder companyFolder : companyFolders) {
        treeNodeIds.add(companyFolder.getFolderId());
      }
    }

    if (!treeNodeIds.isEmpty()) {
      List<TreeNode> treeNodes = treeService.findTreesByIds(treeNodeIds.toArray(new Long[treeNodeIds.size()]));
      for (TreeNode treeNode : treeNodes) {
        if (companyIndustries != null && !companyIndustries.isEmpty()) {
          for (CompanyIndustry companyIndustry : companyIndustries) {
            if (treeNode.getId().longValue() == companyIndustry.getIndustryId()) {
              companyIndustry.setIndustry(treeNode);
            }
          }
        }
        if (companyFolders != null && !companyFolders.isEmpty()) {
          for (CompanyFolder companyFolder : companyFolders) {
            if (treeNode.getId().longValue() == companyFolder.getFolderId()) {
              companyFolder.setFolder(treeNode);
            }
          }
        }

        for (Company company : companies) {
          if (treeNode.getId().equals(company.getCompanyTypeId())) {
            company.setCompanyType(treeNode);
          }
          if (treeNode.getId().equals(company.getCityId())) {
            company.setCity(treeNode);
          }
          if (treeNode.getId().equals(company.getNatureId())) {
            company.setNature(treeNode);
          }
          if (treeNode.getId().equals(company.getPropertyRightStructureId())) {
            company.setPropertyRightStructure(treeNode);
          }
        }

      }
    }

    for (Company company : companies) {
      if (companyIndustries != null && !companyIndustries.isEmpty()) {
        for (CompanyIndustry companyIndustry : companyIndustries) {
          if (company.getId().equals(companyIndustry.getCompanyId())) {
            company.getIndustries().add(companyIndustry);
          }
        }
      }
      if (companyFolders != null && !companyFolders.isEmpty()) {
        for (CompanyFolder companyFolder : companyFolders) {
          if (company.getId().equals(companyFolder.getCompanyId())) {
            company.getFolders().add(companyFolder);
          }
        }
      }
    }
  }

}
