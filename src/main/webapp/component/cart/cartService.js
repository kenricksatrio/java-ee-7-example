(function () {

    angular.module('app').service('cart.CartService', Svc);

    Svc.$inject = ['$http'];
    function Svc($http) {

        var baseUrl = 'api/cart';

        this.findAll = function () {
            return $http.get(baseUrl);
        };

        /**
         * @param {int} productId
         * @param {int} qty
         * */
        this.addToCart = function (productId, qty) {
            return $http.post(baseUrl + '/' + productId, qty);
        };

        /**
         * @param {int} productId
         * @param {int} qty
         * */
        this.update = function (productId, qty) {
            return $http.put(baseUrl + '/' + productId, qty);
        };

        /**
         * @param {int} productId
         * */
        this.remove = function (productId) {
            return $http.delete(baseUrl + '/' + productId);
        };

        this.clear = function () {
            return $http.delete(baseUrl);
        }

    }

})();