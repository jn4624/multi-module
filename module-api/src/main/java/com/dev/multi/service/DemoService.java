package com.dev.multi.service;

import com.dev.multi.domain.Member;
import com.dev.multi.enums.CodeEnum;
import com.dev.multi.exception.CustomException;
import com.dev.multi.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    @Value("${profile-name}")
    private String name;

    private final CommonDemoService commonDemoService;

    private final MemberRepository memberRepository;

    public String save() {
        System.out.println("name : " + name);

        memberRepository.save(Member.builder()
                .name(Thread.currentThread().getName())
                .build());

        System.out.println(CodeEnum.SUCCESS.getCode());
        return "save";
    }

    public String find() {
        int size = memberRepository.findAll().size();
        System.out.println("DB size : " + size);

        System.out.println(commonDemoService.commonService());
        return "find";
    }

    public String exception() {
        if (true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "exception";
    }
}
