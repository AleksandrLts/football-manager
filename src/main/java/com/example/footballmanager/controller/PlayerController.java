package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.PlayerRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.mapper.DtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final DtoMapper<PlayerRequestDto, PlayerResponseDto, Player> playerMapper;

    @PostMapping
    public PlayerResponseDto add(@RequestBody PlayerRequestDto playerRequestDto) {
        return playerMapper.mapToDto(playerService
                .create(playerMapper.mapToModel(playerRequestDto)));
    }

    @GetMapping("/{id}")
    public PlayerResponseDto get(@PathVariable Long id) {
        return playerMapper.mapToDto(playerService.get(id));
    }

    @PatchMapping("/{id}")
    public PlayerResponseDto update(@PathVariable Long id,
                                    @RequestBody PlayerRequestDto playerRequestDto) {
        Player playerToUpdate = playerMapper.mapToModel(playerRequestDto);
        playerToUpdate.setId(id);
        return playerMapper.mapToDto(playerService
                .update(playerToUpdate));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}
