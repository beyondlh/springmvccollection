package com.lh.ehcache;

import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2016/12/26.
 */
public interface CarService {
    Car createCar();

    Car getCar(String vin);

    List<Car> getListCar();

    Map<String, Car> getMapCar();
    List<Car> testNoCacheGetListCar();
}
