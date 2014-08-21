package com.companyname.hbms.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * User: fellowlong
 * Date: 4/7/13
 * Time: 11:46 AM
 */
public abstract class BeanUtils {

  public static void bindProperties(Object obj, Map<String, Object> properties) {
    if (properties == null || properties.isEmpty()) {
      return;
    }
    MutablePropertyValues pvs = new MutablePropertyValues();
    for (Map.Entry<String, Object> entry : properties.entrySet()) {
      pvs.add(entry.getKey(), entry.getValue());
    }
    BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(obj);
    bw.setPropertyValues(pvs, true);
  }

  public static Object searchValue(Object target, String path) throws NoSuchFieldException, IllegalAccessException {
    if (target == null || path == null || path.length() == 0) {
      return target;
    }
    String currentNode = path.indexOf(".") > -1 ? path.substring(0, path.indexOf(".")) : path;
    String subPath = path.indexOf(".") > -1 ? path.substring(path.indexOf(".") + 1) : null;
    if (Pattern.compile(".+\\[.*]$").matcher(currentNode).find()) {
      subPath = currentNode.substring(currentNode.indexOf("["))
              + ((subPath == null || subPath.length() == 0) ? "" : "." + subPath);
      currentNode = currentNode.substring(0, currentNode.indexOf("["));
    }
    int index = -1;
    if (Pattern.compile("^\\[.*]$").matcher(currentNode).find()) {
      index = Integer.parseInt(currentNode.substring(1, currentNode.length() -1));
    }
    if (target instanceof Collection || target.getClass().isArray()) {
      if (target instanceof Collection) {
        target = ((Collection)target).toArray();
      }
      int i = -1;
      for (Object o : (Object[])target) {
        i++;
        if (index > -1) {
          if (index == i) {
            return searchValue(o, subPath);
          }
        } else {
          return searchValue(o, path);
        }
      }
    } else if (target instanceof Map) {
      return searchValue(((Map)target).get(currentNode), subPath);
    } else {
      Field field = target.getClass().getDeclaredField(currentNode);
      if (field != null) {
        field.setAccessible(true);
        return searchValue(field.get(target), subPath);
      }
    }
    return null;
  }

  public static void main(String[] args) throws IOException, SQLException, NoSuchFieldException, IllegalAccessException {
    /*
    BasicDataSource ds = new BasicDataSource();
    Properties properties = new Properties();
    String p = "driverClassName=oracle.jdbc.driver.OracleDriver\n" +
            "url=jdbc:oracle:thin:@192.168.232.81:1521/ORCL\n" +
            "username=bd_center\n" +
            "password=123456\n" +
            "defaultAutoCommit=true\n";
    properties.load(new ByteArrayInputStream(p.getBytes()));
    Map<String, Object> propertiesA = new HashMap<String, Object>();
    for (String name : properties.stringPropertyNames()) {
      propertiesA.put(name, properties.get(name));
    }
    bindProperties(ds, propertiesA);
    Connection connection = ds.getConnection();
    System.out.println(connection);
    */
    Person person1 = new Person();
    person1.setName("张三");
    person1.setSex("男性");

    Person person2 = new Person();
    person2.setName("阿芳");
    person2.setSex("女性");

    Department department1 = new Department();
    department1.setCode("研发部");

    Department department2 = new Department();
    department2.setCode("人事部");

    Child child1 = new Child();
    child1.setDepartment(department1);
    child1.setAge(13);
    child1.setFav("看书");

    Child child2 = new Child();
    child2.setDepartment(department2);
    child2.setAge(10);
    child2.setFav("游泳");

    List<Child> children = new ArrayList<Child>(2);
    children.add(child1);
    children.add(child2);

    person1.setDepartment(department1);
    person2.setDepartment(department2);

    person1.setChildren(children);
    person2.setChildren(children);

    List<Person> personList = new ArrayList<Person>();
    personList.add(person1);
    personList.add(person2);

    System.out.println(searchValue(new Person[]{person1, person2}, "department.code"));
    System.out.println(searchValue(personList, "department.code"));
    System.out.println(searchValue(personList, "[1].department.code"));
    System.out.println(searchValue(personList, "[1].children[1].department.code"));
    System.out.println(searchValue(person2, "children[1].department.code"));
  }
}

class Person implements Serializable {

  private Long id;
  private String name;
  private String sex;
  private Date updateTime;
  private Date createTime;

  private List<Child> children;

  private Department department;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  List<Child> getChildren() {
    return children;
  }

  void setChildren(List<Child> children) {
    this.children = children;
  }
}

class Child {
  private int age;
  private String fav;
  private Department department;

  int getAge() {
    return age;
  }

  void setAge(int age) {
    this.age = age;
  }

  String getFav() {
    return fav;
  }

  void setFav(String fav) {
    this.fav = fav;
  }

  Department getDepartment() {
    return department;
  }

  void setDepartment(Department department) {
    this.department = department;
  }
}

class Department {

  private Long id;

  private String name;

  private String code;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
