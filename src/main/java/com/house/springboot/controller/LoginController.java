package com.house.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.house.springboot.bean.TbUser;
import com.house.springboot.component.SysResult;
import com.house.springboot.service.AdminServiceImpl;
import com.house.springboot.bean.Admin;
import com.house.springboot.service.TbUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

	@Autowired
	public AdminServiceImpl adminService;

	@Autowired
	private TbUserServiceImpl userService;

	@GetMapping("/login")
	public String login(){
		return "login";
	}


	@GetMapping("/register")
	public String register(){
		return "register";
	}

	/**
	 * 用户注册
	 * @param admin
	 * @param map
	 * @param session
	 * @return
	 */
	@PostMapping("/register")
	public String register(TbUser user, Map<String, Object> map, HttpSession session) {

		List<TbUser> userList = userService.selectTbUserList(user);

		if(userList.size() > 0){
			map.put("msg","用户已存在，请重新输入用户名密码");
			return "register";
		}

		// 新增用户信息
		userService.insertTbUser(user);

		map.put("msg","注册成功");
		return "register";
	}
	
	@PostMapping("/login")
	public String login(Admin admin, Map<String, Object> map, HttpSession session) {
		if(admin.getRole().equals("1")){
			// 管理员
			List<Admin> adminList = adminService.selectAdminList(admin);

			if (adminList.size() > 0) {
				Admin sessionAdmin = adminList.get(0);
				sessionAdmin.setRole("1");
				session.setAttribute("loginUser", sessionAdmin);

				return "redirect:/adminFrame.html";
			}else {
				map.put("msg","用户名或密码错误");
				return "login";
			}
		}else if(admin.getRole().equals("2")){
			// 租客
			TbUser user = new TbUser();
			user.setUsername(admin.getAccount());
			user.setPassword(admin.getPassword());
			user.setRole("2");
			List<TbUser> adminList = userService.selectTbUserList(user);
			if (adminList.size() > 0) {
				Admin admin1 = new Admin();
				admin1.setId(adminList.get(0).getId());
				admin1.setAccount(adminList.get(0).getUsername());
				admin1.setPassword(adminList.get(0).getPassword());
				admin1.setPhone(adminList.get(0).getPhone());
				admin1.setRole("2");
				session.setAttribute("loginUser", admin1);

				return "redirect:/frame.html";
			}else {
				map.put("msg","用户名或密码错误");
				return "login";
			}
		}else{
			// 房东
			TbUser user = new TbUser();
			user.setUsername(admin.getAccount());
			user.setPassword(admin.getPassword());
			user.setRole("3");
			List<TbUser> userList = userService.selectTbUserList(user);
			if (userList.size() > 0) {
				Admin admin1 = new Admin();
				admin1.setId(userList.get(0).getId());
				admin1.setAccount(userList.get(0).getUsername());
				admin1.setPassword(userList.get(0).getPassword());
				admin1.setPhone(userList.get(0).getPhone());
				admin1.setRole("3");
				session.setAttribute("loginUser", admin1);

				return "redirect:/fangdongFrame.html";
			}else {
				map.put("msg","用户名或密码错误");
				return "login";
			}
		}

	}


	@ResponseBody
	@PostMapping("/sension")
	public SysResult getSsension(HttpSession session) {
		Admin admin = (Admin)session.getAttribute("loginUser");
		if (admin != null) {
			return SysResult.build(200, "已登录", admin);
		}else {
			return SysResult.build(400, "未登录", null);
		}
	}

	@ResponseBody
	@RequestMapping("/logout")
	public SysResult logOut(HttpSession session) {
		session.removeAttribute("loginUser");
		return SysResult.build(200, "用户注销", null);
	}

	@ResponseBody
	@RequestMapping("/changepwd")
	public SysResult changePassword(String password, String newpassword, HttpSession session) {
		System.out.println(password+"---"+newpassword);
		String attribute = (String)session.getAttribute("loginUser");
		String[] str = attribute.split("%");

		if(!password.equals(str[1])){
			return SysResult.build(400, "旧密码错误", null);
		}

		Admin admin = new Admin();
		admin.setAccount(str[0]);
		admin.setPassword(newpassword);
		adminService.updateAdmin(admin);

		return SysResult.ok();
	}
}
