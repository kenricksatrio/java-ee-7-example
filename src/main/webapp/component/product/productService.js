(function () {

    angular.module('app')
        .service('product.ProductService', Svc);

    Svc.$inject = ['$http'];
    function Svc($http) {

        var baseUrl = 'api/product';

        this.findAll = function() {
            return $http.get(baseUrl);
        };

        /**
         * @param product <object>
         * */
        this.save = function(product) {
            return $http.post(baseUrl, product);
        };

        this.update = function(product) {
            return $http.put(baseUrl + '/' + product.id, product);
        };

        this.delete = function (productId) {
          return $http.delete(baseUrl + '/' + productId);
        };

    }

})();