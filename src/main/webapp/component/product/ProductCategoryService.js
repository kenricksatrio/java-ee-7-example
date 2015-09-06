(function () {

    angular.module('app')
        .service('product.ProductCategoryService', Svc);

    Svc.$inject = ['$http'];
    function Svc($http) {

        var baseUrl = 'api/product-category';

        this.findAll = function() {
            return $http.get(baseUrl);
        }

    }

})();