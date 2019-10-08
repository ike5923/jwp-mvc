package nextstep.mvc.tobe;

import nextstep.mvc.tobe.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerResolver {
    ModelAndView resolve(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
