class RecentCounter {
    queue: number[];

    constructor() {
        this.queue = [];
    }

    ping(t: number): number {
        while (this.queue.length > 0 && (this.queue[this.queue.length - 1] < t)) {
            this.queue.pop();
        }
        
        this.queue.splice(0, 0, t + 3000);
        return this.queue.length;
    }
}
