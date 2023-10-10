package com.ktk.workhuservice.controllers;

import com.ktk.workhuservice.service.TeamRoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamRoundController {

    private TeamRoundService service;

    public TeamRoundController(TeamRoundService service) {
        this.service = service;
    }

    @GetMapping("/teamRounds")
    public ResponseEntity getAllTeamRounds() {
        return ResponseEntity.status(200).body(service.findAll());
    }
}
