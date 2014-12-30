'use strict';

/**
 * @ngdoc function
 * @name OrderInterceptAndReleaseApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the OrderInterceptAndReleaseApp
 */
angular.module('OrderInterceptAndReleaseApp')
	.controller('LoginCtrl', 'Auth', function($scope, $location, Auth) {
		$scope.userInfo = null;
		$scope.login = function() {
			authenticationSvc.login($scope.userName, $scope.password)
				.then(function(result) {
					$scope.userInfo = result;
					$location.path("/");
				}, function(error) {
					$window.alert("Invalid credentials");
					console.log(error);
				});
		};

		$scope.cancel = function() {
			$scope.userName = "";
			$scope.password = "";
		};
	});