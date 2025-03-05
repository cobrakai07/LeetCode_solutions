function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    let marr:number[]=[];
    for(let i=0; i<arr.length;i++)
        marr.push(fn(arr[i],i));
    return marr;
};