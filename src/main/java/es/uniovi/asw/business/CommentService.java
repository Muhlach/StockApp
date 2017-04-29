package es.uniovi.asw.business;

import es.uniovi.asw.persistence.model.ss.Comment;

public interface CommentService {
	void save(Comment coment);
	void delete(Comment coment);

}
