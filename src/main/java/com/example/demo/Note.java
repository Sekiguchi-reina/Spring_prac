package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
	@Id
	@GeneratedValue
	private int id;
	
	private String content;
	private String createdAt;
	public Note(String content,String createdAt) {
		this.content = content;
		this.createdAt = createdAt;
	}
}
