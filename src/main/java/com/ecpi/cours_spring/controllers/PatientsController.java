package com.ecpi.cours_spring.controllers;

import com.ecpi.cours_spring.dto.PatientDTO;
import com.ecpi.cours_spring.model.Patient;
import com.ecpi.cours_spring.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("patients")
@RequiredArgsConstructor
public class PatientsController {

    private final PatientService patientService;

    @GetMapping(value = "/create")
    public String create(Model model){
        var patient = new Patient();
        model.addAttribute("patient", patient);
        return  "creatPatient";
    }

    @PostMapping
    public String store(@Valid @ModelAttribute("patient") PatientDTO patient, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            return  "creatPatient";
        }

        patientService.create(patient);
        redirectAttributes.addFlashAttribute("message", "Le patient a été crée!");
        return "redirect:/patients";
    }

    @GetMapping
    public String read(Model model){
        var patients =  patientService.read();
        model.addAttribute("patients", patients);
        return  "patient";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        var patient = patientService.find(id);
        model.addAttribute("patient", patient);
        return  "EditPatient";
    }


    @PostMapping(value = "/update")
    public String update(@ModelAttribute("patient") Patient patient, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return  "EditPatient";
        }
        patientService.update(patient);
        redirectAttributes.addFlashAttribute("message", "Le patient a été modifié!");
        return "redirect:/patients";
    }



    @GetMapping("/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
          patientService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Le patient a été supprimé!");
        return "redirect:/patients";
    }
}
