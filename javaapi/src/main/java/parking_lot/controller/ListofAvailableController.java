package parking_lot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import parking_lot.model.AvailableParkingLot;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListofAvailableController", urlPatterns = { "/parking_lot/available" })
public class ListofAvailableController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Todo
        List<AvailableParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new AvailableParkingLot(1, 10));
        parkingLots.add(new AvailableParkingLot(2, 20));
        parkingLots.add(new AvailableParkingLot(3, 30));
        parkingLots.add(new AvailableParkingLot(4, 40));
        parkingLots.add(new AvailableParkingLot(5, 50));

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), parkingLots);
    }

}
