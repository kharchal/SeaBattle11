package ua.com.hav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.model.Base;
import ua.com.hav.model.Pet;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pet")
public class PetController {

    private Base base = new Base();;


    @RequestMapping("/pets")
    public String pets(Model model) {
        model.addAttribute("pets", base.asList());
        return "pets";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("edit", "false");
        return "pet";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addPet(@Valid Pet pet, BindingResult result, Model model, boolean edit) {
        System.out.println("pet = " + pet);
        if  (result.hasErrors()) {
            System.out.println("errors: " + result);
            model.addAttribute("edit", edit);
            return "/pet";
        }
        if (edit) {
            base.edit(pet);
        } else {
            base.add(pet);
        }

        model.addAttribute("pets", base.asList());
        return "/pets";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Pet pet = base.get(id);
        model.addAttribute("pet", pet);
        model.addAttribute("edit", "true");
        return "pet";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        base.remove(id);
        model.addAttribute("pets", base.asList());
        return "redirect:/pet/pets";
    }

}
