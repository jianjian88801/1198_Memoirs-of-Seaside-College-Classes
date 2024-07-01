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

import com.entity.JuanzengxinxiEntity;
import com.entity.view.JuanzengxinxiView;

import com.service.JuanzengxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 捐赠信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
@RestController
@RequestMapping("/juanzengxinxi")
public class JuanzengxinxiController {
    @Autowired
    private JuanzengxinxiService juanzengxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JuanzengxinxiEntity juanzengxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("banwei")) {
			juanzengxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			juanzengxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JuanzengxinxiEntity> ew = new EntityWrapper<JuanzengxinxiEntity>();
		PageUtils page = juanzengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, juanzengxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JuanzengxinxiEntity juanzengxinxi, 
		HttpServletRequest request){
        EntityWrapper<JuanzengxinxiEntity> ew = new EntityWrapper<JuanzengxinxiEntity>();
		PageUtils page = juanzengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, juanzengxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JuanzengxinxiEntity juanzengxinxi){
       	EntityWrapper<JuanzengxinxiEntity> ew = new EntityWrapper<JuanzengxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( juanzengxinxi, "juanzengxinxi")); 
        return R.ok().put("data", juanzengxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JuanzengxinxiEntity juanzengxinxi){
        EntityWrapper< JuanzengxinxiEntity> ew = new EntityWrapper< JuanzengxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( juanzengxinxi, "juanzengxinxi")); 
		JuanzengxinxiView juanzengxinxiView =  juanzengxinxiService.selectView(ew);
		return R.ok("查询捐赠信息成功").put("data", juanzengxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JuanzengxinxiEntity juanzengxinxi = juanzengxinxiService.selectById(id);
        return R.ok().put("data", juanzengxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JuanzengxinxiEntity juanzengxinxi = juanzengxinxiService.selectById(id);
        return R.ok().put("data", juanzengxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JuanzengxinxiEntity juanzengxinxi, HttpServletRequest request){
    	juanzengxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(juanzengxinxi);
        juanzengxinxiService.insert(juanzengxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JuanzengxinxiEntity juanzengxinxi, HttpServletRequest request){
    	juanzengxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(juanzengxinxi);
        juanzengxinxiService.insert(juanzengxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JuanzengxinxiEntity juanzengxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(juanzengxinxi);
        juanzengxinxiService.updateById(juanzengxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        juanzengxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JuanzengxinxiEntity> wrapper = new EntityWrapper<JuanzengxinxiEntity>();
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

		int count = juanzengxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
