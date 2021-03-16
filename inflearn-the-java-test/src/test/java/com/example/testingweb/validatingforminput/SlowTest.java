package com.example.testingweb.validatingforminput;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 이 애노테이션을 사용한 코드가 이 애노티에션 정보를 런타임까지도 유지를 해야한다는 설정
@Retention(RetentionPolicy.RUNTIME)
// 이 애노테이션을 어디에 쓸 수 있는가.
@Target(ElementType.METHOD)
@Test
@Tag("slow")
public @interface SlowTest {
}
