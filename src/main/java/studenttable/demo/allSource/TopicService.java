package studenttable.demo.allSource;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList (
            new Topic("12931","Novel 1", "about thriller"),
            new Topic("12932","Novel 2", "about dramma"),
            new Topic("12933","Novel 3", "about fantazy"),
            new Topic("12934","Novel 4", "about comedy")
    ));

    public List<Topic> getTopics() {
        return topics;

    }

    public  Topic getTopic(String id){

        return topics.stream().filter(e -> e.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {

        for (int i = 0; i <topics.size() ; i++) {

            Topic t= topics.get(i);

            if(t.getId().equals(id)) {

                topics.set(i , topic);

                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t->t.getId().equals(id));
    }
}
