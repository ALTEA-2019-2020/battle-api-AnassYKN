package TP.repository.Impl;

import TP.bo.Battle;
import TP.repository.BattleRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BattleRepositoryImpl implements BattleRepository {

    private Map<UUID,Battle> battles = new HashMap<>();

    @Override
    public Battle createBattle(Battle battle) {
            battles.put(battle.getUUID(),battle);
            return battle;
    }

    @Override
    public Battle getBattleByUUID(UUID uuid) {
        if (battles.containsKey(uuid)) {
            return battles.get(uuid);
        }else{
            return null;
        }

    }

    @Override
    public HashSet<Battle> getAllBattles() {
        return new HashSet<Battle>(battles.values());
    }
}
