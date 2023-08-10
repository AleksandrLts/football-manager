package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;
import java.math.BigDecimal;

public interface PlayerService {
    Player create(Player player);

    Player get(Long id);

    Player update(Player player);

    void delete(Long id);

    BigDecimal transferPrice(Player player);
}
