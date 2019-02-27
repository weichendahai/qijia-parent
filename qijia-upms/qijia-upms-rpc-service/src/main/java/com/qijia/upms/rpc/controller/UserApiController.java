package com.qijia.upms.rpc.controller;

import com.qijia.framework.dao.IBaseDao;
import com.qijia.framework.dao.MyEntityWrapper;
import com.qijia.framework.dao.MyPage;
import com.qijia.upms.model.UpmsUser;
import com.qijia.upms.rpc.api.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;

/**
 * Created by weichen on 2018/9/29.
 */

@Controller
@RequestMapping("/api/v1/user")
public class UserApiController {

	@Autowired
	UpmsUserService userService;

	/**
	 * 添加用户
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public Integer insert(@RequestBody UpmsUser user) {
		return userService.insert(user);
	}

	/**
	 * 删除用户
	 *
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public Integer deleteById(@RequestParam("user_id") Integer userId) {
		return userService.deleteById(userId);
	}

	@RequestMapping(value = "/delete/batch_ids", method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteBatchIds(@RequestBody Collection<? extends Serializable> var1) {
		return userService.deleteBatchIds(var1);
	}

	/**
	 * 根据用户名查询用户数据
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/query_by_username", method = RequestMethod.GET)
	@ResponseBody
	public UpmsUser selectUpmsUserByUsername(@RequestParam("username") String username) {
		return userService.selectUpmsUserByUsername(username);
	}

	/**
	 * 根据用户Id修改用户数据信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Integer updateById(@RequestBody UpmsUser user) {
		return userService.updateById(user);
	}

	/**
	 * 根据用户ID查找数据
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UpmsUser selectById(@RequestParam("id") Integer userId) {
		return userService.selectById(userId);
	}

	/**
	 * 多个Id 批量查询用户；使用"," 分割；
	 * 如:  100,101,103
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/query/ids/{ids}", method = RequestMethod.GET)
	@ResponseBody
	public List<UpmsUser> selectBatchIds(@RequestParam("ids") String ids) {
		List<String> userIdList = new ArrayList<>();
		if (ids.contains(",")) {
			String[] split = ids.split(",");
			userIdList = Arrays.asList(split);
		}
		return userService.selectBatchIds(userIdList);
	}

	/**
	 * 查询所有用户信息
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<UpmsUser> selectList() {
		return userService.selectList(null);
	}

	/**
	 * 分页查询用户信息
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/query/page/", method = RequestMethod.POST)
	@ResponseBody
	public MyPage<UpmsUser> selectPage(@RequestBody MyPage<UpmsUser> page) {
		MyPage<UpmsUser> userMyPage = userService.selectPage(page);
		return userMyPage;
	}
}
