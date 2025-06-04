package RestAssured;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingApi {

    public static void main(String[] args) {

        //get auth token

        String token = AuthToken.getAuthToken();

        // create booking api

        Response res = CreateBooking.createBooking();
        String bookingId = res.jsonPath().getString("bookingid");
        System.out.println("Booking Id: "+bookingId);

        //get bookings

        Response res1 = GetBookings.getBookingIds();
        List<String> ids = res1.jsonPath().getList("bookingid");
        System.out.println("Is Booking id validation"+ ids.contains(bookingId));

        // get booking by id

        Response res2 = GetBookingId.getBookingId(bookingId);
        Map<String, Object> mappedData = res2.jsonPath().getMap("$");
        System.out.println("mapped data: \n"+mappedData);

        // update booking by id
        HashMap<String, Object> updateData = new HashMap<>();
        HashMap<String, String> dates = new HashMap<>();
        dates.put("checkin", "2025-01-17");
        dates.put("checkout", "2025-04-17");
        updateData.put("firstname", "atis");
        updateData.put("lastname","s");
        updateData.put("totalprice",510);
        updateData.put("depositpaid",false);
        updateData.put("bookingdates",dates);
        updateData.put("additionalneeds","Lunch");

        Response res3 = PutReqUpdateBookingId.updateBookingId(token, bookingId);
        System.out.println("update req "+res3.getStatusCode());
        // get booking by id and verify

        Response res4 = GetBookingId.getBookingId(bookingId);
        Map<String, Object> mappedData2 = res4.jsonPath().getMap("$");
        System.out.println("mapped data after update \n"+mappedData2);

        //partial update booking by id

        HashMap<String, Object> updateData2 = new HashMap<>();
        updateData.put("firstname", "atis1");
        updateData.put("lastname","s1");

        Response res5 = PatchReqUpdateBookingId.partialUpdateBookingId(token, bookingId);
        System.out.println("Partial update "+ res5.statusCode());

        // get booking by id and verify
        Response res6 = GetBookingId.getBookingId(bookingId);
        Map<String, Object> mappedData3 = res6.jsonPath().getMap("$");
        System.out.println("mapped data after partial update \n"+mappedData3);

        // delete booking by id

        Response res7 = DelBookingId.deleteBookingId(token, bookingId);
        System.out.println("Deleted: "+res7.getStatusCode());
    }
}
