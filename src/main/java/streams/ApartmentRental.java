package streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ApartmentRental {
    private List<Apartment> apartmentList = new LinkedList<>();

    public void addApartment(Apartment apartment) {
        apartmentList.add(apartment);
    }

    public List<Apartment> findApartmentByLocation(String location) {
        return apartmentList.stream().filter(e -> e.getLocation().equals(location)).collect(Collectors.toList());
    }

    public List<Apartment> findApartmentByExtras(String... extras) {
        List<String> extrasToFind = new LinkedList<>(List.of(extras));
        return apartmentList.stream().filter(e -> e.getExtras().containsAll(extrasToFind)).toList();
    }

    public boolean isThereApartmentWithBathroomType(BathRoomType bathRoomType) {
        return apartmentList.stream().anyMatch(e -> e.getBathRoomType().equals(bathRoomType));
    }

    public List<Integer> findApartmentsSize() {
        return apartmentList.stream().map(e -> e.getSize()).toList();
    }
}
