package com.example.footballmanager.service.mapper;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.dto.response.TeamResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;

import java.util.stream.Collectors;

public class TeamMapper implements DtoMapper<TeamRequestDto, TeamResponseDto, Team> {
    @Override
    public Team mapToModel(TeamRequestDto dto) {
        Team team = new Team();
        team.setName(dto.getName());
        team.setCountry(dto.getCountry());
        team.setBalance(dto.getBalance());
        team.setCommission(dto.getCommission());
        return team;
    }

    @Override
    public TeamResponseDto mapToDto(Team team) {
        TeamResponseDto teamResponseDto = new TeamResponseDto();
        teamResponseDto.setId(team.getId());
        teamResponseDto.setName(team.getName());
        teamResponseDto.setCountry(team.getCountry());
        teamResponseDto.setBalance(team.getBalance());
        teamResponseDto.setCommission(team.getCommission());
        teamResponseDto.setPlayersIds(team.getPlayers()
                .stream()
                .map(Player::getId)
                .collect(Collectors.toSet()));
        return teamResponseDto;
    }
}
