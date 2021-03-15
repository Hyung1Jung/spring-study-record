package com.example.testingweb.validatingforminput;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    void create_new_Study() {
        Study study = new Study(-10);

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                () -> "스터디를 처음 만들면" + StudyStatus.DRAFT + " 상태다."),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 인원은 0보다 커야 한다.")
        );
        // 3개의 assert문을 모두 실행하기 때문에, 3개중 2개가 깨져도 모두 실행할 수 있다.
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