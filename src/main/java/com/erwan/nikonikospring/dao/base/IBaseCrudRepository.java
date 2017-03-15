package com.erwan.nikonikospring.dao.base;

import org.springframework.data.repository.CrudRepository;
import com.erwan.nikonikospring.models.modelbase.DatabaseItem;


public interface IBaseCrudRepository<T extends DatabaseItem> extends CrudRepository<T, Long> {
	
	

}
