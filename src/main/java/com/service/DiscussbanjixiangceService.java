package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbanjixiangceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbanjixiangceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbanjixiangceView;


/**
 * 班级相册评论表
 *
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface DiscussbanjixiangceService extends IService<DiscussbanjixiangceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbanjixiangceVO> selectListVO(Wrapper<DiscussbanjixiangceEntity> wrapper);
   	
   	DiscussbanjixiangceVO selectVO(@Param("ew") Wrapper<DiscussbanjixiangceEntity> wrapper);
   	
   	List<DiscussbanjixiangceView> selectListView(Wrapper<DiscussbanjixiangceEntity> wrapper);
   	
   	DiscussbanjixiangceView selectView(@Param("ew") Wrapper<DiscussbanjixiangceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbanjixiangceEntity> wrapper);
   	
}

