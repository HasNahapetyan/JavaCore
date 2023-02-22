package ITSpaceAcademy.homeworks.employee.storage;

import ITSpaceAcademy.homeworks.employee.model.Company;
import ITSpaceAcademy.homeworks.employee.model.Employee;

public class CompanyStorage {
    private Company[] companies = new Company[10];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(Company company) {
        if(size == companies.length){
            extend();
        }
        companies[size] = company;
        size++;
    }

    private void extend() {
        Company[] array1 = new Company[size+10];
        if (size >= 0) System.arraycopy(companies, 0, array1, 0, size);
        companies = array1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(companies[i] + " ");
        }
    }

     public Company getCompanyById(String id) {
        for (int i = 0; i < size; i++) {
            Company company = companies[i];
            if(company.getId().equals(id)){
                return company;
            }
        }
        return null;
    }
}
