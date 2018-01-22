package com.newstar.hbms.customer.dao;

import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.domain.CompanyFolder;
import com.newstar.hbms.customer.domain.CompanyIndustry;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2016/10/22.
 */
public interface CompanyDao {

  public int insert(Company company);

  public int update(Company company);

  public int disable(Long[] customerIds);

  public int enable(Long[] customerIds);

  public PagingResult<Company> findByBean(Company company, PageRange pageRange);

  public List<Company> findByIds(Long[] ids);

  public int insertIndustry(CompanyIndustry companyIndustry);

  public int cleanIndustries(Long companyId);

  public int insertFolder(CompanyFolder companyFolder);

  public int cleanFolders(Long companyId);

  public List<CompanyIndustry> findIndustriesByCompanyIds(Long[] companyIds);

  public List<CompanyFolder> findFoldersByCompanyIds(Long[] companyIds);



}
