package application;

import entities.Dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.UK);
        Scanner sc = new Scanner(System.in);

        List<Dados> dadosList = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.print("Id:");
            int id = sc.nextInt();
            while (hasId(dadosList, id)){
                System.out.print("Id already taken. Try again: ");
                id = sc.nextInt();
            }
            System.out.print("Name:");
            String name = sc.next();
            System.out.print("Salary:");
            double salary = sc.nextDouble();
             dadosList.add(new Dados(id,name,salary));


        }
        System.out.println("Enter the employee id that will have salary increase: ");
        int employeeId = sc.nextInt();


        Dados increaseList = dadosList.stream().filter(x -> x.getId() == employeeId).findFirst().orElse(null);
        if (increaseList == null){
            System.out.println("Employee " + employeeId + " not found");
        }
        else {
            System.out.print("Enter the porcentage: ");
            double porcentage = sc.nextDouble();
            increaseList.increaseSalary(porcentage);
        }

        System.out.println();
        System.out.println("List of employees: ");
        for (Dados dados : dadosList){
            System.out.println(dados);
        }

        sc.close();
    }

    public static boolean hasId(List<Dados> dadosList, int id) {
        Dados d = dadosList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return d != null;
    }
}
