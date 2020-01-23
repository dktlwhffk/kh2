package com.kh.sts12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.sts12.entity.MemoDto;
import com.kh.sts12.repository.MemoDao;

@Controller
@RequestMapping("/memo")
public class MemoController {
	@Autowired
	private MemoDao memoDao;
	
	@GetMapping("/")
	public String home() {
		return "memo/home";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MemoDto> list = memoDao.getList();
		model.addAttribute("list", list);
		
		return "memo/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "memo/insert";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute MemoDto memoDto) {
		memoDao.regist(memoDto);
		return "redirect:list";
	}
}
