(function () {

    angular.module('app', ['ngRoute'])
        .config(config)
        .controller('MainCtrl', Ctrl);

    config.$inject = [];
    function config() {

    }

    Ctrl.$inject = ['$scope'];
    function Ctrl() {

    }

})();