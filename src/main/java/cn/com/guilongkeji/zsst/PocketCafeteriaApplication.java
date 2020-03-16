package cn.com.guilongkeji.zsst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author xgl
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 800)  //800秒过期时间
@SpringBootApplication
public class PocketCafeteriaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PocketCafeteriaApplication.class, args);
    }

}
