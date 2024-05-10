package roomescape.service;

import roomescape.exception.NotFoundReservationException;

import java.util.Map;

public class ReservationValidation {

    final static String RESERVATION_NAME = "name";
    final static String RESERVATION_DATE = "date";
    final static String RESERVATION_TIME = "time";

    public static void validateReservationRequestFormat(Map<String, String> params){
        if(!params.containsKey(RESERVATION_NAME) || !params.containsValue(RESERVATION_NAME)){
            throw new IllegalArgumentException("예약자 명을 포함해야 합니다.");
        }
        if(!params.containsKey(RESERVATION_DATE) || !params.containsValue(RESERVATION_DATE)){
            throw new IllegalArgumentException("예약 날짜를 포함해야 합니다.");
        }
        if(!params.containsKey(RESERVATION_TIME) || !params.containsValue(RESERVATION_TIME)){
            throw new IllegalArgumentException("예약 시간을 포함해야 합니다.");
        }
    }

    public static void validateReservationExists(boolean isReservationExist) throws NotFoundReservationException {
        if(!isReservationExist){
            throw new NotFoundReservationException("예약이 존재하지 않습니다.");
        }
    }
}