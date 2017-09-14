package com.geek.spring.boot.blog.domain.es;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Blog 文档
 * @author zhuyangyong
 * @date 2017年9月12日 上午11:22:10
 */
@Document(indexName = "blog", type = "blog")	//文档
public class EsBlog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id		//主键
	private String id;
	
	private String title;
	
	private String summary;
	
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EsBlog() {
		super();
	}

	public EsBlog(String title, String summary, String content) {
		super();
		this.title = title;
		this.summary = summary;
		this.content = content;
	}

	@Override
	public String toString() {
		return "EsBlog [id=" + id + ", title=" + title + ", summary=" + summary + ", content=" + content + "]";
	}
	
}
