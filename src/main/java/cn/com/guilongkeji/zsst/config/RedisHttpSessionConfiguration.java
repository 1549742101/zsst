package cn.com.guilongkeji.zsst.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author : xgl
 * @date : 2020/3/16 16:41
 * @description :
 */
@Configuration
@EnableRedisHttpSession
public class RedisHttpSessionConfiguration {
}