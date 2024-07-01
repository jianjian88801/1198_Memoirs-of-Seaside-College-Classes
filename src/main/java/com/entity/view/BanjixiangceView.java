package com.entity.view;

import com.entity.BanjixiangceEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 班级相册
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
@TableName("banjixiangce")
public class BanjixiangceView  extends BanjixiangceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BanjixiangceView(){
	}
 
 	public BanjixiangceView(BanjixiangceEntity banjixiangceEntity){
 	try {
			BeanUtils.copyProperties(this, banjixiangceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
