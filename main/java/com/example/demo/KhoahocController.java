package com.example.demo;

import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.*;
import com.example.demo.Repository.KhoahocRepository;


@Controller
@RequestMapping("/khoahoc")
public class KhoahocController {
	
	@Autowired
	KhoahocRepository khoahocRepository;
	
	//Get all SV
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Khoahoc> kh = khoahocRepository.findAll();
		model.addAttribute("khoahoc",kh);
		return "khoahoc/khoahoc";
	}
	
	@RequestMapping(value ="add",method = RequestMethod.GET)
	public String add() {
		return "khoahoc/add";
	}
	
	@RequestMapping(value ="add",method = RequestMethod.POST)
	public String add(Khoahoc kh) {
		khoahocRepository.save(kh);
		return "redirect:../khoahoc";
	}
	
	@RequestMapping(value="detail/{id}")
	public String getOne(@PathVariable(value = "id") Integer khid,Model model)
	{
		
		Khoahoc kh = khoahocRepository.getOne(khid);
		
		model.addAttribute("detail",kh);
		model.addAttribute("sinhvien",kh.getSinhvien());
		return "khoahoc/detail";
		
	}
	
	@RequestMapping(value ="update/{id}",method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") Integer svid,Model model) {
		Khoahoc sv = khoahocRepository.getOne(svid);
		model.addAttribute("update",sv);
		return "khoahoc/update";
	}
	
	@RequestMapping(value="update/{id}",method = RequestMethod.POST)
	public String update(@PathVariable(value = "id") Integer khid,Khoahoc sv,Model model)
	{
		Khoahoc currentkh = khoahocRepository.getOne(khid);
		
		currentkh.setNameKH(sv.getNameKH());
	
		khoahocRepository.save(currentkh);
		return "redirect:../../khoahoc";
		
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") Integer khid)
	{
		khoahocRepository.deleteById(khid);
		return "redirect:/khoahoc";
	}
}
