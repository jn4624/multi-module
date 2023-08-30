package com.dev.multi.service;

import com.dev.multi.enums.CodeEnum;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String save() {
        System.out.println(CodeEnum.SUCCESS.getCode());
        return "save";
    }

    public String find() {
        return "find";
    }
}
