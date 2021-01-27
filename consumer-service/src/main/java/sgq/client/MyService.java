package sgq.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Author : sgq
 * Date : 2021/1/27 17:22
 */
@FeignClient(value = "provide-service")
public interface MyService {
    @GetMapping("/service")
    String service();

    @GetMapping("/person/findAllPerson")
    List<Object> findAllPerson();
}
