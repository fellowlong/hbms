package com.newstar.hbms.customer.dao;

import com.newstar.hbms.customer.domain.CompanyFolder;
import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.customer.domain.PositionLanguage;
import com.newstar.hbms.customer.domain.PositionTag;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public interface PositionDao {

  public int insert(Position position);

  public int update(Position position);

  public int disable(Long[] positionIds);

  public int enable(Long[] positionIds);

  public PagingResult<Position> findByBean(Position position, PageRange pageRange);

  public List<Position> findByIds(Long[] ids);

  public int insertLanguage(PositionLanguage positionLanguage);

  public int cleanLanguages(Long positionId);

  public int insertTag(PositionTag positionTag);

  public int cleanTags(Long positionId);

  public List<PositionLanguage> findLanguagesByPositionIds(Long[] positionIdIds);

  public List<PositionTag> findTagsByPositionIds(Long[] positionIdIds);

}
