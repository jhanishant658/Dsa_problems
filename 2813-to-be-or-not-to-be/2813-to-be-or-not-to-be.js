/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
   return { toBe:function(val1){
       if(val1!==val) throw new Error("Not Equal");
       return true ;
    } , 
      notToBe : function(val1){
        if(val1===val)throw new Error("Equal");
        return true ; 
    }}
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */