package com.example.testingweb.validatingforminput.study;


import com.example.testingweb.validatingforminput.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/*
구현체는 없지만 인터페이스만 알고 있고 그 인터페이스 기반으로 코드를 작성하고 있는데, 내가 작성한 코드가 잘 동작하는지 확인을 하려면
Mocking을 해야한다.
 */

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService() {

        MemberService memberService = mock(MemberService.class);
        StudyRepository studyRepository = mock(StudyRepository.class);

        StudyService studyService = new StudyService(memberService, studyRepository);

        assertNotNull(studyService);
    }

}