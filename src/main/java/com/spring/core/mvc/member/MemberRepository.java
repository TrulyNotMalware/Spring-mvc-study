package com.spring.core.mvc.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long Id);
}
