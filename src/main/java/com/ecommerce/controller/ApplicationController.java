package com.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.Items;

@Controller
public class ApplicationController {

	@Autowired
	private ItemController itemController;
	
	@GetMapping
	public String viexItemsIndex(Model model) {
		return "index";
	}
	
	@GetMapping(value = "/items/listItems")
    public String showTodos(ModelMap model) {
		List<Items> itemList=itemController.getAllItems();
		model.addAttribute("itemLists",itemList);
        return "listItems";
    }
	
	@GetMapping(value = "/items/edititems/{id}")
	public String showNewList(@PathVariable int id,Model model) {
	   
	    Items item=itemController.getItems(id);
	    model.addAttribute("item",item);
	    return "edititems";
	}
	
	@GetMapping(value = "/additem")
	public String addList(Model model) {
	    
	    return "additem";
	}
	
	@PostMapping(value = "/items/additem")
	public String showNewList(Model model,@Valid Items item,BindingResult result) {
	    if(result.hasErrors()) {
	    	return "additem";
	    }
	    
	    itemController.addItems(item);
	    
	    return "redirect:/items/listItems";
	}
	
	@RequestMapping(value = "/items/deleteItems/{id}", method = RequestMethod.GET)
    public String deleteItems(@PathVariable int id) {
        itemController.deleteById(id);
        return "redirect:/items/listItems";
    }
	
	@PostMapping(value = "/items/edititems/{id}")
	public String updateItem(Model model, @PathVariable(name = "id") int id,@Valid Items item,BindingResult result) {
	    if(result.hasErrors()) {
	    	return "redirect:/items/listItems";
	    }
	    
	    itemController.updateItem(id, item);
	    return "redirect:/items/listItems";
	}
	
	//**********************************
	
	/*
	@RequestMapping("/")
	public String viexItemsIndex(Model model) {
		List<Items> itemList=itemController.getAllItems();
		model.addAttribute("itemLists",itemList);
		return "ListItems";
	}
	
	@RequestMapping("/addItem")
	public String showNewForm(Model model) {
	    Items item = new Items();
	    model.addAttribute("item", item);
	      
	    return "new_form";
	}
	
	@PutMapping("/item/{id}")
	public ModelAndView updateItem(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_form");
	    Items item = itemController.getItems(id);
	    mav.addObject("item", item);	 
	    return mav;
	}
*/
}
