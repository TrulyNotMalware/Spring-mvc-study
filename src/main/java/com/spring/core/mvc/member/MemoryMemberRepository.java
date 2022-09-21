package com.spring.core.mvc.member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository{

    private Map<Long,Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        this.store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long Id) {
        return store.get(Id);
    }
}
