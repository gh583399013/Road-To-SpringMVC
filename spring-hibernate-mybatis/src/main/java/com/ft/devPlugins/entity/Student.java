package com.ft.devPlugins.entity;

import javax.persistence.*;

/**
 * 这里的注解是给hibernate使用的，mybatis完全用不到
 * 因为这里不注解 那就要去写*.hbm.xml这种文件了
 * @author fengtao
 *
 */
@Entity
@Table(name="t_student")
public class Student {
	@Id
	@GeneratedValue
	private int no;
	@Column(name="name")
	private String name;
	@Column(name="sex")
	private String sex;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
