package es.uniovi.asw.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.ss.Category;
import es.uniovi.asw.persistence.model.ss.Configuration;
import es.uniovi.asw.persistence.model.ss.ForbiddenWords;

@Component("configController")
@Scope("request")
public class ConfigurationController {

	private int lifetime;
	private Configuration conf;
	List<Category> oldCategories;
	List<Category> actualCategories;
	List<ForbiddenWords> words;

	//event attributes
	private boolean skip;
	private ForbiddenWords selectedWord;
	private Category selectedCategory;
	private String addWordInput;
	private String addCategoryInput;

	@Autowired
	private Factories factoria;

	@PostConstruct
	public void init() {
		conf = factoria.getServicesFactory().getConfigurationService().actualConfiguration();
		oldCategories = factoria.getServicesFactory().getCategoryService().findAll();
		actualCategories = new ArrayList<>(oldCategories);
		if(conf != null)
		{
			words = new ArrayList<ForbiddenWords>(conf.getForbiddenWords());
			lifetime = conf.getDeadline();
		}
		else{
			words = new ArrayList<ForbiddenWords>();
			lifetime = 0;
		}		
	}

	public void addForbiddenWord() {
		ForbiddenWords fb = new ForbiddenWords(addWordInput, conf);
		if(!words.contains(fb)){
			//System.out.println("Doesnt contain:"+fb.getWord());
			conf.addWord(fb);
			words.add(fb);
			//System.out.println("adding word");
		}
		else{
			warningForbiddenWord();
		}
		addWordInput = "";
	}

	public void removeForbiddenWord() {
		if(selectedWord!=null)
		{
			conf.removeWord(selectedWord);
			words.remove(selectedWord);
		}

	}

	public void addProvisionalCategory(){
		Category c = new Category(addCategoryInput);
		if(!actualCategories.contains(c)){
			actualCategories.add(c);
			System.out.println("Cat:"+c.getName());
		}
		else
		{
			warningCategory();
		}
		addCategoryInput = "";
	}

	public void removeProvisionalCategory(){
		if(selectedCategory!=null)
		{
			actualCategories.remove(selectedCategory);
			factoria.getServicesFactory().getCategoryService().delete(selectedCategory);
		}
	}

	public String onFlowProcess(FlowEvent event) {
		if(skip) {
			skip = false;   //reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}

	public void warningForbiddenWord() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "This word is already forbidden!"));
	}
	
	private void warningCategory() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "This category already exists!"));
				
	}

	public void saveConfig() {
		for(Category c : actualCategories){
			if(!oldCategories.contains(c)) {
				factoria.getServicesFactory().getCategoryService().save(c);
			}
		}
		for(ForbiddenWords word : words) {
			factoria.getServicesFactory().getForbiddenWordsService().save(word);;
		}
		conf.setDeadline(lifetime);
		factoria.getServicesFactory().getConfigurationService().save(conf);
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	public Configuration getConf() {
		return conf;
	}

	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	public List<Category> getOldCategories() {
		return oldCategories;
	}

	public void setOldCategories(List<Category> oldCategories) {
		this.oldCategories = oldCategories;
	}

	public List<Category> getActualCategories() {
		return actualCategories;
	}

	public void setActualCategories(List<Category> actualCategories) {
		this.actualCategories = actualCategories;
	}

	public List<ForbiddenWords> getWords() {
		return words;
	}

	public void setWords(List<ForbiddenWords> words) {
		this.words = words;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String getAddWordInput() {
		return addWordInput;
	}

	public void setAddWordInput(String addWordInput) {
		this.addWordInput = addWordInput;
	}

	public ForbiddenWords getSelectedWord() {
		return selectedWord;
	}

	public void setSelectedWord(ForbiddenWords selectedWord) {
		this.selectedWord = selectedWord;
	}

	public Category getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public String getAddCategoryInput() {
		return addCategoryInput;
	}

	public void setAddCategoryInput(String addCategoryInput) {
		this.addCategoryInput = addCategoryInput;
	}
	
	


}
