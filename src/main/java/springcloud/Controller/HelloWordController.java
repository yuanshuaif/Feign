package springcloud.Controller;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.Service.HelloWordService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10326 on 2019/4/27.
 */
@RestController
public class HelloWordController {
    @Autowired
    private HelloWordService helloWordService;

    @RequestMapping(value = "/hello")
    public String sayHello(){
        try {
            Map param = new HashMap();
            param.put("str", "hello ys");
            return helloWordService.sayHello(param);
        }catch (FeignException exception){
            return "cuowu";
        }
    }

    @RequestMapping(value = "/hello1")
    public String sayHello1(){
        try {
            MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
            List<String> list = new ArrayList<>();
            list.add("hello ys");
            param.put("str", list);
            return helloWordService.sayHello1(param);
        }catch (FeignException exception){
            exception.printStackTrace();
            return "cuowu";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
