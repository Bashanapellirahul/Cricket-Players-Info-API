package com.CricketersInfo.Cricketers_Info.dto;

import com.CricketersInfo.Cricketers_Info.model.Gender;
import com.CricketersInfo.Cricketers_Info.model.MatchType;
import com.CricketersInfo.Cricketers_Info.model.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerInfoRequest {
    @NotBlank(message = "Player Name is required")
    private String playerName;
    private int playerAge;
    private int matches;
    private int innings;
    private Double playerAverage;
    private int highestScore;
    private int totalRuns;
    private int notOuts;
    private int noOf4s;
    private int noOf6s;
    @NotBlank(message = "Country is required")
    private String country;
    private Role role;
    private MatchType matchType;
    private Gender gender;
}
