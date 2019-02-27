package com.qijia.upms.service;

import com.qijia.framework.dao.MyPage;
import com.qijia.upms.model.UpmsUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by weichen on 2018/9/29.
 */

@FeignClient(name= "qijia-upms-rpc-service")
public interface MyUserService {

	@RequestMapping(value = "/api/v1/user/get_user_list")
	List<UpmsUser> hello();

	@RequestMapping(value = "/api/v1/user/insert", method = RequestMethod.POST)
	@ResponseBody
	Integer insert(@RequestBody UpmsUser user);

	@RequestMapping(value = "/api/v1/user/delete", method = RequestMethod.GET)
	@ResponseBody
	Integer deleteById(@RequestParam("user_id") Integer userId);

	@RequestMapping(value = "/api/v1/user/delete/batch_ids", method = RequestMethod.POST)
	@ResponseBody
	Integer deleteBatchIds(@RequestBody Collection<? extends Serializable> var1);

	@RequestMapping(value = "/api/v1/user/query_by_username", method = RequestMethod.GET)
	@ResponseBody
	UpmsUser selectUpmsUserByUsername(@RequestParam("username") String username);

	@RequestMapping(value = "/api/v1/user/update", method = RequestMethod.POST)
	@ResponseBody
	Integer updateById(@RequestBody UpmsUser user);

	@RequestMapping(value = "/api/v1/user/query/{id}", method = RequestMethod.GET)
	@ResponseBody
	UpmsUser selectById(@RequestParam("id") Integer userId);

	@RequestMapping(value = "/api/v1/user/query/ids/{ids}", method = RequestMethod.GET)
	@ResponseBody
	List<UpmsUser> selectBatchIds(@RequestParam("ids") String ids);

	@RequestMapping(value = "/api/v1/user/all", method = RequestMethod.GET)
	@ResponseBody
	List<UpmsUser> selectList();

	@RequestMapping(value = "/api/v1/user/query/page/", method = RequestMethod.POST)
	@ResponseBody
	MyPage<UpmsUser> selectPage(@RequestBody MyPage<UpmsUser> page);
}
