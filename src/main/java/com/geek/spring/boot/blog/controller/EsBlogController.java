package com.geek.spring.boot.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geek.spring.boot.blog.domain.es.EsBlog;
import com.geek.spring.boot.blog.repository.es.EsBlogRepository;

/**
 *
 * @author zhuyangyong
 * @date 2017年9月13日 下午5:07:29
 */
@RestController
@RequestMapping(value = "/blogs")
public class EsBlogController {

	@Autowired
	private EsBlogRepository esBlogRepository;
	
	@GetMapping
	public void list(HttpServletResponse response,@RequestParam(value="title") String title,
			@RequestParam(value="summary") String summary,
			@RequestParam(value="content") String content,
			@RequestParam(value="pageIndex",defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",defaultValue="10") int pageSize){
		Pageable pageable = new PageRequest(0,20);
		Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title , summary , content,pageable);
	    
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("text/html");  
	    PrintWriter writer = null;  
        try {
			writer = response.getWriter();
			writer.println(page.getContent());  
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	        
		//return page.getContent();
	}
}
