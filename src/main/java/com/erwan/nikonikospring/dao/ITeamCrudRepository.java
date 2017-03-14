package com.erwan.nikonikospring.dao;

import org.springframework.data.repository.CrudRepository;

import com.erwan.nikonikospring.models.Team;

public interface ITeamCrudRepository extends CrudRepository<Team, Long> {

}
