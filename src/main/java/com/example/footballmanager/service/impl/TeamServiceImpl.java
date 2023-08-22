package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.TeamRepository;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final PlayerService playerService;

    @Override
    public Team create(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team get(Long id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't get the team by id: " + id)
        );
    }

    @Override
    public Team update(Team team) {
        return teamRepository.saveAndFlush(team);
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Transactional
    @Override
    public void transfer(Team from, Team to, Player player) {
        BigDecimal commissionFrom = from.getCommission().movePointLeft(2)
                .multiply(playerService.transferPrice(player));
        BigDecimal fullPrice = playerService.transferPrice(player).add(commissionFrom);

        to.setBalance(to.getBalance().subtract(fullPrice));
        from.setBalance(from.getBalance().add(fullPrice));

        to.getPlayers().add(player);
        from.getPlayers().remove(player);

        update(to);
        update(from);
    }
}
