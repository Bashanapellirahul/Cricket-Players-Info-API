package com.CricketersInfo.Cricketers_Info.repository;

import com.CricketersInfo.Cricketers_Info.model.CricketPlayersInfo;
import com.CricketersInfo.Cricketers_Info.model.Gender;
import com.CricketersInfo.Cricketers_Info.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<CricketPlayersInfo, Long> {

    List<CricketPlayersInfo> findByGender(Gender gender);
    List<CricketPlayersInfo> findByRole(Role role);
    Optional<CricketPlayersInfo> findByPlayerNameIgnoreCase(String playerName);
    List<CricketPlayersInfo> findByCountryContainingIgnoreCase(String country);

    Optional<CricketPlayersInfo> findById(Long id);

}
