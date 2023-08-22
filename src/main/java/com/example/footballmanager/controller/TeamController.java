package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.dto.response.TeamResponseDto;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.TeamService;
import com.example.footballmanager.service.mapper.DtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    private final DtoMapper<TeamRequestDto, TeamResponseDto, Team> teamMapper;

    @PostMapping
    public TeamResponseDto add(@RequestBody TeamRequestDto teamRequestDto) {
        return teamMapper.mapToDto(teamService
                .create(teamMapper.mapToModel(teamRequestDto)));
    }

    @GetMapping("/{id}")
    public TeamResponseDto get(@PathVariable Long id) {
        return teamMapper.mapToDto(teamService.get(id));
    }

    @PatchMapping("/{id}")
    public TeamResponseDto update(@PathVariable Long id, @RequestBody TeamRequestDto teamRequestDto) {
        Team teamToUpdate = teamMapper.mapToModel(teamRequestDto);
        teamToUpdate.setId(id);
        return teamMapper.mapToDto(teamService
                .update(teamToUpdate));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }

    @GetMapping
    public List<TeamResponseDto> getAll() {
        return teamService.getAll().stream()
                .map(teamMapper::mapToDto)
                .toList();
    }
}
