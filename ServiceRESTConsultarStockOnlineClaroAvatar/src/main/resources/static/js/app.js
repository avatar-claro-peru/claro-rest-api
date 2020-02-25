'use strict';
var context = '';

document.title = 'apirest';

var apiStockonline = '/api/stockonline/';

var hostname = window.location.origin + context;

var app = angular.module('apirest', [ 'ui.bootstrap', 'ngCookies' ]);
