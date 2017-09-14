package com.geek.spring.boot.blog.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.geek.spring.boot.blog.domain.es.EsBlog;

/**
 * EsBlog Repository 接口
 * @author zhuyangyong
 * @date 2017年9月13日 下午2:31:30
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
	
	/**
	 * 分页查询博客(去重)
	 * @param title
	 * @param summary
	 * @param content
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title,String summary,String content, Pageable pageable);
}
