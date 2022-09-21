package com.spring.core.mvc.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long Id);
}
