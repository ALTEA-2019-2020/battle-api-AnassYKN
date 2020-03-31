package TP.controller;


import TP.bo.Battle;
import TP.service.Impl.BattleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/battles")
public class BattleController {

    @Autowired
    BattleServiceImpl battleService;

    @GetMapping("/")
    public ResponseEntity<List<Battle>> getAllBattles() {

        return ResponseEntity.status(200).body(battleService.getAllBattles());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Battle> getBattle(@PathVariable UUID uuid) {
        return ResponseEntity.status(200).body(battleService.getBattleByUUID(uuid));
    }

    @PostMapping("/")
    public ResponseEntity<Pair<UUID, Battle>> postBattle(@RequestParam String trainer, @RequestParam String opponent) {
        return  ResponseEntity.status(200).body(battleService.createBattle(trainer, opponent));

    }


}
