package com.example.demo.Entity;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="khoahoc")
public class Khoahoc {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nameKH;
	
	@ManyToMany(mappedBy = "khoahoc")
    private List<Sinhvien> sinhvien;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameKH() {
		return nameKH;
	}
	public void setNameKH(String nameKH) {
		this.nameKH = nameKH;
	}
	
	
	
	public List<Sinhvien> getSinhvien() {
		return sinhvien;
	}
	public void setSinhvien(List<Sinhvien> sinhvien) {
		this.sinhvien = sinhvien;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        Khoahoc project = (Khoahoc) o;
 
        if (!id.equals(project.id)) return false;
        return nameKH.equals(project.nameKH);
    }
 
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nameKH.hashCode();
        return result;
    }
	
	
}
