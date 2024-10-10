package HospitalManagementSystem;

import java.time.LocalTime;
import java.util.Scanner;

public class HospitalManagementApp {
    public static void main(String[] args) {
        HospitalManagementSystem system = new HospitalManagementSystem();
        Scanner sc = new Scanner(System.in);
        for (;;) {
            sc.next();
            System.out.println("Press one of the option to continue");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Check Doctors List");
            System.out.println("5. Check Patients List");
            int input = sc.nextInt();
            if (input == 1) {
                System.out.println("Input the following details of Doctor");
                System.out.println("Id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Name: ");
                String name = sc.nextLine();
                System.out.println("Specialization: ");
                String specialization = sc.nextLine();
                system.addDoctor(new Doctor(id, name, specialization));
            } else if (input == 2) {
                System.out.println("Input the following details of Patient");
                System.out.println("Id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Name: ");
                String name = sc.nextLine();
                System.out.println("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.println("Ailment: ");
                String ailment = sc.nextLine();
                system.addPatient(new Patient(id, name, age, ailment));
            } else if (input == 3) {
                System.out.println("Input the following details to Book Appintment");
                System.out.println("Doctor Id: ");
                int doctorId = sc.nextInt();
                System.out.println("Patient Id: ");
                int patientId = sc.nextInt();
                System.out.println("Appointment Hours: ");
                int appointmentHours = sc.nextInt();
                System.out.println("Appointment Minutes: ");
                int appointmentMinutes = sc.nextInt();
                system.bookAppointment(doctorId, patientId, LocalTime.of(appointmentHours, appointmentMinutes));
            } else if (input == 4) {
                system.getAllDoctors();
            } else if (input == 5) {
                system.getAllPatients();
            } else {
                System.out.println("Invalid Input");
                break;
            }
        }
        sc.close();
    }
}
