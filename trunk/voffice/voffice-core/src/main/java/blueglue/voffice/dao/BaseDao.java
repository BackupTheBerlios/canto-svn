package blueglue.voffice.dao;

import java.io.Serializable;

public interface BaseDao<E> {
	
	
	
	public E load(Serializable key) throws EntityNotFoundException;

}
