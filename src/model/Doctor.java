package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{

    private String speciality;

    public Doctor(String name, String email) {
        super(name, email);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new AvailableAppointment(date,time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }


    @Override
    public String toString() {  //That's Polimorfismo. Sobreescritura del método toString. Usamos el de la clase padre model.User y finalmente el de nuestra innner class
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments;
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del hospital: Cruz Roja");
        System.out.println("Departamento: Cancerología");
    }

    public static class AvailableAppointment{       //Clase anidada (Inner class)
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }


        @Override
        public String toString() {
            return "Available Appointments \nDate: " + date + "\nTime: "+ time;
        }
    }


}
