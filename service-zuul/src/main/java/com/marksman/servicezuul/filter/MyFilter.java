package com.marksman.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * @author weilb
 * @date 2018/9/1
 * @description
 */
@Component
public class MyFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null){
            logger.warn("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try{
                context.getResponse().getWriter().write("token is empty");
            } catch (Exception e){
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
