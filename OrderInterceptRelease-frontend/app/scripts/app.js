'use strict';

/**
 * @ngdoc overview
 * @name OrderInterceptAndReleaseApp
 * @description
 * # OrderInterceptAndReleaseApp
 *
 * Main module of the application.
 */
var app = angular
  .module('OrderInterceptAndReleaseApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'LocalStorageModule',
    'restangular',
    'ngGrid'
  ]);

app.config(['localStorageServiceProvider',
  function(localStorageServiceProvider) {
    localStorageServiceProvider.setPrefix('ls');
  }
]);
app.config(function($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'views/main.html',
      controller: 'MainCtrl'
    })
    .when('/about', {
      templateUrl: 'views/about.html',
      controller: 'AboutCtrl'
    })
    .when('/interceptRule', {
      templateUrl: 'views/interceptRule.html',
      controller: 'InterceptRuleCtrl'
    })
    .when('/ruleField', {
      templateUrl: 'views/ruleField.html',
      controller: 'RuleFieldCtrl'
    })
    .when('/queryBuilder', {
      templateUrl: 'views/queryBuilder.html',
      controller: 'QueryBuilderCtrl'
    })
    .when('/queryBuilder/:id', {
      templateUrl: 'views/queryBuilder.html',
      controller: 'QueryBuilderCtrl'
    })
    .when('/login', {
      templateUrl: 'views/login.html',
      controller: 'LoginCtrl'
    })
    .otherwise({
      redirectTo: '/'
    });
});
app.config(function(RestangularProvider) {
  RestangularProvider.setBaseUrl('http://192.168.99.66:8083/services');
});

// app.run(["$rootScope", "$location"
//   function($rootScope, $location, $q, authenticationSvc) {
//     $rootScope.$on('$routeChangeStart', function(event) {
//       var userInfo = authenticationSvc.getUserInfo();
//       if (!userInfo) {
//         console.log('DENY');
//         event.preventDefault();
//         $location.path('/login');
//       } else {
//         console.log('ALLOW');
//         $location.path('/home');
//       }
//     });
//     $rootScope.$on("$routeChangeSuccess", function(userInfo) {
//       console.log(userInfo);
//     });

//     $rootScope.$on("$routeChangeError", function(event, current, previous, eventObj) {
//       if (eventObj.authenticated === false) {
//         $location.path("/login");
//       }
//     });
//   }
// ]);

// app.factory("authenticationSvc", ["$http", "$q", "$window",
//   function($http, $q, $window) {
//     var userInfo;

//     function login(userName, password) {
//       var deferred = $q.defer();

//       $http.post("/api/login", {
//         userName: userName,
//         password: password
//       })
//         .then(function(result) {
//           userInfo = {
//             accessToken: result.data.access_token,
//             userName: result.data.userName
//           };
//           $window.sessionStorage["userInfo"] = JSON.stringify(userInfo);
//           deferred.resolve(userInfo);
//         }, function(error) {
//           deferred.reject(error);
//         });

//       return deferred.promise;
//     }

//     function logout() {
//       var deferred = $q.defer();

//       $http({
//         method: "POST",
//         url: "/api/logout",
//         headers: {
//           "access_token": userInfo.accessToken
//         }
//       }).then(function(result) {
//         userInfo = null;
//         $window.sessionStorage["userInfo"] = null;
//         deferred.resolve(result);
//       }, function(error) {
//         deferred.reject(error);
//       });

//       return deferred.promise;
//     }

//     function getUserInfo() {
//       return userInfo;
//     }

//     function init() {
//       if ($window.sessionStorage["userInfo"]) {
//         userInfo = JSON.parse($window.sessionStorage["userInfo"]);
//       }
//     }
//     init();

//     return {
//       login: login,
//       logout: logout,
//       getUserInfo: getUserInfo
//     };
//   }
// ]);

// app.factory('Auth', function() {
//   var user;

//   return {
//     setUser: function(aUser) {
//       user = aUser;
//     },
//     isLoggedIn: function() {
//       return (user) ? user : false;
//     }
//   }
// });
// app.run(['$rootScope', '$location', 'Auth',
//   function($rootScope, $location, Auth) {
//     $rootScope.$on('$routeChangeStart', function(event) {

//       if (!Auth.isLoggedIn()) {
//         $location.path('/login');
//         console.log('DENY');
//         event.preventDefault();

//       } else {
//         console.log('ALLOW');
//         $location.path('/');
//       }
//     });
//   }
// ]);