package com.drezz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_tbl")
public class StudentPDFData {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Stu_id")
	private long StudentId;
	
	@Column(name="Stu_name")
	private String StudentName;
	
	@Column(name = "Stu_fee")
	private Double StudentFee;

	public long getStudentId() {
		return StudentId;
	}

	public void setStudentId(long studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public Double getStudentFee() {
		return StudentFee;
	}

	public void setStudentFee(Double studentFee) {
		StudentFee = studentFee;
	}

	public StudentPDFData() {
		
	}

	public StudentPDFData(long studentId, String studentName, Double studentFee) {
		StudentId = studentId;
		StudentName = studentName;
		StudentFee = studentFee;
	}
	
	
}
