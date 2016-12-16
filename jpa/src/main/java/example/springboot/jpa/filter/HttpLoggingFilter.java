package example.springboot.jpa.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by abhilekhsingh041992 on 12/14/16.
 */
@Component
public class HttpLoggingFilter extends OncePerRequestFilter {

    protected static final Logger logger = LoggerFactory.getLogger(HttpLoggingFilter.class);
    private AtomicLong requestId = new AtomicLong(1);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(logger.isDebugEnabled()){
            final long id = requestId.incrementAndGet();
            final RequestWrapper requestWrapper = new RequestWrapper(id, request);
            final ResponseWrapper responseWrapper = new ResponseWrapper(id, response);
            filterChain.doFilter(requestWrapper, responseWrapper);
            try {
                final HttpInfo httpInfo = getHttpInfo(requestWrapper, responseWrapper);
                ObjectMapper objectMapper = new ObjectMapper();
                String indented = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(httpInfo);
                logger.debug("Request and response: id={} info={}", id, indented);
            } catch (UnsupportedEncodingException ex) {
                logger.error("Error in logging http request and response id={} error={}", id, ex);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    public HttpInfo getHttpInfo(RequestWrapper requestWrapper, ResponseWrapper responseWrapper) throws UnsupportedEncodingException {
        return HttpInfo.builder()
                .url(getUrl(requestWrapper))
                .requestHeaders(getRequestHeaders(requestWrapper))
                .requestBody(getRequestBody(requestWrapper))
                .responseHeaders(getResponseHeaders(responseWrapper))
                .responseBody(getResponseBody(responseWrapper))
                .build();
    }

    public Map<String, String> getRequestHeaders(RequestWrapper requestWrapper) {
        Map<String, String> headers = new HashMap<>();
        Collections.list(requestWrapper.getHeaderNames()).forEach(key -> headers.put(key, requestWrapper.getHeader(key)));
        return headers;
    }

    public Map<String, String> getResponseHeaders(ResponseWrapper responseWrapper) {
        Map<String, String> headers = new HashMap<>();
        responseWrapper.getHeaderNames().forEach(key -> headers.put(key, responseWrapper.getHeader(key)));
        return headers;
    }

    public String getUrl(RequestWrapper requestWrapper) {
        return requestWrapper.getRequestURL() + "?" + requestWrapper.getQueryString();
    }

    public String getRequestBody(RequestWrapper requestWrapper) throws UnsupportedEncodingException {
        String charEncoding = requestWrapper.getCharacterEncoding() != null ? requestWrapper.getCharacterEncoding() :
                "UTF-8";
        return new String(requestWrapper.toByteArray(), charEncoding);
    }

    public String getResponseBody(ResponseWrapper responseWrapper) throws UnsupportedEncodingException {
        return new String(responseWrapper.toByteArray(), responseWrapper.getCharacterEncoding());
    }

}