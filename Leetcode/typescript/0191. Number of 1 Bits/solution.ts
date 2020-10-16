function hammingWeight(n: number): number {
  let res: number = 0;
  
  for (let i = 0; i < 32; i++) {
      if ((n & 1) === 1) {
          res++;
      }
      n = n >> 1;
  }
  
  return res;
};
