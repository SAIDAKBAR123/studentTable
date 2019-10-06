package studenttable.demo.allSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
public class TopicController {

    @Autowired
    public TopicService topicService;

    @GetMapping ("/")
    public String getAllTopics(Model model){
        model.addAttribute("getAll", topicService.getTopics());
    return "index";
    }

    @GetMapping ("/index")
    public String redirect(){
        return "regStudent";
    }

    @RequestMapping ( method = RequestMethod.POST, value = "/topics")
    public String addTopic ( HttpServletRequest request){
        String id = request.getParameter("studentId");
        String name = request.getParameter("studentName");
        String email = request.getParameter("studentEmail");
        String faculty = request.getParameter("studentFaculty");
        topicService.addTopic(id, name, faculty, email);
        return "redirect:/";
    }

    @RequestMapping ( method = RequestMethod.POST, value = "/topics/edit")
    public String editTopic ( HttpServletRequest request){
        String id = request.getParameter("sId");
        String name = request.getParameter("sName");
        String email = request.getParameter("sEmail");
        String faculty = request.getParameter("sFaculty");
        topicService.editTopic(id, name, faculty, email);
        return "redirect:/";
    }

    @RequestMapping ( method = RequestMethod.POST, value = "/remove/{id}")
    public String updateTopic (@PathVariable String id){
        topicService.deleteTopic(id);
        return "redirect:/";

    }
}
