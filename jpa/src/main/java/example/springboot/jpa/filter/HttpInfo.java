package example.springboot.jpa.filter;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * Created by abhilekhsingh on 12/16/16.
 */
@Data
@Builder
public class HttpInfo {

    private String url;
    private Map<String, String> requestHeaders;
    private String requestBody;
    private  Map<String, String> responseHeaders;
    private String responseBody;

}
