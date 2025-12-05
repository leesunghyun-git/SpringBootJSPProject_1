package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.MusicDAO;
import com.sist.web.vo.MusicVO;

@Service
public class MusicSercieImpl implements MusicService{
	@Autowired
	private MusicDAO mdao;
	@Override
	public List<MusicVO> musicListData(Map map) {
		// TODO Auto-generated method stub
		return mdao.musicListData(map);
	}
	@Override
	public int musicTotalPage() {
		// TODO Auto-generated method stub
		return mdao.musicTotalPage();
	}
	
}
