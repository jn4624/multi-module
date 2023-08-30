package com.dev.multi.service;

import com.dev.multi.enums.CodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {
    private final CommonDemoService commonDemoService;

    public String save() {
        System.out.println(CodeEnum.SUCCESS.getCode());
        return "save";
    }

    public String find() {
        System.out.println(commonDemoService.commonService());
        return "find";
    }
}
