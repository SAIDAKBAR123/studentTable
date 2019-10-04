package studenttable.demo.allSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
//import com.zaxxer.hikari.HikariDataSource;
@Controller

public class TopicController {
    @Autowired
    public TopicService topicService;
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    @GetMapping ({"/index", "/"})
    public String home()
    {
        return "index";
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping ( method = RequestMethod.POST, value = "/topics")
    public void addTopic (@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping ( method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic (@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping ( method = RequestMethod.DELETE, value = "/topics/{id}")
    public void updateTopic (@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
