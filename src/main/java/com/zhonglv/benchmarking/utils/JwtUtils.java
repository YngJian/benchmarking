package com.zhonglv.benchmarking.utils;

import com.zhonglv.benchmarking.common.ConstantType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : Yang Jian
 * @date : 2021/7/4 0004 10:01
 */
@Slf4j
public class JwtUtils {
    /**
     * 创建一个token
     *
     * @param userId u
     * @return s
     */
    public static String generateToken(String userId) {
        Date date = new Date();
        LocalDateTime localDateTime = DateUtils.dateToLocalDateTime(date).plusMinutes(ConstantType.TOKEN_EXPIRE_MINUTES);
        Date expirationDate = DateUtils.localDateTimeToDate(localDateTime);
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setSubject(userId)
                .setIssuedAt(date)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, ConstantType.JWT_SECRET)
                .compact();
    }

    /**
     * 解析token
     */
    public static Claims getClaimsByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(ConstantType.JWT_SECRET)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error("validate is token error", e);
            return null;
        }
    }

    /**
     * 判断 token 是否过期
     */
    public static boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    /**
     * 将传递进来的不需要过滤得路径集合的字符串格式化成一系列的正则规则
     *
     * @param str 不需要过滤的路径集合
     * @return 正则表达式规则
     */
    public static String getRegStr(String str) {
        if (StringUtils.isNotBlank(str)) {
            String[] excludes = str.split(";");
            int length = excludes.length;
            for (int i = 0; i < length; i++) {
                String tmpExclude = excludes[i];
                //对点、反斜杠和星号进行转义
                tmpExclude = tmpExclude.replace("\\", "\\\\").replace(".", "\\.").replace("*", ".*");

                tmpExclude = "^" + tmpExclude + "$";
                excludes[i] = tmpExclude;
            }
            return StringUtils.join(excludes, "|");
        }
        return str;
    }

}
