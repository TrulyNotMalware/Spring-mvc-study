package com.spring.core.mvc.member;

public class MemberServiceImpl implements MemberService{
    //Interface 만 갖고는 구현 객체가 없어서 NullPointerException 발생.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMember(Long Id) {
        return this.memberRepository.findById(Id);
    }
}
