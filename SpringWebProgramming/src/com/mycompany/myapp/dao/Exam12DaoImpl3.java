package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl3 implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl3.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int boardInsert(Exam12Board board) {

		sqlSessionTemplate.insert("board.insert", board); // 삽입된 행의 갯수를 리턴(무조건
															// 1이라고 보면됨)
		int bno = board.getBno();

		LOGGER.info("행 추가 성공");
		return bno;
	}

	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectAll");
		LOGGER.info("SELECT 성공");

		return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", (pageNo - 1) * rowsPerPage + 1);
		map.put("endNum", pageNo * rowsPerPage);
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectByPage", map);
		LOGGER.info("SELECT 성공");

		return list;
	}

	@Override
	public int boardCountAll() {
		int count = sqlSessionTemplate.selectOne("board.countAll");

		return count;
	}

	@Override
	public Exam12Board boardSelectByBno(int bno) {

		Exam12Board board = sqlSessionTemplate.selectOne("board.selectByBno", bno);
		LOGGER.info("SELECT 성공");

		return board;
	}

	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bhitcount", bhitcount);
		map.put("bno", bno);

		sqlSessionTemplate.update("board.updateBhitcount", map);
		LOGGER.info("UPDATE 성공");
	}

	@Override
	public void boardUpdate(Exam12Board board) {

		sqlSessionTemplate.update("board.update", board);
		LOGGER.info("UPDATE 성공");
	}

	@Override
	public void boardDelete(int bno) {

		String sql = "delete from board where bno=?";

		jdbcTemplate.update(sql, bno);
		LOGGER.info("UPDATE 성공");

	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String memberInsert(Exam12Member member) {

		String sql = "insert into member ";
		sql += "(mid, mname, mpassword, mdate, mtel, memail, mage, maddress, moriginalfilename, msavedfilename, mfilecontent) ";
		sql += "values ";
		sql += "(?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?) ";

		jdbcTemplate.update(sql, member.getMid(), member.getMname(), member.getMpassword(), member.getMtel(),
				member.getMemail(), member.getMage(), member.getMaddress(), member.getMoriginalfilename(),
				member.getMsavedfilename(), member.getMfilecontent());
		LOGGER.info("행 추가 성공");

		return member.getMid();
	}

	@Override
	public List<Exam12Member> memberSelectAll() {

		String sql = "select mid, mname, mtel, memail, mage, maddress ";
		sql += "from member ";
		sql += "order by mid asc";

		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {
			@Override
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMdate(rs.getDate("mdate"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				return member;
			}
		};

		List<Exam12Member> list = jdbcTemplate.query(sql, rowMapper);

		return list;
	}

	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {

		String sql = "select * ";
		sql += "from ( ";
		sql += "  select rownum as r, mid, mname, mdate, mtel, memail, mage, maddress ";
		sql += "  from ( ";
		sql += "  select mid, mname, mdate, mtel, memail, mage, maddress from member order by mid asc ";
		sql += "  ) ";
		sql += "  where rownum<=? ";
		sql += ") ";
		sql += "where r>=? ";

		Object[] args = { (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1) };
		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {
			@Override
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMdate(rs.getDate("mdate"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				return member;
			}
		};

		List<Exam12Member> list = jdbcTemplate.query(sql, args, rowMapper);
		return list;
	}

	@Override
	public int memberCountAll() {

		String sql = "select count(*) from member";

		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		LOGGER.info("SELECT 성공");

		return count;
	}

	@Override
	public Exam12Member memberSelectByMid(String mid) {

		String sql = "select * from member where mid=?";

		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {
			@Override
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMname(rs.getString("mname"));
				member.setMdate(rs.getDate("mdate"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				member.setMoriginalfilename(rs.getString("moriginalfilename"));
				member.setMsavedfilename(rs.getString("msavedfilename"));
				member.setMfilecontent(rs.getString("mfilecontent"));
				return member;
			}
		};
		Exam12Member member = jdbcTemplate.queryForObject(sql, rowMapper, mid);
		LOGGER.info("SELECT 성공");

		return member;
	}

	@Override
	public void memberUpdate(Exam12Member member) {

		String sql;
		if (member.getMoriginalfilename() != null) {
			sql = "update member set mname=?, mpassword=?, mdate=sysdate, mtel=?, memail=?, mage=?, maddress=?, moriginalfilename=?, msavedfilename=?, mfilecontent=? where mid=?";
			jdbcTemplate.update(sql, member.getMname(), member.getMpassword(), member.getMtel(), member.getMemail(),
					member.getMage(), member.getMaddress(), member.getMoriginalfilename(), member.getMsavedfilename(),
					member.getMfilecontent(), member.getMid());
		} else {
			sql = "update member set mname=?, mpassword=?, mdate=sysdate, mtel=?, memail=?, mage=?, maddress=? where mid=?";
			jdbcTemplate.update(sql, member.getMname(), member.getMpassword(), member.getMtel(), member.getMemail(),
					member.getMage(), member.getMaddress(), member.getMid());
		}

		LOGGER.info("UPDATE 성공");

	}

	@Override
	public void memberDelete(String mid) {

		String sql = "delete from member where mid=?";
		jdbcTemplate.update(sql, mid);
		LOGGER.info("UPDATE 성공");
	}

}
