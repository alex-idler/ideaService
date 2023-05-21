package ylab.bies.ideaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ylab.bies.ideaservice.entity.Idea;

public interface IdeaRepository extends JpaRepository<Idea, Long> {

}
