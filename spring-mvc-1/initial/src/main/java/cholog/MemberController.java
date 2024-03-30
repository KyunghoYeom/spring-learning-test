package cholog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @GetMapping("/hello")
    public String world(@RequestParam(value = "name", required = false, defaultValue ="World"
    )String name, Model model) {
        if(name.isEmpty()){
            return "static";
        }
        model.addAttribute("name", name);
        return "hello";
        // TODO: /hello 요청 시 resources/templates/static.html 페이지가 응답할 수 있도록 설정하세요.
        // /hello만 실행시 static.html어떻게 응답 되는지?(index는 welcome page인데 static은 따로 설정이 안되어있어서)
        // TODO: 쿼리 파라미터로 name 요청이 들어왔을 때 해당 값을 hello.html에서 사용할 수 있도록 하세요.

    }
    @GetMapping("/json")
    @ResponseBody
    public Person json() {
        Person person = new Person("brown", 20);
        return person;

        // TODO: /json 요청 시 {"name": "brown", "age": 20} 데이터를 응답할 수 있도록 설정하세요.


    }
}
