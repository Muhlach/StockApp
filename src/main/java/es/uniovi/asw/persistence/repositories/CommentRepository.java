package es.uniovi.asw.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.persistence.model.ss.Comment;
import es.uniovi.asw.persistence.model.ss.Proposal;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByProposal(Proposal selectedProposal);

}
