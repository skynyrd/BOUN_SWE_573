package com.bounfoodcoop.controller;


import com.bounfoodcoop.service.ProducerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bounfoodcoop.core.representation.ProducerListRepresentation;

@Controller
@RequestMapping("/producer")
public class ProducerViewController {

    private ProducerService producerService;

    public ProducerViewController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping("/all")
    public String getAll(Model model){
        model.addAttribute("producers", new ProducerListRepresentation(producerService.getAll()));
        return "views/producerList";
    }
}
