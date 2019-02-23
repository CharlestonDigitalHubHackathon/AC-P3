package hackathon9.ca_p3.orchestration;

import hackathon9.ca_p3.models.Reward;
import hackathon9.ca_p3.models.RewardItem;
import hackathon9.ca_p3.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RewardOrchestrator {

    private final RewardRepository rewardRepository;

    @Autowired
    public RewardOrchestrator(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public Reward getUserInformation(UUID userId){
       return rewardRepository.findById(userId).orElse(null);
    }

    public List<RewardItem> getAvailableRewards(){
        return null;
    }


}
