package com.newstar.hbms.candidate.service;

import com.newstar.hbms.candidate.dao.CandidateIndexTaskDao;
import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.candidate.domain.CandidateIndexTask;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjinsi on 2016/10/11.
 */
public class ResumeIndexScheduler {

  private Logger logger = LoggerFactory.getLogger(getClass());

  private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

  private long periodMillisecond = 5000;

  private CandidateService candidateService;

  private CandidateIndexTaskDao candidateIndexTaskDao;

  private HttpSolrServer httpServer;

  public void init() {
    scheduledExecutorService.scheduleAtFixedRate(new ResumeIndexBuilder(), 0, periodMillisecond, TimeUnit.MILLISECONDS);
  }


  private class ResumeIndexBuilder implements Runnable {

    @Override
    public void run() {
      try {
        CandidateIndexTask candidateIndexTask = new CandidateIndexTask();
        candidateIndexTask.setStatus(0);
        candidateIndexTask.setYn(Boolean.TRUE);
        List<CandidateIndexTask> tasks = candidateIndexTaskDao.findByBean(candidateIndexTask);
        if (tasks != null && !tasks.isEmpty()) {
          for (CandidateIndexTask indexTask : tasks) {
            List<Candidate> candidates = candidateService.findByIds(new Long[]{indexTask.getResumeId()});
            if (candidates != null && !candidates.isEmpty()) {
              Candidate candidate = candidates.get(0);
              httpServer.deleteById(String.valueOf(candidate.getId()));
              SolrInputDocument solrDocument = new SolrInputDocument();
              solrDocument.addField("id", candidate.getId());
              solrDocument.addField("name", candidate.getName());
              solrDocument.addField("keyword", candidate.getKeyword());
              solrDocument.addField("remark", candidate.getRemark());
              solrDocument.addField("sourceName", candidate.getResume().getName());
              solrDocument.addField("sourceText", candidate.getResume().getTextResume());
              httpServer.add(solrDocument);
              httpServer.commit();
              indexTask.setStatus(1);
              indexTask.setYn(Boolean.TRUE);
              candidateIndexTaskDao.update(indexTask);
            }
          }
        }
      } catch (Throwable t) {
        logger.error("创建Resume索引失败", t);
      }

    }
  }

  public void setHttpServer(HttpSolrServer httpServer) {
    this.httpServer = httpServer;
  }

  public void setCandidateIndexTaskDao(CandidateIndexTaskDao candidateIndexTaskDao) {
    this.candidateIndexTaskDao = candidateIndexTaskDao;
  }

  public void setCandidateService(CandidateService candidateService) {
    this.candidateService = candidateService;
  }

  public void setPeriodMillisecond(long periodMillisecond) {
    this.periodMillisecond = periodMillisecond;
  }
}
