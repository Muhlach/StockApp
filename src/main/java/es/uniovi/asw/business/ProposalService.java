package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.ss.Comment;
import es.uniovi.asw.persistence.model.ss.Proposal;

public interface ProposalService {
	void save(Proposal proposal);
	void delete(Proposal proposal);
	List<Proposal> findAll();
	List<Comment> findCommentsByProposal(Proposal selectedProposal);
	boolean alreadyExists(Proposal proposal);
	Proposal findByTitle(String title);

}
