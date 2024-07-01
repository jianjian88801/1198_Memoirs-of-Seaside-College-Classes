
var projectName = '班级回忆录系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.html'
},

{
	name: '我的收藏',
	url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '班级信息',
	url: './pages/banjixinxi/list.html'
}, 
{
	name: '新闻信息',
	url: './pages/xinwenxinxi/list.html'
}, 
{
	name: '班级相册',
	url: './pages/banjixiangce/list.html'
}, 
{
	name: '活动信息',
	url: './pages/huodongxinxi/list.html'
}, 
{
	name: '捐赠信息',
	url: './pages/juanzengxinxi/list.html'
}, 

{
	name: '论坛',
	url: './pages/forum/list.html'
}, 
]

var adminurl =  "http://localhost:8080/springboot5r64w/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"班委","menuJump":"列表","tableName":"banwei"}],"menu":"班委管理"},{"child":[{"buttons":["新增","查看","修改","删除","审核"],"menu":"班级信息","menuJump":"列表","tableName":"banjixinxi"}],"menu":"班级信息管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"加入班级","menuJump":"列表","tableName":"jiarubanji"}],"menu":"加入班级管理"},{"child":[{"buttons":["查看","修改","删除","查看评论"],"menu":"新闻信息","menuJump":"列表","tableName":"xinwenxinxi"}],"menu":"新闻信息管理"},{"child":[{"buttons":["查看","修改","删除","查看评论"],"menu":"班级相册","menuJump":"列表","tableName":"banjixiangce"}],"menu":"班级相册管理"},{"child":[{"buttons":["查看","修改","删除","查看评论"],"menu":"活动信息","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"捐赠信息","menuJump":"列表","tableName":"juanzengxinxi"}],"menu":"捐赠信息管理"},{"child":[{"buttons":["查看","删除"],"menu":"论坛管理","tableName":"forum"}],"menu":"论坛管理"},{"child":[{"buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看","加入"],"menu":"班级信息列表","menuJump":"列表","tableName":"banjixinxi"}],"menu":"班级信息模块"},{"child":[{"buttons":["查看"],"menu":"新闻信息列表","menuJump":"列表","tableName":"xinwenxinxi"}],"menu":"新闻信息模块"},{"child":[{"buttons":["查看"],"menu":"班级相册列表","menuJump":"列表","tableName":"banjixiangce"}],"menu":"班级相册模块"},{"child":[{"buttons":["查看"],"menu":"活动信息列表","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息模块"},{"child":[{"buttons":["查看"],"menu":"捐赠信息列表","menuJump":"列表","tableName":"juanzengxinxi"}],"menu":"捐赠信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看","删除"],"menu":"加入班级","menuJump":"列表","tableName":"jiarubanji"}],"menu":"加入班级管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"新闻信息","menuJump":"列表","tableName":"xinwenxinxi"}],"menu":"新闻信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"班级相册","menuJump":"列表","tableName":"banjixiangce"}],"menu":"班级相册管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"活动信息","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"捐赠信息","menuJump":"列表","tableName":"juanzengxinxi"}],"menu":"捐赠信息管理"},{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"buttons":["查看","加入"],"menu":"班级信息列表","menuJump":"列表","tableName":"banjixinxi"}],"menu":"班级信息模块"},{"child":[{"buttons":["查看"],"menu":"新闻信息列表","menuJump":"列表","tableName":"xinwenxinxi"}],"menu":"新闻信息模块"},{"child":[{"buttons":["查看"],"menu":"班级相册列表","menuJump":"列表","tableName":"banjixiangce"}],"menu":"班级相册模块"},{"child":[{"buttons":["查看"],"menu":"活动信息列表","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息模块"},{"child":[{"buttons":["查看"],"menu":"捐赠信息列表","menuJump":"列表","tableName":"juanzengxinxi"}],"menu":"捐赠信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"班级信息","menuJump":"列表","tableName":"banjixinxi"}],"menu":"班级信息管理"},{"child":[{"buttons":["查看","删除","审核"],"menu":"加入班级","menuJump":"列表","tableName":"jiarubanji"}],"menu":"加入班级管理"},{"child":[{"buttons":["查看","审核","删除","查看评论"],"menu":"新闻信息","menuJump":"列表","tableName":"xinwenxinxi"}],"menu":"新闻信息管理"},{"child":[{"buttons":["查看","审核","删除","查看评论"],"menu":"班级相册","menuJump":"列表","tableName":"banjixiangce"}],"menu":"班级相册管理"},{"child":[{"buttons":["查看","审核","删除","查看评论"],"menu":"活动信息","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息管理"},{"child":[{"buttons":["查看","审核","删除"],"menu":"捐赠信息","menuJump":"列表","tableName":"juanzengxinxi"}],"menu":"捐赠信息管理"}],"frontMenu":[{"child":[{"buttons":["查看","加入"],"menu":"班级信息列表","menuJump":"列表","tableName":"banjixinxi"}],"menu":"班级信息模块"},{"child":[{"buttons":["查看"],"menu":"新闻信息列表","menuJump":"列表","tableName":"xinwenxinxi"}],"menu":"新闻信息模块"},{"child":[{"buttons":["查看"],"menu":"班级相册列表","menuJump":"列表","tableName":"banjixiangce"}],"menu":"班级相册模块"},{"child":[{"buttons":["查看"],"menu":"活动信息列表","menuJump":"列表","tableName":"huodongxinxi"}],"menu":"活动信息模块"},{"child":[{"buttons":["查看"],"menu":"捐赠信息列表","menuJump":"列表","tableName":"juanzengxinxi"}],"menu":"捐赠信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"是","roleName":"班委","tableName":"banwei"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
