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
@CrossOrigin("*")
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

    @GetMapping("/{id}")
    public ResponseEntity<PlayerInfoResponse> getSinglePlayerInfoById(@PathVariable Long id){
        return ResponseEntity.ok(service.getPlayerInfoById(id));
    }

    @GetMapping("/role")
    public ResponseEntity<List<PlayerInfoResponse>> getPlayerInfoByRole(@RequestParam Role role){
        return ResponseEntity.ok(service.getPlayerInfoByRole(role));
    }

    @GetMapping("/country")
    public ResponseEntity<List<PlayerInfoResponse>> getPlayerInfoByCountry(@RequestParam String country){
        return ResponseEntity.ok(service.getPlayerInfoByCountry(country));
    }

    @GetMapping("/gender")
    public ResponseEntity<List<PlayerInfoResponse>> getPlayerInfoByGender(@RequestParam Gender gender){
        return ResponseEntity.ok(service.getPlayerInfoByGender(gender));
    }

    @PutMapping("/name")
    public ResponseEntity<PlayerInfoResponse> updatePlayerInfoByName(@RequestParam String name, PlayerInfoRequest request ){
        return ResponseEntity.ok(service.updatePlayerInfoByName(name, request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerInfoResponse> updatePlayerInfoById(@PathVariable Long id, @RequestBody PlayerInfoRequest request){
        return ResponseEntity.ok(service.updatePlayerInfoById(id, request));
    }

    @DeleteMapping("/name")
    public ResponseEntity<String> deletePlayerInfoByName(@RequestParam String name){
        service.deletePlayerInfoByName(name);
        return ResponseEntity.ok("Player Info is deleted successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayerInfoByName(@PathVariable long id){
        service.deletePlayerInfoById(id);
        return ResponseEntity.ok("Player Info is deleted successfully");
    }

    @GetMapping("/sortPlayers")
    public ResponseEntity<List<PlayerInfoResponse>> getSortedPlayerInfo(@RequestParam boolean status){
        return ResponseEntity.ok(service.getPlayerInfoSorting(status, "totalRuns"));
    }

    @GetMapping("/paginatedPlayersInfo")
    public ResponseEntity<List<PlayerInfoResponse>> getSortedPlayersWithPagination(
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "5") int recordsPerPage,
            @RequestParam(defaultValue = "asc") boolean status,
            @RequestParam(defaultValue = "totalRuns") String sortBy){
        return  ResponseEntity.ok(service.getPaginationPlayerInfo(pageNum, recordsPerPage,
                status, sortBy));
    }

//    @GetMapping("/sortedAndPgntdPlyrInfo")
//    public ResponseEntity<List<PlayerInfoResponse>> getDynamicallySortedAndPaginationPlayerInfo(
//            @RequestParam int pageNum, @RequestParam boolean status){
//        return ResponseEntity.ok(service.getDynamicPaginationPlayerInfo(pageNum,status,"totalRuns"));
//    }
}

