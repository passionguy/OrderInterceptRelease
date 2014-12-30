'use strict';

/**
 * @ngdoc function
 * @name OrderInterceptAndReleaseApp.controller:RuleFieldCtrl
 * @description
 * # RuleFieldCtrl
 * Controller of the OrderInterceptAndReleaseApp
 */
angular.module('OrderInterceptAndReleaseApp')
    .controller('RuleFieldCtrl', function($scope, Restangular) {
        var baseRuleField = Restangular.all('rulefield');
        baseRuleField.getList().then(function(RuleFields) {
            $scope.fields = RuleFields;
        });
        $scope.tables = [{
            name: '订单',
            value: 'orders'
        }, {
            name: '订单明细',
            value: 'order_items'
        }];
        $scope.type = {};
        $scope.field_types = [{
            name: '文本',
            value: 'text'
        }, {
            name: '数字',
            value: 'number'
        }, {
            name: '日期时间',
            value: 'datetime'
        }, {
            name: '枚举值',
            value: 'enums'
        }];
        $scope.save = function(field) {
            $scope.fields.push(field);
            baseRuleField.post(field);
            $scope.field = '';
        };
        $scope.update = function(field) {
            $scope.field = field;
        };
        $scope.remove = function(index) {
            $scope.fields.splice(index, 1);
        };
        $scope.$watch('fields', function() {
            //localStorageService.add('fields', $scope.fields);
        }, true);

        // $scope.filterOptions = {
        //   filterText: "",
        //   useExternalFilter: true
        // };
        // $scope.totalServerItems = 0;
        // $scope.pagingOptions = {
        //   pageSizes: [1, 2, 4],
        //   pageSize: 15,
        //   currentPage: 1
        // };
        // $scope.setPagingData = function(data, page, pageSize) {
        //   //var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
        //   $scope.fields = data;
        //   $scope.totalServerItems = data.length;
        //   if (!$scope.$$phase) {
        //     $scope.$apply();
        //   }
        // };
        // $scope.getPagedDataAsync = function(pageSize, page, searchText) {
        //   setTimeout(function() {
        //     var data;
        //     if (searchText) {
        //       var ft = searchText.toLowerCase();
        //       $http.get('jsonFiles/largeLoad.json').success(function(largeLoad) {
        //         data = largeLoad.filter(function(item) {
        //           return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
        //         });
        //         $scope.setPagingData(data, page, pageSize);
        //       });
        //     } else {
        //       baseRuleField.getList({
        //         page: page,
        //         pageSize: pageSize
        //       }).then(function(RuleFields) {
        //         $scope.setPagingData(RuleFields, page, pageSize);
        //       });
        //     }
        //   }, 100);
        // };
        // $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);

        // $scope.$watch('pagingOptions', function(newVal, oldVal) {
        //   if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
        //     $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        //   }
        // }, true);
        // $scope.$watch('filterOptions', function(newVal, oldVal) {
        //   if (newVal !== oldVal) {
        //     $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        //   }
        // }, true);
        // $scope.myOptions = {
        //   data: 'fields',
        //   columnDefs: [{
        //     field: 'fieldTable',
        //     displayName: '表名'
        //   }, {
        //     field: 'fieldName',
        //     displayName: '字段名'
        //   }, {
        //     field: 'fieldDesc',
        //     displayName: '字段描述'
        //   }, {
        //     field: 'fieldType',
        //     displayName: '字段类型'
        //   }],
        //   enablePaging: true,
        //   showFooter: true,
        //   totalServerItems: 'totalServerItems',
        //   pagingOptions: $scope.pagingOptions,
        //   filterOptions: $scope.filterOptions
        // };
    }).filter('tableName', function() {
        var tables = [{
            name: '订单',
            value: 'orders'
        }, {
            name: '订单明细',
            value: 'order_items'
        }];

        var tableNameFilter = function(input) {
            for (var i = 0; i < tables.length; i++) {
                if (input === tables[i].value) {
                    return tables[i].name;
                }
            }
        };
        return tableNameFilter;
    }).filter('fieldType', function() {
        var field_types = [{
            name: '文本',
            value: 'text'
        }, {
            name: '数字',
            value: 'number'
        }, {
            name: '日期时间',
            value: 'datetime'
        }, {
            name: '枚举值',
            value: 'enums'
        }];
        var fieldTypeFilter = function(input) {
            for (var i = 0; i < field_types.length; i++) {
                if (input === field_types[i].value) {
                    return field_types[i].name;
                }
            }
        };
        return fieldTypeFilter;
    });