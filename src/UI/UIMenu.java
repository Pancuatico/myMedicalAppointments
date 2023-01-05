package UI;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("model.Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    showPatientMenu();
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }


    private static void authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez","alejandro@ale.com"));
        doctors.add(new Doctor("Marta Nielsen","marta@dasd.com"));
        doctors.add(new Doctor("Uther Lightbringer","uther@wow.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Anahi Salgado","anahi@mail.com"));
        patients.add(new Patient("Roberto Rodriguez","beto@mail.com"));
        patients.add(new Patient("Carlos Sánchez","carlos@mail.com"));

        boolean emailCorrect = false;

        do {
            System.out.println("Insert your email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();               //Obtengo email ingresado por usuario
            if(userType == 1){
                for(Doctor d: doctors){                 //Por cada doctor (objeto) registrado más arriba
                    if(d.getEmail().equals(email)){     //si el email ingresado coincide con el email del doctor en que se está iterando (ESTO EN LA REALIDAD SERÍA UN QUERY. Sipue, de validación)
                        emailCorrect = true;            //Indico no volver a entrar a este do
                        //Obtener el usuario logeado
                        doctorLogged = d;               //Agarro el doctor (el objeto) que se ha logeado
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if(userType == 2){
                for (Patient p: patients){
                    if(p.getEmail().equals(email)){
                        emailCorrect = true;
                        patientLogged = p;
                        //showPatientMenu
                    }
                }
            }
        }while (!emailCorrect);


    }


    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i +". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
}
