(function() {

    angular.module('app')
        .controller('product.ProductCtrl', Ctrl);

    Ctrl.$inject = ['$scope', 'product.ProductService', 'product.ProductCategoryService', 'cart.CartService'];
    function Ctrl($scope, ProductService, ProductCategoryService, CartService) {

        $scope.productList = [];
        $scope.categoryList = [];
        $scope.newProduct = {};

        $scope.insertProduct = function () {
            ProductService.save($scope.newProduct)
                .success(function(product) {
                    $scope.productList.push(product);
                })
                .error(function (err) {

                });
        };

        $scope.delete = function(product) {

            var deletedProductId = product.id;

            ProductService.delete(deletedProductId )
                .success(function () {

                    $scope.productList.some(function(product, index) {
                        if(product.id == deletedProductId) {
                            $scope.productList.splice(index, 1);
                            return true;
                        }
                    });
                });
        };

        $scope.addToCart = function (product) {
            CartService.addToCart(product.id, 1);
        };

        ProductService.findAll()
            .success(function (productList) {
                $scope.productList = productList;
            });

        ProductCategoryService.findAll()
            .success(function(categoryList) {
                $scope.categoryList = categoryList;
            });

    }
})();