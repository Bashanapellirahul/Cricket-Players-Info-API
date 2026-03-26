package com.CricketersInfo.Cricketers_Info.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playersInfo")
public class CricketPlayersInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String playerName;
    @Column
    private int playerAge;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column
    private String country;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private MatchType matchType;
    @Column
    private int matches;
    @Column
    private int innings;
    @Column
    private int totalRuns;
    @Column
    private int notOuts;
    @Column
    private Double playerAverage;
    @Column
    private int highestScore;
    @Column
    private int noOf4s;
    @Column
    private int noOf6s;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
