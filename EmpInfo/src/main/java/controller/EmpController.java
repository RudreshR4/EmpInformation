package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("econtroller")
@RequestMapping("/")
public class EmpController {
static {
	System.out.println("Controller loaded");
}
}
