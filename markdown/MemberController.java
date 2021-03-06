package com.study.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.utility.Utility;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("com.study.member.MemberServiceImpl")
	private MemberService service;

	@GetMapping("/")
	public String home() {

		return "/home";
	}
	
	@GetMapping("/member/agree")
	public String agree() {
		return "/member/agree";
	}
	
	@PostMapping("/member/createForm")
	public String create() {
		return "/member/create";
	}
	
	@PostMapping("/member/create")
	public String create(MemberDTO dto) throws IOException {
		String upDir = new ClassPathResource("/static/member/storage").getFile().getAbsolutePath();
		String fname = Utility.saveFileSpring(dto.getFnameMF(), upDir);
		int size = (int)dto.getFnameMF().getSize();
		if(size>0) {
			dto.setFname(fname);
		}else {
			dto.setFname("member.jpg");
		}
		
		if(service.create(dto)>0) {
			return "redirect:/";
		}else {
			return "error";
		}
		
	}
	
	@GetMapping(value="/member/emailcheck",produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,String> emailcheck(String email){
		
		int cnt = service.duplicatedEmail(email);  
		
		Map<String,String> map = new HashMap<String,String>();
		if(cnt>0) {
			map.put("str", email+"는 중복되어서 사용할 수 없습니다.");
			
		}else {
			map.put("str", email+"는 중복아님, 사용가능 합니다.");
		}
		
		return map;
		
	}
	
	@GetMapping(value="/member/idcheck",produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,String> idcheck(String id){
		
		int cnt = service.duplicatedId(id); 
		
		Map<String,String> map = new HashMap<String,String>();
		if(cnt>0) {
			map.put("str", id+"는 중복되어서 사용할 수 없습니다.");
			
		}else {
			map.put("str", id+"는 중복아님, 사용가능 합니다.");
		}
		
		return map;
		
	}
	
	@GetMapping("/member/login")
	public String login(HttpServletRequest request) {
		
		/*----쿠키설정 내용시작----------------------------*/
        String c_id = "";     // ID 저장 여부를 저장하는 변수, Y
        String c_id_val = ""; // ID 값
         
        Cookie[] cookies = request.getCookies(); 
        Cookie cookie=null; 
         
        if (cookies != null){ 
         for (int i = 0; i < cookies.length; i++) { 
           cookie = cookies[i]; 
         
           if (cookie.getName().equals("c_id")){ 
             c_id = cookie.getValue();     // Y 
           }else if(cookie.getName().equals("c_id_val")){ 
             c_id_val = cookie.getValue(); // user1... 
           } 
         } 
        } 
        /*----쿠키설정 내용 끝----------------------------*/
        request.setAttribute("c_id", c_id);
        request.setAttribute("c_id_val", c_id_val);
		
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(@RequestParam Map<String,String> map,
			HttpSession session,
			HttpServletResponse response,
			Model model) {
		
		int cnt = service.loginCheck(map);
		
		if(cnt>0) {
			String grade = service.getGrade(map.get("id"));
            session.setAttribute("id", map.get("id"));
            session.setAttribute("grade", grade);
            //Cookie 저장,id저장 여부 및 id
            Cookie cookie = null;
            String c_id = map.get("c_id");
            if(c_id != null) {
                cookie = new Cookie("c_id",c_id ); //c_id=> Y
                cookie.setMaxAge(60 * 60 * 24 * 365);//1년
                response.addCookie(cookie);//요청지(client:브라우저 컴) 쿠키 저장
                
                cookie = new Cookie("c_id_val",map.get("id"));
                cookie.setMaxAge(60 * 60 * 24 * 365);//1년
                response.addCookie(cookie);//요청지(client:브라우저 컴) 쿠키 저장
            }else {
                cookie = new Cookie("c_id",""); //쿠키 삭제
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                
                cookie = new Cookie("c_id_val","");//쿠키 삭제
                cookie.setMaxAge(0);
                response.addCookie(cookie);             
                    
            }
		}//if cnt>0 end
		
		if(cnt>0) {
			return "redirect:/";
		}else {
			model.addAttribute("msg","아이디 또는 비밀번호를 잘못 입력 했거나 <br>회원이 아닙니다. 회원가입 하세요");
            return "/member/errorMsg";
		}
		
	}

}