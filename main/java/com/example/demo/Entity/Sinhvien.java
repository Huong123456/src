package com.example.demo.Entity;


import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="sinhvien")
public class Sinhvien {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nameSV;
	
	private String address;
	
	private String email;
	
	@ManyToMany
	@JoinTable(name ="dangky",
				joinColumns = @JoinColumn(name ="id_sv"),
				inverseJoinColumns = @JoinColumn(name = "id_kh"))
	
	private List<Khoahoc> khoahoc;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameSV() {
		return nameSV;
	}
	public void setNameSV(String nameSV) {
		this.nameSV = nameSV;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	public List<Khoahoc> getKhoahoc() {
		return khoahoc;
	}
	public void setKhoahoc(List<Khoahoc> khoahoc) {
		this.khoahoc = khoahoc;
	}
	
	/*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        Sinhvien sv = (Sinhvien) o;
 
        if (!id.equals(sv.id)) return false;
        return nameSV.equals(sv.nameSV);
    }
 
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nameSV.hashCode();
        return result;
    }*/
	
	
	
	
	
}
