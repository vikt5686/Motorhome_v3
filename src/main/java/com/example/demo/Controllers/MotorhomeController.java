package com.example.demo.Controllers;

import com.example.demo.Model.CustomerModel;
import com.example.demo.Model.MotorhomeModel;
import com.example.demo.Reps.MotorhomeInterfaceRep;
import com.example.demo.Reps.MotorhomeRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotorhomeController {

    private MotorhomeInterfaceRep motorhomeRepository;

    public MotorhomeController() { motorhomeRepository = new MotorhomeRep();
    }


    @GetMapping("/motorhomes")
    public String showAllMotorhomes (Model model){
        model.addAttribute("motorhomes", motorhomeRepository.readAll());

        return "motorhomedetails";
    }


    @GetMapping("/motorhomeform")
    public String motorhomeForm(Model model) {
        MotorhomeModel newMotorhome = new MotorhomeModel();

        model.addAttribute("motorhomeadd", newMotorhome);

        return "motorhomeform";
    }

    @PostMapping("/motorhomeform")
    public String createMotorhome (@ModelAttribute MotorhomeModel motorhomeModel ) {
        //System.out.println(customerModel.getFirstName());
        motorhomeRepository.create(motorhomeModel);

        return "redirect:/";
    }

    @GetMapping("/motorhomeedit")
    public String updateCustomer(Model model, int id){
        model.addAttribute("motorhomes", motorhomeRepository.read(id));

        return "motorhomeedit";
    }

    @PostMapping("/motorhomeedit")
    public String customerUpdated(MotorhomeModel motorhomeModel, int id){
        motorhomeRepository.updateMotorhome(motorhomeModel);

        return "redirect:/";
    }

    @GetMapping("/deletemotorhome")
    public String deleteCustomer(Model model, int id) {
        model.addAttribute("motorhomes", motorhomeRepository.deleteMotorhome(id));

        return "redirect:/";
    }

}
