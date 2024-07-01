package com.dao;

import com.entity.BanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BanweiVO;
import com.entity.view.BanweiView;


/**
 * 班委
 * 
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface BanweiDao extends BaseMapper<BanweiEntity> {
	
	List<BanweiVO> selectListVO(@Param("ew") Wrapper<BanweiEntity> wrapper);
	
	BanweiVO selectVO(@Param("ew") Wrapper<BanweiEntity> wrapper);
	
	List<BanweiView> selectListView(@Param("ew") Wrapper<BanweiEntity> wrapper);

	List<BanweiView> selectListView(Pagination page,@Param("ew") Wrapper<BanweiEntity> wrapper);
	
	BanweiView selectView(@Param("ew") Wrapper<BanweiEntity> wrapper);
	
}
