package by.com.life.alice.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AliceKnowledgeHolder {
    private final static List<AliceKnowledge> knowledges = new ArrayList<>();

    public static synchronized AliceKnowledge getKnowledge(String sessionId) {
        Optional<AliceKnowledge> knowledge = knowledges.stream().filter(k -> sessionId.equals(k.getSessionId())).findFirst();

        if (!knowledge.isPresent()) {
            AliceKnowledge aliceKnowledge = new AliceKnowledge(sessionId);
            knowledges.add(aliceKnowledge);
            return aliceKnowledge;
        }
        return knowledge.get();
    }
}
