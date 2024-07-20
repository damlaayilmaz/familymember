package org.example.famtree.Service;

import org.example.famtree.MemberRepository.MemberRepository;
import org.example.famtree.model.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service

public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<member> findById(int id) {
        return memberRepository.findById();
    }

    public member createMember(member member) {
        return memberRepository.save(member);
    }

    public Optional<member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public member updateMember(Long id, member updatedMember) {
        return memberRepository.findById(id)
                .map(member -> {
                    member.setFirstName(updatedMember.getFirstName());
                    member.setLastName(updatedMember.getLastName());
                    member.setEmail(updatedMember.getEmail());
                    member.setPhone(updatedMember.getPhone());
                    return memberRepository.save(member);
                })
                .orElseGet(() -> {
                    updatedMember.setID(id);
                    return memberRepository.save(updatedMember);
                });
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);

    }
}