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
        public CarService carServiceImpl1;

        private String vin;

        /**
         * Creates cars to look for.
         *
         */
        @Before
        public void before() {
            Car car;
            for (int i = 0; i < 10; i++) {
                car = carServiceImpl1.createCar();
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
            Car car = carServiceImpl1.getCar(vin);  // find the last car added
            assertNotNull(car);
            assertEquals(vin, car.getVin());
//            logger.info("end of first run");

            // the second time the get cars method is called, the cache is fully populated
//            logger.info("beginning of second run");
            car = carServiceImpl1.getCar(vin);  // find the last car added
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
            List<Car> listCar = carServiceImpl1.getListCar();  // find the last car added
            assertNotNull(listCar);
//        assertEquals(vin, listCar.getVin());
//            logger.info("end of first run");

            // the second time the get cars method is called, the cache is fully populated
//            logger.info("beginning of second run");
            listCar = carServiceImpl1.getListCar();  // find the last car added
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
            Map<String,Car> listCar = carServiceImpl1.getMapCar();  // find the last car added
            assertNotNull(listCar);
//        assertEquals(vin, listCar.getVin());
//            logger.info("end of first run");

            // the second time the get cars method is called, the cache is fully populated
//            logger.info("beginning of second run");
            listCar = carServiceImpl1.getMapCar();  // find the last car added
            assertNotNull(listCar);
//        assertEquals(vin, listCar.getVin());
//            logger.info("end of first run");
        }

    /**
     * Tests the get car method.
     * @throws Exception
     */
//    测试不直接调用缓存方法，而是在类内部调用，这种方式无法命中缓存
//    注意和限制基于 proxy 的 spring aop 带来的内部调用问题,spring cache 的原理，即它是基于动态生成的 proxy 代理机制来对方法的调用进行切面，这里关键点是对象的引用问题，如果对象的方法是内部调用（即 this 引用）而不是外部引用，则会导致 proxy 失效，那么我们的切面就失效，也就是说上面定义的各种注释包括 @Cacheable、@CachePut 和 @CacheEvict 都会失效,可以使用基于 aspectJ 的 AOP 模式来解决这个问题。非 public 方法问题和内部调用问题类似，非 public 方法如果想实现基于注释的缓存，必须采用基于 AspectJ 的 AOP 机制，
// 深入研究以及解决方案可参考http://www.iteye.com/topic/494124
    @Test
    public void testGetMapCarttt() throws Exception {
        List<Car> listCar = carServiceImpl1.testNoCacheGetListCar();  // find the last car added
        listCar = carServiceImpl1.testNoCacheGetListCar();
    }

}