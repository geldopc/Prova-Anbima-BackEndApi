package com.geldopc.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geldopc.model.EstimativaSelic;
import com.geldopc.resource.EstimativaSelicResource;

@Repository
public class EstimativaSelicRepository {
	
	@Autowired
	private EstimativaSelicResource estimativaSelicResource;
	
	public List<EstimativaSelic> findAll() {
		return estimativaSelicResource.index();
	}
	
	public List<EstimativaSelic> findByYear(int year) {
		return estimativaSelicResource.index().stream().filter(
				es -> es.getAno() == year).collect(Collectors.toList());
	}
	
	public EstimativaSelic findByYearAndMonth(int year, int month) {
		EstimativaSelic estSelic = estimativaSelicResource.index().stream().filter(
				es -> (es.getAno() == year) && (month > 0 ? es.getMes() == month : true)).findAny().get();
		return estSelic;
	}
}
