'use strict';

var app = angular.module('fescApp')
	.controller('ProductsCtrl', [ '$scope', '$sce', '$store', 'flash', 'ProductService', function ($scope, $sce, $store, flash, productService) {

    // Create newProduct
    $scope.newProduct = {};

    $scope.loadProducts = function(){
        productService.get(null, null, function(response){
          $scope.products = response.products;
        }, function(response) {
          showErrorMessages('Erro ao carregar produtos. ', response);
        });
    };

    $scope.saveProduct = function() {
      if($scope.newProduct.id) {
        $scope.editProduct();
      } else {
        $scope.addProduct();
      }
    }

    $scope.addProduct = function() {

      productService.post(null, {
        code: $scope.newProduct.code,
        description: $scope.newProduct.description,
        productType: $scope.newProduct.type,
        providerValue: $scope.newProduct.valueProvider,
        quantity: $scope.newProduct.quantity
      }, function(response){
        flash.success = $scope.newProduct.description + ' foi criado com sucesso.';

        // clean scope from newProduct
        $scope.newProduct = {};

        $scope.loadProducts();
      }, function(response){
        showErrorMessages('Erro ao criar produto. ', response);
      });
    }

    var showErrorMessages = function(messageDefault, response) {
        console.log(response);

        var message = messageDefault;

        if(response.status == 401) {
          message += "Não autorizado";
        } else if(response.data && response.data.message) {
          message += response.data.message;
        } 


        if(response.data && response.data.errors && response.data.errors.length > 0) {
          response.data.errors.forEach(function(error) {
            message += "<br>" + error;
          });
        }

        flash.error = $sce.trustAsHtml(message);
    }

    $scope.validateCode = function() {
      $scope.newProduct.code = $scope.newProduct.code.replace(/[^0-9]/g, "");
    }

    $scope.editProduct = function() {     
      productService.put(null, {
        description: $scope.newProduct.description,
        type: $scope.newProduct.type,
        valueProvider: $scope.newProduct.valueProvider,
        quantity: $scope.newProduct.quantity
      }, function(response){
        flash.success = $scope.newProduct.description + ' foi atualizado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newProduct
        $scope.newProduct = {};

        $scope.loadProducts();
      }, function(response){
        showErrorMessages('Erro ao editar produto. ', response);
      });
    }



    $scope.selectProductToRemove = function(id) {
      $scope.selectedProductToRemove = id;
    }

    $scope.removeProduct = function() {

      productService.delete({id: $scope.selectedProductToRemove}, null, function(response){
        flash.success = 'Removido com sucesso.';
        $scope.loadProducts();
      }, function(response){
        showErrorMessages('Erro ao excluír produto. ', response);
      });
    }

    $scope.loadProducts();

  	/*
  	 * Edit product by id 
  	 */
  	$scope.edit = function(id) {
  		
    	//search products with given id
        for(var i in $scope.products) {
            if($scope.products[i].id == id) {
                //copy of originial object to scope object
                $scope.newProduct = angular.copy($scope.produto[i]);
            }
        }
    };
}]);