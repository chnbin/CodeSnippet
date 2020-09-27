function minOperations(logs: string[]): number {
    let res: number = 0;
    
    for (let log of logs) {
        if (log.indexOf("..") != -1 && res != 0) {
            res--;
        } else if (log.indexOf(".") != -1) {
            continue;
        } else {
            res++;
        }
    }
    
    
    return res;
};
