package com.tema.testare.gestiune.presentation;

import com.tema.testare.gestiune.domain.dto.MarketDto;
import com.tema.testare.gestiune.orchestration.MarketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class MarketController {

  @Autowired
  Environment environment;

  @Autowired
  MarketService marketService;

  @PostMapping("/market")
  public ResponseEntity<String> createMarket(@RequestBody MarketDto marketDto) {

    String marketId = marketService.createMarket(marketDto);

    return ResponseEntity.created(URI.create("/market/" + marketId))
        .build();
  }

  @GetMapping("/market/{id}")
  public ResponseEntity<MarketDto> retrieveMarket(@PathVariable("id") String id) {
    MarketDto marketDto = marketService.retrieveMarket(id);

    return ResponseEntity.ok(marketDto);
  }
}
