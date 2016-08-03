Spring MVC 练习
=============
如果在请求处理方法中需要访问HttpSession对象，则可以添加HttpSession作为参数，Spring会将对象正确的传递给方法，如:public  String action(HttpSession session)；若需要访问客户端语言环境和HttpServletRequest对象，则可以在方法签名上包含这样的参数，如：public String action(HttpServletRequest request,Locale locale)。可以在请求中出现的参数类型有：

org.springframework.web.context.request.WebRequest
org.springframework.web.context.request.NativeWebRequest
java.util.Locale 当前请求的语言环境
java.util.TimeZone 时区
java.io.InputStream或java.io.Reader
java.io.OutputStream或java.io.Writer
org.springframework.http.HttpMethod
java.security.Principal
HttpEntity <?>参数用于访问Servlet的HTTP请求的标题和内容
java.util.Map / org.springframework.ui.Model / org.springframework.ui.ModelMap 视图隐含模型
org.springframework.web.servlet.mvc.support.RedirectAttributes 重定向
命令或表单对象
基本数据类型，如int,String,double...
复杂数据类型，如自定义的POJO对象
HandlerAdapter
org.springframework.validation.Errors / org.springframework.validation.BindingResult 验证结果
org.springframework.web.bind.support.SessionStatus 会话状态
org.springframework.web.util.UriComponentsBuilder
@PathVariable 注解参数访问URI模板变量。
@MatrixVariable 注释参数用于访问位于URI路径段键值对对，矩阵变量。
@RequestParam 注解参数访问特定的Servlet请求参数，请求参数绑定。
@RequestHeader 注解参数访问特定的se​​rvlet请求HTTP标头，映射请求头。
@RequestBody 注解参数访问HTTP请求主体，注解映射请求体
@RequestPart 注解参数访问“的multipart / form-data的”请求部分的内容。处理客户端上传文件，多部分文件上传的支持
@SessionAttribute 注解参数会话属性
@RequestAttribute 注解参数访问请求属性