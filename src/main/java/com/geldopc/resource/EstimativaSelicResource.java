package com.geldopc.resource;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.geldopc.model.EstimativaSelic;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class EstimativaSelicResource {
	
	public List<EstimativaSelic> index() {
		Gson gson = new Gson();
		List<EstimativaSelic> list = new ArrayList<EstimativaSelic>();
		try (Reader reader = new FileReader("json\\estimativa_selic.json")) {
			list = gson.fromJson(reader, new TypeToken<List<EstimativaSelic>>() {}.getType());
			int id = 1;
			for (EstimativaSelic es : list) {
				es.setId(id++);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
