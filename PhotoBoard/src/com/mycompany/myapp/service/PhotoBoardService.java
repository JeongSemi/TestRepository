package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.dto.PhotoBoard;

public interface PhotoBoardService {
	public void boardWrite(PhotoBoard board);
	public int boardTotalRows();
	public List<PhotoBoard> boardListPage(int pageNo, int rowsPerPage);
	public PhotoBoard getBoard(int bno);
	public void boardUpdateBhitCount(PhotoBoard board);
	public String boardCheckBpassword(int bno, String bpassword);
	public void boardUpdate(PhotoBoard board);
	public void boardDelete(int bno);
}