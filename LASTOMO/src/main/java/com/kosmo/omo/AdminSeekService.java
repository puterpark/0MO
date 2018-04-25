package com.kosmo.omo;

import java.util.ArrayList;

import com.kosmo.vo.SeekAllVO;

public interface AdminSeekService {

	public int AdminSeekCount();
	public ArrayList<SeekAllVO> adminSeekList(int startseq, int endseq);
	public SeekAllVO adminSeekDetail(int sseq);
	public int adminSeekUpdate(SeekAllVO svo);

		
}
