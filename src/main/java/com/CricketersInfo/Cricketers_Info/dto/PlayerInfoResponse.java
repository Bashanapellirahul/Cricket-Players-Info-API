package com.CricketersInfo.Cricketers_Info.dto;

import com.CricketersInfo.Cricketers_Info.model.Gender;
import com.CricketersInfo.Cricketers_Info.model.MatchType;
import com.CricketersInfo.Cricketers_Info.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerInfoResponse {
    private String playerName;
    private int playerAge;
    private int matches;
    private int innings;
    private Double playerAverage;
    private int highestScore;
    private int noOf4s;
    private int noOf6s;
    private int totalRuns;
    private int notOuts;
    private String country;
    private Role role;
    private MatchType matchType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Gender gender;

}
