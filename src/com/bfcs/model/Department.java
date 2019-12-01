package com.bfcs.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(namespace = "//o7planning.org/jaxb")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {
    private String deptNo;
    private String deptName;
    private String location;

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;

    /**
     *  Cấu tử mặc định này là bắt buộc nếu có thêm cấu tử khác.
     */
    public Department() {

    }

    public Department(String deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
