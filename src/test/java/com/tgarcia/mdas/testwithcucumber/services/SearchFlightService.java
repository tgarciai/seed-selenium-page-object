package com.tgarcia.mdas.testwithcucumber.services;

import com.tgarcia.mdas.testwithcucumber.builder.SearchFlightDataBuilder;
import com.tgarcia.mdas.testwithcucumber.domain.SearchFlightVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchFlightService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public List<SearchFlightVO> addSearchFlight(int numberOfSearchs) {
        LOGGER.debug("addSearchFlight starts, creating [{}]", numberOfSearchs);

        List<SearchFlightVO> searchFlightVOs = IntStream.range(0, numberOfSearchs)
                .mapToObj(this::generateSearchFlight)
                .collect(Collectors.toList());

        // TODO interact with the API of the application (in this case this app is an example)

        return searchFlightVOs;
    }

    private SearchFlightVO generateSearchFlight(int i) {
        return new SearchFlightDataBuilder().defaultReservation(i).build();
    }

    public void clean() {
        LOGGER.debug("clean");

        // TODO interact with the API of the application (in this case this app is an example)
    }

}
