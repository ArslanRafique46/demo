package streamproject;


import lombok.*;
import org.springframework.security.core.parameters.P;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProject {
    public static String make_Susuki = "susuki";
    public static String make_Honda = "honda";
    public static String make_Toyota = "toyota";
    public static String make_kia = "kia";

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    private static class Car {
        private String make;
        private BigDecimal price;
        private boolean imported;

        public String toString() {
            return this.getMake() + " ** " + this.getPrice() + " ** " + this.isImported();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    @ToString
    private static class ShowRoom {
        private String name;
        private List<Car> carList;
    }

    public static void main(String[] args) {
        Car c = Car.builder().make(make_Honda).price(BigDecimal.valueOf(15000)).imported(true).build();
        Car c1 = Car.builder().make(make_Honda).price(BigDecimal.valueOf(45000)).imported(false).build();
        Car c2 = Car.builder().make(make_Susuki).price(BigDecimal.valueOf(15000)).imported(true).build();
        Car c3 = Car.builder().make(make_Susuki).price(BigDecimal.valueOf(25000)).imported(false).build();
        Car c4 = Car.builder().make(make_Honda).price(BigDecimal.valueOf(35000)).imported(false).build();
        Car c5 = Car.builder().make(make_kia).price(BigDecimal.valueOf(5000)).imported(true).build();
        Car c6 = Car.builder().make(make_Honda).price(BigDecimal.valueOf(62000)).imported(true).build();
        Car c7 = Car.builder().make(make_Honda).price(BigDecimal.valueOf(12000)).imported(false).build();
        Car c8 = Car.builder().make(make_Honda).price(BigDecimal.valueOf(13000)).imported(true).build();

        ShowRoom showRoom = ShowRoom.builder().name("A car list ").carList(Arrays.asList(c, c1, c2, c3)).build();
        ShowRoom showRoom1 = ShowRoom.builder().name("A car list ").carList(Arrays.asList(c3, c4, c5)).build();
        ShowRoom showRoom2 = ShowRoom.builder().name("A car list ").carList(Arrays.asList(c6, c7, c8)).build();
        Stream<Car> carStream = Stream.of(c, c2, c3, c4, c5);
        Predicate<Car> carPredicate = car -> make_Honda.equals(car.getMake());
      /*  Map<Boolean,List<Car>>booleanListMap=carStream.collect(Collectors.partitioningBy(car->make_Susuki.equals(car.getMake())));
        System.out.println("This is suzuki Cars");
        List<Car>carList=booleanListMap.get(true);
        for (Car car:carList){
            System.out.println(car);
        }
        System.out.println("Non Suzuki Cars");
        List<Car>carList1=booleanListMap.get(false);
        for (Car ca:carList1){
            System.out.println(ca);
        }*/
       /* Map<String, List<BigDecimal>> stringListMap = carStream.collect(Collectors.groupingBy(Car::getMake, Collectors.mapping(Car::getPrice, Collectors.toList())));
        for (String str : stringListMap.keySet()) {
            for (BigDecimal bigDecimal : stringListMap.get(str)) {
                System.out.println(str + " ---- " + bigDecimal);
            }
        }*/
      /*  List<ShowRoom> showRoomList = Arrays.asList(showRoom1, showRoom2, showRoom);
        List<Car> carList = showRoomList.stream().map(showR -> showR.getCarList()).flatMap(Collection::stream)
                .filter(car -> car.getPrice().compareTo(BigDecimal.valueOf(14000)) >= 0).collect(Collectors.toList());
        carList.forEach(ca -> System.out.println(ca));*/
      /*  Map<Boolean, List<Car>> booleanListMap = carStream.collect(Collectors.partitioningBy(car -> make_Susuki.equals(car.getMake())));
        System.out.println("Suzuki Car is ");
        List<Car> carList = booleanListMap.get(true);
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println("Non Suzuki Cars");
        List<Car> carList1 = booleanListMap.get(false);
        for (Car car : carList1) {
            System.out.println(car);
        }*/
      /*  Map<String, List<BigDecimal>> stringList = carStream.collect(Collectors
                .groupingBy(car -> car.getMake(), Collectors.mapping(Car::getPrice, Collectors.toList())));
        for (String str : stringList.keySet()) {
            for (BigDecimal bigDecimal : stringList.get(str))
                System.out.println(str + "------ " + bigDecimal);
        }*/
       /* Map<String, List<BigDecimal>> stringListMap = carStream.collect(Collectors.groupingBy(Car::getMake, Collectors.mapping(Car::getPrice, Collectors.toList())));
        for (String str : stringListMap.keySet()) {
            for (BigDecimal price : stringListMap.get(str)) {
                System.out.println(str + " --------" + price);
            }
        }*/
       /* Map<Boolean, List<Car>> booleanListMap = carStream.collect(Collectors.partitioningBy(car -> make_Susuki.equals(car.getMake())));
        System.out.println("Suzuki Car ------------");
        List<Car> carList = booleanListMap.get(true);
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println("Non Suzuki Cars ------------");
        List<Car> carList1 = booleanListMap.get(false);
        for (Car ca : carList1) {
            System.out.println(ca);
        }*/

    }
}
