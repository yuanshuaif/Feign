package springcloud.Config;

import feign.Logger;
import feign.Request;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

/**
 * Created by 10326 on 2019/5/4.
 */
@Configuration
public class FeignConfiguration {

    // new一个form编码器，实现支持form表单提交
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(this.messageConverters));
    }
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor(){
        return new BasicAuthenticationInterceptor("user", "password");// 服务端会校验该处的用户名密码
    }

    /**
     * 设置连接超时时间，请求获取超时时间`
     * @return
     */
    @Bean
    public Request.Options options(){
        // 默认 10 * 1000, 60 * 1000
        return new Request.Options(5000, 10000);
    }
}
