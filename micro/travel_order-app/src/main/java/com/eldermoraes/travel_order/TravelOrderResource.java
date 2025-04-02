package com.eldermoraes.travel_order;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("travel-order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RunOnVirtualThread
public class TravelOrderResource {

    @GET
    @Path("findById")
    public TravelOrder findById(@QueryParam("id") long id){
        return TravelOrder.findById(id);
    }

    @GET
    public List<TravelOrder> travelOrders() {
        return TravelOrder.listAll();
    }

    @POST
    @Transactional
    public TravelOrder newTravelOrder(TravelOrder travelOrder){
        travelOrder.id = null;
        travelOrder.persist();

        return travelOrder;
    }

    @DELETE
    @Transactional
    public Response deleteById(long id){
        TravelOrder.deleteById(id);

        return Response.accepted().build();
    }

}
