package nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : sgq
 * Date : 2021/1/21 20:11
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class MySpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringbootApplication.class,args);
    }
    @Autowired
    ConfigurableApplicationContext applicationContext;
//    @Value("${driver-class-name}")
//    String driver_2;

    @GetMapping("/getAutoUpdateConfig.do")
    public String getAutoUpdateConfig(){
        String driver =  applicationContext.getEnvironment().getProperty("c2c.driver");
        String url =  applicationContext.getEnvironment().getProperty("c2c.url");
        String user =  applicationContext.getEnvironment().getProperty("c2c.username");
        String password = applicationContext.getEnvironment().getProperty("c2c.password");
        String name = applicationContext.getEnvironment().getProperty("common.name");
        String age = applicationContext.getEnvironment().getProperty("common.age");
        String address = applicationContext.getEnvironment().getProperty("common.address");

        return driver+"->"+url+"->"+user+"->"+password+"||"+
                name+"->"+age+"->"+address+"->";
    }


}
