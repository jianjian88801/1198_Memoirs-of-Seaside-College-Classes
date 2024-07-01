package com.dao;

import com.entity.DiscusshuodongxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusshuodongxinxiVO;
import com.entity.view.DiscusshuodongxinxiView;


/**
 * 活动信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface DiscusshuodongxinxiDao extends BaseMapper<DiscusshuodongxinxiEntity> {
	
	List<DiscusshuodongxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusshuodongxinxiEntity> wrapper);
	
	DiscusshuodongxinxiVO selectVO(@Param("ew") Wrapper<DiscusshuodongxinxiEntity> wrapper);
	
	List<DiscusshuodongxinxiView> selectListView(@Param("ew") Wrapper<DiscusshuodongxinxiEntity> wrapper);

	List<DiscusshuodongxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusshuodongxinxiEntity> wrapper);
	
	DiscusshuodongxinxiView selectView(@Param("ew") Wrapper<DiscusshuodongxinxiEntity> wrapper);
	
}
