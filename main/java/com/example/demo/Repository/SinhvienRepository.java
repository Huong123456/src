package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Sinhvien;


@Repository
public interface SinhvienRepository extends JpaRepository<Sinhvien, Integer>  {
}
