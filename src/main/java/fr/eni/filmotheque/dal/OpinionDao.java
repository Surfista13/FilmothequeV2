package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionDao extends JpaRepository<Opinion, Long> {
}
