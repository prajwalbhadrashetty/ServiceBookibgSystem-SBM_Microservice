package com.cts.servicebookingmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.servicebookingmanagement.model.AppServiceReq;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface BookingDao extends CrudRepository<AppServiceReq, Integer>{

	Optional<List<AppServiceReq>> findAllByStatus(@PathVariable(value = "status") String status);
	Optional<List<AppServiceReq>> findAllByUserId(@PathVariable(value = "userId") Integer userId);

	boolean existsByUserId(@PathVariable(value = "userId") Integer userId);

}

