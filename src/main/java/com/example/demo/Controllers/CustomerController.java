package com.example.demo.Controllers;

import com.example.demo.Model.CustomerModel;
import com.example.demo.Reps.CustomerInterfaceRep;
import com.example.demo.Reps.CustomerRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

private CustomerInterfaceRep customerRepository;

public CustomerController() {
    customerRepository = new CustomerRep();
}

/*
@GetMapping("/")
    public String index(Model model) {
    model.addAttribute("customers", customerRepository.readAll());

    return "index";
}

 */

@GetMapping("/customerform")
    public String customerForm(Model model) {
    CustomerModel newCustomer = new CustomerModel();

    model.addAttribute("customeradd", newCustomer);

    return "customerform";
}

@PostMapping("/customerform")
    public String createCustomer (@ModelAttribute CustomerModel customerModel) {
    //System.out.println(customerModel.getFirstName());
    customerRepository.create(customerModel);

    return "redirect:/";
}

    @GetMapping("/detail")
    public String readCustomer (Model model, int id) {
    model.addAttribute("customers", customerRepository.read(id));

    return "detail";
    }






    @GetMapping("/customers")
    public String showAllCustomers (Model model){
    model.addAttribute("customers", customerRepository.readAll());

    return "details";
    }

    @GetMapping("/delete")
    public String deleteCustomer(Model model, int id) {
    model.addAttribute("customers", customerRepository.delete(id));

    return "redirect:/";
    }

    @GetMapping("/edit")
    public String updateCustomer(Model model, int id){
    model.addAttribute("customers", customerRepository.read(id));

    return "edit";
    }

    @PostMapping("/edit")
    public String customerUpdated(CustomerModel customerModel, int id){
    customerRepository.update(customerModel);

    return "redirect:/";
    }



}
