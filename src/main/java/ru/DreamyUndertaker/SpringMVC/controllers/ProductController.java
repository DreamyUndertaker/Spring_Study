package ru.DreamyUndertaker.SpringMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.DreamyUndertaker.SpringMVC.dao.ProductDAO;
import ru.DreamyUndertaker.SpringMVC.models.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;


    @GetMapping()
    public String index(Model model){
        // Получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("products", productDAO.index());
        return "products/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        // Получим одного человека по id из DAO и передадим на отображение в представление
        model.addAttribute("product", productDAO.show(id));
        return "products/show";
    }
    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product){

        return "products/new";
    }
    @PostMapping
    public String create(@ModelAttribute("product") Product product){
        productDAO.save(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") int id){
        model.addAttribute("product", productDAO.show(id));

        return "products/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") Product product,
                         @PathVariable("id") int id){
        productDAO.update(id, product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        productDAO.delete(id);
        return "redirect:/products";
    }
}
