package com.sensedia.apix2019.kit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sensedia.apix2019.kit.request.KitRequest;
import com.sensedia.apix2019.kit.request.RecommendationsPatchRequest;
import com.sensedia.apix2019.kit.response.KitResponse;
import com.sensedia.apix2019.kit.service.KitService;

@RestController
@RequestMapping("/kits")
@CrossOrigin
public class KitController {

	@Autowired
	private KitService kitService;

	// eu sou um post! alguém viu minha anotação por aí?
	public ResponseEntity<Void> kits(@RequestBody KitRequest kitRequest) {
		return null;
	}

	// eu sou um get! alguém viu minha anotação por aí?
	public ResponseEntity<List<KitResponse>> kitsByPhone(@RequestParam String phone) {
		return null;
	}

	// eu sou um patch! alguém viu minha anotação por aí?
	public ResponseEntity<Void> partiallyUpdate(@PathVariable String id,
			@RequestBody RecommendationsPatchRequest recommendationsPatchRequest) {
		return null;
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<KitResponse> kitById(@PathVariable String id) {
		return null;
	}
}
