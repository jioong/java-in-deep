package com.mybatis3.typehandler;

import com.mybatis3.domain.PhoneNumber;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jioong on 17-9-29.
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PhoneNumber phoneNumber, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, phoneNumber.toString());
    }

    public PhoneNumber getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    public PhoneNumber getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    public PhoneNumber getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
