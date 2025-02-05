package jp.co.remms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "prefs")


public class Pref {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prefs_gen")
	@SequenceGenerator(name = "seq_prefs_gen", sequenceName = "seq_prefs", allocationSize = 1)
	private Integer id;
	
	@Column(name = "code")
	private String code;	
	
	@Column(name = "name")
	private String name;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
