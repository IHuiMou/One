app.controller('brandController', function ($scope,$controller, brandService) {
$controller('baseController',{$scope:$scope})

    //读取列表数据绑定到表单中
    //不分页查询
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }

    //分页
    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    //根据id查询
    $scope.findOne = function (id) {
        alert(id);
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }


    //添加和编辑
    $scope.save = function () {
        brandService.save($scope.entity)
            .success(
                function (response) {
                    if (response.success) {
                        //重新查询
                        $scope.reloadList();//重新加载
                    } else {
                        alert(response.message);
                    }
                })
    }

    //删除
    $scope.delete = function () {
        alert($scope.selectIds);
        brandService.delete($scope.selectIds).success(function (data) {
            if (data.success) {
                $scope.reloadList();//重新加载
            }

        })
    }

    //条件查询
    $scope.search = function (page, rows) {

        brandService.search(page, rows, $scope.searchEntity).success(function (response) {
            $scope.paginationConf.totalItems = response.total;//总记录数
            $scope.list = response.rows;//给列表变量赋值

        })
    }

});