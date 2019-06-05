package com.sensedia.apix2019.kit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> kits(@RequestBody KitRequest kitRequest) {
        String id = kitService.create(kitRequest);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri())
                .build();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<KitResponse> kitById(@PathVariable String id) {
        KitResponse kitDto = kitService.findById(id);
        return ResponseEntity.ok(kitDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<KitResponse>> kitsByPhone(@RequestParam String phone) {
        if (phone.startsWith(" ")) {
            phone = "+".concat(phone.trim());
        }

        List<KitResponse> kits = kitService.findByPhone(phone);
        if (kits.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(kits);
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> partiallyUpdate(@PathVariable String id,
            @RequestBody RecommendationsPatchRequest recommendationsPatchRequest) {
        kitService.updateSelectedRecommendations(id, recommendationsPatchRequest);
        return ResponseEntity.noContent().build();
    }

}
