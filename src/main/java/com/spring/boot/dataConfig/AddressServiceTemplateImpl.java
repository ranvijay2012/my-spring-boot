package com.spring.boot.dataConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddressServiceTemplateImpl {

    @Autowired
    private AddressServiceTemplate addressServiceTemplate;

    public String getData() {
        log.info("data is getting from address service");
        return addressServiceTemplate.getData();
    }
}
