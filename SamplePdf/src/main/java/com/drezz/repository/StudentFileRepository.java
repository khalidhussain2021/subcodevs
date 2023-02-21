package com.drezz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drezz.entity.StudentPDFData;

@Repository
public interface StudentFileRepository extends JpaRepository<StudentPDFData,Long>{

}
