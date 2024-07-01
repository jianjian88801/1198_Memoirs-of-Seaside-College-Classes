package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BanweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BanweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BanweiView;


/**
 * 班委
 *
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface BanweiService extends IService<BanweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BanweiVO> selectListVO(Wrapper<BanweiEntity> wrapper);
   	
   	BanweiVO selectVO(@Param("ew") Wrapper<BanweiEntity> wrapper);
   	
   	List<BanweiView> selectListView(Wrapper<BanweiEntity> wrapper);
   	
   	BanweiView selectView(@Param("ew") Wrapper<BanweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BanweiEntity> wrapper);
   	
}

