package com.example.testingweb.validatingforminput;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {


    @Test
    @DisplayName("스터디 만들기")
    @EnabledOnOs({OS.LINUX, OS.MAC}) // OS에 특화된 TEST가 있다면
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_11})
    void create_new_Study() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        // LOCAL인 경우에만 다음에 있는 TEST를 실행, 환경변수 = TEST_ENV -> LOCAL로 설정 헀을 때,
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            System.out.println("local");
            Study actual = new Study(100);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });
        assumingThat("hyungil".equalsIgnoreCase(test_env), () -> {
            System.out.println("hyungil");
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });

    }

    @Test
    @DisabledOnOs(OS.LINUX)
    @EnabledOnOs(JRE.OTHER)
    void create1_new_study_again() {
        System.out.println("create1");
    }

    // 모든 테스트가 실행되기 전에, 딱 한번 만 호출이 된다.
    // return 값을 가지면 안되고 반드시 static 이여야 한다.
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    // 모든 테스트가 실행된 이후에, 딱 한번 만 호출이 된다.
    // return 값을 가지면 안되고 반드시 static 이여야 한다.
    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    // 모든 테스트를 실행하기 이전과 이후에  한 번씩 호출이 된다.
    // 굳이 static일 필요가 없다.
    @BeforeEach
    void beforeEach() {
        System.out.println("Bfter each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }

}