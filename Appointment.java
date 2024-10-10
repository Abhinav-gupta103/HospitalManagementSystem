package HospitalManagementSystem;

import java.time.LocalTime;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private LocalTime appointmenTime;

    public Appointment(Doctor doctor, Patient patient, LocalTime appointmenTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmenTime = appointmenTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalTime getAppointmenTime() {
        return appointmenTime;
    }

    public void setAppointmenTime(LocalTime appointmenTime) {
        this.appointmenTime = appointmenTime;
    }

    @Override
    public String toString() {
        return "Appointment [doctor=" + doctor.getName() + ", patient=" + patient.getName() + ", appointmenTime="
                + appointmenTime + "]";
    }
}
