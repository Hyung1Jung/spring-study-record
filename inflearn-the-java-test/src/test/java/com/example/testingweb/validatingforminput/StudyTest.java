package com.example.testingweb.validatingforminput;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

/*
    100이 넘으면 300까지 기다릴 필요 없이 바로 종료, assertTimeoutPreemptively

    주의해서 사용하여함. 테스트코드에서 이 코드블럭은 별도의 쓰레드에서 실행하기 때문에
    만약에 ThreadLocal을 사용하는 코드블럭이 있다면, 예상치 못한 에러가 발생할 수 있다.
    스프링 트랜잭션 전략 같은 경우는 ThreadLocal을 기본적으로 사용을 하는데 ThreadLocal는 다른 Thread는 공유가 안되기 때문에 스프링이 만든 트랜잭션 설정이 적용이 제대로 안될 수 가 있다.
    트랜잭션은 롤백을 기본적으로 실행을 하는데 롤백이 안되고 DB에 반영이 되는 경우가 생길 수 있다. 트랜잭션 설정을 가지고 있는 쓰레드와 별개로 실항하기 때문이다. 쓰레드와 관련이 없는 코드를 실행할 경우 괞찮다.
*/

    @Test
    @DisplayName("스터디 만들기")
    void create_new_Study() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test
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