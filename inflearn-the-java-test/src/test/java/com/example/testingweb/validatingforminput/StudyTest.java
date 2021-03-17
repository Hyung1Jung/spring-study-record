package com.example.testingweb.validatingforminput;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @FastTest
    @DisplayName("스터디 만들기")
    void create_new_Study() {
        Study actual = new Study(100);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    // 아주 간단하게 테스트를 반복할 수 있다. 몇 번을 반복할지 적어주고, 테스트를 작성하면 된다.
    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("test" + repetitionInfo.getCurrentRepetition() + "/" +
                repetitionInfo.getTotalRepetitions());
    }

    // 반복적인 테스트를 할 때마다, 다른 값들을 가지고 테스트틀 하고싶다.
    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(ints = {10, 20, 40})
    void parameterizedTest(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println(study.getLimit());
    }

    static class StudyConverter extends SimpleArgumentConverter{
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
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