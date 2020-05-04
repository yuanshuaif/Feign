package springcloud.Service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * Created by 10326 on 2020/1/12.
 * feign集成hystrix的降级方案
 */
@Component
public class FallBackHelloWordService implements HelloWordService {
    @Override
    public String sayHello(Map param) {
        return "this's fallbak method";
    }

    @Override
    public String sayHello1(MultiValueMap<String, String> str) {
        return "this's fallbak method11";
    }
}
