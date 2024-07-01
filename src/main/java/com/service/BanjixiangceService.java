package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BanjixiangceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BanjixiangceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BanjixiangceView;


/**
 * 班级相册
 *
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface BanjixiangceService extends IService<BanjixiangceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BanjixiangceVO> selectListVO(Wrapper<BanjixiangceEntity> wrapper);
   	
   	BanjixiangceVO selectVO(@Param("ew") Wrapper<BanjixiangceEntity> wrapper);
   	
   	List<BanjixiangceView> selectListView(Wrapper<BanjixiangceEntity> wrapper);
   	
   	BanjixiangceView selectView(@Param("ew") Wrapper<BanjixiangceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BanjixiangceEntity> wrapper);
   	
}

