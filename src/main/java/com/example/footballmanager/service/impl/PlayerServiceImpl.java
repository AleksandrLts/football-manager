package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.service.PlayerService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {
    private static final Long PRICE_PER_MONTH = 100000L;
    private final PlayerRepository playerRepository;

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player get(Long id) {
        return playerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't get the player by id: " + id)
        );
    }

    @Override
    public Player update(Player player) {
        return playerRepository.saveAndFlush(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public BigDecimal transferPrice(Player player) {
        int age = Period.between(player.getDateOfBirth(), LocalDate.now()).getYears();
        int experience = Period.between(player.getDateOfStartCareer(), LocalDate.now()).getMonths();
        return BigDecimal.valueOf(experience * PRICE_PER_MONTH / age);
    }
}
