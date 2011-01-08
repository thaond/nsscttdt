package com.sgs.portlet.pcccdocumentsend.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.sgs.portlet.pcccdocumentsend.dto.UserDTO;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.service.persistence.PositionUtil;
import com.sgs.portlet.signer.model.Signer;
import com.sgs.portlet.signer.service.SignerLocalServiceUtil;


public class DocumendSendUtil {
	
	public List<PmlEdmIssuingPlace> getIssuingPlace() {
	
		List<PmlEdmIssuingPlace> pmlIssuingPlaceList = new ArrayList<PmlEdmIssuingPlace>();
		try{
			List<PmlEdmIssuingPlace> pmlIssuingPlaceListTemp = PmlEdmIssuingPlaceUtil.findAll();
		if (pmlIssuingPlaceList == null) {
			return pmlIssuingPlaceList;
		}
		
		pmlIssuingPlaceList = pmlIssuingPlaceListTemp;
		
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return pmlIssuingPlaceList;
		
	}
	
	public List<String> getIssuingPlaceName(){
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < getIssuingPlace().size(); i++) {
			res.add(getIssuingPlace().get(i).getIssuingPlaceName());
		}
		
		return res;
	}
	
	/**
	 * Lay nguoi dung co quyen ky van ban
	 * @return
	 * @throws Exception
	 */
	public List<UserDTO> getSigner() throws Exception {
		
		List<UserDTO> userDTOList =	new ArrayList<UserDTO>();
		List<User> listUser = UserUtil.findAll();
		// Lay danh sach user co quyen ky van ban di
		List<Signer> signers = SignerLocalServiceUtil.getAll();
		List<String> signerUserIds = new ArrayList<String>();
		if (!signers.isEmpty()) {
			for (Signer signer : signers) {
				signerUserIds.add(String.valueOf(signer.getUserId()));
			} // end for
		} // end if
		// Xoa cac phan tu trong list listUser neu nguoi dung khong co quyen ky van ban
		int idx = 0;
		while (!listUser.isEmpty() && idx < listUser.size()) {
			if (signerUserIds.indexOf(String.valueOf(listUser.get(idx).getUserId())) < 0) {
				// Nguoi dung khong co quyen ky
				listUser.remove(idx);
			} // end if
			else {
				idx ++;
			} // end else
		} // end while
		
		for (User user : listUser) {
			UserDTO dto = new UserDTO();
			dto.setUserId(user.getUserId());
			dto.setAccount(user.getScreenName());
			dto.setUserName(PmlUserLocalServiceUtil.getFullName(user.getUserId()));
			String positionName = "";
			PmlUser pmlUser = null;
			try {
				pmlUser = PmlUserUtil.findByPrimaryKey(user.getUserId()); 
			} 
			catch (Exception e) {
				pmlUser = null;
			}
			
			if (pmlUser != null) {
				String positionId = pmlUser.getPositionId();
				Position position = null;
				try {
					position = PositionUtil.findByPrimaryKey(positionId);
				} 
				catch (Exception e) {
					position = null;
				}
				if (position != null ) {
					positionName = position.getPositionName();
				}
			}
			
			dto.setPosition(positionName);
			
			userDTOList.add(dto);
		}
		
		return userDTOList;
	}
	
	public List<String> getSignerName()  {
		
		List<String> userNameList =	new ArrayList<String>();
		//List<User> listUser = new ArrayList<User>();
		List<Signer> signers = new ArrayList<Signer>();
		try {
			// minh update 20101112
			//listUser = UserUtil.findAll();
			signers = SignerLocalServiceUtil.getAll();
		} // end try
		catch (Exception e) {
			
		} // end catch
		
		//if (!listUser.isEmpty()) {
		
		User user = null;
		int size = signers.size();
		if (!signers.isEmpty()) {
			for (int i = 0; i < size; i++) {
				try {
					user = UserUtil.fetchByPrimaryKey(signers.get(i).getUserId());
					userNameList.add(getVietnameseStypeName(user));
				} catch (SystemException e) {
				}
			} // end for
		} // end if
		
		// sort alphabe
		Collections.sort(userNameList, new Comparator<String>() {
			public int compare(String userName1, String userName2) {
				return userName1.compareTo(userName2);
			}
		});
		
		return userNameList;
	}
	
	public static String getVietnameseStypeName(User user) {
		if (user != null) {
		return user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
	}
		return "";
	}

	public boolean addSigner(long userId) {
		try {
			Signer newItem = SignerLocalServiceUtil.addSigner(userId);
			if (newItem != null) {
				return true;
			} // end if
			return false;
		} // end try
		catch (Exception ex) {
			return false;
		} // end catch
	}

	/**
	 * Lay danh sach nguoi dung theo dang DTO
	 * @return
	 */
	public List<UserDTO> getUserDTOList() {

		List<UserDTO> userDTOList =	new ArrayList<UserDTO>();
		try {
			List<User> listUser = UserUtil.findAll();
			
			for (User user : listUser) {
				UserDTO dto = new UserDTO();
				dto.setUserId(user.getUserId());
				dto.setAccount(user.getScreenName());
				dto.setUserName(PmlUserLocalServiceUtil.getFullName(user.getUserId()));
				String positionName = "";
				PmlUser pmlUser = null;
				try {
					pmlUser = PmlUserUtil.findByPrimaryKey(user.getUserId()); 
				} 
				catch (Exception e) {
					pmlUser = null;
				}
				
				if (pmlUser != null) {
					String positionId = pmlUser.getPositionId();
					Position position = null;
					try {
						position = PositionUtil.findByPrimaryKey(positionId);
					} 
					catch (Exception e) {
						position = null;
					}
					if (position != null ) {
						positionName = position.getPositionName();
					}
					
				}
				
				dto.setPosition(positionName);
				
				userDTOList.add(dto);
			} // end for
		} // end try
		catch (Exception ex) {
			// Do nothing
		}
		
		return userDTOList;
	}
}
