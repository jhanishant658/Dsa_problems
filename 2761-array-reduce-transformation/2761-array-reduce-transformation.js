/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
   let acc = init ;
    for(var i = 0 ;i<nums.length ;i++){
        acc=fn(acc , nums[i]);
    }
    return acc ; 
};