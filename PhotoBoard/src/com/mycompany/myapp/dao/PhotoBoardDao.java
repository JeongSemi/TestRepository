package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.PhotoBoard;

public interface PhotoBoardDao {
	public int boardWrite(PhotoBoard board);
	public int boardCountAll();
	public List<PhotoBoard> boardSelectPage(int pageNo, int rowsPerPage);
	public PhotoBoard boardSelectByBno(int bno);
	public void boardUpdateBhitCount(PhotoBoard board);
	public void boardUpdate(PhotoBoard board);
	public void boardDelete(int bno);
	
}
