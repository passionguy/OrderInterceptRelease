'use strict';

/**
 * @ngdoc function
 * @name OrderInterceptAndReleaseApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the OrderInterceptAndReleaseApp
 */
angular.module('OrderInterceptAndReleaseApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });

function show_modal(elem_modal, elem_modal_content, content_html, elem_focus) {
  if(elem_focus) {
    elem_modal.on('hidden.bs.modal', function(e) {
      elem_focus.focus();
    });
  }
  elem_modal_content.html(content_html);
  elem_modal.modal("show");
}
