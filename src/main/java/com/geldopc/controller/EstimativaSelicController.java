package com.geldopc.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geldopc.model.EstimativaSelic;
import com.geldopc.model.MediaEstimativaSelic;
import com.geldopc.repository.EstimativaSelicRepository;

@RestController
@RequestMapping("/estimativaSelic")
public class EstimativaSelicController {

	@Autowired
	private EstimativaSelicRepository repository;

	@GetMapping
	public ResponseEntity<List<EstimativaSelic>> index() {
		List<EstimativaSelic> estitimativaSelicList = repository.findAll();
		if (estitimativaSelicList == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estitimativaSelicList);
	}

	@GetMapping("/{ano}")
	public ResponseEntity<List<EstimativaSelic>> index(@PathVariable(required = true) int ano) {
		List<EstimativaSelic> estitimativaSelicList = repository.findByYear(ano);
		if (estitimativaSelicList == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estitimativaSelicList);
	}

	@GetMapping("/{ano}/{mes}")
	public ResponseEntity<EstimativaSelic> index(@PathVariable(required = true) int ano, @PathVariable int mes) {
		EstimativaSelic estSelict = repository.findByYearAndMonth(ano, mes);
		if (estSelict == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estSelict);
	}
	
	@GetMapping("/media/{ano}")
	public ResponseEntity<MediaEstimativaSelic> media(@PathVariable int ano) {
		List<EstimativaSelic> estitimativaSelicList = repository.findByYear(ano);
		if (estitimativaSelicList == null) {
			return ResponseEntity.notFound().build();
		}
		double totalTaxa = estitimativaSelicList.stream().mapToDouble(f -> f.getEstimativa_taxa_selic()).sum(); 
		double media = totalTaxa / estitimativaSelicList.size();
		DecimalFormat df = new DecimalFormat("#.##");
		MediaEstimativaSelic mediaEstSelic = new MediaEstimativaSelic(ano, Double.valueOf(df.format(media).replace(",", ".")));
		return ResponseEntity.ok(mediaEstSelic);
	}

}
