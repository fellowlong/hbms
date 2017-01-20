package jackson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newstar.hbms.system.domain.User;
import junit.framework.TestCase;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by wangjinsi on 17-1-3.
 */
public class Test extends TestCase {



  public void testJacksonFilter() throws IOException, ClassNotFoundException {

    User user = new User();
    user.setId(123L);
    user.setUsername("wang'er");
    user.setRealName("王二兄");

/*    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    //反序列化时：忽略未知属性（默认为true，会抛出异常）
    objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    objectMapper.configure(SerializationConfig.Feature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
    objectMapper.getSerializationConfig().addMixInAnnotations(Object.class, Class.forName("jackson.MixInUser"));
    System.out.println(objectMapper.writeValueAsString(user));*/

    ExclusionStrategy myExclusionStrategy = new ExclusionStrategy() {

      @Override
      public boolean shouldSkipField(FieldAttributes fa) {
        return fa.getName().equals("id") || fa.getName().equals("username"); // <---
      }

      @Override
      public boolean shouldSkipClass(Class<?> clazz) {
        return false;
      }

    };

    Gson gson = new GsonBuilder().disableHtmlEscaping()
        .setExclusionStrategies(myExclusionStrategy) // <---
        .create();

    String json = gson.toJson(user);
    System.out.println(json);
  }

}
