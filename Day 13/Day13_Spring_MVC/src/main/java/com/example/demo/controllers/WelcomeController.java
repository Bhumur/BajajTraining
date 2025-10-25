package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.Application;
import com.example.demo.dto.CustomerDto;
import com.example.demo.service.CustomerService;

@Controller
@RequestMapping("/")
public class WelcomeController {


    @Autowired
    private ModelAndView mView;
    
    @Autowired
    private CustomerService service;


    @GetMapping
    public String init(Model model) {
        model.addAttribute("heading", "Abhi CRM Application");
        return "index";
    }

    @GetMapping("/customer")
    public ModelAndView showCustomerForm() {
    	String []type = {"RETAIL", "CORPORATE"};
    	mView.addObject("type",type);
        mView.addObject("customer", new CustomerDto());
        mView.setViewName("addcustomer");
        return mView;
    }

    @PostMapping("/customer")
    public ModelAndView submitCustomerForm(@ModelAttribute("customer") CustomerDto customer) {
        System.out.println("Customer submitted: " + customer);
        
        service.save(customer);

        mView.addObject("customer", customer);
        mView.setViewName("success");
        return mView;
    }
    
    @GetMapping("/allCustomer")
    public ModelAndView getAllCustomer() {
    	List<CustomerDto> list = service.findAll();
        mView.addObject("allCustomer", list);
        mView.setViewName("allcustomer");
        return mView;
    }
    
    @GetMapping("/customer/{id}")
    public ModelAndView getCustomerById(@PathVariable("id") int id) {
    	CustomerDto dto = service.findById(id);
        mView.addObject("customer", dto);
        mView.setViewName("customerbyid");
        return mView;
    }
    
    @GetMapping("/search")
    public ModelAndView searchByName() {
        mView.setViewName("search");
        return mView;
    }
    
    @PostMapping("/search")
    public ModelAndView searchCustomer(@RequestParam("searchString") String name) {
        CustomerDto dto = service.findByName(name);
        
        if (dto == null) {
            mView.addObject("errorMessage", "Customer not found with name: " + name);
            mView.setViewName("search"); // go back to search page
            return mView;
        }
        
        mView.addObject("customer", dto);
        mView.setViewName("customerbyid");
        return mView;
    }
    
    
}
