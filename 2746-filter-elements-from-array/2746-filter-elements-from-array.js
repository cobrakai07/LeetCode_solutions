/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let marr=[];
    for(let i=0;i<arr.length ;i++)
    {
        if(fn(arr[i],i))marr.push(arr[i]);
    }
    return marr;
};