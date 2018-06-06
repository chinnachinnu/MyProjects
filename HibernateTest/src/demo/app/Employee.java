package demo.app;

public class Employee {
 private int id;
 private String name;
 private String Designation;
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", Designation=" + Designation + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesignation() {
	return Designation;
}
public void setDesignation(String designation) {
	Designation = designation;
}
 
 
}
