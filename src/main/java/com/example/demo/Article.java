package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	private String description;
	private String url;
	
	public Article(String title,String description,String url) {
		this.title = title;
		this.description = description;
		this.url = url;
	}
}
