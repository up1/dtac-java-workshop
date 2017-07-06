package parking_lot.model;

public class BookingRequest {
    private int id;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
