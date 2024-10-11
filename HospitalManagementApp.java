package HospitalManagementSystem;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalManagementApp {

    private static final Scanner sc = new Scanner(System.in);

    private static final HospitalManagementSystem system = new HospitalManagementSystem();

    public static void main(String[] args) {
        system.setSerializedDoctors();
        system.setSerializedPatients();
        while (true) {
            displayMenu();
            try {
                int input = sc.nextInt();
                handeUserInput(input);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("An error occured: " + e.getMessage());
                sc.nextLine();
            }
        }

    }

    private static void displayMenu() {
        System.out.println("Press one of the options to continue");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Book Appointment");
        System.out.println("4. Check Doctors List");
        System.out.println("5. Check Patients List");
        System.out.println("6. Exit");
        System.out.println("Your choice: ");
    }

    public static void handeUserInput(int input) {
        switch (input) {
            case 1 -> addDoctor();
            case 2 -> addPatient();
            case 3 -> bookAppointment();
            case 4 -> system.getAllDoctors();
            case 5 -> system.getAllPatients();
            case 6 -> {
                System.out.println("Exiting the system....");
                sc.close();
                System.exit(0);
            }
            default -> System.out.println("Invalid Input!x");
        }
    }

    private static void addDoctor() {
        try {
            System.out.println("Input the following details of Doctor");
            System.out.println("Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Specialization: ");
            String specialization = sc.nextLine();
            system.addDoctor(new Doctor(id, name, specialization));
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid doctor details.");
            sc.nextLine();
        }
    }

    private static void addPatient() {
        try {
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
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid patient details.");
            sc.nextLine();
        }
    }

    private static void bookAppointment() {
        try {
            System.out.println("Input the following details to Book Appointment");
            System.out.println("Doctor Id: ");
            int doctorId = sc.nextInt();
            System.out.println("Patient Id: ");
            int patientId = sc.nextInt();
            System.out.println("Appointment Hours: ");
            int appointmentHours = sc.nextInt();
            System.out.println("Appointment Minutes: ");
            int appointmentMinutes = sc.nextInt();
            if (appointmentHours < 9 || appointmentHours > 21 || appointmentMinutes < 0
                    || appointmentMinutes >= 59) {
                System.out.println("Invalid time! Appointments are only available from 9:00 to 21:00.");
            } else
                system.bookAppointment(doctorId, patientId, LocalTime.of(appointmentHours, appointmentMinutes));
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid Appointment details.");
            sc.nextLine();
        }
    }
}