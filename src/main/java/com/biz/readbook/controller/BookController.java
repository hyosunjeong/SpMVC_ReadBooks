package com.biz.readbook.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.readbook.model.BookVO;
import com.biz.readbook.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bService;

	@ModelAttribute("bookVO")
	public BookVO newBookBO() {
		return new BookVO();
	}
	
	/*
	 * 홈화면에서 버튼을 클릭하면 나오는 화면
	 * 
	 */
	@RequestMapping(value="write",method=RequestMethod.GET)
	public String book(Model model) {
		BookVO bookVO = new BookVO();
		
		LocalDateTime ld = LocalDateTime.now();
		bookVO.setB_date(ld.toString());
		
		bookVO.setB_userid("test");
		
		model.addAttribute("BOOK", bookVO);
		return "book_write";
	}
	

	@RequestMapping(value="book",method=RequestMethod.POST)
	public String book(@ModelAttribute BookVO bookVO) {
		int ret = bService.insert(bookVO);
		return "home";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute ("bookVO")BookVO bookVO,Model model) {
		long id = bookVO.getB_id();
		bookVO =bService.findById(id);
		return "redirect:/";
	}
	
	
	
}
