/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.djamware.springmvc.controller;
import java.util.List;

import com.djamware.springmvc.VideoRepository;
import com.djamware.springmvc.model.Videos;

import java.io.Console;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideoController {

    private final MongoTemplate mongoTemplate;

    public VideoController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Autowired
    VideoRepository productRepository;
    
    
    
    @RequestMapping("/all")
    public List<Videos> getAllUsers() {
        
        return mongoTemplate.findAll(Videos.class);
    }
    
    @RequestMapping(value = {"/","/home"})
    public String product(Model model) {
        model.addAttribute("videos", productRepository.findAll());
        return "content";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }
    
    @RequestMapping("/upload")
    public String upload(Model model) {
        return "upload";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String VTitle, @RequestParam String VDesc, @RequestParam String URL, @RequestParam String prodImage) {
        Videos product = new Videos();
        product.setVTitle(VTitle);
        product.setVDesc(VDesc);
        product.setProdImage(prodImage);
        product.setURL(URL);
        productRepository.save(product);

        return "redirect:/show/" + product.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable BigInteger id, Model model) {
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam BigInteger id) {
        Videos product = productRepository.findById(id).orElse(null);
        productRepository.delete(product);

        return "redirect:/home";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable BigInteger id, Model model) {
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "edit";
    }

    @RequestMapping("/update")
    public String update(@RequestParam BigInteger id, @RequestParam String VTitle,@RequestParam String URL, @RequestParam String VDesc,@RequestParam String prodImage) {
        Videos product = productRepository.findById(id).orElse(null);
        product.setVTitle(VTitle);
        product.setVDesc(VDesc);
        product.setProdImage(prodImage);
        product.setURL(URL);
        productRepository.save(product);
        

        return "redirect:/show/" + product.getId();
    }

}
