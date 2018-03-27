package com.xym.springboot;

import com.xym.springboot.domain.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @author xym
 */
@Controller
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }

    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person(11, "aa");
        ArrayList<Person> people = new ArrayList<Person>();
        Person p1 = new Person(11, "xx");
        Person p2 = new Person(22, "yy");
        Person p3 = new Person(33, "zz");
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
}
