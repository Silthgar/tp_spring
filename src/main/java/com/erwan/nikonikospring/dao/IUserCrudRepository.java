package com.erwan.nikonikospring.dao;

import org.springframework.data.repository.CrudRepository;

import com.erwan.nikonikospring.models.User;

public interface IUserCrudRepository extends CrudRepository<User,Long>{

}
