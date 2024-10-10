package HospitalManagementSystem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalManagementSystem {
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private Map<Doctor, List<Appointment>> doctorAppointments = new HashMap<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctorAppointments.put(doctor, new ArrayList<>());
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public boolean bookAppointment(int doctorId, int patientId, LocalTime time) {
        Doctor doctor = findDoctorById(doctorId);
        Patient patient = findPatientById(patientId);

        if (doctor == null || patient == null) {
            System.out.println("Doctor or Patient not Found");
        }
        if (isTimeSlotAvailable(doctor, time)) {
            Appointment appointment = new Appointment(doctor, patient, time);
            doctorAppointments.get(doctor).add(appointment);
            System.out.println("Appointment booked: " + appointment);
            return true;
        }
        System.out.println("Time slot not available");
        return false;
    }

    private Doctor findDoctorById(int doctorId) {
        return doctors.stream().filter(doc -> doc.getId() == doctorId).findFirst().orElse(null);
    }

    private Patient findPatientById(int patientId) {
        return patients.stream().filter(pat -> pat.getId() == patientId).findFirst().orElse(null);
    }

    private boolean isTimeSlotAvailable(Doctor doctor, LocalTime time) {
        if (time.isBefore(LocalTime.of(9, 0)) || time.isAfter(LocalTime.of(21, 0)))
            return false;
        return doctorAppointments.get(doctor).stream()
                .noneMatch(appointment -> appointment.getAppointmenTime().equals(time));
    }

    public void getAllDoctors() {
        if (doctors.size() == 0) {
            System.out.println("No Doctors in Hospital");
            return;
        }
        for (Doctor doc : doctors) {
            System.out.println(doc);
        }
    }

    public void getAllPatients() {
        if (patients.size() == 0) {
            System.out.println("No Patients in Hospital");
            return;
        }
        for (Patient pat : patients) {
            System.out.println(pat);
        }
    }
}
