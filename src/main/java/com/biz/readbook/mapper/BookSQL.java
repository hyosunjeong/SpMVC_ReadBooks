package com.biz.readbook.mapper;

import org.apache.ibatis.jdbc.SQL;

public class BookSQL {

	public String book_insert_sql() {
		SQL sql = new SQL()
				.INSERT_INTO("tbl_books")
				.INTO_COLUMNS("b_id").INTO_VALUES("SEQ_BOOK.NEXTVAL")
				.INTO_COLUMNS("b_userid").INTO_VALUES("#{b_userid,jdbcType=VARCHAR}")
				.INTO_COLUMNS("b_isbn").INTO_VALUES("#{b_isbn,jdbcType=VARCHAR}")
				.INTO_COLUMNS("b_title").INTO_VALUES("#{b_title,jdbcType=VARCHAR}")
				.INTO_COLUMNS("b_date").INTO_VALUES("#{b_date,jdbcType=VARCHAR}")
				.INTO_COLUMNS("b_star").INTO_VALUES("#{b_star,jdbcType=VARCHAR}")
				.INTO_COLUMNS("b_text").INTO_VALUES("#{b_text,jdbcType=VARCHAR}");
				
				return sql.toString();
		
	}
	
	public String book_update_sql() {
		SQL sql = new SQL()
				.UPDATE("tbl_books")
				.SET("b_userid = #{b_userid,jdbcType=VARCHAR}")
				.SET("b_isbn = #{b_isbn,jdbcType=VARCHAR}")
				.SET("b_title = #{b_title,jdbcType=VARCHAR}")
				.SET("b_star = #{b_star,jdbcType=VARCHAR}")
				.SET("b_text = #{b_text,jdbcType=VARCHAR}")
				.WHERE("b_id = #{b_id}");
		return sql.toString();
		
	}
	
}
