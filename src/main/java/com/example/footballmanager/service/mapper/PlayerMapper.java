package com.example.footballmanager.service.mapper;

import com.example.footballmanager.dto.request.PlayerRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper implements DtoMapper<PlayerRequestDto, PlayerResponseDto, Player> {
    @Override
    public Player mapToModel(PlayerRequestDto dto) {
        Player player = new Player();
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setDateOfBirth(dto.getDateOfBirth());
        Team team = new Team();
        team.setId(dto.getTeamId());
        player.setTeam(team);
        player.setDateOfStartCareer(dto.getDateOfStartCareer());
        return player;
    }

    @Override
    public PlayerResponseDto mapToDto(Player model) {
        PlayerResponseDto playerResponseDto = new PlayerResponseDto();
        playerResponseDto.setId(model.getId());
        playerResponseDto.setFirstName(model.getFirstName());
        playerResponseDto.setLastName(model.getLastName());
        playerResponseDto.setDateOfBirth(model.getDateOfBirth());
        playerResponseDto.setDateOfStartCareer(model.getDateOfStartCareer());
        playerResponseDto.setTeamId(model.getTeam().getId());
        return playerResponseDto;
    }
}
