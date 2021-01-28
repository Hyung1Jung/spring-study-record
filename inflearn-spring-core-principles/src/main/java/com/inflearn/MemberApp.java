package com.inflearn;

import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import com.inflearn.member.MemberService;
import com.inflearn.order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//      ApplicationContext가 컨테이너라고 보면 되고 applicationContext가 bean들을 다 관리해준다. 스프링 컨테이너에 객체 생성한 것들을 다 집어넣고 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
