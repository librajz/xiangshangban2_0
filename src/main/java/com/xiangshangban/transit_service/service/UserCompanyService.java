package com.xiangshangban.transit_service.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiangshangban.transit_service.bean.UserCompanyDefault;

/**
 * Created by mian on 2017/11/6.
 */
public interface UserCompanyService {

	List<UserCompanyDefault> selectByUserId(String userId);
	
    int deleteByPrimaryKey(UserCompanyDefault key);

    int insert(UserCompanyDefault record);

    int insertSelective(UserCompanyDefault record);
    
    UserCompanyDefault selectBySoleUserId(String userId);
    
    UserCompanyDefault selectByUserIdAndCompanyId(String userId,String companyId);
    
    int updateUserCompanyCoption(String userId,String companyId,String option);
}
