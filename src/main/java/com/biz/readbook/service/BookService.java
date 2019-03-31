package com.biz.readbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.readbook.mapper.BookDao;
import com.biz.readbook.model.BookVO;

@Service
public class BookService {

	@Autowired
	BookDao bDao;
	
	public List<BookVO> selectAll() {
		
		return bDao.selectAll();
	}

	public BookVO findById(long b_id) {
		return bDao.findById(b_id);
	}


	public List<BookVO> findByUserId(String b_userid) {
		return bDao.findByUserId(b_userid);
	}

	public int insert(BookVO bookVO) {
		int ret = bDao.insert(bookVO);
		return ret;
	}

//	public int update(BookVO bookVO) {
//		return 0;
//	}

	public int delete(long b_id) {
		return bDao.delete(b_id);
	}
	
	public int save(BookVO bookVO) {
		int ret =0;
		
		if(bookVO.getB_id() > 0) {
			ret = bDao.update(bookVO);
		} else {
			ret = bDao.insert(bookVO);
		}
			return 0;
	}

}
