package com.dao;

import com.entity.JiarubanjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiarubanjiVO;
import com.entity.view.JiarubanjiView;


/**
 * 加入班级
 * 
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface JiarubanjiDao extends BaseMapper<JiarubanjiEntity> {
	
	List<JiarubanjiVO> selectListVO(@Param("ew") Wrapper<JiarubanjiEntity> wrapper);
	
	JiarubanjiVO selectVO(@Param("ew") Wrapper<JiarubanjiEntity> wrapper);
	
	List<JiarubanjiView> selectListView(@Param("ew") Wrapper<JiarubanjiEntity> wrapper);

	List<JiarubanjiView> selectListView(Pagination page,@Param("ew") Wrapper<JiarubanjiEntity> wrapper);
	
	JiarubanjiView selectView(@Param("ew") Wrapper<JiarubanjiEntity> wrapper);
	
}
