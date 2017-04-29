package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.business.AdministratorService;
import es.uniovi.asw.business.ArticuloService;
import es.uniovi.asw.business.CategoryService;
import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.CommentService;
import es.uniovi.asw.business.ConfigurationService;
import es.uniovi.asw.business.ForbiddenWordsService;
import es.uniovi.asw.business.ProposalService;
import es.uniovi.asw.business.ServicesFactory;
import es.uniovi.asw.business.TiendaService;
import es.uniovi.asw.business.VentaService;
import es.uniovi.asw.business.VoteService;

@Component
public class ServicesFactoryImpl implements ServicesFactory {

	@Autowired
	private VoteService voteService;
	@Autowired
	private CitizenService citizenService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ProposalService proposalService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ConfigurationService configurationService;
	@Autowired
	private ForbiddenWordsService forbiddenWordsService;
	@Autowired
	private AdministratorService administratorService;	
	@Autowired
	private ArticuloService articuloService;	
	@Autowired
	private VentaService ventaService;	
	@Autowired
	private TiendaService tiendaService;	

	@Override
	public CitizenService getCitizenService() {
		return citizenService;
	}

	@Override
	public VoteService getVoteService() {
		return voteService;
	}

	@Override
	public CommentService getCommentService() {
		return commentService;
	}

	@Override
	public ProposalService getProposalService() {
		return proposalService;
	}

	@Override
	public CategoryService getCategoryService() {
		return categoryService;
	}

	@Override
	public ConfigurationService getConfigurationService() {
		return configurationService;
	}

	@Override
	public ForbiddenWordsService getForbiddenWordsService() {
		return forbiddenWordsService;
	}

	@Override
	public AdministratorService getAdministratorService() {
		return administratorService;
	}

	@Override
	public TiendaService getTiendaService() {
		// TODO Auto-generated method stub
		return tiendaService;
	}

	@Override
	public ArticuloService getArticuloService() {
		// TODO Auto-generated method stub
		return articuloService;
	}

	@Override
	public VentaService getVentaService() {
		// TODO Auto-generated method stub
		return ventaService;
	}
	
}
