package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member> authenticate(Member member);
}
