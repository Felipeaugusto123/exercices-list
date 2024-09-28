package program;

import Entities.Employe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int registerEmployee;
        double percentage;
        int idEmployeeIncrease;
        int id;
        String name;
        double salary;

        List<Employe> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);


        System.out.println("How many employee will be registered ?");
        registerEmployee = sc.nextInt();

        for (int i = 0; i < registerEmployee; i++) {
            System.out.println("Employee #" + (i + 1) + ":");

            System.out.println("Id : ");
            id = sc.nextInt();
            while (existId(list, id)) {
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }


            System.out.println("Name : ");
            sc.nextLine();
            name = sc.nextLine();

            System.out.println("Salary : ");
            salary = sc.nextDouble();


            Employe employe = new Employe(name, salary, id);
            list.add(employe);
        }
        for (Employe x : list) {
            System.out.println(x);
        }

        System.out.println("id of the employee that will be increase salary ");
        idEmployeeIncrease = sc.nextInt();
        Integer pos = position(list, idEmployeeIncrease);
        if (pos == -1) {
            System.out.println("this employee does not exist");
        } else {
            System.out.println("Enter the percentage of salary");
            percentage = sc.nextInt();
            list.get(pos).increasySalary(percentage);
        }

        System.out.println("List:");
        for (Employe x : list) {
            System.out.println(x);
        }

    }


    public static Integer position(List<Employe> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static boolean existId(List<Employe> list, int id) {
        for (Employe employe : list) {
            if (employe.getId() == id) {
                return true;
            }
        }
        return false;
    }
}