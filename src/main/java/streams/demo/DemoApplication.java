package streams.demo;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@SpringBootApplication
public class DemoApplication {
    public static String make_kia = "kia";
    public static String make_toyota = "toyota";
    public static String make_suzuki = "suzuki";
    public static String make_Honda = "honda";

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    @ToString
    private static class Car {
        private String make;
        private BigDecimal price;
        private boolean imported;

        public String toString() {
            return this.getMake() + " ** " + this.getPrice() + " ** " + this.isImported();
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder(toBuilder = true)
    public static class ShowRoom {
        private String name;
        private List<Car> carList;
    }

    public static void main(String[] args) {
        Car c1 = Car.builder().make(make_toyota).price(BigDecimal.valueOf(9000)).imported(true).build();
        Car c2 = Car.builder().make(make_suzuki).price(BigDecimal.valueOf(10000)).imported(false).build();
        Car c3 = Car.builder().make(make_kia).price(BigDecimal.valueOf(17000)).imported(true).build();
        Car c4 = Car.builder().make(make_Honda).price(BigDecimal.valueOf(24000)).imported(true).build();
        Car c5 = Car.builder().make(make_kia).price(BigDecimal.valueOf(14000)).imported(false).build();
        Car c6 = Car.builder().make(make_suzuki).price(BigDecimal.valueOf(14000)).imported(true).build();
        Car c7 = Car.builder().make(make_Honda).price(BigDecimal.valueOf(34000)).imported(false).build();
        Car c8 = Car.builder().make(make_kia).price(BigDecimal.valueOf(15000)).imported(true).build();
        Car c9 = Car.builder().make(make_toyota).price(BigDecimal.valueOf(16000)).imported(false).build();

        ShowRoom showRoom = ShowRoom.builder().name("A car dealer ").carList(Arrays.asList(c1, c2, c3)).build();
        ShowRoom showRoom1 = ShowRoom.builder().name("B car dealer ").carList(Arrays.asList(c4, c5, c6)).build();
        ShowRoom showRoom2 = ShowRoom.builder().name("C car dealer ").carList(Arrays.asList(c7, c8, c9)).build();
          /*  List<ShowRoom> showRoomList = Arrays.asList(showRoom1, showRoom2, showRoom);
            List<Car> carList = showRoomList.stream().map(c -> c.getCarList()).flatMap(Collection::stream)
                    .filter(c -> c.getPrice().compareTo(BigDecimal.valueOf(14000)) >= 0).collect(Collectors.toList());
            carList.forEach(c -> System.out.println(c));*/

    }
}


