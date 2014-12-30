'use strict';

/**
 * @ngdoc function
 * @name OrderInterceptAndReleaseApp.controller:RuleFieldCtrl
 * @description
 * # RuleFieldCtrl
 * Controller of the OrderInterceptAndReleaseApp
 */
angular.module('OrderInterceptAndReleaseApp')
  .controller('QueryBuilderCtrl', function($scope, $location, $filter, $routeParams, Restangular) {
    $scope.id = $routeParams.id;

    var ruleFields = [];
    var baseRuleField = Restangular.all('rulefield');
    var baseRule = Restangular.all('rule');
    baseRuleField.getList().then(function(RuleFields) {
      ruleFields = Restangular.copy(RuleFields);
      var field_filters = [];
      for (var i = ruleFields.length - 1; i >= 0; i--) {
        var filter = {};
        var field = ruleFields[i];
        filter.id = field.fieldTable + '.' + field.fieldName;
        filter.label = field.fieldDesc;
        if (field.fieldType === 'datetime') {
          filter.type = 'datetime';
          filter.validation = {
            format: 'mm/dd/yyyy hh:mm:ss'
          };
          filter.plugin = 'datetimepicker';
          filter.plugin_config = {
            format: 'mm/dd/yyyy hh:mm:ss',
            todayBtn: 'linked',
            todayHighlight: true,
            autoclose: true
          };
        }
        if (field.fieldType === 'number') {
          filter.type = 'integer';
        }
        if (field.fieldType === 'enums') {
          filter.type = 'integer';
          filter.input = 'select';
          filter.multiple = true;
          filter.operators = ['in', 'not_in', 'is_null', 'is_not_null'];
          filter.values = field.enumValues.split('\n') || [];
        }
        field_filters.push(filter);
      };
      $('#builder').queryBuilder({
        sortable: true,
        filters: field_filters
      });
    });
    if ($scope.id) {
      Restangular.one('rule', $scope.id).get().then(function(rule) {
        $scope.rule = rule;
        $scope.rule.effectTimeStart = moment($scope.rule.effectTimeStart)._d;
        $scope.rule.effectTimeEnd = moment($scope.rule.effectTimeEnd)._d;
        $('#effectTimeStart').datetimepicker('setDate', $scope.rule.effectTimeStart);
        $('#effectTimeEnd').datetimepicker('setDate', $scope.rule.effectTimeEnd);
        $('#builder').queryBuilder('setRules', JSON.parse($scope.rule.ruleJson));
      });
    } else {
      $scope.rule = {};
      $scope.rule.ruleType = $routeParams.ruleType;
    }
    $('#effectTimeStart').datetimepicker({
      timeFormat: 'HH:mm:ss'
    });
    $('#effectTimeEnd').datetimepicker({
      timeFormat: 'HH:mm:ss'
    });


    // reset builder
    $('.reset').on('click', function() {
      $('#builder').queryBuilder('reset');
      $('#result').empty().addClass('hide');
    });

    $('.save-rule').on('click', function() {
      $scope.rule.effectTimeStart = moment($scope.rule.effectTimeStart)._d;
      $scope.rule.effectTimeEnd = moment($scope.rule.effectTimeEnd)._d;
      $scope.rule.ruleJson = JSON.stringify($('#builder').queryBuilder('getRules'), null, 2);
      var res = $('#builder').queryBuilder('getSQL', false);
      $scope.rule.ruleSql = res.sql;
      // rule.params = JSON.stringify(res.params, null, 2);
      baseRule.post($scope.rule);
      $location.path('/interceptRule/');
    });


  });