
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CatanAgent {
 void init(int playerId);
 Move chooseInitialSettlement(GameState state);
 Move chooseInitialRoad(GameState state);
 Move chooseMove(GameState state);
 Map<ResourceType, Integer> chooseDiscard(GameState state,int discardCount);
 ResourceType chooseResource(GameState state);
 int chooseRobberTarget(GameState state, List<Integer> possibleTargets);
 DevelopmentCard chooseDevelopmentCard(GameState state);
}


public class StubCatanAgent implements CatanAgent {
    
    private int playerId;
    
    
    private static final int DEFAULT_SETTLEMENT_LOCATION = 0;
    private static final int DEFAULT_ROAD_LOCATION = 0;
    private static final ResourceType DEFAULT_RESOURCE = ResourceType.BRICK;
    
    @Override
    public void init(int playerId) {
        this.playerId = playerId;
    }
    
    @Override
    public Move chooseInitialSettlement(GameState state) {
        return new Move(MoveType.SETTLEMENT, DEFAULT_SETTLEMENT_LOCATION);
    }
    
    @Override
    public Move chooseInitialRoad(GameState state) {
        return new Move(MoveType.ROAD, DEFAULT_ROAD_LOCATION);
    }
    
    @Override
    public Move chooseMove(GameState state) {
        return new Move(MoveType.PASS);
    }
    
    @Override
    public Map<ResourceType, Integer> chooseDiscard(GameState state, int discardCount) {
        Map<ResourceType, Integer> discard = new HashMap<>();
        discard.put(DEFAULT_RESOURCE, discardCount);
        return discard;
    }
    
    @Override
    public ResourceType chooseResource(GameState state) {
        return DEFAULT_RESOURCE;
    }
    
    @Override
    public int chooseRobberTarget(GameState state, List<Integer> possibleTargets) {
        return possibleTargets.get(0);
    }
    
    @Override
    public DevelopmentCard chooseDevelopmentCard(GameState state) {
        return DevelopmentCard.KNIGHT;
    }
}
