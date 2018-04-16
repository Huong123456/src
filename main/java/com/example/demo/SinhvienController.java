package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Sinhvien;
import com.example.demo.Repository.SinhvienRepository;

import java.util.*;


@Controller
@RequestMapping("/sinhvien")
public class SinhvienController {
	
	@Autowired
	SinhvienRepository sinhvienRepository;
	
	//Get all SV
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Sinhvien> sinhvien = sinhvienRepository.findAll();
		model.addAttribute("sinhvien",sinhvien);
		return "sinhvien/sinhvien";
	}
	
	@RequestMapping(value ="add",method = RequestMethod.GET)
	public String add() {
		return "sinhvien/add";
	}
	
	@RequestMapping(value ="add",method = RequestMethod.POST)
	public String add(Sinhvien sv) {
		sinhvienRepository.save(sv);
		return "redirect:../sinhvien";
	}
	
	@RequestMapping(value="detail/{id}")
	public String getOne(@PathVariable(value = "id") Integer svid,Model model)
	{
		Sinhvien sv = sinhvienRepository.getOne(svid);
		model.addAttribute("detail",sv);
		return "sinhvien/detail";
		
	}
	
	@RequestMapping(value ="update/{id}",method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") Integer svid,Model model) {
		Sinhvien sv = sinhvienRepository.getOne(svid);
		model.addAttribute("update",sv);
		return "sinhvien/update";
	}
	
	@RequestMapping(value="update/{id}",method = RequestMethod.POST)
	public String update(@PathVariable(value = "id") Integer svid,Sinhvien sv,Model model)
	{
		Sinhvien currentsv = sinhvienRepository.getOne(svid);
		
		currentsv.setNameSV(sv.getNameSV());
		currentsv.setAddress(sv.getAddress());
		currentsv.setEmail(sv.getEmail());
		sinhvienRepository.save(currentsv);
		return "redirect:../../sinhvien";
		
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") Integer svid)
	{
		sinhvienRepository.deleteById(svid);
		return "redirect:/sinhvien";
	}
	
	
}
