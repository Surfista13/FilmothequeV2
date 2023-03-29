package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Long> {
}
