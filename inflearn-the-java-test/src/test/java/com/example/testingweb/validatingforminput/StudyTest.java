package com.example.testingweb.validatingforminput;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    void create_new_Study() {
        Study study = new Study(-10);
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(),
                () -> "스터디를 처음 만들면" + StudyStatus.DRAFT + "상태다.");
        /*
        assertEquals(StudyStatus.DRAFT, study.getStatus(),"스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        위처럼 말고, Line 15처럼 람다식으로 만들어주는게 더 좋다.
        람다식을 쓸 경우 실패했을 경우에만 문자열 연산 비용이 들지만, 두 번째는 실패하든 성공하든, 문자열 연산 비용이 든다.

        문자열 계산 하는 비용이 들 것 같으면 람다식을 쓰는 게 성능상 이점을 가질 수 있다. 위와 같은 경우.
        */
        assertTrue(study.getLimit() > 0, "스터디 최대 참석 인원은 0보다 커야 한다.");


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