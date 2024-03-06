package antonioGavilanes.v004;

public class WeekNode {
    
        private Week week;
        private WeekNode next;
    
        public WeekNode(Week week) {
            this.week = week;
            this.next = null;
        }
    
        public Week getWeek() {
            return week;
        }
    
        public void setWeek(Week week) {
            this.week = week;
        }
    
        public WeekNode getNext() {
            return next;
        }
    
        public void setNext(WeekNode next) {
            this.next = next;
        }
    
}
