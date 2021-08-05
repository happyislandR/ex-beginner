package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		return member;
	};
	
	/**
	 * 曖昧検索を行う
	 * @param character 検索する文字列
	 * @return 曖昧検索にヒットしたmemberのリスト
	 */
	public List<Member> findByLikeName(String character) {
		String sql = "SELECT id, name FROM members WHERE name LIKE :name";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + character + "%");
		List<Member> memberList = template.query(sql, param, MEMBER_ROW_MAPPER);
		return memberList;
	}
	
}
