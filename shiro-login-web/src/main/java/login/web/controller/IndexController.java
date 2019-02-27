package login.web.controller;

import login.web.model.SysResource;
import login.web.model.SysUser;
import login.web.service.SysResourceService;
import login.web.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by weichen on 2018/9/18.
 */

@Controller
public class IndexController {

	@Autowired
	SysResourceService resourceService;

	@Autowired
	SysUserService userService;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String userName = "admin";
		Set<String> permissions = userService.findPermissions(userName);
		List<SysResource> menus = resourceService.findMenus(permissions);
		System.out.println("权限:" + permissions.toString());
		System.out.println("菜单" + menus.toString());
		return "index";
	}

	@RequestMapping("/welcome")
	@ResponseBody
	public String welcome() {
		return "welcome";
	}

	@RequiresPermissions("user:create")
	@RequestMapping("/test_permission")
	@ResponseBody
	public String testPermission() {

		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			return "user is not login";
		}

//		System.out.println(currentUser.getPrincipal().toString());
//		System.out.println(currentUser.toString());
//
//		if (currentUser.isPermitted("user:create")) {
//			System.out.println("user is have user:create");
//		}
//
//		if (currentUser.isPermitted("student:create")) {
//			System.out.println("user is have student:create");
//		}

		return "testPermission";
	}


	@RequiresPermissions("user1ss:create111")
	@RequestMapping("/test_role")
	@ResponseBody
	public String testRole() {
		return "testRole";
	}


	@RequiresPermissions("user:view")
	@RequestMapping("/test_user_view")
	@ResponseBody
	public String testUserView() {
		System.out.println("用户具有 user:view 权限");
		return "test user view";
	}

	/**
	 * 登录方法
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxLogin(@RequestBody Map params) {

		String userName = params.get("userName").toString();
		String password = params.get("password").toString();
		SysUser user = new SysUser();
		user.setUsername(userName);
		user.setPassword(password);

//		JSONObject jsonObject = new JSONObject();
		HashMap<String,Object> result = new HashMap<>();

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try {
			subject.login(token);
			result.put("token", subject.getSession().getId());
			result.put("msg", "登录成功");
		} catch (IncorrectCredentialsException e) {
			result.put("msg", "密码错误");
		} catch (LockedAccountException e) {
			result.put("msg", "登录失败，该用户已被冻结");
		} catch (AuthenticationException e) {
			result.put("msg", "该用户不存在");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}


	/**
	 *  本项目使用SpringMVC框架，可以自行修改使用其他MVC框架。登录成功则返回sessionId作为token给前端存储，
	 *  前端请求时将该token放入请求头，以Authorization为key，以此来鉴权。
	 *  如果出现账号或密码错误等异常则返回错误信息。
	 *  传统项目中，登出后应重定向请求，到登录界面或其他指定界面，在前后端分离的项目中，
	 *  我们应该返回json信息。在上面提到的ShiroConfig中配置了默认登录路由
	 *
	 *  未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
	 * @return
	 */
	@RequestMapping(value = "/unauth")
	@ResponseBody
	public Object unauth() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "1000000");
		map.put("msg", "未登录");
		return map.toString();
	}

}
