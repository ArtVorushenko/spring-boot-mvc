package com.itransition.partylist.controllers;

import com.itransition.partylist.models.JoinPartyRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PartyListController {

    @GetMapping("/")
    public String entryPoint(Model model) {
        model.addAttribute("requestForParty", new JoinPartyRequest());
        return "form";
    }

    @PostMapping("/addToList")
    public String confirmInvitation(@ModelAttribute JoinPartyRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("name", request.getName());
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String successView(Model model) {
        String viewName = "success";
        if (!model.containsAttribute("name")) {
            viewName = "redirect:/";
        }
        return viewName;
    }
}
