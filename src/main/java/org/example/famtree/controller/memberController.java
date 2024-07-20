package org.example.famtree.controller;

import ch.qos.logback.core.model.Model;
import org.example.famtree.Service.MemberService;
import org.example.famtree.model.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequestMapping
public class memberController {

    private final MemberService memberService;

    @Autowired
    public memberController (MemberService memberService) {
       this.memberService = memberService;
    }
    @GetMapping
    public String getAllMember(Model model) {
        List<member> members = memberService.findAll();
        model.addText("members");
        return "members";
    }
    @GetMapping("/{id}")
    public String getMemberById(@PathVariable Long id, Model model) {
        Member member = (Member) memberService.getMemberById(id).orElse(null);
        model.addText("member");
        return "member";
    }

    @PostMapping
    public String createMember(@ModelAttribute Member member) {
        memberService.createMember((org.example.famtree.model.member) member);
        return "redirect:/members";
    }

    @PutMapping("/{id}")
    public String updateMember(@PathVariable Long id, @ModelAttribute member member) {

        memberService.updateMember(id,member);
        return "redirect:/members";
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "redirect:/members";
    }
}


