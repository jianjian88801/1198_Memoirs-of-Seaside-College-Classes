package com.entity.view;

import com.entity.DiscussbanjixiangceEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 班级相册评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
@TableName("discussbanjixiangce")
public class DiscussbanjixiangceView  extends DiscussbanjixiangceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussbanjixiangceView(){
	}
 
 	public DiscussbanjixiangceView(DiscussbanjixiangceEntity discussbanjixiangceEntity){
 	try {
			BeanUtils.copyProperties(this, discussbanjixiangceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
