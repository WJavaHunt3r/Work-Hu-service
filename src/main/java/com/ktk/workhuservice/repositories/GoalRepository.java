package com.ktk.workhuservice.repositories;

import com.ktk.workhuservice.data.Goal;
import com.ktk.workhuservice.data.Season;
import com.ktk.workhuservice.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    @Query(" SELECT g from Goal g where g.user = ?1 and g.season.seasonYear = ?2 or g.user.spouseId = ?1 and g.season.seasonYear = ?2")
    Optional<Goal> findByUserAndSeasonSeasonYearOrUserSpouse(User user, Integer season, Long spouseId);

    List<Goal> findBySeason(Season season);
}
