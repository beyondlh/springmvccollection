package example.blog.spring.mvc.rest.exhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Default controller that exists to return a proper REST response for unmapped requests.
 */
@Controller
public class DefaultController {

/*    @RequestMapping("*//**")
    public void unmappedRequest(HttpServletRequest request) throws Exception {
        String uri = request.getRequestURI();
//        throw new UnknownResourceException("There is no resource for path " + uri);
        throw new Exception("测试异常");
//        throw new IllegalArgumentException("Username is required.");
    }*/


    @RequestMapping("/**")
    public void unmappedRequest(HttpServletRequest request) throws Exception {
        String uri = request.getRequestURI();
        throw new HttpRequestMethodNotSupportedException("请求的方法不支持");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<HttpStatus> handleIOException(HttpRequestMethodNotSupportedException ex) {
        // prepare responseEntity
        return new ResponseEntity(HttpStatus.OK);
    }
}
