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

import com.entity.BanjixiangceEntity;
import com.entity.view.BanjixiangceView;

import com.service.BanjixiangceService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 班级相册
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-09 11:37:10
 */
@RestController
@RequestMapping("/banjixiangce")
public class BanjixiangceController {
    @Autowired
    private BanjixiangceService banjixiangceService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BanjixiangceEntity banjixiangce,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("banwei")) {
			banjixiangce.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			banjixiangce.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BanjixiangceEntity> ew = new EntityWrapper<BanjixiangceEntity>();
		PageUtils page = banjixiangceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banjixiangce), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BanjixiangceEntity banjixiangce, 
		HttpServletRequest request){
        EntityWrapper<BanjixiangceEntity> ew = new EntityWrapper<BanjixiangceEntity>();
		PageUtils page = banjixiangceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banjixiangce), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BanjixiangceEntity banjixiangce){
       	EntityWrapper<BanjixiangceEntity> ew = new EntityWrapper<BanjixiangceEntity>();
      	ew.allEq(MPUtil.allEQMapPre( banjixiangce, "banjixiangce")); 
        return R.ok().put("data", banjixiangceService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BanjixiangceEntity banjixiangce){
        EntityWrapper< BanjixiangceEntity> ew = new EntityWrapper< BanjixiangceEntity>();
 		ew.allEq(MPUtil.allEQMapPre( banjixiangce, "banjixiangce")); 
		BanjixiangceView banjixiangceView =  banjixiangceService.selectView(ew);
		return R.ok("查询班级相册成功").put("data", banjixiangceView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BanjixiangceEntity banjixiangce = banjixiangceService.selectById(id);
        return R.ok().put("data", banjixiangce);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BanjixiangceEntity banjixiangce = banjixiangceService.selectById(id);
        return R.ok().put("data", banjixiangce);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        BanjixiangceEntity banjixiangce = banjixiangceService.selectById(id);
        if(type.equals("1")) {
        	banjixiangce.setThumbsupnum(banjixiangce.getThumbsupnum()+1);
        } else {
        	banjixiangce.setCrazilynum(banjixiangce.getCrazilynum()+1);
        }
        banjixiangceService.updateById(banjixiangce);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BanjixiangceEntity banjixiangce, HttpServletRequest request){
    	banjixiangce.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(banjixiangce);
        banjixiangceService.insert(banjixiangce);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BanjixiangceEntity banjixiangce, HttpServletRequest request){
    	banjixiangce.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(banjixiangce);
        banjixiangceService.insert(banjixiangce);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BanjixiangceEntity banjixiangce, HttpServletRequest request){
        //ValidatorUtils.validateEntity(banjixiangce);
        banjixiangceService.updateById(banjixiangce);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        banjixiangceService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<BanjixiangceEntity> wrapper = new EntityWrapper<BanjixiangceEntity>();
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

		int count = banjixiangceService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
