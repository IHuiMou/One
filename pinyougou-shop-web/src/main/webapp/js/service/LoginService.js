app.service('loginService',function ($http) {

    this.loginByName=function () {

        return $http.get('../seller/loginByName.do');
    }
})