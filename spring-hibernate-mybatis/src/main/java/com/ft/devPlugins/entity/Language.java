package com.ft.devPlugins.entity;

import javax.persistence.*;

@Entity
@Table(name="t_language")
public class Language {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="rank")
	private String rank;
	@Column(name="description")
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
