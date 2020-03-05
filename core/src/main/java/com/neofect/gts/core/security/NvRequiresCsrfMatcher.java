package com.neofect.gts.core.security;

import com.unvus.web.util.WebUtil;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;

public class NvRequiresCsrfMatcher implements RequestMatcher {
    private final HashSet<String> allowedMethods = new HashSet<>(
        Arrays.asList("HEAD", "TRACE", "OPTIONS"));

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.security.web.util.matcher.RequestMatcher#matches(javax.
     * servlet.http.HttpServletRequest)
     */
    @Override
    public boolean matches(HttpServletRequest request) {

        if(!WebUtil.isAjax(request)) {
            return true;
        }
        return !this.allowedMethods.contains(request.getMethod());
    }
}
