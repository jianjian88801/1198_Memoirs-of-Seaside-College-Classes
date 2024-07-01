package com.dao;

import com.entity.BanjixiangceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BanjixiangceVO;
import com.entity.view.BanjixiangceView;


/**
 * 班级相册
 * 
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface BanjixiangceDao extends BaseMapper<BanjixiangceEntity> {
	
	List<BanjixiangceVO> selectListVO(@Param("ew") Wrapper<BanjixiangceEntity> wrapper);
	
	BanjixiangceVO selectVO(@Param("ew") Wrapper<BanjixiangceEntity> wrapper);
	
	List<BanjixiangceView> selectListView(@Param("ew") Wrapper<BanjixiangceEntity> wrapper);

	List<BanjixiangceView> selectListView(Pagination page,@Param("ew") Wrapper<BanjixiangceEntity> wrapper);
	
	BanjixiangceView selectView(@Param("ew") Wrapper<BanjixiangceEntity> wrapper);
	
}
