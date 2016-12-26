package com.lh.ehcache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lh on 2016/12/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CarServiceTest {
//        private Logger logger = LoggerFactory.getLogger(getClass());

//    使用这种方式，则CarService必须是接口，直接注入CarServiceImpl会报错，或者使用另外一种代理方式
        @Autowired
        public CarService carServiceImpl;

        private String vin;

        /**
         * Creates cars to look for.
         */
        @Before
        public void before() {
            Car car;
            for (int i = 0; i < 10; i++) {
                car = carServiceImpl.createCar();
                assertNotNull(car);
                assertNotNull(car.getMake());
                assertNotNull(car.getModel());
                assertNotNull(car.getVin());

                // store the value of the last car
                vin = car.getVin();
            }
        }

        /**
         * Tests the get car method.
         * @throws Exception
         */
        @Test
        public void testGetCar() throws Exception {
            // the first time the get cars method is called, the cache is empty
//            logger.info("beginning of first run");
            Car car = carServiceImpl.getCar(vin);  // find the last car added
            assertNotNull(car);
            assertEquals(vin, car.getVin());
//            logger.info("end of first run");

            // the second time the get cars method is called, the cache is fully populated
//            logger.info("beginning of second run");
            car = carServiceImpl.getCar(vin);  // find the last car added
            assertNotNull(car);
            assertEquals(vin, car.getVin());
//            logger.info("end of first run");
        }


        /**
         * Tests the get car method.
         * @throws Exception
         */
        @Test
        public void testGetListCar() throws Exception {
            // the first time the get cars method is called, the cache is empty
//            logger.info("beginning of first run");
            List<Car> listCar = carServiceImpl.getListCar();  // find the last car added
            assertNotNull(listCar);
//        assertEquals(vin, listCar.getVin());
//            logger.info("end of first run");

            // the second time the get cars method is called, the cache is fully populated
//            logger.info("beginning of second run");
            listCar = carServiceImpl.getListCar();  // find the last car added
            assertNotNull(listCar);
//        assertEquals(vin, listCar.getVin());
//            logger.info("end of first run");
        }


        /**
         * Tests the get car method.
         * @throws Exception
         */
        @Test
        public void testGetMapCar() throws Exception {
            Map<String,Car> listCar = carServiceImpl.getMapCar();  // find the last car added
            assertNotNull(listCar);
//        assertEquals(vin, listCar.getVin());
//            logger.info("end of first run");

            // the second time the get cars method is called, the cache is fully populated
//            logger.info("beginning of second run");
            listCar = carServiceImpl.getMapCar();  // find the last car added
            assertNotNull(listCar);
//        assertEquals(vin, listCar.getVin());
//            logger.info("end of first run");
        }

    /**
     * Tests the get car method.
     * @throws Exception
     */
//    测试不直接调用缓存方法，而是在类内部调用，这种方式无法命中缓存
    @Test
    public void testGetMapCarttt() throws Exception {
        List<Car> listCar = carServiceImpl.testNoCacheGetListCar();  // find the last car added
        listCar = carServiceImpl.testNoCacheGetListCar();
    }

}