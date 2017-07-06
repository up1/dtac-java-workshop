package parking_lot.controller;

import org.springframework.web.bind.annotation.*;
import parking_lot.model.AvailableParkingLot;
import parking_lot.model.BookingRequest;
import parking_lot.model.BookingResponse;
import parking_lot.model.PakingLot;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ParkingLotController {

    @GetMapping("/parking_lot/available")
    public List<AvailableParkingLot> listOfAvailable() {
        List<AvailableParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new AvailableParkingLot(1, 10));
        parkingLots.add(new AvailableParkingLot(2, 20));
        parkingLots.add(new AvailableParkingLot(3, 30));
        parkingLots.add(new AvailableParkingLot(4, 40));
        parkingLots.add(new AvailableParkingLot(5, 50));
        return parkingLots;
    }

    @GetMapping("/parking_lot/available/{level}")
    public List<PakingLot> getByLevel(@PathVariable int level) {
        List<PakingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new PakingLot(1, 0));
        parkingLots.add(new PakingLot(2, 0));
        parkingLots.add(new PakingLot(3, 0));
        parkingLots.add(new PakingLot(4, 0));
        parkingLots.add(new PakingLot(5, 0));
        return parkingLots;
    }

    @PutMapping("/parking_lot/booking/{position}")
    public BookingResponse booking(@PathVariable int position
                                , @RequestBody BookingRequest request) {
        return new BookingResponse(200, "Success");
    }

}
