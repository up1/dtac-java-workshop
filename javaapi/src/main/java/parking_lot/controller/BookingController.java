package parking_lot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import parking_lot.model.BookingRequest;
import parking_lot.model.BookingResponse;
import parking_lot.model.PakingLot;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookingController", urlPatterns = { "/parking_lot/booking/*" })
public class BookingController extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        StringBuilder json = new StringBuilder();

        if(pathInfo.substring(1).trim().length() > 0) {
            //Parse data in body
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null) {
                json.append(line);
            }
            ObjectMapper mapper = new ObjectMapper();
            try {
                BookingRequest bookingRequest = mapper.readValue(json.toString(), BookingRequest.class);
            }catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            //Todo
            mapper.writeValue(response.getOutputStream(), new BookingResponse(200, "Success"));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
