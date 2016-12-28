package example.spring.hateoas.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sgupta on 12/28/16.
 */
@Data
@AllArgsConstructor
public class Resource<T> extends ResourceSupport {
    private T content;
}
