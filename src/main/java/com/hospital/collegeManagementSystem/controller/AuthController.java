package com.hospital.collegeManagementSystem.controller;

import com.hospital.collegeManagementSystem.model.Student;
import com.hospital.collegeManagementSystem.service.StudentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("isLogin", false);
        return "auth";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("isLogin", true);
        return "auth";
    }

    @PostMapping("/signup")
    public String registerStudent(@Valid @ModelAttribute("student") Student student,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("isLogin", false);
            return "auth";
        }

        try {
            studentService.registerStudent(student);
            redirectAttributes.addFlashAttribute("successMessage",
                    "Registration successful! Please login with your credentials.");
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("isLogin", false);
            return "auth";
        }
    }

    @PostMapping("/login")
    public String loginStudent(@RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            Model model,
            RedirectAttributes redirectAttributes) {
        var student = studentService.login(email, password);

        if (student.isPresent()) {
            session.setAttribute("student", student.get());
            session.setAttribute("studentId", student.get().getId());
            redirectAttributes.addFlashAttribute("successMessage",
                    "Welcome back, " + student.get().getFirstName() + "!");
            return "redirect:/dashboard";
        } else {
            model.addAttribute("errorMessage", "Invalid email or password");
            model.addAttribute("isLogin", true);
            model.addAttribute("student", new Student());
            return "auth";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("successMessage", "You have been logged out successfully.");
        return "redirect:/";
    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId == null) {
            return "redirect:/login";
        }

        var student = studentService.findById(studentId);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "dashboard";
        }
        return "redirect:/login";
    }
}
