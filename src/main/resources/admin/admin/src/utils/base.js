const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot5r64w/",
            name: "springboot5r64w",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot5r64w/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "班级回忆录系统"
        } 
    }
}
export default base
