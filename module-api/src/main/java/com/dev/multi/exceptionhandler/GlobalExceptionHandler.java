package com.dev.multi.exceptionhandler;

import com.dev.multi.enums.CodeEnum;
import com.dev.multi.exception.CustomException;
import com.dev.multi.response.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 어떤 Exception을 어떻게 핸들링 할 것인지 정의하기 위한 객체
 * 정의한 return 타입이 client에게 전달된다
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e) {
        /**
         * 리턴할 CommonResponse 객체 Builder 패턴으로 생성
         * info 객체는 필요 없다 가정
         */
        return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }

    /**
     * Custom하게 Exception을 모두 핸들링한다 하더라도 놓칠 수 있는 포인트가 있을 수 있어
     * 그런 점을 방지하고자 Exception.class를 따로 정의
     * Exception 클래스 같은 경우에는 별도로 Custom한게 아니기 때문에 우리가 원하는 값이 없을 수 있다
     * 그럴 땐 협의하에 정한 코드와 메세지로 인위적으로 설정해준다
     */
    @ExceptionHandler(Exception.class)
    public CommonResponse handlerException(Exception e) {
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }
}
