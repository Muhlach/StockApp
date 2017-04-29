package es.uniovi.asw.persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistenceFactoryImpl implements PersistenceFactory{
	
	@Autowired
	private VoteRepository voteRepository;
	@Autowired
	private CitizenRepository citizenRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private ProposalRepository proposalRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ConfigurationRepository configurationRepository;
	@Autowired
	private ForbiddenWordsRepository forbiddenWordsRepository;
	@Autowired
	private AdministratorRepository administratorRepository;
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private ArticuloRepository articuloRepository;
	@Autowired
	private TiendaRepository tiendaRepository;
	
	
	
	@Override
	public CitizenRepository getCitizenRepository() {
		return citizenRepository;
	}
	@Override
	public VoteRepository getVoteRepository() {
		return voteRepository;
	}
	@Override
	public CommentRepository getCommentRepository() {
		return commentRepository;
	}
	@Override
	public ProposalRepository getProposalRepository() {
		return proposalRepository;
	}
	@Override
	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}
	@Override
	public ConfigurationRepository getConfigurationRepository() {
		return configurationRepository;
	}
	@Override
	public ForbiddenWordsRepository getForbiddenWordsRepository() {
		return forbiddenWordsRepository;
	}
	@Override
	public AdministratorRepository getAdministratorRepository() {
		return administratorRepository;
	}
	@Override
	public VentaRepository getVentaRepository() {
		// TODO Auto-generated method stub
		return ventaRepository;
	}
	@Override
	public TiendaRepository getTiendaRepository() {
		// TODO Auto-generated method stub
		return tiendaRepository;
	}
	@Override
	public ArticuloRepository getArticuloRepository() {
		// TODO Auto-generated method stub
		return articuloRepository;
	}


}
