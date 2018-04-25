package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.SeekAllVO;

@Repository("adminSeek")
public interface AdminSeekMapper {

	public int AdminSeekCount();

	public ArrayList<SeekAllVO> AdminSeekList(@Param("startSeq") int startseq, @Param("endSeq") int endseq);

	public SeekAllVO adminSeekDetail(@Param("sseq") int sseq);
	
	public int adminSeekUpdate(SeekAllVO svo);
}
