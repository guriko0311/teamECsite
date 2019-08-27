package com.internousdev.texas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.texas.dto.DestinationInfoDTO;
import com.internousdev.texas.util.DBConnector;

public class DestinationInfoDAO {

	public int insert(String userId,String familyName,String firstName,
	String familyNameKana,String firstNameKana,String email,String telNumber,String userAddress){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int count = 0;
		String sql = "INSERT INTO destination_info"
				+ "(user_id,family_name,first_name,family_name_kana,first_name_kana,"
				+ "email,tel_number,user_address,regist_date,update_date)VALUES(?,?,?,?,?,?,?,?,now(),now())";

		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,familyName);
			ps.setString(3,firstName);
			ps.setString(4,familyNameKana);
			ps.setString(5,firstNameKana);
			ps.setString(6,email);
			ps.setString(7,telNumber);
			ps.setString(8,userAddress);
			count = ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{

			connection.close();

			}catch(SQLException e){

				e.printStackTrace();
			}
		}
		return count;

	}

	public List<DestinationInfoDTO> getDestinationInfo(String userId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT id, family_name, first_name, family_name_kana, first_name_kana, user_address, tel_number, email "
				+ "FROM destination_info WHERE user_id = ?";

	try {
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
			destinationInfoDTO.setId(rs.getInt("id"));
			destinationInfoDTO.setFamilyName(rs.getString("family_name"));
			destinationInfoDTO.setFirstName(rs.getString("first_name"));
			destinationInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
			destinationInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
			destinationInfoDTO.setUserAddress(rs.getString("user_address"));
			destinationInfoDTO.setEmail(rs.getString("email"));
			destinationInfoDTO.setTelNumber(rs.getString("tel_number"));
			destinationInfoDTOList.add(destinationInfoDTO);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return destinationInfoDTOList;
}

public int deleteDestination(String id){
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();

	String sql = "DELETE FROM destination_info WHERE id = ?";
	int count = 0;
	try {
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, id);
		count = ps.executeUpdate();

	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return count;
}

}
