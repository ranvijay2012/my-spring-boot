package com.spring.boot.dataConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "my-address", url = "http://localhost:9090/add/v1")
public interface AddressServiceTemplate {

    @GetMapping("/api")
    String getData();
}
