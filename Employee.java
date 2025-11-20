package com.codegnan.entity;

public class Employee {
private int eno;
private String ename;
private double esal;
private String eaddr;
public Employee() {
	super();
}
public Employee(int eno, String ename, double esal, String eaddr) {
	super();
	this.eno = eno;
	this.ename = ename;
	this.esal = esal;
	this.eaddr = eaddr;
}
public int getEno() {
	return eno;
}
public void setEno(int eno) {
	this.eno = eno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public double getEsal() {
	return esal;
}
public void setEsal(double esal) {
	this.esal = esal;
}
public String getEaddr() {
	return eaddr;
}
public void setEaddr(String eaddr) {
	this.eaddr = eaddr;
}
@Override
public String toString() {
	return "Employee [eno=" + eno + ", ename=" + ename + ", esal=" + esal + ", eaddr=" + eaddr + "]";
}

}
