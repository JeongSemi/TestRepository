package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.PhotoBoard;

@Component
public class PhotoBoardDaoImpl implements PhotoBoardDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhotoBoardDaoImpl.class);

	@Override
	public int boardWrite(PhotoBoard board) {
		int bno = -1;
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn = DriverManager.getConnection(url, "djsuser", "iot12345");
			LOGGER.info("���� ����");

			String sql = "insert into photoboard ";
			sql += "(bno, boriginalfilename, bsavedfilename, bfilecontent, btitle, bwriter, bpassword, bdate, bcontent, bhitcount) ";
			sql += "values ";
			sql += "(board_bno_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, ?, 0) ";

			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });
			pstmt.setString(1, board.getBoriginalfilename());
			pstmt.setString(2, board.getBsavedfilename());
			pstmt.setString(3, board.getBfilecontent());
			pstmt.setString(4, board.getBtitle());
			pstmt.setString(5, board.getBwriter());
			pstmt.setString(6, board.getBpassword());
			pstmt.setString(7, board.getBcontent());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			bno = rs.getInt(1);
			// rs.close();
			pstmt.close();
			LOGGER.info("�� �߰� ����");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// ���� ����
			try {
				conn.close();
				LOGGER.info("���� ����");
			} catch (SQLException e) {
			}
		}

		return bno;
	}

	@Override
	public int boardCountAll() {
		int count = 0;
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn = DriverManager.getConnection(url, "djsuser", "iot12345");
			LOGGER.info("���� ����");

			String sql = "select count(*) from photoboard";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // ����X, DB�� ���¸� ������Ѷ�
			rs.next();
			count = rs.getInt(1);
			rs.close();
			pstmt.close();
			LOGGER.info("COUNT ����");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	@Override
	public List<PhotoBoard> boardSelectPage(int pageNo, int rowsPerPage) {
		List<PhotoBoard> list = new ArrayList<>();
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn = DriverManager.getConnection(url, "djsuser", "iot12345");
			LOGGER.info("���� ����");

			String sql = "select * ";
			sql += "from ( ";
			sql += "  select rownum as r, bno, btitle, bwriter, bcontent, bdate, bhitcount, boriginalfilename ";
			sql += "  from ( ";
			sql += "  select bno, btitle, bwriter, bcontent, bdate, bhitcount, boriginalfilename from photoboard order by bno desc ";
			sql += "  ) ";
			sql += "  where rownum<=? ";
			sql += ") ";
			sql += "where r>=? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo * rowsPerPage);
			pstmt.setInt(2, (pageNo - 1) * rowsPerPage + 1);
			ResultSet rs = pstmt.executeQuery(); // ����X, DB�� ���¸� ������Ѷ�
			while (rs.next()) {
				PhotoBoard board = new PhotoBoard();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(4));
				board.setBcontent(rs.getString("bcontent"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				list.add(board);
			}
			rs.close();
			pstmt.close();
			LOGGER.info("SELECT ����");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public PhotoBoard boardSelectByBno(int bno) {
		PhotoBoard board = null;
		Connection conn = null;
		

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn = DriverManager.getConnection(url, "djsuser", "iot12345");
			LOGGER.info("���� ����");

			String sql = "select * from photoboard where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery(); // ����X, DB�� ���¸� ������Ѷ�
			if (rs.next()) {
				board = new PhotoBoard();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBdate(rs.getDate("bdate"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBpassword(rs.getString("bpassword"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
			}
			rs.close();
			pstmt.close();
			LOGGER.info("SELECTBYBNO ����");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return board;
	}

	@Override
	public void boardUpdateBhitCount(PhotoBoard board) {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn = DriverManager.getConnection(url, "djsuser", "iot12345");
			LOGGER.info("���� ����");

			String sql = "update photoboard set bhitcount=? where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBhitcount());
			pstmt.setInt(2, board.getBno());
			pstmt.executeUpdate(); // ����X, DB�� ���¸� ������Ѷ�
			pstmt.close();
			LOGGER.info("UPDATE ����");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public void boardUpdate(PhotoBoard board) {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn = DriverManager.getConnection(url, "djsuser", "iot12345");
			LOGGER.info("���� ����");

			String sql;
			if (board.getBoriginalfilename() != null) {
				sql = "update photoboard set btitle=?, bcontent=?, bpassword=?, boriginalfilename=?, bdate=sysdate, bsavedfilename=?, bfilecontent=? where bno=?";
			} else {
				sql = "update photoboard set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=?";
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBpassword());
			if (board.getBoriginalfilename() != null) {
				pstmt.setString(4, board.getBoriginalfilename());
				pstmt.setString(5, board.getBsavedfilename());
				pstmt.setString(6, board.getBfilecontent());
				pstmt.setInt(7, board.getBno());
			} else {
				pstmt.setInt(4, board.getBno());
			}
			pstmt.executeUpdate();
			pstmt.close();
			LOGGER.info("UPDATE ����");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void boardDelete(int bno) {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@117.17.198.43:1531:orcl";
			conn = DriverManager.getConnection(url, "djsuser", "iot12345");
			LOGGER.info("���� ����");

			String sql = "delete from photoboard where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			pstmt.close();
			LOGGER.info("DELETE ����");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

	}
}