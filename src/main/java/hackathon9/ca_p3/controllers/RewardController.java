package hackathon9.ca_p3.controllers;

import hackathon9.ca_p3.models.Reward;
import hackathon9.ca_p3.models.RewardItem;
import hackathon9.ca_p3.orchestration.RewardOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class RewardController {

    private final RewardOrchestrator rewardOrchestrator;

    @Autowired
    public RewardController(RewardOrchestrator rewardOrchestrator) {
        this.rewardOrchestrator = rewardOrchestrator;
    }

    @GetMapping(value="/retrieveRewardItems")
    public List<RewardItem> retrieveRewardItems() {
        return rewardOrchestrator.getAvailableRewards();
    }

    @GetMapping(value = "/retrieveUserPoints")
    public Reward getRewardStatus(@CookieValue("userId") UUID userId){
        return rewardOrchestrator.getUserInformation(userId);
    }
}
