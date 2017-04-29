package es.uniovi.asw.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.ss.Citizen;
import es.uniovi.asw.persistence.model.ss.Comment;
import es.uniovi.asw.persistence.model.ss.Proposal;
import es.uniovi.asw.persistence.model.ss.Vote;
import es.uniovi.asw.persistence.model.ss.VoteProposal;

@Component("ProposalListController")
@Scope("session")
public class ProposaListController {

	private String title;
	private String description;
	@Autowired
	private Factories factoria;

	private Citizen citizen;
	private List<Proposal> list;
	private Proposal selectedProposal;
	private List<Comment> comments;
	private int score;

	@PostConstruct
	public void init() {
		list= factoria.getServicesFactory().getProposalService().findAll();
		citizen=(Citizen) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
	}
	

	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public List<Proposal> getList() {
		return list;
	}

	public Proposal getSelectedProposal() {
		return selectedProposal;
	}

	public void setSelectedProposal(Proposal selectedProposal) {
		this.selectedProposal = selectedProposal;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public void setList(List<Proposal> list) {
		this.list = list;
	}
	
	public List<Proposal> showProposals()
	{
		 list = factoria.getServicesFactory().getProposalService().findAll();
		return list;
	}
	
	public String selectProposal(Proposal pr)
	{
		selectedProposal=pr;
		title=selectedProposal.getTitle();
		description=selectedProposal.getDescription();
		score=selectedProposal.getScore();
		
		return "goToView";
	}
	
	public void removeProposal(Proposal pr){
		factoria.getServicesFactory().getProposalService().delete(pr);
	}
	
	public String goToAddView(){
		return "addView";
	}
	
	public List<Comment> showComments()
	{
		comments = factoria.getServicesFactory().getProposalService().findCommentsByProposal(selectedProposal);
		return comments;
	}

	public void voteProposal(){
		//System.out.println("votando");
		
//		List<Vote> votes = factoria.getServicesFactory().getVoteService().findProposalVotesByCitizen(citizen);		
//		List<VoteProposal> votesProposal = new ArrayList<VoteProposal>();
//		for(Vote vote:votes)
//		{
//			if(((VoteProposal)vote).getProposal().equals(selectedProposal))
//			{
//				votesProposal.add((VoteProposal)vote);
//			}
//		}
//		selectedProposal.setVotes(votesProposal);
		Vote vote= new VoteProposal(citizen,selectedProposal);
		List<Vote> votes = factoria.getServicesFactory().getVoteService().findProposalVotesByCitizen(citizen);
		if(votes.contains(vote)){
			System.out.println("ya votaste");
		}
		else{
			factoria.getServicesFactory().getVoteService().save(vote);
			selectedProposal.setScore(score++);
			factoria.getServicesFactory().getProposalService().save(selectedProposal);
		}
	}


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
