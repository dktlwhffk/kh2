package com.kh.sts13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sts13.entity.ProductDto;
import com.kh.sts13.repository.ProductDao;

@Controller
@RequestMapping("/product")
public class ProductController {
	
//	@ResponseBody
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/regist")
	public String regist() {
		return "product/regist";
	}
	@PostMapping("/regist")
	public String regist1(@ModelAttribute ProductDto productDto) {
		productDao.regist(productDto);
		return "redirect:list";
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<ProductDto> list = productDao.getlist();
		model.addAttribute("list", list);
		return "product/list";
	}
	@GetMapping("/search")
	public String search(String keyword, Model model) {
		List<ProductDto> search = productDao.getsearch(keyword);
		model.addAttribute("search", search);
		System.out.println(search.size());
		return "product/search";
	}
}
