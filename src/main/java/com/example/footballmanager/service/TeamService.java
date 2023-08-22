package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;

import java.util.List;

public interface TeamService {
    Team create(Team team);

    Team get(Long id);

    Team update(Team team);

    void delete(Long id);

    void transfer(Team from, Team to, Player player);

    List<Team> getAll();
}
