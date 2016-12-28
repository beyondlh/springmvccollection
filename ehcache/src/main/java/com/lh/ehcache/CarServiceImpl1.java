package com.lh.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lh on 2016/12/26.
 */
@Service
public class CarServiceImpl1 implements CarService {

//    private Logger logger = LoggerFactory.getLogger(getClass());

    private List<Car> cars = new LinkedList<>();

    /**
     * Creates a new car.
     *
     * @return Car object with values populated.
     */
    public Car createCar() {
        Car car = new Car();
        car.setMake("make");
        car.setModel("model");
        car.setVin("vin");

        // Add to my list of all cars
        cars.add(car);

        return car;
    }

    @Cacheable(value = "trafficFlowCache")
    public Car getCar(String vin) {
        Car car = null;
        for (Car car1 : cars) {
            if (car1.getVin().equals(vin)) {
                car = car1;
            }
        }
        return car;
    }

    @Cacheable(value = "trafficFlowCache")
    public List<Car> getListCar() {
        System.out.println("------------------222----------------------");
        List<Car> listCar = new ArrayList<>();
        Car car = null;
        for (Car car1 : cars) {
            listCar.add(car);
        }
        return listCar;
    }

    @Cacheable(value = "trafficFlowCache")
    public Map<String, Car> getMapCar() {
        System.out.println("mapcar");
        Map<String, Car> stringCarMap = new HashMap<String, Car>();
        Car car = null;
        for (Car car1 : cars) {
            stringCarMap.put(car1.getVin(), car1);
        }
        return stringCarMap;
    }


    public List<Car> testNoCacheGetListCar() {
        return this.getListCar();
    }
}
