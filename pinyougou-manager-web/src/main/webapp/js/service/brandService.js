app.service('brandService', function ($http) {
    //不分页查询
    this.findAll = function () {
        return $http.get('../brand/findAll.do');
    }
    //分页查询

    this.findPage = function (page, rows) {
        return $http.get('../brand/findPage.do?page=' + page + '&rows=' + rows);

    }


    //根据id查询

    this.findOne=function (id) {
        return $http.get('../brand/findOne.do?id='+id);
    }
    //添加或编辑
    this.save = function (entity) {
        var methodName = 'add';//方法名称
        if (entity.id != null) {//如果有ID
            methodName = 'update';//则执行修改方法
        }
        return $http.post('../brand/' + methodName + '.do', entity);

    }

    //删除
    this.delete = function (selectIds) {
        alert(selectIds);
        return $http.get('../brand/delete.do?ids=' + selectIds);
    }

    //查询
    this.search = function (page, rows,searchEntity) {
        return $http.post('../brand/search.do?page=' + page + "&rows=" + rows,
           searchEntity);
    }


    //下拉列表数据
    this.selectOptionList=function() {

        return $http.get('../brand/selectOptionList.do');
    }
});
