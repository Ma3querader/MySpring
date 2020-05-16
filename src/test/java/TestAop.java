import com.lakers.domain.Account;
import com.lakers.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: panyusheng
 * @Date: 2020/5/16 17:44
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestAop {

    @Autowired
    private AccountService service;

    @Test
    public void testFindAll() {
        List<Account> allAccount = service.findAllAccount();
        System.out.println(allAccount);
    }

    @Test
    public void testTransfer() {
        service.transfer("aaa", "bbb", 100f);
    }

}
