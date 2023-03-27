package fr.eni.filmotheque.controller;

import fr.eni.filmotheque.bo.Member;
import fr.eni.filmotheque.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ConnexionController {

    private MemberService memberService;

    @Autowired
    public ConnexionController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String login() {
        return "connexion";
    }

    @PostMapping("/login")
    public String login(String login, String password, Model model, HttpSession session) {
        boolean isConnected = false;
        Member visitor = new Member();
        visitor.setLogin(login);
        visitor.setPassword(password);
        if (memberService.authenticate(visitor).isPresent()) {
            isConnected = true;
            session.setAttribute("login", login);
            session.setAttribute("isConnected",isConnected);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Login ou mot de passe incorrect");
            return "connexion";
        }
}
}
