package common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fellowlong on 2014-10-27.
 */
public abstract class TestUtils {

  public static ApplicationContext applicationContext = null;

  static {
    applicationContext = new ClassPathXmlApplicationContext("classpath:dispatcher-servlet.xml");
  }

  public static <T> T getBean(String name) {
    return (T) applicationContext.getBean(name);
  }

  public static <T> T getBean(Class clazz) {
    return (T) applicationContext.getBean(clazz);
  }

}
