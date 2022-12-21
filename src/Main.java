import model.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        showMenu();

        Doctor myDoctor = new Doctor("Anahí Salgado","Pediatra");

        myDoctor.addAvailableAppointment(new Date(),"4 pm");
        myDoctor.addAvailableAppointment(new Date(),"4:30 pm");
        myDoctor.addAvailableAppointment(new Date(),"7 pm");
        myDoctor.addAvailableAppointment(new Date(),"6 pm");

        for (Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointments()){  //Esto es como un for each o_O
            System.out.println(aA.getDate() + " " + aA.getTime());
        }

        System.out.println(myDoctor);

        Patient patient = new Patient("Beto","rsepulbravo@gmail.com");
        patient.setPhoneNumber("123456789");
        patient.setWeight(65);
        patient.setHeight(1.68);


        System.out.println(patient);

        User user = new Doctor("Anahi","ana@ana.com");      //Aplicando polimorfismo
        user.showDataUser();                                            //Este es un método abstracto de la clase User

        User patient2 = new Patient("Pedro","pedro@pedro.com");
        patient2.showDataUser();

        //Clase anónima
        User user1 = new User("Beto","beto@beto.com") {     //Este objeto abstracto no se podría implementar si no fuera porque le sobreescribí el método abstracto de manera anónima
            @Override
            public void showDataUser() {
                System.out.println("Si amigos estamos usando clase anónima");
            }
        };

        user1.showDataUser();

        ISchedulable isSchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {

            }
        };

        Date date = new Date();
        ISchedulable iSchedulable1 = new AppointmentDoctor();
        iSchedulable1.schedule(date,"2pm");
    }
}