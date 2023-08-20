package itm;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "itm.TimeServlet", urlPatterns = "/time")
public class TimeServlet extends HttpServlet {
    private String initTime;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tz = req.getParameter("timezone");
        if ( tz == null ) tz="UTC";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss OOOO");
        initTime = OffsetDateTime.now(ZoneId.of(tz.replace(' ', '+'))).format(formatter);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(initTime);
        resp.getWriter().close();
    }
}
