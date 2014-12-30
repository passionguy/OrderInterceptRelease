'use strict';

/**
 * @ngdoc function
 * @name OrderInterceptAndReleaseApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the OrderInterceptAndReleaseApp
 */
angular.module('OrderInterceptAndReleaseApp')
	.controller('InterceptRuleCtrl', function($scope, $location, Restangular) {
		var baseRule = Restangular.all('rule');
		$scope.interceptRules = [];
		$scope.releaseRules = [];
		baseRule.getList().then(function(Rules) {
			for (var i = 0; i < Rules.length; i++) {
				if (Rules[i].ruleType === 1) {
					$scope.interceptRules.push(Rules[i]);
				} else if (Rules[i].ruleType === 2) {
					$scope.releaseRules.push(Rules[i]);
				}
			}
		});

		$scope.edit = function(rule) {
			$location.path('/queryBuilder/' + rule.id);
		};
		$scope.check = function(rule) {
			bootbox.dialog({
				message: "审核该条规则",
				title: "审核",
				buttons: {
					PAAS: {
						label: "审核通过",
						className: "btn-primary",
						callback: function() {
							baseRule.one("check", rule.id).get({
								flag: true
							});
						}
					},
					NOTPAAS: {
						label: "审核不通过",
						className: "btn-danger",
						callback: function() {
							baseRule.one("check", rule.id).get({
								flag: false
							});
						}
					},
					Cancel: {
						label: "返回",
						className: "btn-default",
						callback: function() {
							alert("Cancel");
						}
					}

				}
			});
		};
	}).filter('checkStatus', function() {
		var checkStatusFilter = function(input) {
			if (input === 1) {
				return "审核通过";
			} else if (input === 2) {
				return "审核不通过";
			} else {
				return "未审核";
			}
		};
		return checkStatusFilter;
	});