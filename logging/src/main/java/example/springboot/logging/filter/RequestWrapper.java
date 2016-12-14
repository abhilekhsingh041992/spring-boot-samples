package example.springboot.logging.filter;

import org.apache.commons.io.input.TeeInputStream;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by abhilekhsingh041992 on 12/14/16.
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private long id;


    public RequestWrapper(Long requestId, HttpServletRequest request) {
        super(request);
        this.id = requestId;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            private TeeInputStream tee = new TeeInputStream(RequestWrapper.super.getInputStream(), bos);

            @Override
            public int read() throws IOException {
                return tee.read();
            }
        };
    }

    public byte[] toByteArray(){
        return bos.toByteArray();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
