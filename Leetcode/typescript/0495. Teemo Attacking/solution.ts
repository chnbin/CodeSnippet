function findPoisonedDuration(timeSeries: number[], duration: number): number {
    if (timeSeries === undefined || timeSeries.length === 0) {
        return 0;
    }

    let res: number = duration;
    
    for (let i = 1; i < timeSeries.length; i++) {
        res += (Math.min(timeSeries[i] - timeSeries[i - 1], duration));
    }
    
    return res;
};
