import com.lakers.SpringConfiguration;
import com.lakers.dao.AccountDao;
import com.lakers.domain.Account;
import com.lakers.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: panyusheng
 * @Date: 2020/5/14 1:24
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestIocXml {

    @Autowired
//    @Qualifier("proxyAccountService")
    private AccountService service;

//    @Before
//    public void init() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
////        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
////        service = ac.getBean("accountService", AccountService.class);
//    }

    @Test
    public void testFindAll() {
        List<Account> allAccount = service.findAllAccount();
        System.out.println(allAccount);
    }

    @Test
    public void testFindById() {
        Account a = service.findAccountById(1);
        System.out.println(a);
    }



    @Test
    public void testTransfer() {
        service.transfer("aaa", "bbb", 100f);
    }

}
