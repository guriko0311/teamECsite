package com.internousdev.texas.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.texas.dao.CartInfoDAO;
import com.internousdev.texas.dao.PurchaseHistoryInfoDAO;
import com.internousdev.texas.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware{

	private String id;
	private Map<String,Object> session;

	public String execute()throws SQLException{
		if(!session.containsKey("tempUserId") && !session.containsKey("userId")){
			return "sessionTimeout";
		}

		String result = ERROR;

		String userId = session.get("userId").toString();

		@SuppressWarnings("unchecked")
		List<CartInfoDTO> cartInfoDTOList = (List<CartInfoDTO>) session.get("cartInfoDTOList");

		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int count = 0;
		for (CartInfoDTO dto : cartInfoDTOList) {
			count += purchaseHistoryInfoDAO.regist(
				userId,
				dto.getProductId(),
				dto.getProductCount(),
				Integer.parseInt(id),
				dto.getPrice()
			);
		}
		if(count > 0) {
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			count = cartInfoDAO.deleteAll(String.valueOf(session.get("userId")));
			if(count > 0) {
				result = SUCCESS;
			}
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
