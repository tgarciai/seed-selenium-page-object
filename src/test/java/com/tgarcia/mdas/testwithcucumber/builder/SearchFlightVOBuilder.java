package com.tgarcia.mdas.testwithcucumber.builder;

import com.tgarcia.mdas.testwithcucumber.domain.SearchFlightVO;

public class SearchFlightVOBuilder {



    private String originLocation;
    private String destinationLocation;
    private Integer id;

    public static SearchFlightVOBuilder aSearchFlight() {
        return new SearchFlightVOBuilder();
    }

    public SearchFlightVOBuilder whithLocations(String originLocation, String destinationLocation){
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        return this;
    }

    public SearchFlightVOBuilder withId(Integer id){
        this.id = id;
        return this;
    }

    public SearchFlightVO build() {
        SearchFlightVO reservation = new SearchFlightVO();
        reservation.setOriginLocation(originLocation);
        reservation.setDestinationLocation(destinationLocation);
        return reservation;
    }
}
