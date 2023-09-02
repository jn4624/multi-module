package com.dev.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 모듈간 생성 패키지명이 상이하여 Application 구동시
 * 주입 받은 모듈의 Bean을 찾을 수 없을 경우
 * Application의 위치를 동일한 package로 이동하는 방법도 있지만
 * 아래와 같이 @SpringBootApplication의 scanBasePackages 설정으로
 * 각 모듈의 상이한 패키지명을 명시하여 해결하는 방법을 실무에서는 사용을 하고 있다
 */
//@SpringBootApplication(
//    scanBasePackages = {"module-api의 패키지 경로", "module-common의 패키지 경로"}
//)
@SpringBootApplication
//@EntityScan("com.dev.multi.domain.Member")
//@EnableJpaRepositories(basePackages = "com.dev.multi.repositories")
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}

// jvm 옵션으로 profile 설정 후 jar 실행 명령어: java -jar -Dspring.profiles.active=beta module-api-0.0.1-SNAPSHOT.jar
