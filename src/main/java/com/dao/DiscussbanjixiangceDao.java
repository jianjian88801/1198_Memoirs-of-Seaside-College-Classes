package com.dao;

import com.entity.DiscussbanjixiangceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbanjixiangceVO;
import com.entity.view.DiscussbanjixiangceView;


/**
 * 班级相册评论表
 * 
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface DiscussbanjixiangceDao extends BaseMapper<DiscussbanjixiangceEntity> {
	
	List<DiscussbanjixiangceVO> selectListVO(@Param("ew") Wrapper<DiscussbanjixiangceEntity> wrapper);
	
	DiscussbanjixiangceVO selectVO(@Param("ew") Wrapper<DiscussbanjixiangceEntity> wrapper);
	
	List<DiscussbanjixiangceView> selectListView(@Param("ew") Wrapper<DiscussbanjixiangceEntity> wrapper);

	List<DiscussbanjixiangceView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbanjixiangceEntity> wrapper);
	
	DiscussbanjixiangceView selectView(@Param("ew") Wrapper<DiscussbanjixiangceEntity> wrapper);
	
}
