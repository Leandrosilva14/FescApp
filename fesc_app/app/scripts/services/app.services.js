'use strict';

var appServices = angular.module("AppServices", ['ngResource', 'ngRoute']);
var domainURL = "http://localhost:5000/api/v1";

appServices.run(['$http', function(http) {
	http.defaults.headers.common['Authorization'] = 'Basic YWRtaW46MTIzNDU2';
}]);


// Products
appServices.factory('ProductService', ['$resource', function(resource) {
	return resource(domainURL + '/product', null, {
		get: { method:'GET'},
		post: { method:'POST'},
		put: {method: 'PUT'},
		delete: {method: 'DELETE'}
	});
}]);

appServices.factory('ProductMovementService', ['$resource', function(resource) {
	return resource(domainURL + '/product-movement', null, {
		post: { method:'POST'}
	});
}]);


appServices.factory('ListProductMovementByTypeService', ['$resource', function(resource) {
	return resource(domainURL + '/product-movement/list-by-product-type', null, {
		get: { method:'GET'}
	});
}]);

appServices.factory('ListProductMovementByProductService', ['$resource', function(resource) {
	return resource(domainURL + '/product-movement/list-by-product', null, {
		get: { method:'GET'}
	});
}]);