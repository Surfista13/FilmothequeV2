package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceMock implements MemberService {

    private List<Member> members;

    public MemberServiceMock() {
        this.members = List.of(
                new Member(1L, "admin", "admin", "admin", "admin", true),
                new Member(2L, "user", "user", "user", "user", false)
        );
    }

    @Override
    public Optional<Member> authenticate(Member member) {
        Optional<Member> memberOptional = members.stream().filter(m -> m.getLogin().equals(member.getLogin()) && m.getPassword().equals(member.getPassword())).findFirst();
        return memberOptional;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
