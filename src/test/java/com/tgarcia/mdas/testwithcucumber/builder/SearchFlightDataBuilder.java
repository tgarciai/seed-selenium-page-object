package com.tgarcia.mdas.testwithcucumber.builder;


public class SearchFlightDataBuilder {

    public static SearchFlightVOBuilder defaultReservation(Integer id){
        return SearchFlightVOBuilder.aSearchFlight().withId(id)
                .whithLocations("Madrid","Barcelona");
    }

}
