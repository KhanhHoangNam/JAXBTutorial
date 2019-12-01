package com.bfcs.test;

import com.bfcs.model.Department;
import com.bfcs.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {
    private static final String XML_FILE = "dept-info.xml";

    public static void main(String[] args) {
        Employee firstEmp = new Employee("EO1", "Tom", null);
        Employee secondEmp = new Employee("E02", "Mary", "E01");
        Employee thirdEmp = new Employee("E03", "John", null);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(firstEmp);
        employeeList.add(secondEmp);
        employeeList.add(thirdEmp);

        Department department = new Department("D01", "ACCOUNTING", "NEW YORK");
        department.setEmployees(employeeList);

        try {
            /**
             Tạo đối tượng JAXB context.
             **/
            JAXBContext jaxbContext = JAXBContext.newInstance(Department.class);

            /**
             (1) Marshaller : Chuyển đối tượng Java thành XML
             **/
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            /**
             * Ghi đối tượng java (dept) ra màn hình Console (System.out)
             */
            marshaller.marshal(department, System.out);

            // Ghi đối tượng Java (dept) ra file.
            File outFile = new File(XML_FILE);
            marshaller.marshal(department, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());

            // (2) Unmarshaller : Chuyển dữ liệu XML thành đối tượng Java.
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Phân tích file XML vừa được tạo ra ở bước trước.
                    Department deptFromFile = (Department) unmarshaller.unmarshal(new FileReader(
                    XML_FILE));
            List<Employee> emps = deptFromFile.getEmployees();
            for (Employee emp : emps) {
                System.out.println("Employee: " + emp.getEmpName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
