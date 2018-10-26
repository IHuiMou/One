app.controller('LoginAController', function ($scope, $controller, loginService) {
    $controller('baseController',{$scope:$scope});//继承

    $scope.loginByName = function () {

        loginService.loginByName().success(function (data) {
            $scope.logina = data;
        })
    }

})