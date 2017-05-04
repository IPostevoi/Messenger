package hello;

import hello.storage.UserJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bakla410 on 03.05.17.
 */

public class Config {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    private  static UserJDBC userJDBC =
            (UserJDBC)context.getBean("userJDBC");

    public static UserJDBC getStorage() {
        return userJDBC;
    }
}
