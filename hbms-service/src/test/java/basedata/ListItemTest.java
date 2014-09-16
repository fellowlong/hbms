package basedata;

import com.companyname.hbms.basedata.domain.ListItem;
import com.companyname.hbms.basedata.service.ListItemService;
import com.companyname.hbms.talent.service.TalentService;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by fellowlong on 2014-09-09.
 */
public class ListItemTest extends TestCase {

  private static Long listItemId = null;

  public void testInsert() {
    ListItemService listItemService = TestUtils.getApplicationContext().getBean(ListItemService.class);
    ListItem listItem = new ListItem(null, "学历", null);
    listItemService.insert(listItem);
    listItemId = listItem.getId();
    Assert.assertNotNull(listItemId);
  }
  public void testUpdate() {
    ListItemService listItemService = TestUtils.getApplicationContext().getBean(ListItemService.class);
    List<ListItem> listItems = listItemService.findByBean(new ListItem(listItemId, null, null));
    Assert.assertTrue(listItems != null && listItems.get(0).getId() .equals(listItemId));
  }
  public void testDeleteById() {
    ListItemService listItemService = TestUtils.getApplicationContext().getBean(ListItemService.class);
    listItemService.deleteById(new Long[]{listItemId});
    List<ListItem> listItems = listItemService.findByBean(new ListItem(listItemId, null, null));
    Assert.assertTrue(listItems == null || listItems.size() == 0);
  }
  public void testFindByBean() {
    testInsert();
    ListItemService listItemService = TestUtils.getApplicationContext().getBean(ListItemService.class);
    ListItem listItem = new ListItem(listItemId, null, null);
    List<ListItem> listItems = listItemService.findByBean(listItem);
    Assert.assertTrue(listItems != null && listItems.size() == 1);
  }
  public void testFindAllCategory() {
    ListItemService listItemService = TestUtils.getApplicationContext().getBean(ListItemService.class);
    List<ListItem> listItems = listItemService.findAllCategory();
    Assert.assertTrue(listItems != null && listItems.size() > 0);
  }


}
