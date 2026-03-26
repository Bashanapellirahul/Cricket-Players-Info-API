package com.CricketersInfo.Cricketers_Info.controller;

import com.CricketersInfo.Cricketers_Info.dto.PlayerInfoRequest;
import com.CricketersInfo.Cricketers_Info.dto.PlayerInfoResponse;
import com.CricketersInfo.Cricketers_Info.model.Gender;
import com.CricketersInfo.Cricketers_Info.model.Role;
import com.CricketersInfo.Cricketers_Info.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService service;


    @PostMapping
    public ResponseEntity<PlayerInfoResponse> createPlayerInfo(@Valid @RequestBody PlayerInfoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPlayerInfo(request));
    }

    @GetMapping
    public ResponseEntity<List<PlayerInfoResponse>> getAllPlayerInfo(){
        return ResponseEntity.ok(service.getAllPlayersInfo());
    }

    @GetMapping("/name")
    public ResponseEntity<List<PlayerInfoResponse>> getSinglePlayerInfo(@RequestParam String name){
        return ResponseEntity.ok(service.getSinglePlayerInfoByName(name));
    }

    @GetMapping("/role")
    public ResponseEntity<List<PlayerInfoResponse>> getPlayerInfoByRole(@RequestParam Role role){
        return ResponseEntity.ok(service.getPlayerInfoByRole(role));
    }

    @GetMapping("/country")
    public ResponseEntity<List<PlayerInfoResponse>> getPlayerInfoByCountry(@RequestParam String country){
        return ResponseEntity.ok(service.getPlayerinfoByCountry(country));
    }

    @GetMapping("/gender")
    public ResponseEntity<List<PlayerInfoResponse>> getPlayerInfoByGender(@RequestParam Gender gender){
        return ResponseEntity.ok(service.getPlayerInfoByGender(gender));
    }

    @PutMapping("/name")
    public ResponseEntity<PlayerInfoResponse> updatePlayerInfoByName(@RequestParam String name, PlayerInfoRequest request ){
        return ResponseEntity.ok(service.updatePlayerInfo(name, request));
    }

}

