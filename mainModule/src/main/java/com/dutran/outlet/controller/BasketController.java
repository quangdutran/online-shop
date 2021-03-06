package com.dutran.outlet.controller;

import com.dutran.outlet.entity.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/basket")
class BasketController {

    @Autowired
    private Basket basket;

    @PostMapping
    String addToBasket(@RequestParam String sku) {
        this.basket.add(sku);
        return "redirect:/";
    }

    @GetMapping
    ModelAndView showBasket() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("basketTotal", basket.getTotalItems());
        map.put("items", basket.getItems());
        return new ModelAndView("basket", map);
    }

    @PostMapping("/delete")
    String removeFromBasket(@RequestParam String sku) {
        this.basket.remove(sku);
        return "redirect:/basket";
    }

}