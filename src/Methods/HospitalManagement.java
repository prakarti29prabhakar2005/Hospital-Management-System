package Methods;

import Components.Appointment;
import Components.Doctor;
import Components.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagement {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("______________________________");
            System.out.println("Hospital Management System :");
            System.out.println("______________________________");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    scheduleAppointment(scanner);
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again...");
            }
        }while (choice != 0);
        scanner.close();
    }

    private static void scheduleAppointment(Scanner scanner) {
        System.out.println("______________________________");
        System.out.print("Enter Patient ID : ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID : ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD) : ");
        String date = scanner.next();
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);
        if(patient != null && doctor != null) {
            appointments.add(new Appointment(patient, doctor, date));
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Invalid Patient ID or Doctor ID!");
        }
        System.out.println("______________________________");
    }

    private static Doctor findDoctorById(int doctorId) {
        for(Doctor doctor : doctors) {
            if(doctor.getId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }

    private static Patient findPatientById(int patientId) {
        for(Patient patient : patients) {
            if(patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    private static void viewAppointments() {
        System.out.println("______________________________");
        int i=1;
        for(Appointment appointment : appointments) {
            System.out.println(i+" . "+appointment);
            i++;
        }
        System.out.println("______________________________");
    }

    private static void viewDoctors() {
        System.out.println("______________________________");
        if(doctors.size() == 0) {
            System.out.println("No doctor available!");
            return;
        }
        int i=1;
        for(Doctor doctor : doctors) {
            System.out.println(i+" . "+doctor);
            i++;
        }
        System.out.println("______________________________");
    }

    private static void viewPatients() {
        System.out.println("______________________________");
        if(patients.size() == 0) {
            System.out.println("No patient available!");
            return;
        }
        int i=1;
        for(Patient patient : patients) {
            System.out.println(i+" . "+patient);
            i++;
        }
        System.out.println("______________________________");
    }

    private static void addDoctor(Scanner scanner) {
        System.out.println("______________________________");
        System.out.print("Enter Doctor's Name : ");
        String name = scanner.next();
        System.out.print("Enter Doctor's Speciality : ");
        String speciality = scanner.next();
        doctors.add(new Doctor(name, speciality));
        System.out.println("Doctor added successfully!");
        System.out.println("______________________________");
    }

    private static void addPatient(Scanner scanner) {
        System.out.println("______________________________");
        System.out.print("Enter Patient's Name : ");
        String name = scanner.next();
        System.out.print("Enter Patient's Age : ");
        int age = scanner.nextInt();
        System.out.print("Enter Patient's Gender : ");
        String gender = scanner.next();
        patients.add(new Patient(name, gender, age));
        System.out.println("Patient added successfully!");
        System.out.println("______________________________");

    }
}
