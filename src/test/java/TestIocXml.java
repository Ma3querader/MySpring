import com.lakers.SpringConfiguration;
import com.lakers.domain.Account;
import com.lakers.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: panyusheng
 * @Date: 2020/5/14 1:24
 * @Version 1.0
 */
public class TestIocXml {

    private AccountService service;

    @Before
    public void init() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        service = ac.getBean("accountService", AccountService.class);
    }

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
    public void testSave() {
        Account a = new Account();
        a.setName("火云邪神");
        a.setMoney(4000000f);
        service.saveAccount(a);
    }

    @Test
    public void testUpdate() {
        Account a = new Account();
        a.setName("火云邪神233");
        a.setId(4);
        service.updateAccount(a);
    }

    @Test
    public void testDelete() {
        service.deleteAccount(4);
    }

}
