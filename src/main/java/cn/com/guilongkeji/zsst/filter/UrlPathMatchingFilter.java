package cn.com.guilongkeji.zsst.filter;

import cn.com.guilongkeji.zsst.service.UserService;
import cn.com.guilongkeji.zsst.utils.SpringContextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public class UrlPathMatchingFilter extends PathMatchingFilter {
    @Autowired
    private UserService userService;
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        if (HttpMethod.OPTIONS.toString().equals((httpServletRequest).getMethod())) {
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        if (null==userService) {
            userService = SpringContextUtils.getContext().getBean(UserService.class);
        }

        String pathWithinApplication = getPathWithinApplication(request);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            System.out.println("需要登录");
            return false;
        }
        return super.onPreHandle(request, response, mappedValue);
    }
}
