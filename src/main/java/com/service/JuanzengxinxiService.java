package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JuanzengxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JuanzengxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JuanzengxinxiView;


/**
 * 捐赠信息
 *
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
public interface JuanzengxinxiService extends IService<JuanzengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JuanzengxinxiVO> selectListVO(Wrapper<JuanzengxinxiEntity> wrapper);
   	
   	JuanzengxinxiVO selectVO(@Param("ew") Wrapper<JuanzengxinxiEntity> wrapper);
   	
   	List<JuanzengxinxiView> selectListView(Wrapper<JuanzengxinxiEntity> wrapper);
   	
   	JuanzengxinxiView selectView(@Param("ew") Wrapper<JuanzengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JuanzengxinxiEntity> wrapper);
   	
}

