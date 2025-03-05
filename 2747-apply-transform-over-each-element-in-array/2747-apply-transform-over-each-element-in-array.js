/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let marr= [];
    for(let i=0; i<arr.length; i++)
        marr.push(fn(arr[i],i));
    return marr;
};