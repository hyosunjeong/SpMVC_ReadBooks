package com.biz.readbook.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.readbook.model.BookVO;
import com.biz.readbook.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bService;

	@ModelAttribute("bookVO")
	public BookVO newBookVO() {
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
		DateTimeFormatter fd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String today = ld.format(fd);
		bookVO.setB_date(today);
		
		model.addAttribute("BOOKS", bookVO);
		return "body/book_write";
	}
	
/*
 * 데이터 입력
 */
	@RequestMapping(value="book",method=RequestMethod.POST)
	public String book_insert(@ModelAttribute BookVO bookVO) {
		int ret = bService.insert(bookVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String book_update(@ModelAttribute BookVO bookVO) {
		int ret = bService.update(bookVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(@ModelAttribute("bookVO") BookVO bookVO, Model model) {
		
		long id = bookVO.getB_id();
		bookVO = bService.findById(id);
		
		model.addAttribute("bookVO", bookVO);
		
		return "body/book_view";
	}
	
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam long id) {
		bService.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@ModelAttribute("bookVO")BookVO bookVO, Model model) {
		long id = bookVO.getB_id();
		bookVO = bService.findById(id);
		
		model.addAttribute("BOOK", bookVO);
		
		return "body/book_update";
	}
	
}
