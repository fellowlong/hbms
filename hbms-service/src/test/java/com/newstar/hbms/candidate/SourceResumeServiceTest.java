/*
package com.newstar.hbms.resume;

import com.newstar.hbmsattachmentdomain.SourceResume;
import com.newstar.hbmsattachmentservice.SourceResumeService;
import com.newstar.hbms.utils.FileUtils;
import com.newstar.hbms.utils.WordParser;
import junit.framework.TestCase;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.mapper.Mapping;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.highlight.HighlightField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.net.InetAddress;
import java.util.List;

*/
/**
 * Created by wangjinsi on 2016/2/10.
 *//*

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SourceResumeServiceTest extends TestCase {

  @Autowired
  SourceResumeService sourceResumeService;

  @Test
  public void testInsert() throws IOException {
    Resume sourceResume = new Resume();
    sourceResume.setName("张三的简历");
    FileInputStream fileInputStream = new FileInputStream("C:/吴奇的简历.doc");
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int length = 0;
    byte[] buffer = new byte[1024];
    while ((length = fileInputStream.read(buffer, 0, buffer.length)) > 0) {
      out.write(buffer, 0, length);
    }
    fileInputStream.close();
    out.close();
    sourceResume.setBinaryResume(out.toByteArray());
    String textResume = FileUtils.getText("C:/吴奇的简历.doc");
    sourceResume.setTextResume(textResume);
    sourceResumeService.insert(sourceResume);
  }

  @Test
  public void testEsCreateIndex() throws IOException {
    */
/*Client client = TransportClient.builder().build()
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    System.out.println(client.admin().indices().create(Requests.createIndexRequest("hbms")).actionGet());*//*

  }


  @Test
  public void testEsMapping() throws IOException {
    Client client = TransportClient.builder().build()
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    PutMappingRequest request = Requests.putMappingRequest("hbms").type("candidate").source(XContentFactory.jsonBuilder()
    .startObject()
      .startObject("candidate")
        .startObject("_all")
          .field("analyzer", "ik_max_word")
          .field("search_analyzer", "ik_max_word")
          .field("term_vector", "no")
        .endObject()
        .startObject("properties")
          .startObject("name")
            .field("type", "string")
            .field("term_vector", "with_positions_offsets")
            .field("analyzer", "ik_max_word")
            .field("search_analyzer", "ik_max_word")
            .field("include_in_all", "true")
            .field("boost", 8)
          .endObject()
          .startObject("textResume")
            .field("type", "string")
            .field("term_vector", "with_positions_offsets")
            .field("analyzer", "ik_max_word")
            .field("search_analyzer", "ik_max_word")
            .field("include_in_all", "true")
            .field("boost", 8)
          .endObject()
          .startObject("createTime")
            .field("type", "date")
            .field("index", "not_analyzed")
          .endObject()
          .startObject("createUser")
            .field("type", "string")
            .field("index", "not_analyzed")
          .endObject()
          .startObject("updateTime")
            .field("type", "date")
            .field("index", "not_analyzed")
          .endObject()
          .startObject("updateUser")
            .field("type", "string")
            .field("index", "not_analyzed")
          .endObject()
        .endObject()
      .endObject()
    .endObject());
    System.out.println(client.admin().indices().putMapping(request).actionGet());
  }



  @Test
  public void testInsertEs() throws IOException {
    List<Resume> sourceResumes = sourceResumeService.findByIds(new Long[]{5L});
    Resume sourceResume = sourceResumes.get(0);
    Client client = TransportClient.builder().build()
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    IndexResponse response = client.prepareIndex("hbms", "candidate", String.valueOf(sourceResume.getId()))
        .setSource(XContentFactory.jsonBuilder()
            .startObject()
            .field("name", sourceResume.getName())
            .field("textResume", sourceResume.getTextResume())
            .field("createTime", sourceResume.getCreateTime())
            .field("createUser", sourceResume.getCreateUser())
            .field("updateTime", sourceResume.getUpdateTime())
            .field("updateUser", sourceResume.getUpdateUser())
            .endObject())
//        .setSource("{\"name\":\"张三\"}")
        .get();
    System.out.println(response);
  }


  @Test
  public void testQueryEs() throws IOException {
    Client client = TransportClient.builder().build()
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    SearchResponse response = client.prepareSearch("hbms")
        .setTypes("candidate")
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        .setQuery(QueryBuilders.matchQuery("textResume", "吴奇"))                 // Query
        .setFrom(0).setSize(60).setExplain(true)
        .addHighlightedField("textResume")
//        .setHighlighterFragmentSize(Integer.MAX_VALUE)
        .setHighlighterPreTags("<span style=\"color:red\">")
        .setHighlighterPostTags("</span>")
        .execute()
        .actionGet();
//    System.out.println(response);
    for (SearchHit searchHit : response.getHits().getHits()) {
      for (HighlightField searchHitField : searchHit.getHighlightFields().values()) {
        System.out.println(searchHitField.getName());
        for (Text text : searchHitField.fragments()) {
          System.out.println(text.string());
        }
      }
      System.out.println("===================================================");
    }
  }

}
*/
