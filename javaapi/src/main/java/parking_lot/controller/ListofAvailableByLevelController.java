package parking_lot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import parking_lot.model.AvailableParkingLot;
import parking_lot.model.PakingLot;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListofAvailableByLevelController", urlPatterns = { "/parking_lot/available/*" })
public class ListofAvailableByLevelController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }


    private void doProcess(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = req.getPathInfo();

        if(pathInfo.substring(1).trim().length() > 0) {
            //Todo
            List<PakingLot> parkingLots = new ArrayList<>();
            parkingLots.add(new PakingLot(1, 0));
            parkingLots.add(new PakingLot(2, 0));
            parkingLots.add(new PakingLot(3, 0));
            parkingLots.add(new PakingLot(4, 0));
            parkingLots.add(new PakingLot(5, 0));

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), parkingLots);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
