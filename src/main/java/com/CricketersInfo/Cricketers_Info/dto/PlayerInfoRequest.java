package com.CricketersInfo.Cricketers_Info.dto;

import com.CricketersInfo.Cricketers_Info.model.Gender;
import com.CricketersInfo.Cricketers_Info.model.MatchType;
import com.CricketersInfo.Cricketers_Info.model.PlayerStatus;
import com.CricketersInfo.Cricketers_Info.model.Role;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerInfoRequest {
    @NotBlank(message = "Player Name is required")
    private String playerName;

    @Min(value = 1, message = "Age must be at least 1")
    private int playerAge;

    @Min(value = 1, message = "Matches must be at least 1")
    private int matches;

    @Min(value = 1, message = "Innings must be at least 1")
    private int innings;

    private Double playerAverage;

    @Min(value = 0, message = "Highest score cannot be negative")
    private int highestScore;

    @Min(value = 0)
    private int totalRuns;

    @Min(value = 0)
    private int notOuts;

    @Min(value = 0)
    private int noOf4s;

    @Min(value = 0)
    private int noOf6s;

    @NotBlank(message = "Country is required")
    private String country;

    @NotNull(message = "Role is required")
    private Role role;

    @NotNull(message = "Match type is required")
    private MatchType matchType;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Player Status is required")
    private PlayerStatus playerStatus;
}
