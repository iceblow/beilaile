package com.warehouse.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
/**
 * 因为这个方法是mybatis在给参数设置值的时候，
 * 会调用到此方法，基于这样的原因，如果我们在setParameter中判断当前参数传入的值，
 * 如果value=null，我们就将参数的值设置为空的字符串，
 * 这样就避免了在执行插入语句的时候，传入null的情况，数据库中也不会报错，
 * 
 * @author MQ
 *
 */
public class NullValueHandler implements TypeHandler<String> {

	@Override
	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		if (parameter == null && jdbcType == JdbcType.VARCHAR) {// 判断传入的参数值是否为null
			ps.setString(i, "");// 设置当前参数的值为空字符串
		} else {
			ps.setString(i, parameter);// 如果不为null，则直接设置参数的值为value
		}

	}

	@Override
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		return rs.getString(columnName);
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getString(columnIndex);
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getString(columnIndex);
	}

}
