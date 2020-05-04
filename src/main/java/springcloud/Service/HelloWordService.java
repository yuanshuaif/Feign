package springcloud.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import springcloud.Config.FeignConfiguration;

import java.util.Map;

/**
 * Created by 10326 on 2019/4/27.
 * @FeignClient用于通知Feign组件对该接口进行代理(不需要编写接口实现)
 * path统一前缀
 */
@FeignClient(value = "LSJ-SPRINGBOOT",path = "/ces", configuration = FeignConfiguration.class, fallback = FallBackHelloWordService.class)
public interface HelloWordService {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    // 参数中，@RequestParam注解的参数放到url中，没有注解的参数放到body中，使用encoder编码
    String sayHello(Map param);

    // , consumes = "application/x-www-form-urlencoded"   ###未实现###
    @PostMapping(value = "/post", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    String sayHello1(MultiValueMap<String, String> str);
}
