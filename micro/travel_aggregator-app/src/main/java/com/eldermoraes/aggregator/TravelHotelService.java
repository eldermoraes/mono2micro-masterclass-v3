package com.eldermoraes.aggregator;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TravelHotelService {

    @GET
    public List<TravelHotel> travelHotels();

    @GET
    @Path("findById")
    public TravelHotel findById(@QueryParam("id") long id);

    @GET
    @Path("findByTravelOrderId")
    public TravelHotel findByTravelOrderId(@QueryParam("travelOrderId") long id);

    @POST
    public TravelHotel newTravelHotel(TravelHotel travelHotel);

    @DELETE
    public Response deleteById(long id);

}
