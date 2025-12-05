package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*
 * 		JSP == MVC === SpringFrameWork === SpringBoot
 * 		JavaScript === JQuery === Vue === React === Next
 * 
 * 
 */
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.MusicService;
import com.sist.web.vo.MusicVO;
@Controller
public class MusicController {
	@Autowired
	private MusicService mservice;
	
	@GetMapping("/")
	public String music_list(@RequestParam(name="page",required=false)String page,Model model)
	{
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		int rowSize=12;
		int start=((curPage-1)*rowSize)+1;
		int end=curPage*rowSize;
		
		Map map=new HashMap();
		map.put("start",start);
		map.put("end",end);
		
		List<MusicVO> list=mservice.musicListData(map);
		int totalPage = mservice.musicTotalPage();
		
		final int BLOCK=10;
		int startPage = ((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalPage)
			endPage=totalPage;
		
		model.addAttribute("list", list);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);	
		return "main";
	}
}
