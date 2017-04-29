package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.ss.Citizen;
import es.uniovi.asw.persistence.model.ss.Vote;
import es.uniovi.asw.persistence.model.ss.VoteComment;
import es.uniovi.asw.persistence.model.ss.VoteProposal;

public interface VoteService {
	void save(Vote vote);
	List<Vote> findCommentVotesByCitizen(Citizen citizen);
	List<Vote> findProposalVotesByCitizen(Citizen citizen);
}
