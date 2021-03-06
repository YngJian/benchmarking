package com.zhonglv.benchmarking.interceptor;

import com.zhonglv.benchmarking.annotations.UnLoginLimit;
import com.zhonglv.benchmarking.common.ConstantType;
import com.zhonglv.benchmarking.exception.UnLoginException;
import com.zhonglv.benchmarking.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * @author : Yang Jian
 * @date : 2021/7/7 0007 22:24
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${auth.no-token-path}")
    private String noToken;

    private String regex;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws UnLoginException {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            UnLoginLimit unlimited = method.getMethodAnnotation(UnLoginLimit.class);

            if (StringUtils.isBlank(regex)) {
                regex = JwtUtils.getRegStr(noToken);
            }

            String requestUri = request.getRequestURI();
            if (StringUtils.isNotBlank(requestUri)) {
                requestUri = requestUri.replace(request.getContextPath(), "");
            }

            if (unlimited != null || Pattern.compile(regex).matcher(requestUri).matches()) {
                // 免登陆接口
                return true;
            } else {
                // 需要登录接口
                String token = request.getHeader("token");
                if (StringUtils.isEmpty(token)) {
                    throw new UnLoginException("token is null.");
                }

                Claims claimsByToken = JwtUtils.getClaimsByToken(token);
                if (claimsByToken == null) {
                    throw new UnLoginException("validate is token error.");
                }

                String user = stringRedisTemplate.opsForValue().get(ConstantType.TOKEN_KEY + token);
                if (StringUtils.isEmpty(user)) {
                    throw new UnLoginException("The token has expired. please login again.");
                }
            }
        }
        return true;
    }
}
