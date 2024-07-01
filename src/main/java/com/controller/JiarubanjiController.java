package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiarubanjiEntity;
import com.entity.view.JiarubanjiView;

import com.service.JiarubanjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 加入班级
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
@RestController
@RequestMapping("/jiarubanji")
public class JiarubanjiController {
    @Autowired
    private JiarubanjiService jiarubanjiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiarubanjiEntity jiarubanji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("banwei")) {
			jiarubanji.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			jiarubanji.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiarubanjiEntity> ew = new EntityWrapper<JiarubanjiEntity>();
		PageUtils page = jiarubanjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiarubanji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiarubanjiEntity jiarubanji, 
		HttpServletRequest request){
        EntityWrapper<JiarubanjiEntity> ew = new EntityWrapper<JiarubanjiEntity>();
		PageUtils page = jiarubanjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiarubanji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiarubanjiEntity jiarubanji){
       	EntityWrapper<JiarubanjiEntity> ew = new EntityWrapper<JiarubanjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiarubanji, "jiarubanji")); 
        return R.ok().put("data", jiarubanjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiarubanjiEntity jiarubanji){
        EntityWrapper< JiarubanjiEntity> ew = new EntityWrapper< JiarubanjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiarubanji, "jiarubanji")); 
		JiarubanjiView jiarubanjiView =  jiarubanjiService.selectView(ew);
		return R.ok("查询加入班级成功").put("data", jiarubanjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiarubanjiEntity jiarubanji = jiarubanjiService.selectById(id);
        return R.ok().put("data", jiarubanji);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiarubanjiEntity jiarubanji = jiarubanjiService.selectById(id);
        return R.ok().put("data", jiarubanji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiarubanjiEntity jiarubanji, HttpServletRequest request){
    	jiarubanji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiarubanji);
        jiarubanjiService.insert(jiarubanji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiarubanjiEntity jiarubanji, HttpServletRequest request){
    	jiarubanji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiarubanji);
        jiarubanjiService.insert(jiarubanji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiarubanjiEntity jiarubanji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiarubanji);
        jiarubanjiService.updateById(jiarubanji);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiarubanjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiarubanjiEntity> wrapper = new EntityWrapper<JiarubanjiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("banwei")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = jiarubanjiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
