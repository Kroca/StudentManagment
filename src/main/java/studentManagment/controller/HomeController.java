package studentManagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import studentManagment.model.Templates.LessonTemplate;
import studentManagment.model.Templates.ScheduleTemplate;
import studentManagment.model.Templates.UserTemplate;
import studentManagment.service.LessonsService;
import studentManagment.service.ScheduleService;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    LessonsService lessonsService;

    @GetMapping("/home")
    ModelAndView getHome(Model model, HttpSession session) {
        UserTemplate userTemplate = (UserTemplate) session.getAttribute("user");
        if(userTemplate.getRole().equals("user")) {
            System.out.println(scheduleService.getStudentsSchedule(userTemplate.getId()));
            model.addAttribute("schedule", scheduleService.getStudentsSchedule(userTemplate.getId()));
        }else {
            model.addAttribute("schedule",scheduleService.getFullSchedule());
        }
        model.addAttribute("login",userTemplate.getLogin());
        return new ModelAndView("home");
    }

    @PostMapping("editLesson")
    ModelAndView postEditLesson(Model model,@RequestParam("lessonId") int lessonId){
        if(lessonId>0){
            LessonTemplate lessonTemplate = lessonsService.getById(lessonId);
            model.addAttribute("lesson",lessonTemplate);
        }
        return new ModelAndView("editLesson");
    }

    @PostMapping("updateLesson")
    ModelAndView postUpdateLesson(Model model,
                                  @RequestParam("lesson_id") Integer id,
                                  @RequestParam("course_id") Integer course_id,
                                  @RequestParam("date") Date date){
        if(course_id>0&& date!=null){
            lessonsService.edit(new LessonTemplate(id,course_id,date));
        }
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("deleteLesson")
    ModelAndView postDeleteLesson(@RequestParam("lessonId") int lessonId){
        if(lessonId>0) {
            lessonsService.deleteById(lessonId);
        }
        return new ModelAndView("redirect:/ home");
    }

}

