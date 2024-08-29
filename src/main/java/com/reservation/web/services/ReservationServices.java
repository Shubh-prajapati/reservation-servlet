    package com.reservation.web.services;


    import com.reservation.web.model.Reservation;
    import com.reservation.web.repository.ReservationRepository;
    import java.sql.SQLException;

    public class ReservationServices {
        private static ReservationRepository reservationRepository=new ReservationRepository();

        public static boolean insertReservation(Reservation reservation)throws SQLException{
            if(reservationRepository.insertReservation(reservation)){
                System.out.println("Reservation inserted Successfully");
            }else{
                System.out.println("Failed to inserted Successfully! ");
                return  false;

            }
            return true;
        }



    }
