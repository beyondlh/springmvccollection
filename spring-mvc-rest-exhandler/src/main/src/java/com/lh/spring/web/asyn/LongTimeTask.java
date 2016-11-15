package com.lh.spring.web.asyn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lh on 2016/11/14.
 */
@Controller
@RequestMapping("/async")
public class LongTimeTask {
    @RequestMapping(value = "/mytask",method = RequestMethod.GET)
    public DeferredResult<ModelAndView> asyncTask(){
        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());
        DeferredResult<ModelAndView> modelAndViewDeferredResult = new DeferredResult<>();
//        modelAndViewDeferredResul
        return modelAndViewDeferredResult;
    }
}
