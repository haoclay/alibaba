package com.sgq.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;


@Component
public class AuthFilter extends ZuulFilter {
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
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token =request.getParameter("token");
        if(token==null||!token.equals("123")){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);

            context.addZuulRequestHeader("content-type","text/html;charset=utf-8");
            context.setResponseBody("非法请求,滚滚滚。。。");
            System.out.println();
        }else {
            System.out.println("请求成功");
        }
        return null;
    }
}
