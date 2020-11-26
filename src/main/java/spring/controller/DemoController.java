package spring.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import spring.service.BmiService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static l.demo.Demo.p;

/**
 * DemoController
 *
 * @author ljh
 * created on 2020/11/25 11:45
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    private final BmiService bmiService;

    @Autowired
    public DemoController(BmiService bmiService) {
        this.bmiService = bmiService;
    }

    /**
     * SpringMVC 默认采用转发方式定位视图
     */
    @RequestMapping("/toBmi")
    public String toBmi() {
        p("toBmi()");
        return "bmi";
    }

    /**
     * HttpServletRequest 获取参数
     */
    @RequestMapping("/bmi")
    public String bmi(HttpServletRequest request) {
        p("bmi()");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        return bmi(Double.parseDouble(height), Double.parseDouble(weight), request);
    }

    /**
     * `@RequestParam 获取参数，和 表单 name 相同获取参数
     */
    @RequestMapping("/bmi2")
    public String bmi2(@RequestParam("height") String ht, String weight, HttpServletRequest request) {
        p("bmi2()");
        return bmi(Double.parseDouble(ht), Double.parseDouble(weight), request);
    }

    /**
     * Bean 获取参数
     */
    @RequestMapping("/bmi3")
    public String bmi3(BmiParam bp, HttpServletRequest request) {
        p("bmi3()");
        return bmi(bp.getHeight(), bp.getWeight(), request);
    }

    /**
     * ModelAndView 传递参数
     */
    @RequestMapping("/bmi4")
    public ModelAndView bmi4(BmiParam bp) {
        p("bmi4()");
        Map<String, Object> data = new HashMap<>();
        data.put("status", bmiService.bmi(bp.getHeight(), bp.getWeight()));
        return new ModelAndView("view", data);
    }

    /**
     * ModelAndView 传递参数
     */
    @RequestMapping("/bmi5")
    public ModelAndView bmi5(BmiParam bp) {
        p("bmi5()");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("status", bmiService.bmi(bp.getHeight(), bp.getWeight()));
        modelAndView.setViewName("view");
        return modelAndView;
    }

    /**
     * ModelMap 传递参数
     */
    @RequestMapping("/bmi6")
    public String bmi6(BmiParam bp, ModelMap mm) {
        p("bmi6()");
        mm.addAttribute("status", bmiService.bmi(bp.getHeight(), bp.getWeight()));
        return "view";
    }

    /**
     * HttpSession 传递参数
     */
    @RequestMapping("/bmi7")
    public String bmi7(BmiParam bp, HttpSession session) {
        p("bmi7()");
        session.setAttribute("status", bmiService.bmi(bp.getHeight(), bp.getWeight()));
        return "view";
    }

    /**
     * viewName 重定向
     */
    @RequestMapping("/redirect1")
    public String redirect1() {
        p("redirect1()");
        return "hello";
    }

    /**
     * ModelAndView 和 RedirectView 重定向
     */
    @RequestMapping("/redirect2")
    public ModelAndView redirect2() {
        return new ModelAndView(new RedirectView("hello.do"));
    }

    @RequestMapping("/hello")
    public String hello() {
        p("hello()");
        return "hello";
    }

    /**
     * HttpServletRequest 传递参数
     */
    private String bmi(double height, double weight, HttpServletRequest request) {
        String status = bmiService.bmi(height, weight);
        request.setAttribute("status", status);
        return "view";
    }

    @Getter
    @Setter
    private static class BmiParam {
        private double height;
        private double weight;
    }

}