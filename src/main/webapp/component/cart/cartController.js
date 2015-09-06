(function() {

    angular.module('app').controller('cart.CartCtrl', Ctrl);

    Ctrl.$inject = ['$scope', 'cart.CartService'];
    function Ctrl($scope, CartService) {

        $scope.cartList = [];

        $scope.update = function(cart) {

            var productId = cart.productId;
            var qty = cart.qty;

            CartService.update(productId, qty)
                .success(function () {
                    console.log('success update cart');
                });
        };

        $scope.remove = function(cart) {

            var productId = cart.productId;

            CartService.remove(productId)
                .success(function() {
                    $scope.cartList.some(function(cart, index) {
                        if(cart.productId == productId) {
                            $scope.cartList.splice(index, 1);
                            return true;
                        }
                    });
                });
        };

        CartService.findAll()
            .success(function (cartList) {
                $scope.cartList = cartList;
            });

    }

})();