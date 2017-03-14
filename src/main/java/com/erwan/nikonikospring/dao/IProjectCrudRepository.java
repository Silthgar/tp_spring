package com.erwan.nikonikospring.dao;

import org.springframework.data.repository.CrudRepository;

import com.erwan.nikonikospring.models.Project;

public interface IProjectCrudRepository extends CrudRepository<Project, Long>{

}
