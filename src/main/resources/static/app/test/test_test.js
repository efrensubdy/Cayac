'use strict';

describe('myApp.test module', function() {

  beforeEach(module('myApp.test'));

  describe('test controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var view1Ctrl = $controller('testCtrl');
      expect(view1Ctrl).toBeDefined();
    }));

  });
});