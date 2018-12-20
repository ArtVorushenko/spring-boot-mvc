package com.itransition.partylist.controllers;

import com.itransition.partylist.models.JoinPartyRequest;
import com.itransition.partylist.services.PartyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PartyListController {

    @Autowired
    private PartyListService partyListService;

    @GetMapping("/")
    public String entryPoint(Model model) {
        model.addAttribute("requestForParty", new JoinPartyRequest());
        return "form";
    }

    @PostMapping("/addToList")
    public String confirmInvitation(@ModelAttribute @Valid JoinPartyRequest request,
                                    BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Some of the fields have invalid values.");
            return "redirect:/";
        } else {
            partyListService.registerNewMember(request);
            redirectAttributes.addFlashAttribute("name", request.getName());
            return "redirect:/success";
        }
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
