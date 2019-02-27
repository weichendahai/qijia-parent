package login.web.exception;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weichen on 2018/9/19.
 * 全局异常处理
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
		ModelAndView mv = new ModelAndView();

		Map<String, Object> attributes = new HashMap<String, Object>();
		if (ex instanceof UnauthenticatedException) {
			attributes.put("code", "1000001");
			attributes.put("msg", "token错误");
		} else if (ex instanceof UnauthorizedException) {
			attributes.put("code", "1000002");
			attributes.put("msg", "用户无权限");
		} else {
			attributes.put("code", "1000003");
			attributes.put("msg", ex.getMessage());
		}
//		FastJsonJsonView view = new FastJsonJsonView();
//		view.setAttributesMap(attributes);

		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setAttributesMap(attributes);
		mv.setView(view);
		return mv;
	}
}
