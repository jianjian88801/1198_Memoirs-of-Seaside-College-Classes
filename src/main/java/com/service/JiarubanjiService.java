package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiarubanjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiarubanjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiarubanjiView;


/**
 * 加入班级
 *
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface JiarubanjiService extends IService<JiarubanjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiarubanjiVO> selectListVO(Wrapper<JiarubanjiEntity> wrapper);
   	
   	JiarubanjiVO selectVO(@Param("ew") Wrapper<JiarubanjiEntity> wrapper);
   	
   	List<JiarubanjiView> selectListView(Wrapper<JiarubanjiEntity> wrapper);
   	
   	JiarubanjiView selectView(@Param("ew") Wrapper<JiarubanjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiarubanjiEntity> wrapper);
   	
}

