package com.CricketersInfo.Cricketers_Info.service;

import com.CricketersInfo.Cricketers_Info.dto.PlayerInfoRequest;
import com.CricketersInfo.Cricketers_Info.dto.PlayerInfoResponse;
import com.CricketersInfo.Cricketers_Info.model.CricketPlayersInfo;
import com.CricketersInfo.Cricketers_Info.model.Gender;
import com.CricketersInfo.Cricketers_Info.model.Role;
import com.CricketersInfo.Cricketers_Info.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;

    public PlayerInfoResponse createPlayerInfo(PlayerInfoRequest request){

        CricketPlayersInfo entity = new CricketPlayersInfo();
        mapToRequest(entity, request);
        return mapToResponse(repository.save(entity));
    }

    public List<PlayerInfoResponse> getAllPlayersInfo(){
       return  repository.findAll()
               .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<PlayerInfoResponse> getSinglePlayerInfoByName(String playerName ){
        return repository.findByPlayerNameIgnoreCase(playerName)
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public PlayerInfoResponse getPlayerInfoById(Long id){
        CricketPlayersInfo entity = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Player Not Found with id: "+id));
        return mapToResponse(entity);
    }

    public List<PlayerInfoResponse> getPlayerInfoByRole(Role role){
        return repository.findByRole(role)
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<PlayerInfoResponse> getPlayerInfoByCountry(String country){
        return repository.findByCountryContainingIgnoreCase(country)
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<PlayerInfoResponse> getPlayerInfoByGender(Gender gender){
        return repository.findByGender(gender).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public PlayerInfoResponse updatePlayerInfoByName(String name, PlayerInfoRequest request){

        CricketPlayersInfo entity = repository.findByPlayerNameIgnoreCase(name).orElseThrow(()->new RuntimeException("Player not found"));
        mapToRequest(entity, request);
        return mapToResponse(repository.save(entity));
    }

    public PlayerInfoResponse updatePlayerInfoById(Long id, PlayerInfoRequest request){

        CricketPlayersInfo entity = repository.findById(id).orElseThrow(()->new RuntimeException("Player not found"));
        mapToRequest(entity, request);
        return mapToResponse(repository.save(entity));
    }

    public void deletePlayerInfoByName(String name){
        CricketPlayersInfo cricketPlayersInfo = repository.findByPlayerNameIgnoreCase(name)
                .orElseThrow(()->new RuntimeException("Player name not found"));
        repository.delete(cricketPlayersInfo);
    }

    public void deletePlayerInfoById(Long id){
        CricketPlayersInfo cricketPlayersInfo = repository.findById(id)
                .orElseThrow(()->new RuntimeException("Player name not found"));
        repository.delete(cricketPlayersInfo);
    }

    public double calculateAverage(int totalRuns, int innings, int notOuts){
        int timesOut = innings - notOuts;
        if(timesOut==0){
            return totalRuns;
        }

        return (double) totalRuns/timesOut;
    }

    private PlayerInfoResponse mapToResponse(CricketPlayersInfo entity){
        PlayerInfoResponse response = new PlayerInfoResponse();
        response.setId(entity.getId());
        response.setPlayerName(entity.getPlayerName());
        response.setPlayerAge(entity.getPlayerAge());
        response.setCountry(entity.getCountry());
        response.setMatches(entity.getMatches());
        response.setInnings(entity.getInnings());
        response.setTotalRuns(entity.getTotalRuns());
        response.setNotOuts(entity.getNotOuts());
        response.setPlayerAverage(calculateAverage(entity.getTotalRuns(), entity.getInnings(), entity.getNotOuts()));
        response.setHighestScore(entity.getHighestScore());
        response.setNoOf4s(entity.getNoOf4s());
        response.setNoOf6s(entity.getNoOf6s());
        response.setRole(entity.getRole());
        response.setGender(entity.getGender());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        response.setMatchType(entity.getMatchType());
        return  response;
    }

    private void mapToRequest(CricketPlayersInfo entity, PlayerInfoRequest request){
        if(request.getNotOuts()>request.getInnings()){
            throw new RuntimeException("Not outs should not exceed innings");
        }
        if(request.getMatches()<request.getInnings()){
            throw new RuntimeException("Innings must be less than Matches");
        }
        if(request.getRole() == null ||request.getMatchType() == null ||request.getGender() == null ){
            throw new RuntimeException("Role, MatchType and Gender is required");
        }
        if(request.getTotalRuns() < request.getHighestScore()){
            throw new RuntimeException("Total runs can not be less than highest score");
        }
        if(request.getInnings() - request.getNotOuts() == 0){
            throw new IllegalArgumentException("Can not calculate average (Division by zero)");
        }
        entity.setPlayerName(request.getPlayerName());
        entity.setPlayerAge(request.getPlayerAge());
        entity.setCountry(request.getCountry());
        entity.setMatches(request.getMatches());
        entity.setInnings(request.getInnings());
        entity.setTotalRuns(request.getTotalRuns());
        entity.setNotOuts(request.getNotOuts());
        entity.setPlayerAverage(calculateAverage(request.getTotalRuns(), request.getInnings(), request.getNotOuts()));
        entity.setHighestScore(request.getHighestScore());
        entity.setNoOf4s(request.getNoOf4s());
        entity.setNoOf6s(request.getNoOf6s());
        entity.setRole(request.getRole());
        entity.setGender(request.getGender());
        entity.setMatchType(request.getMatchType());

    }
}

