package streams;

import java.util.List;

public class Apartment {
    private String location;
    private int size;
    private BathRoomType bathRoomType;
    private List<String> extras;

    public Apartment(String city, int area, BathRoomType bathroomType, List<String> extras) {
        this.location = city;
        this.size = area;
        this.bathRoomType = bathroomType;
        this.extras = extras;
    }

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public BathRoomType getBathRoomType() {
        return bathRoomType;
    }

    public List<String> getExtras() {
        return extras;
    }
}
