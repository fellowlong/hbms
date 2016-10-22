package com.newstar.hbms.resume.service;

import com.newstar.hbms.resume.dao.ResumeIndexTaskDao;
import com.newstar.hbms.resume.domain.Resume;
import com.newstar.hbms.resume.domain.ResumeIndexTask;
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

  private ResumeService resumeService;

  private ResumeIndexTaskDao resumeIndexTaskDao;

  private HttpSolrServer httpServer;

  public void init() {
    scheduledExecutorService.scheduleAtFixedRate(new ResumeIndexBuilder(), 0, periodMillisecond, TimeUnit.MILLISECONDS);
  }


  private class ResumeIndexBuilder implements Runnable {

    @Override
    public void run() {
      try {
        ResumeIndexTask resumeIndexTask = new ResumeIndexTask();
        resumeIndexTask.setStatus(0);
        resumeIndexTask.setYn(Boolean.TRUE);
        List<ResumeIndexTask> tasks = resumeIndexTaskDao.findByBean(resumeIndexTask);
        if (tasks != null && !tasks.isEmpty()) {
          for (ResumeIndexTask indexTask : tasks) {
            List<Resume> resumes = resumeService.findByIds(new Long[]{indexTask.getResumeId()});
            if (resumes != null && !resumes.isEmpty()) {
              Resume resume = resumes.get(0);
              httpServer.deleteById(String.valueOf(resume.getId()));
              SolrInputDocument solrDocument = new SolrInputDocument();
              solrDocument.addField("id", resume.getId());
              solrDocument.addField("name", resume.getName());
              solrDocument.addField("keyword", resume.getKeyword());
              solrDocument.addField("remark", resume.getRemark());
              solrDocument.addField("sourceName", resume.getSourceResume().getName());
              solrDocument.addField("sourceText", resume.getSourceResume().getTextResume());
              httpServer.add(solrDocument);
              httpServer.commit();
              indexTask.setStatus(1);
              indexTask.setYn(Boolean.TRUE);
              resumeIndexTaskDao.update(indexTask);
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

  public void setResumeIndexTaskDao(ResumeIndexTaskDao resumeIndexTaskDao) {
    this.resumeIndexTaskDao = resumeIndexTaskDao;
  }

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  public void setPeriodMillisecond(long periodMillisecond) {
    this.periodMillisecond = periodMillisecond;
  }
}
