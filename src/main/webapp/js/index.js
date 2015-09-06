(function () {

    angular.module('app', ['ngRoute', 'ngMessages'])
        .config(config)
        .controller('MainCtrl', Ctrl);

    config.$inject = ['$routeProvider'];
    function config($routeProvider) {

        menuList.forEach(function (menu) {
            $routeProvider.when(menu.url, menu);
        });

    }

    Ctrl.$inject = ['$scope'];
    function Ctrl($scope) {
        $scope.menuList = menuList;
    }

})();